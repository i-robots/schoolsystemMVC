package school.repositories;

import org.springframework.data.repository.CrudRepository;

import school.domain.Staff;

public interface StaffRepository extends CrudRepository<Staff,Long>{
	Staff findByUsername(String username);
}
