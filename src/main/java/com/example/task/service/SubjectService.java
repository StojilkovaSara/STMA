package com.example.task.service;

import com.example.task.entity.PlaceEntity;
import com.example.task.entity.StudentEntity;
import com.example.task.entity.event.*;
import com.example.task.entity.projection.ExamEvent;
import com.example.task.entity.projection.NonRepeatingClassEvent;
import com.example.task.entity.projection.RepeatingClassEvent;
import com.example.task.entity.schoolyear.SchoolYearEntity;
import com.example.task.entity.schoolyear.SchoolYearId;
import com.example.task.entity.subject.SubjectEntity;
import com.example.task.entity.subject.SubjectId;
import com.example.task.entity.term.TermEntity;
import com.example.task.entity.term.TermId;
import com.example.task.repository.*;
import com.example.task.repository.event.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@AllArgsConstructor
public class SubjectService {

    private final PlaceRepository placeRepository;
    private final SubjectRepository subjectRepository;
    private final CalendarEventRepository calendarEventRepository;
    private final HappensAtPlaceRepository happensAtPlaceRepository;
    private final NonRepeatingEventRepository nonRepeatingEventRepository;
    private final SubjectEventRepository subjectEventRepository;
    private final StudentRepository studentRepository;
    private final SchoolYearRepository schoolYearRepository;
    private final TermRepository termRepository;
    private final RepeatingEventRepository repeatingEventRepository;
    private final UserAuthenticationService userAuthenticationService;

    public List<PlaceEntity> findAllPlaces() {
        return placeRepository.findAll();
    }

    public List<SubjectEntity> findAllSubjects() {
        List<SubjectEntity> arr = subjectRepository.findAll();
        arr.removeIf(s -> s.getId().getTermEntity().getTermId().getSchoolYear().getSchoolYearId().getStudentId().getStudentId() != userAuthenticationService.getLoggedInUser().getStudentId());
        return arr;
    }

    public void addExam(String subjectId, Integer placeId, String examName, String examDescription, LocalDate date, String startTime, String endTime) throws Exception {

        PlaceEntity place = placeRepository.findById(placeId).orElseThrow(Exception::new);
        SubjectEntity subject = returnSubject(subjectId);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time1 = LocalTime.parse(startTime, formatter);
        LocalTime time2 = LocalTime.parse(endTime, formatter);

        CalendarEvent calendarEvent = new CalendarEvent(examName, "Exam", examDescription, Time.valueOf(time1), Time.valueOf(time2));
        calendarEventRepository.save(calendarEvent);
        NonRepeatingEvent nonRepeatingEvent = new NonRepeatingEvent(new NonRepeatingEventId(calendarEvent), date);
        nonRepeatingEventRepository.save(nonRepeatingEvent);
        SubjectEvent subjectEvent = new SubjectEvent(new SubjectEventId(calendarEvent), subject);
        subjectEventRepository.save(subjectEvent);
        HappensAtPlace happensAtPlace = new HappensAtPlace(new NonRepeatingEventId(calendarEvent), place);
        happensAtPlaceRepository.save(happensAtPlace);
    }

    public void addClass(String subjectId, Integer placeId, String examName, String examDescription, LocalDate startingDate, LocalDate endingDate, String day, String startTime, String endTime) throws Exception {

        PlaceEntity place = placeRepository.findById(placeId).orElseThrow(Exception::new);
        SubjectEntity subject = returnSubject(subjectId);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time1 = LocalTime.parse(startTime, formatter);
        LocalTime time2 = LocalTime.parse(endTime, formatter);

        CalendarEvent calendarEvent = new CalendarEvent(examName, "Class", examDescription, Time.valueOf(time1), Time.valueOf(time2));
        calendarEventRepository.save(calendarEvent);

        if (endingDate == null) {
            NonRepeatingEvent nonRepeatingEvent = new NonRepeatingEvent(new NonRepeatingEventId(calendarEvent), startingDate);
            nonRepeatingEventRepository.save(nonRepeatingEvent);

        } else {
            RepeatingEvent repeatingEvent = new RepeatingEvent(new NonRepeatingEventId(calendarEvent), day, 1, startingDate, endingDate);
            repeatingEventRepository.save(repeatingEvent);
        }

        SubjectEvent subjectEvent = new SubjectEvent(new SubjectEventId(calendarEvent), subject);
        subjectEventRepository.save(subjectEvent);
        HappensAtPlace happensAtPlace = new HappensAtPlace(new NonRepeatingEventId(calendarEvent), place);
        happensAtPlaceRepository.save(happensAtPlace);

    }

    public List<ExamEvent> findAllUserExams() {
        return subjectRepository.exams(userAuthenticationService.getLoggedInUser().getStudentId());
    }

    public List<NonRepeatingClassEvent> findAllUserNonRepeatingClasses() {
        return subjectRepository.nonRepeatingClasses(userAuthenticationService.getLoggedInUser().getStudentId());
    }

    public List<RepeatingClassEvent> findAllUserRepeatingClasses() {
        return subjectRepository.repeatingClasses(userAuthenticationService.getLoggedInUser().getStudentId());
    }

    private SubjectEntity returnSubject(String subjectId) throws Exception {
        Integer subject_id = Integer.parseInt(subjectId.split("\\s+")[0]);
        Integer student_id = Integer.parseInt(subjectId.split("\\s+")[1]);
        Integer starting_year = Integer.parseInt(subjectId.split("\\s+")[2]);
        Integer finishing_year = Integer.parseInt(subjectId.split("\\s+")[3]);
        String termType = subjectId.split("\\s+")[4];

        StudentEntity studentEntity = studentRepository.findById(student_id).orElseThrow(Exception::new);
        SchoolYearEntity schoolYearEntity = schoolYearRepository.findById(new SchoolYearId(starting_year, finishing_year, studentEntity)).orElseThrow(Exception::new);
        TermEntity termEntity = termRepository.findById(new TermId(termType, schoolYearEntity)).orElseThrow(Exception::new);
        SubjectEntity subjectEntity = subjectRepository.findById(new SubjectId(subject_id, termEntity)).orElseThrow(Exception::new);
        return subjectEntity;
    }
}
