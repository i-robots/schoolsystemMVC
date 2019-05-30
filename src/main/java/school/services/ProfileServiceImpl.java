package school.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.domain.Grade;
import school.domain.Grade.ClassName;
import school.domain.Grade.Section;
import school.domain.Profile;
import school.repositories.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService{
	
	private ProfileRepository profileRepository;
	
	@Autowired
	public ProfileServiceImpl(ProfileRepository profileRepository) {
		this.profileRepository = profileRepository;
	}

	@Override
	public Profile save(Profile profile) {
		return profileRepository.save(profile);
	}
	
	@Override
	public Iterable<Profile> findStudentProfileByGradeAndSection(ClassName grade,Section section) {
		return profileRepository.findByGradeAndSection(grade, section);
	}
	
	@Override
	public Iterable<Profile> findStudentProfileByGrade(ClassName grade) {
		return profileRepository.findByGrade(grade);
	}

	@Override
	public Iterable<Profile> saveAll(Iterable<Profile> profiles) {
		return profileRepository.saveAll(profiles);
	}

	@Override
	public Optional<Profile> findById(Long id) {
		return profileRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return profileRepository.existsById(id);
	}

	@Override
	public Iterable<Profile> findAll() {
		return profileRepository.findAll();
	}

	@Override
	public Iterable<Profile> findAllById(Iterable<Long> ids) {
		return profileRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return profileRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		profileRepository.deleteById(id);	
	}

	@Override
	public void delete(Profile profile) {
		profileRepository.delete(profile);
	}

	@Override
	public void deleteAll(Iterable<Profile> profile) {
		profileRepository.deleteAll(profile);
	}

	@Override
	public void deleteAll() {
		profileRepository.deleteAll();
	}
}
