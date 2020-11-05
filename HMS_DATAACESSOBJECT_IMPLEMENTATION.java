package healthMonitoringSystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class HMS_DATAACESSOBJECT_IMPLEMENTATION implements HMS_DATAACCESSOBJECT {

    HMS_DATABASECONNECTION connx = new HMS_DATABASECONNECTION();

    @Override
    // Store database results in Arrayist Method
    public ArrayList<Patient> patientList() {
        ArrayList<Patient> patientList = new ArrayList<>();
        String selectAllSQLQuery = "SELECT * FROM `patients`";
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = connx.databaseConnection().createStatement();
            rs = stmt.executeQuery(selectAllSQLQuery);

            // Loop through the results 
            while (rs.next()) {
                Patient patient = new Patient();
                // populate Phone Setters
                patient.setId(rs.getInt("id"));
                patient.setfirstName(rs.getString("FirstName"));
                patient.setmiddleName(rs.getString("MiddleName"));
                patient.setlastName(rs.getString("LastName"));
                patient.setGender(rs.getString("Gender"));
                patient.setdateOfBirth(rs.getString("DateOfBirth"));
                patient.setbloodType(rs.getString("BloodType"));
                patient.setcivilStatus(rs.getString("CivilStatus"));
                patient.setReligion(rs.getString("Religion"));
                patient.setNationality(rs.getString("Nationality"));
                patient.setphoneNumber(rs.getString("CellphoneNumber"));
                patient.setimagePath(rs.getBytes("ImagePath"));
                patientList.add(patient);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            // Close variables to prevent java.sql.SQLException: Java heap space error

            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }

            } catch (SQLException sQLException) {
                sQLException.getMessage();
            }

        }

        return patientList;
    }

    @Override
    public void populatepatientDataTableFromMySQLDatabase(DefaultTableModel model, JTable patientDataTable) {
        ArrayList<Patient> dataArray = patientList();
        model = (DefaultTableModel) patientDataTable.getModel();
        // Clear patientDataTable Rows
        model.setRowCount(0);
        Object[] rows = new Object[12];

        // Loop through the ArrayList to Populate patientDataTable
        for (int i = 0; i < dataArray.size(); i++) {
            rows[0] = dataArray.get(i).getID();
            rows[1] = dataArray.get(i).getfirstName();
            rows[2] = dataArray.get(i).getMiddleName();
            rows[3] = dataArray.get(i).getLastName();
            rows[4] = dataArray.get(i).getGender();
            rows[5] = dataArray.get(i).getdateOfBirth();
            rows[6] = dataArray.get(i).getbloodType();
            rows[7] = dataArray.get(i).getcivilStatus();
            rows[8] = dataArray.get(i).getReligion();
            rows[9] = dataArray.get(i).getNationality();
            rows[10] = dataArray.get(i).getphoneNumber();
            model.addRow(rows);

        }
    }
}
