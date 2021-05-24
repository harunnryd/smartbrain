/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unindra.smartbrain.model;

/**
 *
 * @author harunnurrasyid
 */
public class ReportCard {

    Integer id;
    Integer instructorId;
    String instructorName;
    Integer participantId;
    String participantName;
    Integer courseId;
    String courseName;
    Integer score;
    String schoolYear;

    public ReportCard() {
    }

    public ReportCard(Integer id, Integer instructorId, Integer participantId, Integer courseId, Integer score, String schoolYear) {
        this.id = id;
        this.instructorId = instructorId;
        this.participantId = participantId;
        this.courseId = courseId;
        this.score = score;
        this.schoolYear = schoolYear;
    }
    
    public ReportCard(Integer id, Integer instructorId, String instructorName, Integer participantId, String participantName, Integer courseId, String courseName, Integer score, String schoolYear) {
        this.id = id;
        this.instructorId = instructorId;
        this.instructorName = instructorName;
        this.participantId = participantId;
        this.participantName = participantName;
        this.courseId = courseId;
        this.courseName = courseName;
        this.score = score;
        this.schoolYear = schoolYear;
    }

    public ReportCard(Integer instructorId, Integer participantId, Integer courseId, Integer score, String schoolYear) {
        this.instructorId = instructorId;
        this.participantId = participantId;
        this.courseId = courseId;
        this.score = score;
        this.schoolYear = schoolYear;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setInstructorId(Integer instructorId) {
        this.instructorId = instructorId;
    }

    public Integer getInstructorId() {
        return this.instructorId;
    }
    
    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getInstructorName() {
        return this.instructorName;
    }

    public void setParticipantId(Integer participantId) {
        this.participantId = participantId;
    }

    public Integer getParticipantId() {
        return this.participantId;
    }
    
    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public String getParticipantName() {
        return this.participantName;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getCourseId() {
        return this.courseId;
    }
    
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getScore() {
        return this.score;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public String getSchoolYear() {
        return this.schoolYear;
    }
}
