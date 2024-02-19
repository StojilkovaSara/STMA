package com.example.task.controller;

import com.example.task.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@AllArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping("/add/subject/exam")
    public String getAddExamPage(Model model) {
        model.addAttribute("subjects", subjectService.findAllSubjects());
        model.addAttribute("places", subjectService.findAllPlaces());
        return "subject/form_exam";
    }

    @GetMapping("/add/subject/class")
    public String getAddClassPage(Model model) {
        model.addAttribute("subjects", subjectService.findAllSubjects());
        model.addAttribute("places", subjectService.findAllPlaces());
        return "subject/form_class";
    }

    @PostMapping("/add/subject/exam")
    public String addExam(@RequestParam(name = "subject") String subjectId,
                          @RequestParam(name = "place") Integer placeId,
                          @RequestParam(name = "name") String examName,
                          @RequestParam(name = "description") String examDescription,
                          @RequestParam(name = "date") LocalDate date,
                          @RequestParam(name = "startTime") String startTime,
                          @RequestParam(name = "endTime") String endTime) throws Exception {
        subjectService.addExam(subjectId, placeId, examName, examDescription, date, startTime, endTime);
        return "redirect:/add/subject/exam";
    }

    @PostMapping("/add/subject/class")
    public String addClass(@RequestParam(name = "subject") String subjectId,
                           @RequestParam(name = "place") Integer placeId,
                           @RequestParam(name = "name") String examName,
                           @RequestParam(name = "description") String examDescription,
                           @RequestParam(name = "startingDate", required = false) LocalDate startingDate,
                           @RequestParam(name = "endingDate", required = false) LocalDate endingDate,
                           @RequestParam(name = "day", required = false) String day,
                           @RequestParam(name = "startTime") String startTime,
                           @RequestParam(name = "endTime") String endTime) throws Exception {
        subjectService.addClass(subjectId, placeId, examName, examDescription, startingDate, endingDate, day, startTime, endTime);
        return "redirect:/add/subject/class";
    }

    @GetMapping("/exam")
    public String getUserExam(Model model) {
        model.addAttribute("exams", subjectService.findAllUserExams());
        return "subject/list_exam";
    }

    @GetMapping("/class")
    public String getUserClasses(Model model) {
        model.addAttribute("nonRepeatingClasses", subjectService.findAllUserNonRepeatingClasses());
        model.addAttribute("repeatingClasses", subjectService.findAllUserRepeatingClasses());
        return "subject/list_class";
    }
}
