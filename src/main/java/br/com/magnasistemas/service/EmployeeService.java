package br.com.magnasistemas.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magnasistemas.entity.EmployeeEntity;
import br.com.magnasistemas.repositoty.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public Optional<EmployeeEntity> findById(Long id) {
		return repository.findById(id);
	}

	@Transactional
	public EmployeeEntity save(EmployeeEntity employeeEntity) {
		return repository.save(employeeEntity);
	}
	
	@Transactional
	public void deleteById(Long id)  {
		repository.deleteById(id);
	}
	
	public Page<EmployeeEntity> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Transactional
	public EmployeeEntity update(EmployeeEntity employee) {
		return repository.saveAndFlush(employee);
	}
	
	

}
