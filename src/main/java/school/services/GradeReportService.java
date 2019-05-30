package school.services;

import school.domain.GradeReport;

public interface GradeReportService{
	void save(GradeReport gradeReport);
	Iterable<GradeReport> findAll();
}
