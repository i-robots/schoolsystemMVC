package school.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import school.domain.Staff;
import school.repositories.StaffRepository;
import school.security.User;

@Service
public class StaffServiceImpl implements StaffService{
	
	private StaffRepository staffRepository;
	private UserService userService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public StaffServiceImpl(StaffRepository staffRepository,UserService userService,BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.staffRepository = staffRepository;
		this.userService = userService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public Staff findStaffByUsername(String username) {
		return staffRepository.findByUsername(username);
	}

	@Override
	public void saveStaff(Staff staff) {
		staff.setPassword(bCryptPasswordEncoder.encode(staff.getPassword()));
		staffRepository.save(staff);
		User user = new User();
		user.setUsername(staff.getUsername());
		user.setPassword(staff.getPassword());	
		userService.saveUser(user, staff.getJob_title().toString());		
	}
}
