package school.repositories;

import org.springframework.data.repository.CrudRepository;
import school.domain.Profile;
import school.domain.Grade.ClassName;
import school.domain.Grade.Section;

public interface ProfileRepository extends CrudRepository<Profile,Long>{
	Iterable<Profile> findByGradeAndSection(ClassName grade, Section section);
	Iterable<Profile> findByGrade(ClassName grade);
}
