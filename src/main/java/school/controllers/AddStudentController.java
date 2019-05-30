package school.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import school.domain.Profile;
import school.domain.Student;
import school.domain.Grade.*;
import school.services.ProfileService;
import school.services.StudentService;
import school.services.UserService;

@Controller
@RequestMapping("/Student")
@SessionAttributes("student")
public class AddStudentController {
	
	private StudentService studentService;
	private UserService userService;
	private ProfileService profileservice;
	private Profile prof;
	//Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "src//main//resources//static//images//student//";
    
	@Autowired
	public AddStudentController(StudentService studentService,ProfileService profileservice,UserService userService) {
	   this.studentService = studentService;
	   this.userService = userService;
	   this.profileservice = profileservice;
	}
	
	@ModelAttribute
	public void addNamesToModel(Model model) {
		model.addAttribute("grades", ClassName.values());
		model.addAttribute("sections",Section.values());		
	}
	
	@ModelAttribute(name = "student")
    public Student Student() {
	   return new Student();
	}
	
	@ModelAttribute(name = "profile")
    public Profile Profile() {
	   return new Profile();
	}
	
	@GetMapping
	public String addStudent(Model model) {
		return "addStudent";    
	}
	
	@PostMapping
	public String processRegistration(@Valid Profile profile,Errors errors, Model model,@RequestParam("file") MultipartFile file) {
		if(errors.hasErrors()) {
			return "addStudent";
		}
		if(profileservice.existsById(profile.getId())) {
			model.addAttribute("idExist", "Id already exists!");
			System.out.print("id exist "+ profile.getId());
			return "addStudent";
		}
		
		if (file.isEmpty()) {
			model.addAttribute("message", "profile picture required!");
            return "addStudent";
        }
		
		try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            System.out.print("Images path: "+path);
            Files.write(path, bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }
		profile.setPicUrl("/images/student/" + file.getOriginalFilename());
		profileservice.save(profile);
		prof = profile;
		return "redirect:/Student/register";
	}
	
	@GetMapping("/register")
	public String processRegistration() {
		return "register";
	}
	
	@PostMapping("/register")
	public String processRegistration(@Valid Student stu,Errors errors, Model model) {
		if(errors.hasErrors()) {
			return "register";
		}
		
		if(userService.findUserByUsername(stu.getUsername()) != null) {
			model.addAttribute("idExist", "User name already exists!");
			System.out.print("User name exists "+ stu.getUsername());
			return "register";
		}
		
		stu.setProfile(prof);
		studentService.save(stu);
		return "redirect:/Student/profile";		
	}
	
	@GetMapping("/profile")
	public String profile(SessionStatus sessionStatus,Model model,Principal principal){
		Student stu = studentService.findStudentByUsername(principal.getName());
		if(stu.getProfile() != prof) {
			prof =  stu.getProfile();
		}
		model.addAttribute("student",prof);
		sessionStatus.setComplete();
		return "profile";
	}
}
