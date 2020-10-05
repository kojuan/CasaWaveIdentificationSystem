package healthMonitoringSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HMS_DATABASECONNECTION {

    // get database authentication
    String dbUsername = "root";
    String dbPassword = "root";
    String dbServerUrl = "jdbc:mysql://localhost:3306/health_monitoring_system_database";
    String dbClassPathUrl = "com.mysql.jdbc.Driver";

    public final Connection databaseConnection() {
        Connection conn;
        try {
            Class.forName(dbClassPathUrl); // load driver
            // connect to database 
            conn = DriverManager.getConnection(dbServerUrl, dbUsername, dbPassword);
            return conn;
        } catch (SQLException ex) {
            return null;
        } catch (ClassNotFoundException ex) {
        }
        return null;
    }

}
