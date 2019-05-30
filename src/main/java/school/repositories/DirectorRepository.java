package school.repositories;

import org.springframework.data.repository.CrudRepository;

import school.domain.Director;

public interface DirectorRepository extends CrudRepository<Director,Long>{
	Director findByUsername(String username);
}
