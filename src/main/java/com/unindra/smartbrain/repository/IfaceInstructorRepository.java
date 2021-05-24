/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unindra.smartbrain.repository;

import com.unindra.smartbrain.model.Instructor;
import java.util.List;

/**
 *
 * @author harunnurrasyid
 */
public interface IfaceInstructorRepository {
    Instructor createInstructor(Instructor instructor);
    Instructor getInstructorById(int id);
    Instructor getInstructorByName(String name);
    Instructor updateInstructorById(int id, Instructor instructor);
    List<Instructor> getInstructors();
    void deleteInstructorById(int id);
}
