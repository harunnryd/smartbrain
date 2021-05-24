/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unindra.smartbrain.repository;

import com.unindra.smartbrain.database.EntityManager;
import com.unindra.smartbrain.database.NamedParamStatement;
import com.unindra.smartbrain.model.Participant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author harunnurrasyid
 */
public class ParticipantRepository implements IfaceParticipantRepository {

    EntityManager entityManager;
    Participant participant;

    public ParticipantRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Participant createParticipant(Participant participant) {
        try {
            Connection dbase = this.entityManager.connectPgSQL();
            PreparedStatement statement = dbase.prepareStatement("INSERT INTO participants (name, age, address) VALUES (?, ?, ?)");
            statement.setString(1, participant.getName());
            statement.setInt(2, participant.getAge());
            statement.setString(3, participant.getAddress());
            
            int affectedRow = statement.executeUpdate();
            
            participant.setId(affectedRow);
            
            return participant;
        } catch (Exception e) {
            e.printStackTrace();
            return new Participant();
        }
    }

    @Override
    public Participant getParticipantById(int id) {
        try {
            Connection dbase = this.entityManager.connectPgSQL();
            NamedParamStatement statement = new NamedParamStatement(dbase, "SELECT id, name, age, address FROM participants WHERE id = :id LIMIT 1");
            statement.setInt("id", id);
            
            ResultSet result = statement.executeQuery();
            Participant participant = new Participant();

            while (result.next()) {
                participant.setId(result.getInt("id"));
                participant.setName(result.getString("name"));
                participant.setAge(result.getInt("age"));
                participant.setAddress(result.getString("address"));
                
            }
            
            return participant;
        } catch (Exception e) {
            e.printStackTrace();
            return new Participant();
        }
    }

    @Override
    public Participant getParticipantByName(String name) {
        try {
            Connection dbase = this.entityManager.connectPgSQL();
            NamedParamStatement statement = new NamedParamStatement(dbase, "SELECT id, name, age, address FROM participants WHERE name = :name LIMIT 1");
            statement.setString("name", name);
            
            ResultSet result = statement.executeQuery();
            Participant participant = new Participant();

            while (result.next()) {
                participant.setId(result.getInt("id"));
                participant.setName(result.getString("name"));
                participant.setAge(result.getInt("age"));
                participant.setAddress(result.getString("address"));
                
            }
            
            return participant;
        } catch (Exception e) {
            e.printStackTrace();
            return new Participant();
        }
    }    

    @Override
    public List<Participant> getParticipants() {
        try {
            List<Participant> participants = new ArrayList<Participant>();
            Connection dbase = this.entityManager.connectPgSQL();
            NamedParamStatement statement = new NamedParamStatement(dbase, "SELECT id, name, age, address FROM participants ORDER BY id ASC");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                participants.add(new Participant(result.getInt("id"), result.getString("name"), result.getInt("age"), result.getString("address")));
            }
            
            return participants;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Participant>();
        }
    }

    @Override
    public Participant updateParticipantById(int id, Participant participant) {
        try {
            Connection dbase = this.entityManager.connectPgSQL();
            PreparedStatement statement = dbase.prepareStatement("UPDATE participants SET name = ?, age = ?, address = ? WHERE id = ?");
            statement.setString(1, participant.getName());
            statement.setInt(2, participant.getAge());
            statement.setString(3, participant.getAddress());
            statement.setInt(4, id);
            
            statement.executeUpdate();
            
            participant.setId(id);
            
            return participant;
        } catch (Exception e) {
            e.printStackTrace();
            return new Participant();
        }
    }

    @Override
    public void deleteParticipantById(int id) {
        try {
            Connection dbase = this.entityManager.connectPgSQL();
            PreparedStatement statement = dbase.prepareStatement("DELETE FROM participants WHERE id = ?");
            statement.setInt(1, id);
            
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
