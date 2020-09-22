/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthMonitoringSystem;

import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Khian Orland
 */
public class HMS_ADMINFORM extends javax.swing.JFrame {

    /**
     * Creates new form HMS_ADMINTOOLFORM
     */
    public HMS_ADMINFORM() {
        
    // sets the look and feel to be that of the operating system's
    try { 
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException | 
        InstantiationException | 
        IllegalAccessException | 
        UnsupportedLookAndFeelException e) {System.out.println(e);
    }

        initComponents();
        adminCancelButton.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainAdminPanel = new java.awt.Panel();
        adminToolHeader = new javax.swing.JLabel();
        registerEmployeeButton = new javax.swing.JButton();
        adminCancelButton = new javax.swing.JButton();
        manageDatabaseURL = new javax.swing.JButton();
        manageUserButton = new javax.swing.JButton();
        manageEmployeesButton = new javax.swing.JButton();
        registerUserInDatabaseButton1 = new javax.swing.JButton();
        managePatientsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setMaximumSize(new java.awt.Dimension(1000, 629));
        setName("adminFormMainFrame"); // NOI18N
        setUndecorated(true);
        setResizable(false);

        mainAdminPanel.setBackground(new java.awt.Color(235, 241, 253));

        adminToolHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/healthMonitoringSystem/APP_IMAGES/login_images/HMS_TOPPANEL_ADMINFORM.png"))); // NOI18N

        registerEmployeeButton.setBackground(new java.awt.Color(60, 143, 246));
        registerEmployeeButton.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        registerEmployeeButton.setForeground(new java.awt.Color(255, 255, 255));
        registerEmployeeButton.setText("Register Employee");
        registerEmployeeButton.setToolTipText("");
        registerEmployeeButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        registerEmployeeButton.setBorderPainted(false);
        registerEmployeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerEmployeeButtonActionPerformed(evt);
            }
        });
        registerEmployeeButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                registerEmployeeButtonKeyPressed(evt);
            }
        });

        adminCancelButton.setBackground(new java.awt.Color(255, 102, 102));
        adminCancelButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        adminCancelButton.setText("Cancel (Esc)");
        adminCancelButton.setBorderPainted(false);
        adminCancelButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        adminCancelButton.setSelected(true);
        adminCancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminCancelButtonMouseClicked(evt);
            }
        });
        adminCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminCancelButtonActionPerformed(evt);
            }
        });
        adminCancelButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                adminCancelButtonKeyPressed(evt);
            }
        });

        manageDatabaseURL.setBackground(new java.awt.Color(15, 79, 157));
        manageDatabaseURL.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        manageDatabaseURL.setForeground(new java.awt.Color(255, 255, 255));
        manageDatabaseURL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/healthMonitoringSystem/APP_IMAGES/mainprogram/hyperlinkIcon.png"))); // NOI18N
        manageDatabaseURL.setText("Manage Database [localhost/phpmyadmin/]");
        manageDatabaseURL.setToolTipText("Full admin commands of the database");
        manageDatabaseURL.setActionCommand("");
        manageDatabaseURL.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255)));
        manageDatabaseURL.setBorderPainted(false);
        manageDatabaseURL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        manageDatabaseURL.setHideActionText(true);
        manageDatabaseURL.setPreferredSize(new java.awt.Dimension(507, 35));
        manageDatabaseURL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageDatabaseURLActionPerformed(evt);
            }
        });
        manageDatabaseURL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                manageDatabaseURLKeyPressed(evt);
            }
        });

        manageUserButton.setBackground(new java.awt.Color(15, 79, 157));
        manageUserButton.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        manageUserButton.setForeground(new java.awt.Color(255, 255, 255));
        manageUserButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/healthMonitoringSystem/APP_IMAGES/mainprogram/userIcon.png"))); // NOI18N
        manageUserButton.setText("<html>\n<center>Manage<br>Users</center>\n</html>");
        manageUserButton.setToolTipText("Full admin commands of the database");
        manageUserButton.setActionCommand("");
        manageUserButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        manageUserButton.setBorderPainted(false);
        manageUserButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        manageUserButton.setHideActionText(true);
        manageUserButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        manageUserButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        manageUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageUserButtonActionPerformed(evt);
            }
        });
        manageUserButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                manageUserButtonKeyPressed(evt);
            }
        });

        manageEmployeesButton.setBackground(new java.awt.Color(15, 79, 157));
        manageEmployeesButton.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        manageEmployeesButton.setForeground(new java.awt.Color(255, 255, 255));
        manageEmployeesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/healthMonitoringSystem/APP_IMAGES/mainprogram/employeeIcon.png"))); // NOI18N
        manageEmployeesButton.setText("<html>\n<center>Manage<br>Employees</center>\n</html>");
        manageEmployeesButton.setToolTipText("Full admin commands of the database");
        manageEmployeesButton.setActionCommand("");
        manageEmployeesButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255)));
        manageEmployeesButton.setBorderPainted(false);
        manageEmployeesButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        manageEmployeesButton.setHideActionText(true);
        manageEmployeesButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        manageEmployeesButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        manageEmployeesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEmployeesButtonActionPerformed(evt);
            }
        });
        manageEmployeesButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                manageEmployeesButtonKeyPressed(evt);
            }
        });

        registerUserInDatabaseButton1.setBackground(new java.awt.Color(60, 143, 246));
        registerUserInDatabaseButton1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        registerUserInDatabaseButton1.setForeground(new java.awt.Color(255, 255, 255));
        registerUserInDatabaseButton1.setText("Register User Account");
        registerUserInDatabaseButton1.setToolTipText("");
        registerUserInDatabaseButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        registerUserInDatabaseButton1.setBorderPainted(false);
        registerUserInDatabaseButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerUserInDatabaseButton1ActionPerformed(evt);
            }
        });
        registerUserInDatabaseButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                registerUserInDatabaseButton1KeyPressed(evt);
            }
        });

        managePatientsButton.setBackground(new java.awt.Color(15, 79, 157));
        managePatientsButton.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        managePatientsButton.setForeground(new java.awt.Color(255, 255, 255));
        managePatientsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/healthMonitoringSystem/APP_IMAGES/mainprogram/patientIcon.png"))); // NOI18N
        managePatientsButton.setText("<html>\n<center>Manage<br>Patients</center>\n</html>");
        managePatientsButton.setToolTipText("Full admin commands of the database");
        managePatientsButton.setActionCommand("");
        managePatientsButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255)));
        managePatientsButton.setBorderPainted(false);
        managePatientsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        managePatientsButton.setHideActionText(true);
        managePatientsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        managePatientsButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        managePatientsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managePatientsButtonActionPerformed(evt);
            }
        });
        managePatientsButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                managePatientsButtonKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout mainAdminPanelLayout = new javax.swing.GroupLayout(mainAdminPanel);
        mainAdminPanel.setLayout(mainAdminPanelLayout);
        mainAdminPanelLayout.setHorizontalGroup(
            mainAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(adminToolHeader)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainAdminPanelLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(mainAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(adminCancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manageDatabaseURL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainAdminPanelLayout.createSequentialGroup()
                        .addGroup(mainAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(registerUserInDatabaseButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                            .addComponent(registerEmployeeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(manageUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(manageEmployeesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(managePatientsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(77, 77, 77))
        );
        mainAdminPanelLayout.setVerticalGroup(
            mainAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainAdminPanelLayout.createSequentialGroup()
                .addComponent(adminToolHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainAdminPanelLayout.createSequentialGroup()
                        .addComponent(registerUserInDatabaseButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(registerEmployeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(manageUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(manageEmployeesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(managePatientsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(manageDatabaseURL, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adminCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainAdminPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainAdminPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void registerEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerEmployeeButtonActionPerformed
         HMS_EMPLOYEE_REGISTRATION employeeRegistrationForm = new HMS_EMPLOYEE_REGISTRATION();
        employeeRegistrationForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_registerEmployeeButtonActionPerformed

    private void adminCancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminCancelButtonMouseClicked
        this.dispose();
    }//GEN-LAST:event_adminCancelButtonMouseClicked

    private void registerEmployeeButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_registerEmployeeButtonKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ESCAPE){
            this.dispose();
            HMS_LOGIN showLoginScreen = new HMS_LOGIN();
            showLoginScreen.setVisible(true);}
        else{}
    }//GEN-LAST:event_registerEmployeeButtonKeyPressed

    private void adminCancelButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adminCancelButtonKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ESCAPE){
            HMS_LOGIN showLoginScreen = new HMS_LOGIN();
            showLoginScreen.setVisible(true);
            this.dispose();
        } else{}
    }//GEN-LAST:event_adminCancelButtonKeyPressed

    private void adminCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminCancelButtonActionPerformed
        HMS_LOGIN mainLoginForm = new HMS_LOGIN();
        mainLoginForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_adminCancelButtonActionPerformed

    private void manageUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageUserButtonActionPerformed
        
    }//GEN-LAST:event_manageUserButtonActionPerformed

    private void manageEmployeesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEmployeesButtonActionPerformed
        HMS_EMPLOYEE_LIST showEmployeeListForm = new HMS_EMPLOYEE_LIST();
        showEmployeeListForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_manageEmployeesButtonActionPerformed

    private void manageDatabaseURLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageDatabaseURLActionPerformed
        try {

            Desktop.getDesktop().browse(new URI("http://localhost/phpmyadmin/"));

        } catch (IOException | URISyntaxException err1) {
            System.out.println(err1);
        }
    }//GEN-LAST:event_manageDatabaseURLActionPerformed

    private void registerUserInDatabaseButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerUserInDatabaseButton1ActionPerformed
        this.dispose();
        HMS_USER_REGISTRATION registerForm = new HMS_USER_REGISTRATION();
        registerForm.setVisible(true);
    }//GEN-LAST:event_registerUserInDatabaseButton1ActionPerformed

    private void registerUserInDatabaseButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_registerUserInDatabaseButton1KeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ESCAPE){
            this.dispose();
            HMS_LOGIN showLoginScreen = new HMS_LOGIN();
            showLoginScreen.setVisible(true);}
        else{}  
    }//GEN-LAST:event_registerUserInDatabaseButton1KeyPressed

    private void managePatientsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managePatientsButtonActionPerformed
        try {

            Desktop.getDesktop().browse(new URI("http://localhost/phpmyadmin/sql.php?server=1&db=health_monitoring_system_database&table=patients&pos=0"));

        } catch (IOException | URISyntaxException err1) {
            System.out.println(err1);
        }
    }//GEN-LAST:event_managePatientsButtonActionPerformed

    private void manageDatabaseURLKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_manageDatabaseURLKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ESCAPE){
            this.dispose();
            HMS_LOGIN showLoginScreen = new HMS_LOGIN();
            showLoginScreen.setVisible(true);}
        else{}
    }//GEN-LAST:event_manageDatabaseURLKeyPressed

    private void manageEmployeesButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_manageEmployeesButtonKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ESCAPE){
            this.dispose();
            HMS_LOGIN showLoginScreen = new HMS_LOGIN();
            showLoginScreen.setVisible(true);}
        else{}            
    }//GEN-LAST:event_manageEmployeesButtonKeyPressed

    private void manageUserButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_manageUserButtonKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ESCAPE){
            this.dispose();
            HMS_LOGIN showLoginScreen = new HMS_LOGIN();
            showLoginScreen.setVisible(true);}
        else{}
    }//GEN-LAST:event_manageUserButtonKeyPressed

    private void managePatientsButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_managePatientsButtonKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ESCAPE){
            this.dispose();
            HMS_LOGIN showLoginScreen = new HMS_LOGIN();
            showLoginScreen.setVisible(true);}
        else{}
    }//GEN-LAST:event_managePatientsButtonKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void HMS_MAIN() {
//    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HMS_ADMINFORM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adminCancelButton;
    private javax.swing.JLabel adminToolHeader;
    private java.awt.Panel mainAdminPanel;
    private javax.swing.JButton manageDatabaseURL;
    private javax.swing.JButton manageEmployeesButton;
    private javax.swing.JButton managePatientsButton;
    private javax.swing.JButton manageUserButton;
    private javax.swing.JButton registerEmployeeButton;
    private javax.swing.JButton registerUserInDatabaseButton1;
    // End of variables declaration//GEN-END:variables
}
