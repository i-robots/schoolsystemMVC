package school.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.domain.GradeReport;
import school.repositories.GradeReportRepository;

@Service
public class GradeReportServiceImpl implements GradeReportService{
	
	@Autowired
	private GradeReportRepository gradeRepo;

	@Override
	public void save(GradeReport gradeReport) {
		gradeRepo.save(gradeReport);		
	}

	@Override
	public Iterable<GradeReport> findAll() {
		return gradeRepo.findAll();
	}
}
