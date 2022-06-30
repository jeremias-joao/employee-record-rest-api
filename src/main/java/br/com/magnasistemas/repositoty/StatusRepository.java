package br.com.magnasistemas.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.magnasistemas.entity.StatusEntity;

@Repository
public interface StatusRepository extends JpaRepository<StatusEntity, Long> {

}
