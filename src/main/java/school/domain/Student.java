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
@Table(name="student")
@Entity
public class Student {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
		
	@OneToOne(targetEntity=Profile.class)
	private Profile profile;
	
	@OneToMany(targetEntity=GradeReport.class)
	private List<GradeReport> gradeReport;
	
	@Size(min=3, message="Username too short!")
	private String username; 
	
	@Size(min=3, message="Password too weak!")
	private String password;
		
	public static enum Gender {
		MALE, FEMALE
	}
}
