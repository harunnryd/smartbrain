/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unindra.smartbrain.repository;

import com.unindra.smartbrain.model.Instructor;
import com.unindra.smartbrain.database.EntityManager;
import com.unindra.smartbrain.database.NamedParamStatement;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;


/**
 *
 * @author harunnurrasyid
 */
public class InstructorRepository implements IfaceInstructorRepository {

    EntityManager entityManager;
    Instructor instructor;

    public InstructorRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Instructor createInstructor(Instructor instructor) {
        try {
            Connection dbase = this.entityManager.connectPgSQL();
            PreparedStatement statement = dbase.prepareStatement("INSERT INTO instructors (name, age) VALUES (?, ?)");
            statement.setString(1, instructor.getName());
            statement.setInt(2, instructor.getAge());
            
            int affectedRow = statement.executeUpdate();
            
            instructor.setId(affectedRow);
            
            return instructor;
        } catch (Exception e) {
            e.printStackTrace();
            return new Instructor();
        }
    }

    @Override
    public Instructor getInstructorById(int id) {
        try {
            Connection dbase = this.entityManager.connectPgSQL();
            NamedParamStatement statement = new NamedParamStatement(dbase, "SELECT id, name, age FROM instructors WHERE id = :id LIMIT 1");
            statement.setInt("id", id);
            
            ResultSet result = statement.executeQuery();
            Instructor instructor = new Instructor();

            while (result.next()) {
                instructor.setId(result.getInt("id"));
                instructor.setName(result.getString("name"));
                instructor.setAge(result.getInt("age"));
            }
            
            return instructor;
        } catch (Exception e) {
            e.printStackTrace();
            return new Instructor();
        }
    }
    
    @Override
    public Instructor getInstructorByName(String name) {
        try {
            Connection dbase = this.entityManager.connectPgSQL();
            NamedParamStatement statement = new NamedParamStatement(dbase, "SELECT id, name, age FROM instructors WHERE name = :name LIMIT 1");
            statement.setString("name", name);
            
            ResultSet result = statement.executeQuery();
            Instructor instructor = new Instructor();

            while (result.next()) {
                instructor.setId(result.getInt("id"));
                instructor.setName(result.getString("name"));
                instructor.setAge(result.getInt("age"));
            }
            
            return instructor;
        } catch (Exception e) {
            e.printStackTrace();
            return new Instructor();
        }
    }

    @Override
    public List<Instructor> getInstructors() {
        try {
            List<Instructor> instructors = new ArrayList<Instructor>();
            Connection dbase = this.entityManager.connectPgSQL();
            NamedParamStatement statement = new NamedParamStatement(dbase, "SELECT id, name, age FROM instructors ORDER BY id ASC");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                instructors.add(new Instructor(result.getInt("id"), result.getString("name"), result.getInt("age")));
            }
            
            return instructors;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Instructor>();
        }
    }

    @Override
    public Instructor updateInstructorById(int id, Instructor instructor) {
        try {
            Connection dbase = this.entityManager.connectPgSQL();
            PreparedStatement statement = dbase.prepareStatement("UPDATE instructors SET name = ?, age = ? WHERE id = ?");
            statement.setString(1, instructor.getName());
            statement.setInt(2, instructor.getAge());
            statement.setInt(3, id);
            
            statement.executeUpdate();
            
            instructor.setId(id);
            
            return instructor;
        } catch (Exception e) {
            e.printStackTrace();
            return new Instructor();
        }
    }

    @Override
    public void deleteInstructorById(int id) {
        try {
            Connection dbase = this.entityManager.connectPgSQL();
            PreparedStatement statement = dbase.prepareStatement("DELETE FROM instructors WHERE id = ?");
            statement.setInt(1, id);
            
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
