package school;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import school.services.GradeService;
import school.services.RoleService;
import school.services.SubjectService;
import school.domain.Grade;
import school.domain.Grade.ClassName;
import school.domain.Grade.Section;
import school.domain.Subject;
import school.domain.Subject.SubjectName;
import school.security.Role;;

@SpringBootApplication
public class SchoolSystemApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SchoolSystemApplication.class, args);
	}
	
	@Override 
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SchoolSystemApplication.class);
	}
	@Bean
	public CommandLineRunner dataLoader(RoleService roleService, SubjectService subjectService , GradeService gradeService) {
	    return new CommandLineRunner() {
	      @Override
	      public void run(String... args) throws Exception {
	    	  roleService.save(new Role(1L, "STUDENT"));
	    	  roleService.save(new Role(2L, "TEACHER"));
	    	  roleService.save(new Role(3L, "DIRCTOR"));
	    	  roleService.save(new Role(4L, "CASHIER"));
	    	  
	    	  subjectService.save(new Subject(1L,SubjectName.AMHARIC));
	    	  subjectService.save(new Subject(2L,SubjectName.BIOLOGY));
	    	  subjectService.save(new Subject(3L,SubjectName.CHEMISTRY));
	    	  subjectService.save(new Subject(4L,SubjectName.CIVICS));
	    	  subjectService.save(new Subject(5L,SubjectName.ENGLISH));
	    	  subjectService.save(new Subject(6L,SubjectName.GEOGRAPHY));
	    	  subjectService.save(new Subject(7L,SubjectName.HISTORY));
	    	  subjectService.save(new Subject(8L,SubjectName.HPE));
	    	  subjectService.save(new Subject(9L,SubjectName.IT));
	    	  subjectService.save(new Subject(10L,SubjectName.MATHEMATICS));
	    	  subjectService.save(new Subject(11L,SubjectName.PHYSICS));
	    	  
	    	  Long id = 1L;
	    	  for(Section section : Section.values()) {
	    		  for(ClassName Class :ClassName.values()) {
		    		  gradeService.save(new Grade(id,Class,section));
		    		  id++;
		    	  }
	    	  }	    	  	    	  
	      }
	    };
	}
}

