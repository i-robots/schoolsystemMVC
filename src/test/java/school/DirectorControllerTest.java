package school;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;

@RunWith(SpringRunner.class)
@WebMvcTest 
public class  DirectorControllerTest {
	
	 @Autowired
	  private MockMvc mockMvc;   // <2>

	 
	  @Test
	  public void teststudentList() throws Exception {
	    mockMvc.perform(get("/"))    // <3>
	    
	      .andExpect(status().isOk())  // <4>
	      
	      .andExpect(view().name("studentList"))  // <5>
	      
	      .andExpect(content().string(           // <6>
	          containsString("students proceding...")));  
	  }
	  
	  @Test
	  public void testdirectorsArea() throws Exception {
	    mockMvc.perform(get("/"))    // <3>
	    
	      .andExpect(status().isOk())  // <4>
	      
	      .andExpect(view().name("directorsArea"))  // <5>
	      
	      .andExpect(content().string(           // <6>
	          containsString("director working...")));  
	  }
	  
	  @Test
	  public void testTeacherslist() throws Exception {
	    mockMvc.perform(get("/"))    // <3>
	    
	      .andExpect(status().isOk())  // <4>
	      
	      .andExpect(view().name("teacherslist"))  // <5>
	      
	      .andExpect(content().string(           // <6>
	          containsString(" teachers working..")));  
	  }

}
