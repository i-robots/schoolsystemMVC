package school.services;

import school.domain.Assessment;

public interface AssessmentService {
	void save(Assessment assessment);
	Iterable<Assessment> findAll();
}
