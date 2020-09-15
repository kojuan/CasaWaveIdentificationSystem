package healthMonitoringSystem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
// import javax.swing.SwingConstants; // center text/label

public class HMS_LOGIN extends javax.swing.JFrame {
    
    // Absolute =  Drive +  {folders(s)} + {file} | Uniform Naming Convention
    // Relative = No drive | ..\ one level up | ..\..\ two levels up
   final String currentAbsoluteFileDirectoryPath = System.getProperty("user.dir");
   java.net.URL url = ClassLoader.getSystemResource(currentAbsoluteFileDirectoryPath + "/APP_IMAGES/LOGO_ICONS");
  
    /**
     * Creates new form BCLOGIN
     */
    public HMS_LOGIN() {
        // sets the look and feel to be that of the operating system's
    try { 
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException | 
        InstantiationException | 
        IllegalAccessException | 
        UnsupportedLookAndFeelException e) {
    }
    
     
        System.out.println("Current absolute path is:" + currentAbsoluteFileDirectoryPath);

           
        
        initComponents();
        setIcon();

        /* - Download The Connector For JAVA & MySQL Database 
         LINK: https://dev.mysql.com/downloads/connector/j/5.1.html */
        // OPEN XAMPP and Start Apache & MySQL
        // Go to : http://localhost/phpmyadmin and create a new database
        // Create a Connection with the database
        
        
        // center the form

          
        Border glob_panel_border = BorderFactory.createMatteBorder(1, 0, 0, 0, Color.blue);
        bottomPanel.setBorder(glob_panel_border);
        
        // create border for the username and password field
        Border textfields_panel_border = BorderFactory.createMatteBorder(1, 0, 1, 1, Color.blue);
        usernameTf.setBorder(textfields_panel_border);
        passwordTf.setBorder(textfields_panel_border);
        
        Border roundedBorder = new LineBorder(Color.blue, 1, true); // the third parameter - true, says it's round
        usernameTf.setBorder(roundedBorder);
        passwordTf.setBorder(roundedBorder);
        
        showDate();
        showTime();
        
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

        bottomPanel = new javax.swing.JPanel();
        javax.swing.JButton adminButton = new javax.swing.JButton();
        aboutButton = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        javax.swing.JLabel usernameLabel = new javax.swing.JLabel();
        javax.swing.JLabel passwordLabel = new javax.swing.JLabel();
        showCBox = new javax.swing.JCheckBox();
        loginButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        passwordTf = new javax.swing.JPasswordField();
        usernameTf = new javax.swing.JTextField();
        DATEANDTIME_PANEL = new javax.swing.JPanel();
        dateLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        javax.swing.JLabel imageLabelTop = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MEDICAL HEALTH MONITORING SYSTEM");
        setBackground(new java.awt.Color(118, 158, 203));
        setMaximumSize(new java.awt.Dimension(1000, 629));
        setName("mainProgramFrame"); // NOI18N
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        bottomPanel.setBackground(new java.awt.Color(153, 153, 255));
        bottomPanel.setRequestFocusEnabled(false);

        adminButton.setBackground(new java.awt.Color(153, 204, 255));
        adminButton.setText("ADMIN");
        adminButton.setToolTipText("Administrator Access");
        adminButton.setBorder(new javax.swing.border.MatteBorder(null));
        adminButton.setBorderPainted(false);
        adminButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        adminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminButtonActionPerformed(evt);
            }
        });

        aboutButton.setBackground(new java.awt.Color(153, 204, 255));
        aboutButton.setText("ABOUT");
        aboutButton.setToolTipText("About the application.");
        aboutButton.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        aboutButton.setBorderPainted(false);
        aboutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        aboutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                aboutButtonMousePressed(evt);
            }
        });

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addComponent(adminButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 801, Short.MAX_VALUE)
                .addComponent(aboutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(adminButton, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(aboutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(bottomPanel);
        bottomPanel.setBounds(0, 600, 1000, 30);

        mainPanel.setBackground(new java.awt.Color(235, 241, 253));

        usernameLabel.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        usernameLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/healthMonitoringSystem/APP_IMAGES/login_images/usernameIconIMAGE.png"))); // NOI18N
        usernameLabel.setLabelFor(usernameLabel);
        usernameLabel.setText("Username:");

        passwordLabel.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        passwordLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/healthMonitoringSystem/APP_IMAGES/login_images/passwordIconIMAGE.png"))); // NOI18N
        passwordLabel.setLabelFor(passwordLabel);
        passwordLabel.setText(" Password:");

        showCBox.setBackground(new java.awt.Color(235, 241, 253));
        showCBox.setText("Show");
        showCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showCBoxActionPerformed(evt);
            }
        });

        loginButton.setBackground(new java.awt.Color(60, 143, 246));
        loginButton.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        loginButton.setText("LOGIN (Enter)");
        loginButton.setToolTipText("Log In");
        loginButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        loginButton.setBorderPainted(false);
        loginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginButtonMouseExited(evt);
            }
        });
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        loginButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginButtonKeyPressed(evt);
            }
        });

        closeButton.setBackground(new java.awt.Color(255, 102, 102));
        closeButton.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        closeButton.setText("Close (Esc)");
        closeButton.setToolTipText("Exit the application");
        closeButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        closeButton.setBorderPainted(false);
        closeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        passwordTf.setBackground(new java.awt.Color(204, 204, 255));
        passwordTf.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        passwordTf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordTfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordTfFocusLost(evt);
            }
        });
        passwordTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTfActionPerformed(evt);
            }
        });
        passwordTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordTfKeyPressed(evt);
            }
        });

        usernameTf.setBackground(new java.awt.Color(204, 204, 255));
        usernameTf.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        usernameTf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usernameTfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernameTfFocusLost(evt);
            }
        });
        usernameTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTfActionPerformed(evt);
            }
        });
        usernameTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usernameTfKeyPressed(evt);
            }
        });

        DATEANDTIME_PANEL.setBackground(new java.awt.Color(235, 241, 253));
        DATEANDTIME_PANEL.setRequestFocusEnabled(false);

        dateLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(0, 0, 153));
        dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateLabel.setText("Date");
        dateLabel.setRequestFocusEnabled(false);

        timeLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        timeLabel.setForeground(new java.awt.Color(0, 0, 153));
        timeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLabel.setText("Time");
        timeLabel.setRequestFocusEnabled(false);

        javax.swing.GroupLayout DATEANDTIME_PANELLayout = new javax.swing.GroupLayout(DATEANDTIME_PANEL);
        DATEANDTIME_PANEL.setLayout(DATEANDTIME_PANELLayout);
        DATEANDTIME_PANELLayout.setHorizontalGroup(
            DATEANDTIME_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
            .addComponent(timeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DATEANDTIME_PANELLayout.setVerticalGroup(
            DATEANDTIME_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DATEANDTIME_PANELLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        imageLabelTop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/healthMonitoringSystem/APP_IMAGES/login_images/HMS_TOPPANEL_LOGIN.png"))); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(showCBox)
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                    .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(passwordTf, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                    .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(usernameTf, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                    .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(DATEANDTIME_PANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(imageLabelTop))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addComponent(imageLabelTop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DATEANDTIME_PANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameTf, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordTf, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addComponent(showCBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(91, 91, 91))
        );

        getContentPane().add(mainPanel);
        mainPanel.setBounds(0, 0, 1000, 600);

        setSize(new java.awt.Dimension(1000, 629));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void passwordTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTfActionPerformed
        loginButton.doClick();
    }//GEN-LAST:event_passwordTfActionPerformed

    private void loginButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginButtonKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
        JOptionPane.showMessageDialog(null , "Login success.");
    }
    }//GEN-LAST:event_loginButtonKeyPressed

    private void usernameTfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameTfKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
        passwordTf.requestFocusInWindow();
    }
        else if (evt.getKeyCode()==KeyEvent.VK_ESCAPE){
            System.exit(0);
    }
    }//GEN-LAST:event_usernameTfKeyPressed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        
        PreparedStatement st;
        ResultSet rs;
        
        // get the username & password
        String username = usernameTf.getText();
        String password = String.valueOf(passwordTf.getPassword());
        
        //create a select query to check if the username and the password exist in the database
        String query = "SELECT * FROM users WHERE usernameString = ? AND passwordString = ?";
        
        // Show a message if the username or the password fields are empty.
        if (username.trim().equals("username"))
        {
            JOptionPane.showMessageDialog(null, "Enter Your Username", "Blank Username or Password", 2);
        }
        else if (password.trim().equals("password"))
        {
            JOptionPane.showMessageDialog(null, "Enter Your Password", "Blank Username or Password", 2);
        }
        else
        {
            try {
            st = HEALTH_MONITORING_SYSTEM_DATABASE.getConnection().prepareStatement(query);
                 
            st.setString(1, username);
            st.setString(2, password);
            rs = st.executeQuery();
            
            if (rs.next())
            {
                // show a new form
                HMS_MAIN.HMS_MAIN();
                HMS_MAIN.frame.setVisible(true);
//                 close the current form(login form)
                this.dispose();

            } else {
                // error message
                JOptionPane.showMessageDialog(null, "Invalid Username or Password.\nPlease try again.","Login Error", 2);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(HMS_LOGIN.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "SQL Server Error.");
        }
        }
        
        
        
        
   
        
    }//GEN-LAST:event_loginButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_closeButtonActionPerformed

    private void adminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminButtonActionPerformed
        HMS_ADMINFORM adminForm = new HMS_ADMINFORM();
        adminForm.setVisible(true);
    }//GEN-LAST:event_adminButtonActionPerformed

    private void passwordTfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordTfFocusGained
        // clear the password field on focus if the text is "password"
        
        // get the password text
        String pass = String.valueOf(passwordTf.getPassword());
        if (pass.trim().toLowerCase().equals("password"))
        {
            passwordTf.setText("");
            passwordTf.setForeground(Color.black);
        }
        
        // set a yellow border to the Username Icon
        //Border password_icon = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow);
        //passwordLabel.setBorder(password_icon);
    }//GEN-LAST:event_passwordTfFocusGained

    private void usernameTfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameTfFocusGained
         if (usernameTf.getText().trim().toLowerCase().equals("username"))
        {
            usernameTf.setText("");
            usernameTf.setForeground(Color.black);
        }
        
        
        // set a yellow border to the Username Icon
        //Border username_icon = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow);
        //usernameLabel.setBorder(username_icon);
    }//GEN-LAST:event_usernameTfFocusGained

    private void usernameTfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameTfFocusLost
        /** if the text field is equal to username or empty
        *   we will set the "username" text in the field
            on focus lost event */
        if (usernameTf.getText().trim().equals("") ||  //placeholder
            usernameTf.getText().trim().toLowerCase().equals("username"))
        {
            usernameTf.setText("username");
            usernameTf.setForeground(new Color(153, 153, 153));
        }
        

    }//GEN-LAST:event_usernameTfFocusLost

    private void passwordTfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordTfFocusLost
         /** if the text field is equal to password or empty
        *   we will set the "password" text in the field
            on focus lost event */
         // get password text
         String pass = String.valueOf(passwordTf.getPassword());
        if (pass.trim().equals("") || // placeholder
            pass.trim().toLowerCase().equals("password"))
        {
            passwordTf.setText("password");
            passwordTf.setForeground(new Color(153, 153, 153));
        }
        

    }//GEN-LAST:event_passwordTfFocusLost

    private void loginButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseEntered
        // set Login Button Background
        loginButton.setBackground(new Color (94, 126, 162));
    }//GEN-LAST:event_loginButtonMouseEntered

    private void loginButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseExited
        // set Login Button Background
        loginButton.setBackground(new Color (60, 143, 246));
    }//GEN-LAST:event_loginButtonMouseExited

    private void aboutButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutButtonMousePressed
         HMS_ABOUT hmsaboutForm = new HMS_ABOUT();
         hmsaboutForm.setVisible(true);
    }//GEN-LAST:event_aboutButtonMousePressed

    private void usernameTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTfActionPerformed
        
    }//GEN-LAST:event_usernameTfActionPerformed

    private void passwordTfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordTfKeyPressed
    if (evt.getKeyCode()==KeyEvent.VK_ESCAPE){
            System.exit(0);
    }
    }//GEN-LAST:event_passwordTfKeyPressed

    private void showCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showCBoxActionPerformed
        if (showCBox.isSelected())
        {
            passwordTf.setEchoChar((char)0);
        } else
        {
            passwordTf.setEchoChar((char)0x2022);
        }
    }//GEN-LAST:event_showCBoxActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | 
                IllegalAccessException |
                javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HMS_LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new HMS_LOGIN().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DATEANDTIME_PANEL;
    private javax.swing.JButton aboutButton;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel dateLabel;
    public javax.swing.JButton loginButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPasswordField passwordTf;
    private javax.swing.JCheckBox showCBox;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JTextField usernameTf;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        Image icon = Toolkit.getDefaultToolkit().getImage(currentAbsoluteFileDirectoryPath + "\\HMS_ICON_256BY256.ico");  
        this.setIconImage(icon);
    }
}
