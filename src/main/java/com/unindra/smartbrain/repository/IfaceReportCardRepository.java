/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unindra.smartbrain.repository;

import com.unindra.smartbrain.model.ReportCard;
import java.util.List;

/**
 *
 * @author harunnurrasyid
 */
public interface IfaceReportCardRepository {
    ReportCard createReportCard(ReportCard reportCard);
    ReportCard getReportCardById(int id);
    ReportCard updateReportCardById(int id, ReportCard reportCard);
    List<ReportCard> getReportCards();
    void deleteReportCardById(int id);
}
