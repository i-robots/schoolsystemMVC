package school.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.domain.Subject;
import school.repositories.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService{
	
	@Autowired
	private SubjectRepository subjectRepo;
	
	@Override
	public void save(Subject subject) {
		subjectRepo.save(subject);
	}

	@Override
	public Iterable<Subject> findAll() {
		return subjectRepo.findAll();
	}

}
