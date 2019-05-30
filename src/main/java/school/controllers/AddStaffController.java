package school.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import school.domain.Staff;
import school.domain.Teacher;
import school.domain.Grade;
import school.domain.Staff.jobTitle;
import school.domain.Subject;
import school.domain.Subject.SubjectName;
import school.services.CashierService;
import school.services.DirectorService;
import school.services.GradeService;
import school.services.SubjectService;
import school.services.TeacherService;
import school.services.UserService;

@Controller
@RequestMapping("/Staff")
public class AddStaffController {
	private UserService userService;
	private TeacherService teacherService;
	private CashierService cashierService;
	private DirectorService directorService;
	private Staff staff;
	
	@Autowired
	private GradeService gradeService;
	
	@Autowired
	private SubjectService subjectService;
	
	public AddStaffController(UserService userService,TeacherService teacherService,
			CashierService cashierService,DirectorService directorService) {
		this.userService = userService;
		this.teacherService = teacherService;
		this.cashierService = cashierService;
		this.directorService = directorService;
	}
	
	@ModelAttribute
	public void addJobsToModel(Model model) {
		model.addAttribute("jobs",jobTitle.values());
	}
	
	
	@ModelAttribute(name="staff")
	public Staff Staff() {
		return new Staff();
	}
	
	@ModelAttribute(name="teacheRg")
	public Teacher Teacher() {
		return new Teacher();
	}
	
	@GetMapping
	public String addStaff(Model model) {
		return "addStaff";		
	}
	
	@PostMapping
	public String processStaffReg(@Valid Staff staff, Errors error,Model model) {
		if(error.hasErrors()) {
			return "addStaff";
		}
		
		if(userService.findUserByUsername(staff.getUsername()) != null) {
			model.addAttribute("usExist", "username already exists!");
			return "addStaff";
		}		
		this.staff = staff;		
		switch(staff.getJob_title()) {
		case TEACHER:
			return "redirect:/Staff/Teacher";
		case CASHIER:
			cashierService.saveCashier(staff);
			return "redirect:/Cashier";
		case DIRECTOR:
			directorService.saveDirector(staff);
			return "redirect:/Director";
		default:
			return "redirect:/error";
		}
	}
	
	@GetMapping("/Teacher")
	public String onGetTeacher(Model model) {
		List<Subject> sub = new ArrayList<>();
		subjectService.findAll().forEach(i -> sub.add(i));
		model.addAttribute("subj",sub);
		
		List<Grade> grades = new ArrayList<>();
		gradeService.findAll().forEach(i -> grades.add(i));
		
		Grade.ClassName[] Class = Grade.ClassName.values();		
		for(Grade.ClassName cls : Class) {
			model.addAttribute(cls.toString().toLowerCase(),filterByClass(grades,cls));
		}
		return "addTeacher";
	}
	
	@PostMapping("/Teacher")
	public String OnPostTeacher(@Valid Teacher teacher,Errors error, Model model) {
		staff.setTeachers(Arrays.asList(teacher));
		teacher.setUsername(staff.getUsername());
		teacherService.saveTeacher(teacher,staff);
		return "redirect:/teachersArea";
	}
	
	private List<Grade> filterByClass(List<Grade> grades,Grade.ClassName Class){
		 return grades.stream().filter(x -> x.getName().equals(Class)).collect(Collectors.toList());
	}
}
