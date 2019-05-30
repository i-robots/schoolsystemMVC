package school.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import school.security.User;

public interface UserService extends UserDetailsService{
	User findUserByUsername(String username);
	void saveUser(User user,String role);
}
