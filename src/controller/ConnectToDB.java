/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author AD
 */
public class ConnectToDB {

    private Connection connectionToDB;

    public ConnectToDB() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connectionToDB = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=QLCB;username=sa;password=conchocun!@#456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnectionToDB() {
        return connectionToDB;
    }

    public void setConnectionToDB(Connection connectionToDB) {
        this.connectionToDB = connectionToDB;
    }

}
