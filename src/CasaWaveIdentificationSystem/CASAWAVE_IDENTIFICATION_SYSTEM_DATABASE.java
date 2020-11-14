package CasaWaveIdentificationSystem;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 *
 * @author Khian Orland
 */
public class CASAWAVE_IDENTIFICATION_SYSTEM_DATABASE {

    private static String servername = "localhost"; // default
    private static String username = "root"; // default
    private static String dbname = "casawave_identification_system_database"; // to get dbname, go to localhost/phpmyadmin
    private static Integer portnumber = 3306; // to get portnumber, go to XAMPP MySQL Port(s)
    private static String password = "root"; // default

    public static Connection getConnection() {
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
            JOptionPane.showMessageDialog(null, "ERROR. Please Activate Server Database Connection.\nPlease restart application with active server database connection.", "Server Offline", JOptionPane.INFORMATION_MESSAGE);
        }
        return cnx;
    }

}
