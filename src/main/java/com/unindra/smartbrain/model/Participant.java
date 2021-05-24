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
public class Participant {
    private Integer id, age;
    private String name, address;
    
    public Participant() {
        
    }
    
    public Participant(Integer id, String name, Integer age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }
    
    public Participant(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
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
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public Integer getAge() {
        return this.age;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getAddress() {
        return this.address;
    }
}
