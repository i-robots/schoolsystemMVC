package school.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import school.domain.Student;
import school.repositories.studentRepository;
import school.security.User;

@Service
public class StudentServiceImpl implements StudentService{
	
	private UserService userService;
	private studentRepository stuRepo;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public StudentServiceImpl(UserService user,studentRepository stuRepo,BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userService = user;
		this.stuRepo = stuRepo;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@Override
	public void save(Student student) {
		student.setPassword(bCryptPasswordEncoder.encode(student.getPassword()));
		stuRepo.save(student);
		User user = new User();
		user.setUsername(student.getUsername());
		user.setPassword(student.getPassword());
		userService.saveUser(user, "STUDENT");
	}

	@Override
	public Student findStudentByUsername(String username) {
		return stuRepo.findByUsername(username);
	}

	@Override
	public Iterable<Student> saveAll(Iterable<Student> student) {
		return stuRepo.saveAll(student);
	}

	@Override
	public Optional<Student> findById(Long id) {
		return stuRepo.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return stuRepo.existsById(id);
	}

	@Override
	public Iterable<Student> findAll() {
		return stuRepo.findAll();
	}

	@Override
	public Iterable<Student> findAllById(Iterable<Long> ids) {
		return stuRepo.findAllById(ids);
	}

	@Override
	public long count() {
		return stuRepo.count();
	}

	@Override
	public void deleteById(Long id) {
		stuRepo.deleteById(id);
		
	}

	@Override
	public void delete(Student stu) {
		stuRepo.delete(stu);
		
	}

	@Override
	public void deleteAll(Iterable<Student> stu) {
		stuRepo.deleteAll(stu);
		
	}

	@Override
	public void deleteAll() {
		stuRepo.deleteAll();
	}
}
