package school;
import static org.mockito.Mockito.verify;
import static 
    org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static 
    org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.ui.Model; 
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;

import school.domain.Staff;
import school.domain.Teacher;
import school.controllers.AddStaffController;
import school.domain.Cashier;
import school.domain.Director;
import school.domain.Grade.ClassName;
import school.domain.Staff.jobTitle;
import school.domain.Subject.SubjectName;
import school.services.CashierService;
import school.services.DirectorService;
import school.services.StaffService;
import school.services.TeacherService;
import school.services.UserService;


@RunWith(SpringRunner.class)
@WebMvcTest(AddStaffController.class)

public class AddStaffControllerTest {
	
	  @Autowired
	  private MockMvc mockMvc;
	  
	  
	  private Staff staff;
	  
	  
	  
	  @Before
	  public void addJobsToModel(Model model) {
			model.addAttribute("jobs",jobTitle.values());
		}
	  
	  
	  @Test
	  public void testAddJobsToModel()throws Exception{
		  staff=new Staff();
		  staff.setId(123456L);
		  staff.setName("Test Mehammed");
		  staff.setLastname("teshome");
		  staff.setUsername("checos");
		  staff.setJob_title(jobTitle.TEACHER);
		  
		  
	  }
	  
	  
	  
	  @Test
	  public Staff testStaff() {
		  staff=new Staff();
		  staff.setId(123456L);
		  staff.setName("Mehammed");
		  staff.setLastname("teshome");
		  staff.setUsername("checos");
		  staff.setJob_title(jobTitle.TEACHER);
		  
		  
		return new Staff();
		}
	  @Test
	  public String addStaff(Model model) throws Exception {
		  mockMvc.perform(get("/addStaff"))
		  .andExpect(status().isOk())
		  .andExpect(view().name("addStaff"))
		  .andExpect((ResultMatcher) model.addAttribute("checos",staff.getUsername()))
		  .andExpect((ResultMatcher) model.addAttribute("mehammed",staff.getName()))
		  .andExpect((ResultMatcher) model.addAttribute("teshome",staff.getLastname()))
		  .andExpect((ResultMatcher) model.addAttribute("TEACHER",staff.getJob_title()));
		  
			return "addStaff";		
		}
	  
	  public void testprocessStaffReg(@Valid Staff staff, Errors error,Model model) throws Exception {
		  mockMvc.perform(post("/addStaff")
				  .content("name = test + Staff & staff=")
				  .contentType(MediaType.APPLICATION_FORM_URLENCODED))
		          .andExpect(status().is3xxRedirection())
		          .andExpect(header().stringValues("Staff", "/addSatff"));
		  
		}
		
	  
	  @Test
	  public String testonGetTeacher(Model model) throws Exception{
		  mockMvc.perform(get("/addTeacher"))
		  .andExpect(status().isOk())
		  .andExpect(view().name("addTeacher"))
		  .andExpect((ResultMatcher) model.addAttribute("subj",SubjectName.AMHARIC))
		  .andExpect((ResultMatcher) model.addAttribute("assClass",ClassName.values()));
		  
		 
			return "addTeacher";
		}
		
		@Test
		public String testOnPostTeacher(Teacher teacher,Errors error, Model model)  throws Exception{
			mockMvc.perform(post("//teachersArea")
					  .content("name = test + Staff & teachersAreaf=")
					  .contentType(MediaType.APPLICATION_FORM_URLENCODED))
			          .andExpect(status().is3xxRedirection())
			          .andExpect(header().stringValues("Staff", "/teachersArea"));
			
			   return "redirect:/Staff/teachersArea";
		}
	

}
