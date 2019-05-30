package school.services;

import school.domain.Staff;

public interface StaffService{	
	Staff findStaffByUsername(String username);
	void saveStaff(Staff staff);
}
