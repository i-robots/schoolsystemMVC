package school;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import school.domain.Student;
import school.domain.Grade.*;
import school.repositories.studentRepository;
import school.services.StudentService;

public class AddStudentControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	private Student student;
	
	private studentRepository studentRepo;
	
	@Before
	public void setup() {
		student = new Student();
		student.getProfile().setName("test student");
	}
	
	@Test
	public void testaddStudent() throws Exception{
		mockMvc.perform(get("/addStudent"))
        .andExpect(status().isOk())
        .andExpect(view().name("addStudent"))
        .andExpect(model().attribute("grades", ClassName.values()))
        .andExpect(model().attribute("sections",Section.values()));
	}
	
	
	@Test
	public void testprocessRegistration() throws Exception{
		when(studentRepo.findByUsername(student.getProfile().getName())).
		 thenReturn(null);
		
		when(studentRepo.save(student))
	        .thenReturn(student);

	    mockMvc.perform(post("/addStudent")
	        .content("name=test+student")
	        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
	        .andExpect(status().is3xxRedirection())
	        .andExpect(header().stringValues("Location", "/addStudent/registration"));
	}

}
