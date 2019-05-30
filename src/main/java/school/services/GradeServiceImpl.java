package school.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.domain.Grade;
import school.repositories.GradeRepository;

@Service
public class GradeServiceImpl implements GradeService{
	
	@Autowired
	GradeRepository gradeRepository;
	
	@Override
	public void save(Grade grade) {
		gradeRepository.save(grade);		
	}

	@Override
	public Iterable<Grade> findAll() {
		return gradeRepository.findAll();
	}	
}
