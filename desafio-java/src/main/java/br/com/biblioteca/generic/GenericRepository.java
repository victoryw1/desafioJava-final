package br.com.biblioteca.generic;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<E> extends JpaRepository<E, Long>, JpaSpecificationExecutor<E> {

	@SuppressWarnings("null")
	List<E> findAll(Specification<E> userEntitySpecification);

}
