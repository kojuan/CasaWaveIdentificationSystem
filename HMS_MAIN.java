package healthMonitoringSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Icon;
import javax.swing.SwingConstants; // center text/label
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class HMS_MAIN {
    public static JFrame frame;
    public static JPanel buttonpanel, topPanel,screenpanel,panel2, keypadpanel,
            passwordPanel;
    public static JLabel titleText, total, currentAmount, depositTextLabel, 
            currentBalance, balInquiryTitle, withdrawTextLabel, passwordLabelText;
    public static JButton exitButton, cwButton, payeeButton, bankButton, 
            chequeHistoryButton, settingsButton, done, b1, b2, b3, b4, b5,  b6,
            b7, b8, b9, b0,
            depositdone, deletechar, withdrawdone;
    public static float balance, depositAmount, f;
    public static TextField tf;
    public static String new_num, a, withdrawinput, dateFormat;
    public static Font titleTextFont;
    
    final String currentAbsoluteFileDirectoryPath = System.getProperty("user.dir");
    
    public static void HMS_MAIN() {
    //public static void main(String[] args)  {

    // sets the look and feel to be that of the operating system's
    try { 
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException | 
        InstantiationException | 
        IllegalAccessException | 
        UnsupportedLookAndFeelException e) {
    }
         
        frame = new JFrame();//creating instance of JFrame    
        frame.setTitle("Medical Health Monitoring System"); //title of the program
        frame.setExtendedState(frame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(0); // set a default close action
        frame.setBackground(new Color(0x6c7a89));
        frame.setVisible(true); // making the frame visible
        frame.setLayout(null);
        frame.setResizable(false); // to stop Restoring Down or maximizing 
        frame.setLocationRelativeTo(null); //center the window
//        frame.setSize(1920,1080); // width, height   ORIGINAL MAIN WINDOW SIZE
        home();
    }
     public static void home()   
    {
        
         //Create font.
 //Font Name : Default label font
 //Font Style : Bold And Italic
 //Font Size : Default label font size

        
        
 
        //MAIN FUNCTIONS OF THE PROGRAM BELOW
        titleText = new JLabel("Medical Health Monitoring System"); // , SwingConstants.CENTER   (to center)
        titleText.setBounds(5, 2, 1500, 70); // int x , int y , width, height
        titleTextFont = new Font(titleText.getFont().getName(),Font.ITALIC + Font.BOLD,titleText.getFont().getSize() * 4);
        titleText.setFont(titleTextFont);
        titleText.setForeground(new Color(0x3944bc)); // hex code blue

        Icon exitIconImage = new ImageIcon("C:\\Users\\Khian Orland Juan\\Documents\\NetBeansProjects\\healthmonitoringsystem\\src\\healthMonitoringSystem\\APP_IMAGES\\mainprogram\\exitIcon.png");
        exitButton = new JButton(exitIconImage);  //creating instance of JButton  
        exitButton.setBounds(1770,0,150,135); //x axis, y axis, width, height
        exitButton.setToolTipText("Exit the Application");
        exitButton.setBorder(BorderFactory.createEmptyBorder());
        exitButton.setContentAreaFilled(false);
        exitButton.setBorderPainted(false);
        exitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitButton.setFont(new Font("Segoe UI", Font.BOLD, 30));
        exitButton.setBackground(new Color(0xccf5ff));
        exitButton.setForeground(new Color(0xf4b350)); // hex code lime orange
        exitButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                
                int confirmed = JOptionPane.showConfirmDialog(null, 
                "Are you sure you want to exit the program?", "Exit Program?",
                JOptionPane.YES_NO_OPTION);

                if (confirmed == JOptionPane.YES_OPTION) {
                    passwordPanel = new JPanel();
                    passwordLabelText = new JLabel("Confirm your password:");
                    JPasswordField passwordField = new JPasswordField(10);
                    passwordPanel.requestFocus();
                    passwordField.requestFocusInWindow();
                    passwordPanel.setBackground(new Color(0xccf5ff));
                    
                    passwordPanel.add(passwordLabelText);
                    passwordPanel.add(passwordField);
                    String[] options = new String[]{"CONFIRM", "CANCEL"};
                    int option = JOptionPane.showOptionDialog(null, passwordPanel, "Please enter password to confirm exit",
                        JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                        null, options, options[1]); // default selection
                        if(option == 0) // pressing CONFIRM button
                        {
                            PreparedStatement st;
                            ResultSet rs;
                            // get the password
                            String password = String.valueOf(passwordField.getPassword());
                            //create a select query to check if the username and the password exist in the database
                            String query = "SELECT * FROM users WHERE passwordString = ?";
                            try {
                                st = HEALTH_MONITORING_SYSTEM_DATABASE.getConnection().prepareStatement(query);
                                st.setString(1, password);
                                rs = st.executeQuery();

                                if (rs.next())
                                {
                                    System.exit(0);
                                } else {
                                    // error message
                                    JOptionPane.showMessageDialog(null, "Invalid Password.\nPlease try again.","Login Error", 2);
                                }


                            } catch (SQLException ex) {
                                Logger.getLogger(HMS_LOGIN.class.getName()).log(Level.SEVERE, null, ex);
                                JOptionPane.showMessageDialog(null, "SQL Server Error. Please contact administrator.");
                            }
                        }
                }
            }
        });
            
        
        //SCREEN PANELS
        topPanel = new JPanel(); // creating panel
        topPanel.setLayout(null); // using no layout managers  
        topPanel.setBounds(0,70,1770,65);  //x, y , width, height   
        topPanel.setBackground(new Color(0xd2d7d3));
        
        
        Icon settingsIconImage = new ImageIcon("C:\\Users\\Khian Orland Juan\\Documents\\NetBeansProjects\\healthmonitoringsystem\\src\\healthMonitoringSystem\\APP_IMAGES\\mainprogram\\settingsIcon.png");
        settingsButton = new JButton(settingsIconImage);  //creating instance of JButton  
        settingsButton.setBorder(BorderFactory.createEmptyBorder());
        settingsButton.setContentAreaFilled(false);
        settingsButton.setBounds(1670,0,100,65); //x axis, y axis, width, height
        settingsButton.setBorderPainted(false);
        settingsButton.setToolTipText("Application settings");
        settingsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        settingsButton.setFont(new Font("Segoe UI", Font.BOLD, 30));
        settingsButton.setBackground(new Color(0xccf5ff));
        settingsButton.setForeground(new Color(0xf4b350)); // hex code lime orange
        settingsButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                
               //frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
               //setVisible(false); //you can't see me!
               //dispose(); //Destroy the JFrame object
            }
        });
        

        
         //SCREEN PANELS
        screenpanel = new JPanel(); // creating panel
        screenpanel.setLayout(null); // using no layout managers  
        screenpanel.setBounds(0,135,1920,850);  //x, y , width, height   850
        screenpanel.setBackground(new Color(0x6c7a89));
        
        frame.add(titleText);
        frame.add(exitButton);
        frame.add(screenpanel);
        frame.add(topPanel);
        

        
        
        //TOP PANEL ADD
        topPanel.add(settingsButton);
        
        
        //SCREEN PANEL ADD

        
        // REFRESH TO LOAD
        frame.invalidate();
        frame.validate();
        frame.repaint();
        
        topPanel.invalidate();
        topPanel.validate();
        topPanel.repaint();
        
        screenpanel.invalidate();
        screenpanel.validate();
        screenpanel.repaint();
        
    }
}