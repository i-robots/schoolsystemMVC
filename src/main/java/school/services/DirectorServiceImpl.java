package school.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.domain.Director;
import school.domain.Staff;
import school.repositories.DirectorRepository;

@Service
public class DirectorServiceImpl implements DirectorService{
	
	@Autowired
	StaffService staffService;
	DirectorRepository directorRepository;
	
	@Autowired
	public DirectorServiceImpl(DirectorRepository directorRepository) {
		this.directorRepository = directorRepository;
	}

	@Override
	public void saveDirector(Staff staff) {
		Director director = new Director();
		director.setUsername(staff.getUsername());
		director.setName(staff.getName() + " " + staff.getLastname());
		directorRepository.save(director);
		staffService.saveStaff(staff);
	}

	@Override
	public Director findDirectorByUsername(String username) {
		return directorRepository.findByUsername(username);
	}

}
