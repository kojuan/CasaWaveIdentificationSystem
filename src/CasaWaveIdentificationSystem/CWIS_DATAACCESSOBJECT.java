
package CasaWaveIdentificationSystem;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public interface CWIS_DATAACCESSOBJECT {
    public ArrayList<Patient> patientList();
    public void populatepatientDataTableFromMySQLDatabase(DefaultTableModel model, JTable patientDataTable);
    public ArrayList<Employee> employeeList();
    public void populateemployeeDataTableFromMySQLDatabase(DefaultTableModel model, JTable employeeListTable);
}
