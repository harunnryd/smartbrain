/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unindra.smartbrain.database;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author harunnurrasyid
 */
public class NamedParamStatement {
    public NamedParamStatement(Connection conn, String sql) throws SQLException {
        int pos;
        while((pos = sql.indexOf(":")) != -1) {
            int end = sql.substring(pos).indexOf(" ");
            if (end == -1)
                end = sql.length();
            else
                end += pos;
            fields.add(sql.substring(pos+1,end));
            sql = sql.substring(0, pos) + "?" + sql.substring(end);
        }       
        prepStmt = conn.prepareStatement(sql);
    }

    public PreparedStatement getPreparedStatement() {
        return prepStmt;
    }
    public ResultSet executeQuery() throws SQLException {
        return prepStmt.executeQuery();
    }
    public void close() throws SQLException {
        prepStmt.close();
    }

    public void setInt(String name, int value) throws SQLException {        
        prepStmt.setInt(getIndex(name), value);
    }
    
    public void setLong(String name, Long value) throws SQLException {
        prepStmt.setLong(getIndex(name), value);
    }
    
    public void setString(String name, String value) throws SQLException {
        prepStmt.setString(getIndex(name), value);
    }

    private int getIndex(String name) {
        return fields.indexOf(name)+1;
    }
    
    private PreparedStatement prepStmt;
    private List<String> fields = new ArrayList<String>();
}