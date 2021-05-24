/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unindra.smartbrain.repository;

import com.unindra.smartbrain.model.Course;
import java.util.List;

/**
 *
 * @author harunnurrasyid
 */
public interface IfaceCourseRepository {
    Course createCourse(Course course);
    Course getCourseById(int id);
    Course getCourseByName(String name);
    Course updateCourseById(int id, Course course);
    List<Course> getCourses();
    void deleteCourseById(int id);
}
