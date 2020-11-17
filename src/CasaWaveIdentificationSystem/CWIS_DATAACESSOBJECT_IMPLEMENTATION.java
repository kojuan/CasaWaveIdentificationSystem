package CasaWaveIdentificationSystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CWIS_DATAACESSOBJECT_IMPLEMENTATION implements CWIS_DATAACCESSOBJECT {

    CWIS_DATABASECONNECTION connx = new CWIS_DATABASECONNECTION();

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

    @Override
    public ArrayList<Employee> employeeList() {
        ArrayList<Employee> employeeList = new ArrayList<>();
        String selectAllSQLQueryEmployee = "SELECT * FROM `employees`";
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = connx.databaseConnection().createStatement();
            rs = stmt.executeQuery(selectAllSQLQueryEmployee);

            // Loop through the results 
            while (rs.next()) {
                Employee employee = new Employee();
                // populate Phone Setters
                employee.setId(rs.getInt("employeeId"));
                employee.setfirstName(rs.getString("firstName"));
                employee.setmiddleName(rs.getString("middleInitial"));
                employee.setlastName(rs.getString("lastName"));
                employee.setAddress(rs.getString("employeeAddress"));
                employee.setGender(rs.getString("employeeGender"));
                employee.setdateOfBirth(rs.getString("DateOfBirth"));
                employee.setbloodType(rs.getString("employeeBloodType"));
                employee.setphoneNumber(rs.getString("cellphoneNumber"));
                employee.setcivilStatus(rs.getString("civilStatus"));
                employee.setReligion(rs.getString("employeeReligion"));
                employee.setNationality(rs.getString("employeeNationality"));
                employee.setFatherEmailAd(rs.getString("fatherEmailAddress"));
                employee.setMotherEmailAd(rs.getString("motherEmailAddress"));
                employee.setDateAndTimeRegistered(rs.getString("dateAndTimeRegistered"));

                employee.setimagePath(rs.getBytes("picture"));
                employeeList.add(employee);
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

        return employeeList;
    }
    @Override
    public void populateemployeeDataTableFromMySQLDatabase(DefaultTableModel model, JTable employeeListTable) {
        ArrayList<Employee> dataArrayEmployee = employeeList();
        model = (DefaultTableModel) employeeListTable.getModel();
        // Clear patientDataTable Rows
        model.setRowCount(0);
        Object[] rowsEmployee = new Object[15];

        // Loop through the ArrayList to Populate employeeListTable
        for (int k = 0; k < dataArrayEmployee.size(); k++) {
            rowsEmployee[0] = dataArrayEmployee.get(k).getID();
            rowsEmployee[1] = dataArrayEmployee.get(k).getfirstName();
            rowsEmployee[2] = dataArrayEmployee.get(k).getMiddleInitial();
            rowsEmployee[3] = dataArrayEmployee.get(k).getLastName();
            rowsEmployee[4] = dataArrayEmployee.get(k).getAddress();
            rowsEmployee[5] = dataArrayEmployee.get(k).getGender();
            rowsEmployee[6] = dataArrayEmployee.get(k).getdateOfBirth();
            rowsEmployee[7] = dataArrayEmployee.get(k).getbloodType();
            rowsEmployee[8] = dataArrayEmployee.get(k).getphoneNumber();
            rowsEmployee[9] = dataArrayEmployee.get(k).getcivilStatus();
            rowsEmployee[10] = dataArrayEmployee.get(k).getReligion();
            rowsEmployee[11] = dataArrayEmployee.get(k).getNationality();
            rowsEmployee[12] = dataArrayEmployee.get(k).getFatherEmailAd();
            rowsEmployee[13] = dataArrayEmployee.get(k).getMotherEmailAd();
            rowsEmployee[14] = dataArrayEmployee.get(k).getDateAndTimeRegistered();
            model.addRow(rowsEmployee);

        }
    }

}
