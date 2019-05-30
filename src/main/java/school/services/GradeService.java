package school.services;

import school.domain.Grade;

public interface GradeService {
	void save(Grade grade);
	Iterable<Grade> findAll();
}
