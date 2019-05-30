package school.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access=AccessLevel.PUBLIC, force=true)
@Table(name="Teacher")
@Entity
public class Teacher{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	private String username;
	
	@OneToMany(targetEntity=Assessment.class)
	private List<Assessment> gradeReports;	
	
	@OneToOne(targetEntity=Subject.class)
	private Subject subject;
	
	@ManyToMany(targetEntity=Grade.class)
	private List<Grade> grades;

}
