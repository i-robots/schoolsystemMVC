package school.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Subject")
@NoArgsConstructor(access=AccessLevel.PRIVATE)
@AllArgsConstructor(access=AccessLevel.PUBLIC)
public class Subject {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private SubjectName name;
	
	public static enum SubjectName {
		BIOLOGY, CHEMISTRY, PHYSICS, AMHARIC, ENGLISH, CIVICS, MATHEMATICS, HISTORY, GEOGRAPHY, HPE, IT
	}
}
