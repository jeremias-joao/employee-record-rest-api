package br.com.magnasistemas.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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

import br.com.magnasistemas.entity.EmployeeEntity;
import br.com.magnasistemas.service.EmployeeService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/employee")
public class EmployeeController {

	private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/find-all")
	@Cacheable(value = "listAll")
	public ResponseEntity<Page<EmployeeEntity>> getAllEmployees(
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable paginas)
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
	@Cacheable(value = "findById")
	public ResponseEntity<Object> getEmployeeById(@PathVariable(value = "id") Long id) throws NotFoundException {
		Optional<EmployeeEntity> employeEntityOptional = employeeService.findById(id);
		if (!employeEntityOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("EMPLOYEE WITH ID{} " + id + " NOT FOUND.");
		}

		logger.info(" EMPLOYEE WITH ID {} " + id + " FOUD SUCESSUFLY");
		return ResponseEntity.status(HttpStatus.OK).body(employeEntityOptional.get());
	}

	@PostMapping("/save")
	@CacheEvict(value = "save", allEntries = true)
	public ResponseEntity<EmployeeEntity> salvar(@RequestBody EmployeeEntity employee) {
		try {
			EmployeeEntity employeeSave = employeeService.save(employee);
			logger.info(" EMPLOYEE WITH NAME " + employee.getName() + " SAVED SUCESSUFLY");
			return ResponseEntity.status(HttpStatus.CREATED).body(employeeSave);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(" EMPLOYEE WITH NAME " + employee.getName() + " NOT SAVED");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/update/{id}")
	@CacheEvict(value = "update", allEntries = true)
	public ResponseEntity<?> atualizar(@RequestBody EmployeeEntity employee, Long id) {

		Optional<EmployeeEntity> employeeOptional = employeeService.findById(id);
		if (!employeeOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("EMPLOYEE WITH ID {} " + id + " NOT FOUND");
		}
		logger.info("EMPLOYEE WITH ID {} " + id + " UPDATE SUCESSUFLY");
		EmployeeEntity employeeUpdate = employeeService.update(employee);

		return new ResponseEntity<>(employeeUpdate, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	@CacheEvict(value = "delete", allEntries = true)
	public ResponseEntity<Object> deleteFunc(@PathVariable(value = "id") Long id) throws NotFoundException {
		Optional<EmployeeEntity> employee = employeeService.findById(id);
		if (!employee.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("EMPLOYEE WITH ID {} " + id + " NOT FOUND");
		}
		employeeService.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("EMPLOYEE WITH ID {}" + id + " DELETED SUCESSUFLY");
	}

}
