/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unindra.smartbrain.repository;

import com.unindra.smartbrain.database.EntityManager;
import com.unindra.smartbrain.database.NamedParamStatement;
import com.unindra.smartbrain.model.ReportCard;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author harunnurrasyid
 */
public class ReportCardRepository implements IfaceReportCardRepository {

    EntityManager entityManager;
    ReportCard reportCard;

    public ReportCardRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public ReportCard createReportCard(ReportCard reportCard) {
        try {
            Connection dbase = this.entityManager.connectPgSQL();
            PreparedStatement statement = dbase.prepareStatement("INSERT INTO report_cards (instructor_id, participant_id, course_id, score, school_year) VALUES (?, ?, ?, ?, ?)");
            statement.setInt(1, reportCard.getInstructorId());
            statement.setInt(2, reportCard.getParticipantId());
            statement.setInt(3, reportCard.getCourseId());
            statement.setInt(4, reportCard.getScore());
            statement.setString(5, reportCard.getSchoolYear());
            
            int affectedRow = statement.executeUpdate();
            
            reportCard.setId(affectedRow);
            
            return reportCard;
        } catch (Exception e) {
            e.printStackTrace();
            return new ReportCard();
        }
    }

    @Override
    public ReportCard getReportCardById(int id) {
        try {
            Connection dbase = this.entityManager.connectPgSQL();
            String query = "SELECT "
                    + "rCard.*, "
                    + "instructor.name AS instructor_name, "
                    + "participant.name AS participant_name, "
                    + "course.name AS course_name "
                    + "FROM report_cards rCard "
                    + "INNER JOIN instructors instructor ON rCard.instructor_id = instructor.id "
                    + "INNER JOIN participants participant ON rCard.participant_id = participant.id "
                    + "INNER JOIN courses course ON rCard.course_id = course.id "
                    + "WHERE rCard.id = :id "
                    + "LIMIT 1";
            
            NamedParamStatement statement = new NamedParamStatement(dbase, query);
            statement.setInt("id", id);
            
            ResultSet result = statement.executeQuery();
            ReportCard reportCard = new ReportCard();

            while (result.next()) {
                reportCard.setId(result.getInt("id"));
                reportCard.setInstructorId(result.getInt("instructor_id"));
                reportCard.setInstructorName(result.getString("instructor_name"));
                reportCard.setParticipantId(result.getInt("participant_id"));
                reportCard.setParticipantName(result.getString("participant_name"));
                reportCard.setCourseId(result.getInt("course_id"));
                reportCard.setCourseName(result.getString("course_name"));
                reportCard.setScore(result.getInt("score"));
                reportCard.setSchoolYear(result.getString("school_year"));
            }
            
            return reportCard;
        } catch (Exception e) {
            e.printStackTrace();
            return new ReportCard();
        }
    }

    @Override
    public List<ReportCard> getReportCards() {
        try {
            List<ReportCard> reportCards = new ArrayList<ReportCard>();
            Connection dbase = this.entityManager.connectPgSQL();
            String query = "SELECT "
                    + "rCard.*,"
                    + "instructor.name AS instructor_name, "
                    + "participant.name AS participant_name, "
                    + "course.name AS course_name "
                    + "FROM report_cards rCard "
                    + "INNER JOIN instructors instructor ON rCard.instructor_id = instructor.id "
                    + "INNER JOIN participants participant ON rCard.participant_id = participant.id "
                    + "INNER JOIN courses course ON rCard.course_id = course.id "
                    + "ORDER BY rCard.id ASC";
            
            NamedParamStatement statement = new NamedParamStatement(dbase, query);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                reportCards.add(new ReportCard(
                        result.getInt("id"), 
                        result.getInt("instructor_id"),
                        result.getString("instructor_name"),
                        result.getInt("participant_id"),
                        result.getString("participant_name"),
                        result.getInt("course_id"),
                        result.getString("course_name"),
                        result.getInt("score"),
                        result.getString("school_year")
                ));
            }
            
            return reportCards;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<ReportCard>();
        }
    }

    @Override
    public ReportCard updateReportCardById(int id, ReportCard reportCard) {
        try {
            Connection dbase = this.entityManager.connectPgSQL();
            String query = "UPDATE report_cards "
                    + "SET instructor_id = ?, "
                    + "participant_id = ?, "
                    + "course_id = ?, "
                    + "score = ?,"
                    + "school_year = ?"
                    + "WHERE id = ?";
            
            PreparedStatement statement = dbase.prepareStatement(query);
            statement.setInt(1, reportCard.getInstructorId());
            statement.setInt(2, reportCard.getParticipantId());
            statement.setInt(3, reportCard.getCourseId());
            statement.setInt(4, reportCard.getScore());
            statement.setString(5, reportCard.getSchoolYear());
            
            statement.setInt(6, id);
            
            statement.executeUpdate();
            
            reportCard.setId(id);
            
            return reportCard;
        } catch (Exception e) {
            e.printStackTrace();
            return new ReportCard();
        }
    }

    @Override
    public void deleteReportCardById(int id) {
        try {
            Connection dbase = this.entityManager.connectPgSQL();
            PreparedStatement statement = dbase.prepareStatement("DELETE FROM report_cards WHERE id = ?");
            statement.setInt(1, id);
            
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
