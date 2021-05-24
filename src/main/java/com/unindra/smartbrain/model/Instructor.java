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
public class Instructor {
    Integer id;
    String name;
    Integer age;
    
    public Instructor() {}
    
    public Instructor(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    
    public Instructor(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public Integer getAge() {
        return this.age;
    }
}
