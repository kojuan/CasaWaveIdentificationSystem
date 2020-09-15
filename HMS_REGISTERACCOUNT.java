
package healthMonitoringSystem;

/**
 *
 * @author Khian Orland
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.swing.SwingConstants; // center text/label
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class HMS_REGISTERACCOUNT extends javax.swing.JFrame {

    /**
     * Creates new form HMS_REGISTERACCOUNT
     */
    
    // Create a variable to set the iamge path in it
    String image_path = null;
    
    public HMS_REGISTERACCOUNT() {
        
        // sets the look and feel to be that of the operating system's
        try { 
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | 
            InstantiationException | 
            IllegalAccessException | 
            UnsupportedLookAndFeelException e) {
        }
        
        initComponents();
        
        
        
        // create border for the text and password fields
        Border field_border = BorderFactory.createMatteBorder(1, 5, 1, 1, Color.blue);
        registerUsernameTf.setBorder(field_border);
        registerPasswordTf.setBorder(field_border);
        registerConfirmPsswordField.setBorder(field_border);
        registerFullNameField.setBorder(field_border);
        registerPhoneNumberTf.setBorder(field_border);
        
        // create a button group for Gender
        ButtonGroup genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(maleButton);
        genderButtonGroup.add(femaleButton);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registerTopPanel = new javax.swing.JPanel();
        registerMainPanel = new javax.swing.JPanel();
        registerUsernameTf = new javax.swing.JTextField();
        usernameClearTextButton = new javax.swing.JButton();
        registerPasswordTf = new javax.swing.JPasswordField();
        passwordClearTextButton = new javax.swing.JButton();
        registerConfirmPsswordField = new javax.swing.JPasswordField();
        registerFullNameField = new javax.swing.JTextField();
        fullNameClearTextButton = new javax.swing.JButton();
        registerPhoneNumberTf = new javax.swing.JTextField();
        phoneNumberClearTextButton = new javax.swing.JButton();
        clearAllButton = new javax.swing.JButton();
        maleButton = new javax.swing.JRadioButton();
        femaleButton = new javax.swing.JRadioButton();
        selectImageButton = new javax.swing.JButton();
        registerUsernameLabel = new javax.swing.JLabel();
        registerPasswordLabel = new javax.swing.JLabel();
        imagePathLabel = new javax.swing.JLabel();
        registerConfirmPasswordLabel = new javax.swing.JLabel();
        fullNameLabel = new javax.swing.JLabel();
        phoneNumberLabel = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        userImageLabel = new javax.swing.JLabel();
        registerButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        registerTopPanelImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Register Account for Cheque Management System");
        setBackground(new java.awt.Color(118, 158, 203));
        setName("registerAccountFrame"); // NOI18N
        setUndecorated(true);
        setResizable(false);

        registerTopPanel.setBackground(new java.awt.Color(255, 255, 255));

        registerMainPanel.setBackground(new java.awt.Color(255, 255, 255));

        registerUsernameTf.setBackground(new java.awt.Color(204, 204, 255));
        registerUsernameTf.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        registerUsernameTf.setToolTipText("Username used to login.");
        registerUsernameTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerUsernameTfActionPerformed(evt);
            }
        });
        registerUsernameTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                registerUsernameTfKeyPressed(evt);
            }
        });

        usernameClearTextButton.setBackground(new java.awt.Color(238, 245, 251));
        usernameClearTextButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        usernameClearTextButton.setText("Clear");
        usernameClearTextButton.setBorderPainted(false);
        usernameClearTextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameClearTextButtonActionPerformed(evt);
            }
        });

        registerPasswordTf.setBackground(new java.awt.Color(204, 204, 255));
        registerPasswordTf.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        registerPasswordTf.setToolTipText("Password used to login.");
        registerPasswordTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                registerPasswordTfKeyPressed(evt);
            }
        });

        passwordClearTextButton.setBackground(new java.awt.Color(238, 245, 251));
        passwordClearTextButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        passwordClearTextButton.setText("Clear");
        passwordClearTextButton.setBorderPainted(false);
        passwordClearTextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordClearTextButtonActionPerformed(evt);
            }
        });

        registerConfirmPsswordField.setBackground(new java.awt.Color(204, 219, 255));
        registerConfirmPsswordField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        registerConfirmPsswordField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        registerConfirmPsswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                registerConfirmPsswordFieldKeyPressed(evt);
            }
        });

        registerFullNameField.setBackground(new java.awt.Color(204, 204, 255));
        registerFullNameField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        registerFullNameField.setToolTipText("First Name, Second Name, M.I., Surname");

        fullNameClearTextButton.setBackground(new java.awt.Color(238, 245, 251));
        fullNameClearTextButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fullNameClearTextButton.setText("Clear");
        fullNameClearTextButton.setBorderPainted(false);
        fullNameClearTextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullNameClearTextButtonActionPerformed(evt);
            }
        });

        registerPhoneNumberTf.setBackground(new java.awt.Color(204, 204, 255));
        registerPhoneNumberTf.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        registerPhoneNumberTf.setToolTipText("Please indicate your Phone number starting at 09xxxxxxxx");
        registerPhoneNumberTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                registerPhoneNumberTfKeyTyped(evt);
            }
        });

        phoneNumberClearTextButton.setBackground(new java.awt.Color(238, 245, 251));
        phoneNumberClearTextButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        phoneNumberClearTextButton.setText("Clear");
        phoneNumberClearTextButton.setBorderPainted(false);
        phoneNumberClearTextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNumberClearTextButtonActionPerformed(evt);
            }
        });

        clearAllButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        clearAllButton.setText("Clear All");
        clearAllButton.setBorderPainted(false);
        clearAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearAllButtonActionPerformed(evt);
            }
        });

        maleButton.setBackground(new java.awt.Color(255, 255, 255));
        maleButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        maleButton.setSelected(true);
        maleButton.setText("Male");

        femaleButton.setBackground(new java.awt.Color(255, 255, 255));
        femaleButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        femaleButton.setText("Female");

        selectImageButton.setBackground(new java.awt.Color(255, 255, 255));
        selectImageButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        selectImageButton.setText("Select Image");
        selectImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectImageButtonActionPerformed(evt);
            }
        });

        registerUsernameLabel.setBackground(new java.awt.Color(255, 255, 255));
        registerUsernameLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        registerUsernameLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/healthMonitoringSystem/APP_IMAGES/login_images/usernameIconIMAGE.png"))); // NOI18N
        registerUsernameLabel.setText("Username:");

        registerPasswordLabel.setBackground(new java.awt.Color(255, 255, 255));
        registerPasswordLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        registerPasswordLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/healthMonitoringSystem/APP_IMAGES/login_images/passwordIconIMAGE.png"))); // NOI18N
        registerPasswordLabel.setText("Password:");

        imagePathLabel.setBackground(new java.awt.Color(255, 255, 255));
        imagePathLabel.setFont(new java.awt.Font("Sylfaen", 0, 11)); // NOI18N
        imagePathLabel.setText("image path");

        registerConfirmPasswordLabel.setBackground(new java.awt.Color(255, 255, 255));
        registerConfirmPasswordLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        registerConfirmPasswordLabel.setText("Confirm Password:");

        fullNameLabel.setBackground(new java.awt.Color(255, 255, 255));
        fullNameLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fullNameLabel.setText("Full Name:");

        phoneNumberLabel.setBackground(new java.awt.Color(255, 255, 255));
        phoneNumberLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        phoneNumberLabel.setText("Phone Number (09xx):");

        genderLabel.setBackground(new java.awt.Color(255, 255, 255));
        genderLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        genderLabel.setText("Gender:");

        userImageLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        userImageLabel.setText("User Image:");

        registerButton.setBackground(new java.awt.Color(118, 158, 203));
        registerButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        registerButton.setText("Register Account");
        registerButton.setBorder(new javax.swing.border.MatteBorder(null));
        registerButton.setBorderPainted(false);
        registerButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        cancelButton.setBackground(new java.awt.Color(255, 102, 102));
        cancelButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cancelButton.setText("Cancel (Esc)");
        cancelButton.setBorderPainted(false);
        cancelButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout registerMainPanelLayout = new javax.swing.GroupLayout(registerMainPanel);
        registerMainPanel.setLayout(registerMainPanelLayout);
        registerMainPanelLayout.setHorizontalGroup(
            registerMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerMainPanelLayout.createSequentialGroup()
                .addGroup(registerMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registerMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(userImageLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(registerMainPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(registerMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(genderLabel)
                                .addComponent(phoneNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fullNameLabel))
                            .addGap(4, 4, 4)))
                    .addComponent(registerConfirmPasswordLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registerMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(registerPasswordLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(registerUsernameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(registerMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registerMainPanelLayout.createSequentialGroup()
                        .addGroup(registerMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(registerMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(registerUsernameTf, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(registerPasswordTf, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(registerConfirmPsswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(registerFullNameField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, registerMainPanelLayout.createSequentialGroup()
                                    .addComponent(maleButton)
                                    .addGap(18, 18, 18)
                                    .addComponent(femaleButton)))
                            .addComponent(registerPhoneNumberTf, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(registerMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phoneNumberClearTextButton)
                            .addComponent(clearAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameClearTextButton)
                            .addGroup(registerMainPanelLayout.createSequentialGroup()
                                .addGroup(registerMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(passwordClearTextButton)
                                    .addComponent(fullNameClearTextButton))
                                .addGap(100, 100, 100)
                                .addGroup(registerMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(registerMainPanelLayout.createSequentialGroup()
                        .addComponent(selectImageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imagePathLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        registerMainPanelLayout.setVerticalGroup(
            registerMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerMainPanelLayout.createSequentialGroup()
                .addGroup(registerMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registerMainPanelLayout.createSequentialGroup()
                        .addGroup(registerMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(registerUsernameTf, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(registerUsernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameClearTextButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(registerMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(registerMainPanelLayout.createSequentialGroup()
                                .addComponent(registerPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(registerMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(registerConfirmPsswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(registerConfirmPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(registerMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(registerPasswordTf, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(passwordClearTextButton)))
                        .addGap(27, 27, 27)
                        .addGroup(registerMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(registerFullNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fullNameClearTextButton)
                            .addComponent(fullNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(registerMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phoneNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(registerPhoneNumberTf, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneNumberClearTextButton)))
                    .addGroup(registerMainPanelLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)))
                .addGap(18, 18, 18)
                .addGroup(registerMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registerMainPanelLayout.createSequentialGroup()
                        .addGroup(registerMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(maleButton)
                            .addComponent(femaleButton)
                            .addComponent(genderLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(registerMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(registerMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(selectImageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(imagePathLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(clearAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(110, 110, 110))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        registerTopPanelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/healthMonitoringSystem/APP_IMAGES/login_images/HMS_TOPPANEL_REGISTER.png"))); // NOI18N
        registerTopPanelImage.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(registerTopPanelImage)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(registerTopPanelImage)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        registerTopPanelImage.getAccessibleContext().setAccessibleName("topImage");

        javax.swing.GroupLayout registerTopPanelLayout = new javax.swing.GroupLayout(registerTopPanel);
        registerTopPanel.setLayout(registerTopPanelLayout);
        registerTopPanelLayout.setHorizontalGroup(
            registerTopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerTopPanelLayout.createSequentialGroup()
                .addGroup(registerTopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(registerMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        registerTopPanelLayout.setVerticalGroup(
            registerTopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registerTopPanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(registerMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registerTopPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registerTopPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1000, 629));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseClicked
        this.dispose();
    }//GEN-LAST:event_cancelButtonMouseClicked

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed

        String fname = registerFullNameField.getText();
        String username = registerUsernameTf.getText();
        String pass1 = String.valueOf(registerPasswordTf.getPassword());
        String pass2 = String.valueOf(registerConfirmPsswordField.getPassword());
        String phone = registerPhoneNumberTf.getText();
        String gender = "Male";

        if (femaleButton.isSelected()) {
            gender= "Female";
        }

        if (verifyFields())
        {
            if (!checkUsername(username))
            {
                PreparedStatement ps;
                ResultSet rs;
                String registerUserQuery = "INSERT INTO users (full_name, usernameString, passwordString, phone, gender, picture) VALUES (?,?,?,?,?,?)";

                try {

                    ps = HEALTH_MONITORING_SYSTEM_DATABASE.getConnection().prepareStatement(registerUserQuery);
                    ps.setString(1, fname);
                    ps.setString(2, username);
                    ps.setString(3, pass1);
                    ps.setString(4, phone);
                    ps.setString(5, gender);

                    try {
                        // Save the image as BLOB in the Database
                        if (image_path != null) {

                            InputStream image = new FileInputStream(new File(image_path));
                            ps.setBlob(6, image);

                        }
                        else if (image_path == null) {
                            ps.setNull(6, java.sql.Types.NULL);
                            System.out.println("No image attached.");

                        } else {
                            ps.setNull(6, java.sql.Types.NULL);
                            System.out.println("No image attached.");
                        }

                        if (ps.executeUpdate() != 0) {
                            JOptionPane.showMessageDialog(null, "Your Account has been created.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Error: Check your Information.");
                        }

                        ps.setNull(6, java.sql.Types.NULL);

                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(HMS_REGISTERACCOUNT.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(HMS_REGISTERACCOUNT.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

    }//GEN-LAST:event_registerButtonActionPerformed

    private void selectImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectImageButtonActionPerformed
        // select an image and set the image path into a JLabel
        String path = null;

        JFileChooser chooser = new JFileChooser();

        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        // File extension
        FileNameExtensionFilter extension = new FileNameExtensionFilter("*Images","jpg","png","jpeg");
        chooser.addChoosableFileFilter(extension);

        int filestate = chooser.showSaveDialog(null);

        // Check if the user select an image
        if (filestate == JFileChooser.APPROVE_OPTION)
        {
            File selectedImage = chooser.getSelectedFile();
            path = selectedImage.getAbsolutePath();
            imagePathLabel.setText(path);

            image_path = path;
        }

    }//GEN-LAST:event_selectImageButtonActionPerformed

    private void clearAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearAllButtonActionPerformed
        registerUsernameTf.setText("");
        registerPasswordTf.setText("");
        registerConfirmPsswordField.setText("");
        registerFullNameField.setText("");
        registerPhoneNumberTf.setText("");
    }//GEN-LAST:event_clearAllButtonActionPerformed

    private void phoneNumberClearTextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneNumberClearTextButtonActionPerformed
        registerPhoneNumberTf.setText("");
    }//GEN-LAST:event_phoneNumberClearTextButtonActionPerformed

    private void registerPhoneNumberTfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_registerPhoneNumberTfKeyTyped
        // allow only numbers
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_registerPhoneNumberTfKeyTyped

    private void fullNameClearTextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullNameClearTextButtonActionPerformed
        registerFullNameField.setText("");
    }//GEN-LAST:event_fullNameClearTextButtonActionPerformed

    private void registerConfirmPsswordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_registerConfirmPsswordFieldKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ESCAPE){
            this.dispose();
        }
    }//GEN-LAST:event_registerConfirmPsswordFieldKeyPressed

    private void passwordClearTextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordClearTextButtonActionPerformed
        registerPasswordTf.setText("");
    }//GEN-LAST:event_passwordClearTextButtonActionPerformed

    private void registerPasswordTfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_registerPasswordTfKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ESCAPE){
            this.dispose();
        }
    }//GEN-LAST:event_registerPasswordTfKeyPressed

    private void usernameClearTextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameClearTextButtonActionPerformed
        registerUsernameTf.setText("");
    }//GEN-LAST:event_usernameClearTextButtonActionPerformed

    private void registerUsernameTfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_registerUsernameTfKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ESCAPE){
            this.dispose();
        }
    }//GEN-LAST:event_registerUsernameTfKeyPressed

    private void registerUsernameTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerUsernameTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registerUsernameTfActionPerformed

    // Create a function to verify the empty fields
    public boolean verifyFields()
    {
        String fname = registerFullNameField.getText();
        String uname = registerUsernameTf.getText();
        String phone = registerPhoneNumberTf.getText();
        String pass1 = String.valueOf(registerPasswordTf.getPassword());
        String pass2 = String.valueOf(registerConfirmPsswordField.getPassword());
        
        // Check empty fields
        if (fname.trim().equals("") || uname.trim().equals("") || phone.trim().equals("")
        || pass1.trim().equals("") || pass2.trim().equals(""))
        {
            JOptionPane.showMessageDialog(null, "One or more fields are empty.", "Empty fields", 2);
            return false;
        }
         // Check if the two password are equal
        else if (!pass1.equals(pass2))
        {
            JOptionPane.showMessageDialog(null, "Password doesn't match.", "Confirm Password", 2);
            return false;
        }
        // If everything is okay...
        else {
            return true;
        }
    }  
    // Create a function to check if the entered username already exists in the Database
    public boolean checkUsername(String username) {
        PreparedStatement st;
        ResultSet rs;
        boolean username_exist = false;

        String query = "SELECT * FROM users WHERE usernameString = ?";
        
        try {
            
            st = HEALTH_MONITORING_SYSTEM_DATABASE.getConnection().prepareStatement(query);
            st.setString(1, username);
            rs = st.executeQuery();
            
            if (rs.next())
            {
                username_exist = true;
                JOptionPane.showMessageDialog(null, "Username is already taken.\nPlease choose another one.", "Username existed", 2);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(HMS_REGISTERACCOUNT.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return username_exist;
    }
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(HMS_REGISTERACCOUNT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HMS_REGISTERACCOUNT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HMS_REGISTERACCOUNT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HMS_REGISTERACCOUNT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HMS_REGISTERACCOUNT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton clearAllButton;
    private javax.swing.JRadioButton femaleButton;
    private javax.swing.JButton fullNameClearTextButton;
    public javax.swing.JLabel fullNameLabel;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel imagePathLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton maleButton;
    private javax.swing.JButton passwordClearTextButton;
    private javax.swing.JButton phoneNumberClearTextButton;
    private javax.swing.JLabel phoneNumberLabel;
    private javax.swing.JButton registerButton;
    private javax.swing.JLabel registerConfirmPasswordLabel;
    private javax.swing.JPasswordField registerConfirmPsswordField;
    private javax.swing.JTextField registerFullNameField;
    public javax.swing.JPanel registerMainPanel;
    private javax.swing.JLabel registerPasswordLabel;
    private javax.swing.JPasswordField registerPasswordTf;
    private javax.swing.JTextField registerPhoneNumberTf;
    public javax.swing.JPanel registerTopPanel;
    private javax.swing.JLabel registerTopPanelImage;
    public javax.swing.JLabel registerUsernameLabel;
    private javax.swing.JTextField registerUsernameTf;
    private javax.swing.JButton selectImageButton;
    private javax.swing.JLabel userImageLabel;
    private javax.swing.JButton usernameClearTextButton;
    // End of variables declaration//GEN-END:variables
}
