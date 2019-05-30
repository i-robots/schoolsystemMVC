package school.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.domain.Assessment;
import school.repositories.AssessmentRepository;

@Service
public class AssessmentServiceImpl implements AssessmentService{
	
	@Autowired
	AssessmentRepository assRepo;

	@Override
	public void save(Assessment assessment) {
		assRepo.save(assessment);		
	}

	@Override
	public Iterable<Assessment> findAll() {
		return assRepo.findAll();
	}

}
