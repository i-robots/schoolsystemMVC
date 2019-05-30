package school.repositories;

import org.springframework.data.repository.CrudRepository;

import school.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{
	Role findByRole(String role);
}
