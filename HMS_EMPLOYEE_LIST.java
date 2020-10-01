
package healthMonitoringSystem;


import com.mysql.jdbc.Connection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

/**
 * @author Khian Orland
 */
public final class HMS_EMPLOYEE_LIST extends javax.swing.JFrame {

    /**
     * Creates new form HMS_EMPLOYEE_LIST
     */
    
    public HMS_EMPLOYEE_LIST() {

       
        
        initComponents();
        DisplayTable();
        showDate();
        showTime();
    }
    public void DisplayTable(){
        PreparedStatement pstmt;
        ResultSet rs;
        DefaultTableModel dm = (DefaultTableModel) employeeListTable.getModel();
        dm.fireTableDataChanged();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String username = "root";
            String password = "root";
            java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/health_monitoring_system_database", username, password);
            String sql = "SELECT * FROM employees";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            employeeListTable.setModel(DbUtils.resultSetToTableModel(rs));

       
        } catch(ClassNotFoundException | SQLException err) {
            JOptionPane.showMessageDialog(null, err);
        } 
    }

    // FILTER DATA
    private void filter (String query) {
        DefaultTableModel dm = (DefaultTableModel) employeeListTable.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dm);
        employeeListTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    
    void showDate() {
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateLabel.setText(simpleDateFormat.format(date));
         }
        
        void showTime() {
        new Timer (0, new ActionListener() {
           
           @Override
           public void actionPerformed(ActionEvent e) {
               Date date = new Date();
               SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss a");
               timeLabel.setText(simpleDateFormat.format(date));
           }
        }).start();
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPanelforImageLabel = new javax.swing.JPanel();
        headImageLabel = new javax.swing.JLabel();
        toolbarPanel = new javax.swing.JPanel();
        bottomPanel = new javax.swing.JPanel();
        dateLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        mainEmployeePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        employeeListTable = new javax.swing.JTable();
        searchEmployeeButton = new javax.swing.JButton();
        updateEmployeeButton = new javax.swing.JButton();
        deleteEmployeeButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        filterSearchTf = new javax.swing.JTextField();
        refreshDataButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setName("hmsEmployeeFrame"); // NOI18N
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        setResizable(false);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });

        topPanelforImageLabel.setBackground(new java.awt.Color(235, 241, 253));

        headImageLabel.setBackground(new java.awt.Color(235, 241, 253));
        headImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/healthMonitoringSystem/APP_IMAGES/mainprogram/HMS_TOPPANEL_EMPLOYEES_fit.png"))); // NOI18N

        javax.swing.GroupLayout topPanelforImageLabelLayout = new javax.swing.GroupLayout(topPanelforImageLabel);
        topPanelforImageLabel.setLayout(topPanelforImageLabelLayout);
        topPanelforImageLabelLayout.setHorizontalGroup(
            topPanelforImageLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelforImageLabelLayout.createSequentialGroup()
                .addComponent(headImageLabel)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        topPanelforImageLabelLayout.setVerticalGroup(
            topPanelforImageLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headImageLabel)
        );

        toolbarPanel.setBackground(new java.awt.Color(153, 153, 255));
        toolbarPanel.setMaximumSize(new java.awt.Dimension(292, 30));
        toolbarPanel.setRequestFocusEnabled(false);

        javax.swing.GroupLayout toolbarPanelLayout = new javax.swing.GroupLayout(toolbarPanel);
        toolbarPanel.setLayout(toolbarPanelLayout);
        toolbarPanelLayout.setHorizontalGroup(
            toolbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        toolbarPanelLayout.setVerticalGroup(
            toolbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        bottomPanel.setBackground(new java.awt.Color(153, 153, 255));
        bottomPanel.setMaximumSize(new java.awt.Dimension(292, 30));
        bottomPanel.setRequestFocusEnabled(false);

        dateLabel.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(255, 255, 255));
        dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateLabel.setText("Date");
        dateLabel.setRequestFocusEnabled(false);

        timeLabel.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        timeLabel.setForeground(new java.awt.Color(255, 255, 255));
        timeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLabel.setText("Time");
        timeLabel.setRequestFocusEnabled(false);

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(timeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainEmployeePanel.setBackground(new java.awt.Color(235, 241, 253));
        mainEmployeePanel.setMaximumSize(new java.awt.Dimension(1920, 1080));
        mainEmployeePanel.setMinimumSize(new java.awt.Dimension(1920, 1080));
        mainEmployeePanel.setRequestFocusEnabled(false);
        mainEmployeePanel.setVerifyInputWhenFocusTarget(false);

        employeeListTable.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        employeeListTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        employeeListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "FIRST NAME", "MIDDLE NAME", "LAST NAME", "Address", "Sex", "Birthday", "Blood Type", "Cellphone Number", "Civil Status", "Religion", "Nationality", "Father's Email Ad.", "Mother's Email Ad."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        employeeListTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        employeeListTable.setGridColor(new java.awt.Color(255, 255, 255));
        employeeListTable.setMaximumSize(new java.awt.Dimension(1920, 1080));
        employeeListTable.setMinimumSize(new java.awt.Dimension(1920, 1080));
        employeeListTable.setRowHeight(40);
        employeeListTable.setShowGrid(false);
        jScrollPane1.setViewportView(employeeListTable);
        if (employeeListTable.getColumnModel().getColumnCount() > 0) {
            employeeListTable.getColumnModel().getColumn(0).setResizable(false);
        }

        searchEmployeeButton.setBackground(new java.awt.Color(153, 204, 255));
        searchEmployeeButton.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        searchEmployeeButton.setText("Search Employee");
        searchEmployeeButton.setBorderPainted(false);
        searchEmployeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchEmployeeButtonActionPerformed(evt);
            }
        });

        updateEmployeeButton.setBackground(new java.awt.Color(153, 204, 255));
        updateEmployeeButton.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        updateEmployeeButton.setText("Update Employee");
        updateEmployeeButton.setBorderPainted(false);
        updateEmployeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateEmployeeButtonActionPerformed(evt);
            }
        });

        deleteEmployeeButton.setBackground(new java.awt.Color(153, 204, 255));
        deleteEmployeeButton.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        deleteEmployeeButton.setText("Delete Employee");
        deleteEmployeeButton.setBorderPainted(false);
        deleteEmployeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEmployeeButtonActionPerformed(evt);
            }
        });

        cancelButton.setBackground(new java.awt.Color(255, 102, 102));
        cancelButton.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cancelButton.setText("Back");
        cancelButton.setBorderPainted(false);
        cancelButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(235, 241, 253));
        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Filter Search:");

        filterSearchTf.setBackground(new java.awt.Color(204, 204, 255));
        filterSearchTf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        filterSearchTf.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        filterSearchTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filterSearchTfKeyReleased(evt);
            }
        });

        refreshDataButton.setBackground(new java.awt.Color(235, 241, 253));
        refreshDataButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        refreshDataButton.setText("Refresh Data");
        refreshDataButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        refreshDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshDataButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainEmployeePanelLayout = new javax.swing.GroupLayout(mainEmployeePanel);
        mainEmployeePanel.setLayout(mainEmployeePanelLayout);
        mainEmployeePanelLayout.setHorizontalGroup(
            mainEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainEmployeePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(mainEmployeePanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filterSearchTf))
                    .addComponent(searchEmployeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(updateEmployeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteEmployeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 316, Short.MAX_VALUE)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(refreshDataButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainEmployeePanelLayout.setVerticalGroup(
            mainEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainEmployeePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(refreshDataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(filterSearchTf, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(mainEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchEmployeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateEmployeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteEmployeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topPanelforImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(bottomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(toolbarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainEmployeePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topPanelforImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toolbarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainEmployeePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 882, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        HMS_ADMINFORM showAdminForm = new HMS_ADMINFORM();
        showAdminForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void searchEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchEmployeeButtonActionPerformed
        HMS_SEARCHEMPLOYEE searchEmployeeForm = new HMS_SEARCHEMPLOYEE();
        searchEmployeeForm.setVisible(true);
    }//GEN-LAST:event_searchEmployeeButtonActionPerformed

    private void filterSearchTfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterSearchTfKeyReleased
        String query = filterSearchTf.getText();
        filter(query);
    }//GEN-LAST:event_filterSearchTfKeyReleased

    private void updateEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateEmployeeButtonActionPerformed
       HMS_EMPLOYEE_UPDATE showEmployeeUpdateForm = new HMS_EMPLOYEE_UPDATE();
        showEmployeeUpdateForm.setVisible(true);
    }//GEN-LAST:event_updateEmployeeButtonActionPerformed

    private void deleteEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEmployeeButtonActionPerformed
        HMS_EMPLOYEE_DELETE showEmployeeDeleteForm = new HMS_EMPLOYEE_DELETE();
        showEmployeeDeleteForm.setVisible(true);
    }//GEN-LAST:event_deleteEmployeeButtonActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        this.repaint();
        DefaultTableModel dm = (DefaultTableModel)employeeListTable.getModel();
        dm.fireTableDataChanged(); // notifies the JTable that the model has changed
        employeeListTable.repaint();
    }//GEN-LAST:event_formFocusGained

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
        this.repaint();
        DefaultTableModel dm = (DefaultTableModel)employeeListTable.getModel();
        dm.fireTableDataChanged(); // notifies the JTable that the model has changed
        employeeListTable.repaint();
    }//GEN-LAST:event_formFocusLost

    private void refreshDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshDataButtonActionPerformed
        PreparedStatement pst;
        ResultSet rs;
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/health_monitoring_system_database", "root", "root");
            String sql = "SELECT * FROM employees";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            
            employeeListTable.setModel(DbUtils.resultSetToTableModel(rs));
            employeeListTable.repaint();
            
            DefaultTableModel dm = (DefaultTableModel)employeeListTable.getModel();
            dm.fireTableDataChanged(); // notifies the JTable that the model has changed
            employeeListTable.repaint();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);}
    }//GEN-LAST:event_refreshDataButtonActionPerformed


    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
                
        try { 
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | 
        InstantiationException | 
        IllegalAccessException | 
        UnsupportedLookAndFeelException e) {System.out.println(e);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HMS_EMPLOYEE_LIST().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton deleteEmployeeButton;
    public javax.swing.JTable employeeListTable;
    private javax.swing.JTextField filterSearchTf;
    private javax.swing.JLabel headImageLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainEmployeePanel;
    private javax.swing.JButton refreshDataButton;
    private javax.swing.JButton searchEmployeeButton;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JPanel toolbarPanel;
    private javax.swing.JPanel topPanelforImageLabel;
    private javax.swing.JButton updateEmployeeButton;
    // End of variables declaration//GEN-END:variables

    void getTableModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
