package com.example.task.repository;

import com.example.task.entity.projection.NonRepeatingClassEvent;
import com.example.task.entity.projection.ExamEvent;
import com.example.task.entity.projection.RepeatingClassEvent;
import com.example.task.entity.subject.SubjectEntity;
import com.example.task.entity.subject.SubjectId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity, SubjectId> {

    @Query(value = "SELECT sat.subject_name AS subjectName, " +
            "ce.event_name AS eventName, " +
            "ce.event_type AS eventType, " +
            "nre.event_date AS eventDate, " +
            "ce.event_start_time AS eventStartTime, " +
            "ce.event_end_time AS eventEndTime, " +
            "ce.calendar_event_id AS eventId " +
            "FROM project.non_repeating_event AS nre " +
            "JOIN project.calendar_event AS ce ON nre.calendar_event_id = ce.calendar_event_id " +
            "JOIN project.subject_event AS sbe ON ce.calendar_event_id = sbe.calendar_event_id " +
            "JOIN project.subject_at_term AS sat ON sat.term_subject_id = sbe.term_subject_id " +
            "AND sat.term_type = sbe.term_type " +
            "AND sat.starting_year = sbe.starting_year " +
            "AND sat.finishing_year = sbe.finishing_year " +
            "AND sat.student_id = sbe.student_id " +
            "WHERE nre.event_date >= CURRENT_DATE " +
            "AND ce.event_type = 'Exam' " +
            "AND sbe.student_id = :studentId " +
            "ORDER BY nre.event_date, ce.event_start_time", nativeQuery = true)
    List<ExamEvent> exams(@Param("studentId") Integer studentId);

    @Query(value = "SELECT sat.subject_name AS subjectName, " +
            "ce.event_name AS eventName, " +
            "ce.event_type AS eventType, " +
            "nre.event_date AS eventDate, " +
            "ce.event_start_time AS eventStartTime, " +
            "ce.event_end_time AS eventEndTime, " +
            "ce.calendar_event_id AS eventId " +
            "FROM project.non_repeating_event AS nre " +
            "JOIN project.calendar_event AS ce ON nre.calendar_event_id = ce.calendar_event_id " +
            "JOIN project.subject_event AS sbe ON ce.calendar_event_id = sbe.calendar_event_id " +
            "JOIN project.subject_at_term AS sat ON sat.term_subject_id = sbe.term_subject_id " +
            "AND sat.term_type = sbe.term_type " +
            "AND sat.starting_year = sbe.starting_year " +
            "AND sat.finishing_year = sbe.finishing_year " +
            "AND sat.student_id = sbe.student_id " +
            "WHERE nre.event_date >= CURRENT_DATE " +
            "AND ce.event_type = 'Class' " +
            "AND sbe.student_id = :studentId " +
            "ORDER BY nre.event_date, ce.event_start_time", nativeQuery = true)
    List<NonRepeatingClassEvent> nonRepeatingClasses(@Param("studentId") Integer studentId);

    @Query(value = "SELECT sat.subject_name AS subjectName, " +
            "ce.event_name AS eventName, " +
            "ce.event_type AS eventType, " +
            "nre.starting_date AS eventStartingDate, " +
            "nre.ending_date AS eventEndingDate, " +
            "nre.event_week_day AS eventDay, " +
            "ce.event_start_time AS eventStartTime, " +
            "ce.event_end_time AS eventEndTime, " +
            "ce.calendar_event_id AS eventId " +
            "FROM project.repeating_event AS nre " +
            "JOIN project.calendar_event AS ce ON nre.calendar_event_id = ce.calendar_event_id " +
            "JOIN project.subject_event AS sbe ON ce.calendar_event_id = sbe.calendar_event_id " +
            "JOIN project.subject_at_term AS sat ON sat.term_subject_id = sbe.term_subject_id " +
            "AND sat.term_type = sbe.term_type " +
            "AND sat.starting_year = sbe.starting_year " +
            "AND sat.finishing_year = sbe.finishing_year " +
            "AND sat.student_id = sbe.student_id " +
            "WHERE nre.starting_date >= CURRENT_DATE " +
            "AND ce.event_type = 'Class' " +
            "AND sbe.student_id = :studentId " +
            "ORDER BY nre.starting_date, ce.event_start_time", nativeQuery = true)
    List<RepeatingClassEvent> repeatingClasses(@Param("studentId") Integer studentId);


}
