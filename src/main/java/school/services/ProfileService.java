package school.services;

import java.util.Optional;

import school.domain.Profile;
import school.domain.Grade;
import school.domain.Grade.ClassName;
import school.domain.Grade.Section;


public interface ProfileService {
	
	public Profile save(Profile profile);
	
	Iterable<Profile> findStudentProfileByGrade(ClassName grade);
	
	Iterable<Profile> findStudentProfileByGradeAndSection(ClassName grade,Section section);
	
	public Iterable<Profile> saveAll(Iterable<Profile> profiles);

	Optional<Profile> findById(Long id);

	boolean existsById(Long id);
	
	Iterable<Profile> findAll();

	Iterable<Profile> findAllById(Iterable<Long> ids);

	long count();
	
	void deleteById(Long id);
	
	void delete(Profile profile);
	
	void deleteAll(Iterable<Profile> profile);

	void deleteAll();
}
