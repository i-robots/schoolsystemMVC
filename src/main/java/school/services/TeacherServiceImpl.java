package school.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import school.domain.Staff;
import school.domain.Teacher;
import school.repositories.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private StaffService staffService;
	private TeacherRepository teacherRepository;
	
	@Autowired
	public TeacherServiceImpl(TeacherRepository teacherRepository) {
		this.teacherRepository = teacherRepository;
	}

	@Override
	public void saveTeacher(Teacher teacher,Staff staff) {
		teacherRepository.save(teacher);
		staffService.saveStaff(staff);
	}

	@Override
	public Teacher findTeacherByUsername(String username) {
		return teacherRepository.findByUsername(username);
	}

	@Override
	public Iterable<Teacher> findAll() {
		return teacherRepository.findAll();
	}

}
