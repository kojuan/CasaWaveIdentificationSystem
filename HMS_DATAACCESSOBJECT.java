
package healthMonitoringSystem;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public interface HMS_DATAACCESSOBJECT {
    public ArrayList<Patient> patientList();
    public void populatepatientDataTableFromMySQLDatabase(DefaultTableModel model, JTable patientDataTable);
}
