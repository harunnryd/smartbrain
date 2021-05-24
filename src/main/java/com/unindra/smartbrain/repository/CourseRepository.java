/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unindra.smartbrain.repository;

import com.unindra.smartbrain.database.EntityManager;
import com.unindra.smartbrain.database.NamedParamStatement;
import com.unindra.smartbrain.model.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author harunnurrasyid
 */
public class CourseRepository implements IfaceCourseRepository {

    EntityManager entityManager;
    Course course;

    public CourseRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Course createCourse(Course course) {
        try {
            Connection dbase = this.entityManager.connectPgSQL();
            PreparedStatement statement = dbase.prepareStatement("INSERT INTO courses (name) VALUES (?)");
            statement.setString(1, course.getName());

            int affectedRow = statement.executeUpdate();

            course.setId(affectedRow);

            return course;
        } catch (Exception e) {
            e.printStackTrace();
            return new Course();
        }
    }

    @Override
    public Course getCourseById(int id) {
        try {
            Connection dbase = this.entityManager.connectPgSQL();
            NamedParamStatement statement = new NamedParamStatement(dbase, "SELECT id, name FROM courses WHERE id = :id LIMIT 1");
            statement.setInt("id", id);

            ResultSet result = statement.executeQuery();
            Course course = new Course();

            while (result.next()) {
                course.setId(result.getInt("id"));
                course.setName(result.getString("name"));
            }

            return course;
        } catch (Exception e) {
            e.printStackTrace();
            return new Course();
        }
    }
    
    @Override
    public Course getCourseByName(String name) {
        try {
            Connection dbase = this.entityManager.connectPgSQL();
            NamedParamStatement statement = new NamedParamStatement(dbase, "SELECT id, name FROM courses WHERE name = :name LIMIT 1");
            statement.setString("name", name);

            ResultSet result = statement.executeQuery();
            Course course = new Course();

            while (result.next()) {
                course.setId(result.getInt("id"));
                course.setName(result.getString("name"));
            }

            return course;
        } catch (Exception e) {
            e.printStackTrace();
            return new Course();
        }
    }
    

    @Override
    public Course updateCourseById(int id, Course course) {
        try {
            Connection dbase = this.entityManager.connectPgSQL();
            PreparedStatement statement = dbase.prepareStatement("UPDATE courses SET name = ? WHERE id = ?");
            statement.setString(1, course.getName());
            statement.setInt(2, id);

            statement.executeUpdate();

            course.setId(id);

            return course;
        } catch (Exception e) {
            e.printStackTrace();
            return new Course();
        }
    }

    @Override
    public List<Course> getCourses() {
        try {
            List<Course> courses = new ArrayList<Course>();
            Connection dbase = this.entityManager.connectPgSQL();
            NamedParamStatement statement = new NamedParamStatement(dbase, "SELECT id, name FROM courses ORDER BY id ASC");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                courses.add(new Course(result.getInt("id"), result.getString("name")));
            }

            return courses;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Course>();
        }
    }

    @Override
    public void deleteCourseById(int id) {
        try {
            Connection dbase = this.entityManager.connectPgSQL();
            PreparedStatement statement = dbase.prepareStatement("DELETE FROM courses WHERE id = ?");
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
