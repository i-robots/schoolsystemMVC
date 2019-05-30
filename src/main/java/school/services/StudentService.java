package school.services;

import java.util.Optional;

import school.domain.Student;

public interface StudentService{
	
	public void save(Student student);
	
	Student findStudentByUsername(String username);
	
	public Iterable<Student> saveAll(Iterable<Student> student);

	Optional<Student> findById(Long id);

	boolean existsById(Long id);
	
	Iterable<Student> findAll();

	Iterable<Student> findAllById(Iterable<Long> ids);

	long count();
	
	void deleteById(Long id);
	
	void delete(Student stu);
	
	void deleteAll(Iterable<Student> stu);

	void deleteAll();
}
