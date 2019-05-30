package school.services;

import school.domain.Subject;

public interface SubjectService {
	
	void save(Subject subject);
	Iterable<Subject> findAll();
}
