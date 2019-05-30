package school.repositories;
import org.springframework.data.repository.CrudRepository;

import school.security.User;

public interface UserRepository extends CrudRepository<User, Long> {
  User findByUsername(String username);
}
