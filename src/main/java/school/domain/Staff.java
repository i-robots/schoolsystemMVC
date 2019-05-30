package school.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access=AccessLevel.PUBLIC, force=true)
@Table(name="Staff")
@Entity
public class Staff {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
		
	@OneToMany(targetEntity=Teacher.class)
	private List<Teacher> teachers;
	
	@Size(min=2, message="name too short!")
	private String name;
	
	@Size(min=2, message="Lname too short!")
	private String lastname;
	
	@Size(min=2, message="provide a better username!")
	private String username; 
	
	@Size(min=2, message="password too short!")
	private String password;
	
	private jobTitle job_title;
		
	public static enum jobTitle{
		TEACHER, CASHIER, DIRECTOR
	}
}
