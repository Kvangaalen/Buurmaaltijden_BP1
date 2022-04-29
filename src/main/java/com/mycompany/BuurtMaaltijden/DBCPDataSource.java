// Wordt A.T.M. niet meeer gebruikt.
package com.mycompany.BuurtMaaltijden;

import java.sql.SQLException;
import java.sql.Connection;
import org.apache.commons.dbcp2.BasicDataSource;

public class DBCPDataSource {
    
    private static BasicDataSource ds = new BasicDataSource();
    
    static{
        ds.setUrl("jdbc:mysql://localhost:3306/buurtmaaltijd?useSSL=false");
        ds.setUsername("buurtmaaltijden");
        ds.setPassword("admin123");
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }
    
    public static Connection getConnection() throws SQLException{
        return ds.getConnection();
    }
    
    private DBCPDataSource(){
        
    }
    
}
