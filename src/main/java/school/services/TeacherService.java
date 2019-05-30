package school.services;

import school.domain.Staff;
import school.domain.Teacher;

public interface TeacherService {
	void saveTeacher(Teacher teacher,Staff staff);
	Teacher findTeacherByUsername(String username);
	Iterable<Teacher> findAll();
}
