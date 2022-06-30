package br.com.magnasistemas.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.magnasistemas.entity.DepartmentEntity;

@Repository
public interface DepartmentRepository  extends JpaRepository<DepartmentEntity, Long> {

}
