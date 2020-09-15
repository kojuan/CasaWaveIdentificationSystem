
package healthMonitoringSystem;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Khian Orland
 */
public class HEALTH_MONITORING_SYSTEM_DATABASE {
  
    private static String servername = "localhost"; // default
    private static String username = "root"; // default
    private static String dbname = "health_monitoring_system_database"; // to get dbname, go to localhost/phpmyadmin
    private static Integer portnumber = 3306; // to get portnumber, go to XAMPP MySQL Port(s)
    private static String password = ""; // default
    
    public static Connection getConnection()
    {
        Connection cnx = null;
        
        MysqlDataSource datasource = new MysqlDataSource();
        
        datasource.setServerName(servername);
        datasource.setUser(username);
        datasource.setPassword(password);
        datasource.setDatabaseName(dbname);
        datasource.setPortNumber(portnumber);
        
        try {
            cnx = datasource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger("ERROR. Get Connection => " + HEALTH_MONITORING_SYSTEM_DATABASE.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cnx;
    }
    
}
