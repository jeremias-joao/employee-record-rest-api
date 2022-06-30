package br.com.magnasistemas.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magnasistemas.dto.EmployeeDto;
import br.com.magnasistemas.entity.AddressEntity;
import br.com.magnasistemas.entity.CompanyEntity;
import br.com.magnasistemas.entity.DepartmentEntity;
import br.com.magnasistemas.entity.EmployeeEntity;
import br.com.magnasistemas.entity.StatusEntity;
import br.com.magnasistemas.exception.NaoEncontradoException;
import br.com.magnasistemas.exception.IdadeMaiorQueCemException;
import br.com.magnasistemas.repositoty.EmployeeRepository;

@Service
public class EmployeeService {

	private static Logger logger = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	private EmployeeRepository repository;

	public Optional<EmployeeEntity> findById(Long id) {
		return Optional.of(repository.findById(id)
				.orElseThrow(() -> new NaoEncontradoException("NENHUM FUNCIONARIO ENCONTRADO COM ID{} " + id + " ")));
	}

	@Transactional
	public EmployeeDto salvar(EmployeeDto employeeDto) throws Exception {

		EmployeeEntity entity = new EmployeeEntity();
		entity = converterParaEntity(employeeDto);
		if (entity.getAge() >= 70) {
			throw new IdadeMaiorQueCemException("A IDADE DO FUNCIONARIO NAO PODE SER MAIOR QUE 70 ANOS");
		}
		repository.save(entity);
		EmployeeDto retorno = new EmployeeDto();
		retorno.setId(entity.getId());
		return retorno;

	}

	@Transactional
	public void deleteById(Long id) {
		logger.info("CONSULTANDO A EXISTENCIA DO FUNCIONARIO NO BANDO DE DADOS-");
		findById(id);
		logger.info("FUNCIONARIO  COM ID {} " + id + "ENCONTRADO COM SUCESSO");
		repository.deleteById(id);
	}

	public Page<EmployeeEntity> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Transactional
	public EmployeeEntity update(EmployeeDto dto) {

		findById(dto.getId());

		EmployeeEntity entity = new EmployeeEntity();
		entity = converterParaEntity(dto);

		return repository.saveAndFlush(entity);
	}

	public EmployeeEntity converterParaEntity(EmployeeDto dto) {

		EmployeeEntity entity = new EmployeeEntity();

		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setAge(dto.getAge());
		entity.setSex(dto.getSex());

		DepartmentEntity departmentEntity = new DepartmentEntity();
		departmentEntity.setId(dto.getDepartment().getId());
		departmentEntity.setName(dto.getDepartment().getName());

		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setId(dto.getAddress().getId());
		addressEntity.setRoad(dto.getAddress().getRoad());
		addressEntity.setDistrict(dto.getAddress().getDistrict());
		addressEntity.setCity(dto.getAddress().getCity());
		addressEntity.setState(dto.getAddress().getState());
		addressEntity.setCep(dto.getAddress().getCep());

		StatusEntity statusEntity = new StatusEntity();
		statusEntity.setId(dto.getCompany().getId());
		statusEntity.setStatus(dto.getCompany().getStatus().getStatus());

		CompanyEntity companyEntity = new CompanyEntity();
		companyEntity.setId(dto.getCompany().getId());
		companyEntity.setName(dto.getCompany().getName());
		companyEntity.setCnpj(dto.getCompany().getCnpj());
		companyEntity.setFoundationDate(dto.getCompany().getFoundationDate());
		companyEntity.setStatus(statusEntity);

		entity.setCompany(companyEntity);
		entity.setDepartment(departmentEntity);
		entity.setAddress(addressEntity);

		return entity;

	}

}
