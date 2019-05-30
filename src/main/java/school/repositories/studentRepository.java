package school.repositories;

import org.springframework.data.repository.CrudRepository;

import school.domain.Student;

public interface studentRepository extends CrudRepository<Student, Long>{
		Student findByUsername(String username);
}
