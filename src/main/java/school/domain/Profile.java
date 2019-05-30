package school.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import school.domain.Grade.*;
import school.domain.Student.Gender;

@Data
@Entity
@Table(name="profile")
public class Profile {
	
	@Id
	@NotNull(message="Id required!")
	@Positive(message="must be a valid id")
	private Long Id;
	
	@Size(min=3, message="Name too short!")
	private String name;
	
	@Size(min=3, message="Lname too short!")
	private String fathersName;
	
	private ClassName grade;
	private Section section;
	private Gender sex;
	private String DateOfBirth;
	
	@Email
	private String email;	
	private String picUrl;
}
