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
        UnsupportedLookAndFeelException e) {
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
        registerUserInDatabaseButton = new javax.swing.JButton();
        adminCancelButton = new javax.swing.JButton();
        manageDatabaseURL = new javax.swing.JButton();
        userDatabaseButton = new javax.swing.JButton();
        patientDatabaseButton = new javax.swing.JButton();
        employeeDatabaseButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAutoRequestFocus(false);
        setMaximumSize(new java.awt.Dimension(1000, 629));
        setName("adminFormMainFrame"); // NOI18N
        setUndecorated(true);
        setResizable(false);

        mainAdminPanel.setBackground(new java.awt.Color(235, 241, 253));

        adminToolHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/healthMonitoringSystem/APP_IMAGES/login_images/HMS_TOPPANEL_ADMINFORM.png"))); // NOI18N

        registerUserInDatabaseButton.setBackground(new java.awt.Color(60, 143, 246));
        registerUserInDatabaseButton.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        registerUserInDatabaseButton.setForeground(new java.awt.Color(255, 255, 255));
        registerUserInDatabaseButton.setText("Register User Account");
        registerUserInDatabaseButton.setToolTipText("");
        registerUserInDatabaseButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        registerUserInDatabaseButton.setBorderPainted(false);
        registerUserInDatabaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerUserInDatabaseButtonActionPerformed(evt);
            }
        });
        registerUserInDatabaseButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                registerUserInDatabaseButtonKeyPressed(evt);
            }
        });

        adminCancelButton.setBackground(new java.awt.Color(255, 102, 102));
        adminCancelButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        adminCancelButton.setText("Cancel (Esc)");
        adminCancelButton.setBorderPainted(false);
        adminCancelButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        userDatabaseButton.setBackground(new java.awt.Color(15, 79, 157));
        userDatabaseButton.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        userDatabaseButton.setForeground(new java.awt.Color(255, 255, 255));
        userDatabaseButton.setText("Manage User Database");
        userDatabaseButton.setToolTipText("Full admin commands of the database");
        userDatabaseButton.setActionCommand("");
        userDatabaseButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255)));
        userDatabaseButton.setBorderPainted(false);
        userDatabaseButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        userDatabaseButton.setHideActionText(true);
        userDatabaseButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        userDatabaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userDatabaseButtonActionPerformed(evt);
            }
        });

        patientDatabaseButton.setBackground(new java.awt.Color(15, 79, 157));
        patientDatabaseButton.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        patientDatabaseButton.setForeground(new java.awt.Color(255, 255, 255));
        patientDatabaseButton.setText("Manage Patient Database");
        patientDatabaseButton.setToolTipText("Full admin commands of the database");
        patientDatabaseButton.setActionCommand("");
        patientDatabaseButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255)));
        patientDatabaseButton.setBorderPainted(false);
        patientDatabaseButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        patientDatabaseButton.setHideActionText(true);
        patientDatabaseButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientDatabaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientDatabaseButtonActionPerformed(evt);
            }
        });

        employeeDatabaseButton.setBackground(new java.awt.Color(15, 79, 157));
        employeeDatabaseButton.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        employeeDatabaseButton.setForeground(new java.awt.Color(255, 255, 255));
        employeeDatabaseButton.setText("Manage Employee Database");
        employeeDatabaseButton.setToolTipText("Full admin commands of the database");
        employeeDatabaseButton.setActionCommand("");
        employeeDatabaseButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255)));
        employeeDatabaseButton.setBorderPainted(false);
        employeeDatabaseButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        employeeDatabaseButton.setHideActionText(true);
        employeeDatabaseButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        employeeDatabaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeDatabaseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainAdminPanelLayout = new javax.swing.GroupLayout(mainAdminPanel);
        mainAdminPanel.setLayout(mainAdminPanelLayout);
        mainAdminPanelLayout.setHorizontalGroup(
            mainAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(adminToolHeader)
            .addGroup(mainAdminPanelLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(mainAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainAdminPanelLayout.createSequentialGroup()
                        .addGroup(mainAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(userDatabaseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(registerUserInDatabaseButton, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(mainAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(employeeDatabaseButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patientDatabaseButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(manageDatabaseURL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(adminCancelButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(71, 71, 71))
        );
        mainAdminPanelLayout.setVerticalGroup(
            mainAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainAdminPanelLayout.createSequentialGroup()
                .addComponent(adminToolHeader)
                .addGap(18, 18, 18)
                .addGroup(mainAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainAdminPanelLayout.createSequentialGroup()
                        .addComponent(registerUserInDatabaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userDatabaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainAdminPanelLayout.createSequentialGroup()
                        .addComponent(employeeDatabaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(patientDatabaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(manageDatabaseURL, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adminCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainAdminPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainAdminPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void registerUserInDatabaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerUserInDatabaseButtonActionPerformed
          HMS_REGISTERACCOUNT registerForm = new HMS_REGISTERACCOUNT();
            registerForm.setVisible(true);
    }//GEN-LAST:event_registerUserInDatabaseButtonActionPerformed

    private void adminCancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminCancelButtonMouseClicked
        this.dispose();
    }//GEN-LAST:event_adminCancelButtonMouseClicked

    private void registerUserInDatabaseButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_registerUserInDatabaseButtonKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ESCAPE){
            this.dispose();}
        else{}
    }//GEN-LAST:event_registerUserInDatabaseButtonKeyPressed

    private void adminCancelButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adminCancelButtonKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ESCAPE){
            this.dispose();}
        else{}  
    }//GEN-LAST:event_adminCancelButtonKeyPressed

    private void adminCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminCancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_adminCancelButtonActionPerformed

    private void userDatabaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userDatabaseButtonActionPerformed
        try {

            Desktop.getDesktop().browse(new URI("http://localhost/phpmyadmin/sql.php?server=1&db=health_monitoring_system_database&table=users&pos=0"));

        } catch (IOException | URISyntaxException err1) {
            System.out.println(err1);
        }
    }//GEN-LAST:event_userDatabaseButtonActionPerformed

    private void patientDatabaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientDatabaseButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patientDatabaseButtonActionPerformed

    private void employeeDatabaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeDatabaseButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeDatabaseButtonActionPerformed

    private void manageDatabaseURLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageDatabaseURLActionPerformed
        try {

            Desktop.getDesktop().browse(new URI("http://localhost/phpmyadmin/"));

        } catch (IOException | URISyntaxException err1) {
            System.out.println(err1);
        }
    }//GEN-LAST:event_manageDatabaseURLActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HMS_ADMINFORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HMS_ADMINFORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HMS_ADMINFORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HMS_ADMINFORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HMS_ADMINFORM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adminCancelButton;
    private javax.swing.JLabel adminToolHeader;
    private javax.swing.JButton employeeDatabaseButton;
    private java.awt.Panel mainAdminPanel;
    private javax.swing.JButton manageDatabaseURL;
    private javax.swing.JButton patientDatabaseButton;
    private javax.swing.JButton registerUserInDatabaseButton;
    private javax.swing.JButton userDatabaseButton;
    // End of variables declaration//GEN-END:variables
}
