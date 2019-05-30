package school.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@Entity
public class Grade {
	
	@Id
    private final Long id;	
	private final ClassName name;
	private final Section section;
	
	public static enum ClassName{
		NURSERY, KG1, KG2, ONE, TWO, THEREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, ELEVEN, TWELVE
	}
	
	public static enum Section {
		A, B, C
	}

}
