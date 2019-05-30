package school.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Positive;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access=AccessLevel.PUBLIC, force=true)
@Table(name="GradeReport")
@Entity
public class GradeReport {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Positive(message="not positive")
	private int mid;
	
	@Positive(message="not positive")
	private int final_exam;
	
	@Positive(message="not positive")
	private int total;
	
	@OneToMany(targetEntity=Assessment.class)
	private List<Assessment> assessement;
}
