package school.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import school.domain.Assessment;
import school.domain.Grade;
import school.domain.GradeReport;
import school.domain.Profile;
import school.domain.Teacher;
import school.services.AssessmentService;
import school.services.GradeReportService;
import school.services.ProfileService;
import school.services.StaffService;
import school.services.TeacherService;

@Controller
public class TeacherController {
	
	@Autowired
	private StaffService staffService;
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private ProfileService studentProfService;
	
	@Autowired
	private AssessmentService assessmentService;
	
	@Autowired
	private GradeReportService gradeRepoService;
	
	List<Iterable<Profile>> profList;
	Iterable<Assessment> assList;
	
	@GetMapping("/teachersArea")
	public String onTeacher(Model model,Principal principal) {
		model.addAttribute("teacher", staffService.findStaffByUsername(principal.getName()));
		return "teachersArea";		
	}
	
	@GetMapping("/studentList")
	public String OnStudentListGrade(Model model,Principal principal) {
		model.addAttribute("teacher", staffService.findStaffByUsername(principal.getName()));
		
		Teacher teacher = teacherService.findTeacherByUsername(principal.getName());

		model.addAttribute("grades",teacher.getGrades());
		List<Grade> grade = teacher.getGrades();
		
		profList = new ArrayList<Iterable<Profile>>();
		for(Grade grad : grade) {
			profList.add(studentProfService.findStudentProfileByGradeAndSection(grad.getName(),grad.getSection()));
		}		
		System.out.print("Get profiles :" + profList );
		model.addAttribute("studentList",profList);
		return "StudentList";
	}
	
	@GetMapping("/PostGrade")
	public String OnPostGrade(Model model) {
		assList = assessmentService.findAll();
		model.addAttribute("assList",assList);
		model.addAttribute("studentList",profList);
		return "postGrade";
	}
	
	@PostMapping("/addAssesement")
	public String onAddAssesement(@Valid Assessment assessment, Errors error, Model model) {
		if(error.hasErrors()) {
			model.addAttribute("studentList",profList);
			model.addAttribute("assList",assList);
			return "postGrade";
		}
		assessmentService.save(assessment);
		model.addAttribute("Isadded"," assessment added!");
		model.addAttribute("studentList",profList);
		return "postGrade";
	}
	
	@PostMapping("/onPost")
	public String onPostGrade(@Valid GradeReport gradeRep,Errors error,Model model) {
		if(error.hasErrors()) {
			model.addAttribute("studentList",profList);
			model.addAttribute("assList",assList);
			return "postGrade";
		}
		gradeRepoService.save(gradeRep);
		return "postGrade";
	}
	
	@ModelAttribute(name="gradeReport")
	public GradeReport gradeRep() {
		return new GradeReport();		
	}
	
	@ModelAttribute(name="assessment")
	public Assessment assGra() {
		return new Assessment();
	}
}
