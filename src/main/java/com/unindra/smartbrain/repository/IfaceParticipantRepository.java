/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unindra.smartbrain.repository;

import com.unindra.smartbrain.model.Participant;
import java.util.List;

/**
 *
 * @author harunnurrasyid
 */
public interface IfaceParticipantRepository {
    Participant createParticipant(Participant participant);
    Participant getParticipantById(int id);
    Participant getParticipantByName(String name);
    Participant updateParticipantById(int id, Participant participant);
    List<Participant> getParticipants();
    void deleteParticipantById(int id);
}
