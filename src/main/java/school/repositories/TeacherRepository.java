package school.repositories;

import org.springframework.data.repository.CrudRepository;

import school.domain.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Long>{
	Teacher findByUsername(String username);
}
