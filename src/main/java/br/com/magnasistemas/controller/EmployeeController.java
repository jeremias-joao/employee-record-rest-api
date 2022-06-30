package br.com.magnasistemas.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webjars.NotFoundException;

import br.com.magnasistemas.dto.EmployeeDto;
import br.com.magnasistemas.entity.EmployeeEntity;
import br.com.magnasistemas.service.EmployeeService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/employee")
public class EmployeeController {

	private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/find-all")
	@CacheEvict(value = "listAll", allEntries = true)
	public ResponseEntity<Page<EmployeeEntity>> getAllEmployees(
			@PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.ASC) Pageable paginas)
			throws NotFoundException {
		try {
			logger.info("LISTING ALL EMPLOYEE SAVED");
			return ResponseEntity.ok(employeeService.findAll(paginas));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("IT'S NOT POSSIBLE TO LIST ALL EMPLOYEE ");
		return null;
	}

	@GetMapping("/{id}")
	@CacheEvict(value = "findById", allEntries = true)
	public ResponseEntity<Object> getEmployeeById(@PathVariable(value = "id") Long id) throws NotFoundException {
		Optional<EmployeeEntity> employeEntityOptional = employeeService.findById(id);
		if (!employeEntityOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("EMPLOYEE WITH ID{} " + id + " NOT FOUND.");
		}

		logger.info(" EMPLOYEE WITH ID {} " + id + " FOUND SUCESSUFLY");
		return ResponseEntity.status(HttpStatus.OK).body(employeEntityOptional.get());
	}

	@PostMapping("/save")
	@CacheEvict(value = "save", allEntries = true)
	public ResponseEntity<EmployeeDto> salvar(@RequestBody @Valid EmployeeDto employeeDto) throws Exception {
		employeeService.salvar(employeeDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeDto);

	}

	@PutMapping("/update/{id}")
	@CacheEvict(value = "update", allEntries = true)
	public ResponseEntity<Object> atualizar(@RequestBody EmployeeDto dto, Long id) {
		logger.info("STARTING TO UPDATE EMPLOYEE");
		EmployeeEntity employeeUpdate = employeeService.update(dto);
		logger.info("EMPLOYEE WITH ID {} " + id + " UPDATE SUCESSUFLY");
		return new ResponseEntity<>(employeeUpdate, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	@CacheEvict(value = "delete", allEntries = true)
	public ResponseEntity<Object> delete(@PathVariable Long id) {
		logger.info("REMOVING EMPLOYEE");
		employeeService.deleteById(id);
		logger.info("EMPLOYEE WITH ID {} " + id + " DELETED SUCESSUFLY");
		return ResponseEntity.status(HttpStatus.OK).body("EMPLOYEE WITH ID {} " + id + " DELETED SUCESSUFLY");
	}

}
