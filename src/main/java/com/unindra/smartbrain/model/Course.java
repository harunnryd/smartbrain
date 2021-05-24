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
public class Course {
    Integer id;
    String name;
    
    public Course() {
        
    }
    
    public Course(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public Course(String name) {
        this.name = name;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
}
