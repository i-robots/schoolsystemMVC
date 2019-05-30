package school.services;

import school.domain.Director;
import school.domain.Staff;

public interface DirectorService {
	void saveDirector(Staff staff);
	Director findDirectorByUsername(String username);
}
