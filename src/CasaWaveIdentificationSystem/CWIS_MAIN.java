package CasaWaveIdentificationSystem;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CWIS_MAIN extends javax.swing.JFrame {

    // Absolute =  Drive +  {folders(s)} + {file} | Uniform Naming Convention
    // Relative = No drive | ..\ one level up | ..\..\ two levels up
    final String currentAbsoluteFileDirectoryPath = System.getProperty("user.dir");

    CWIS_DATABASECONNECTION dbConnect = new CWIS_DATABASECONNECTION();
    //get Strings of 'em all
    String patientIdString = "";
    String firstName = "";
    String middleName = "";
    String lastName = "";
    String genderSelect = "";
    String dateOfBirth = "";
    String bloodType = "";
    String civilStatus = "";
    String religion = "";
    String nationality = "";
    String cellphoneNumber = "";
    String image_path = null;

    // backup database
    String backupRestorePath = null;
    String fileName;

    Connection connx;
    static DefaultTableModel model;
    int currentPosition = 0;
    CWIS_DATAACESSOBJECT_IMPLEMENTATION dao = new CWIS_DATAACESSOBJECT_IMPLEMENTATION();

    public CWIS_MAIN() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("HMS_LOGO_800PX.png")));
        initComponents();
        dashboardPanel.setVisible(true);
        employeePanel.setVisible(false);
        patientPanel.setVisible(false);
        displayDateAndTimePanel.setVisible(false);
        HomeTab.setBackground(Color.white);
        dateLabel.setVisible(true);
        timeLabel.setVisible(true);
        showDate();
        showDatePrivateTab();
        showTime();
        determineEmployeeRowCount();
        determinePatientRowCount();

    }

    private void EmployeeDisplayTable() {
        PreparedStatement pstmt;
        ResultSet rs;
        DefaultTableModel dm = (DefaultTableModel) employeeListTable.getModel();
        dm.fireTableDataChanged();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String username = "root";
            String password = "root";
            java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/casawave_identification_system_database", username, password);
            String sql = "SELECT * FROM employees";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            employeeListTable.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (ClassNotFoundException | SQLException err) {
            JOptionPane.showMessageDialog(null, err);
        }
    }

    // FILTER DATA
    private void employeeFilter(String query) {
        DefaultTableModel employeeDM = (DefaultTableModel) employeeListTable.getModel();
        TableRowSorter<DefaultTableModel> employeeTR = new TableRowSorter<>(employeeDM);
        employeeListTable.setRowSorter(employeeTR);
        employeeTR.setRowFilter(RowFilter.regexFilter(query));
    }

    private void patientFilter(String query) {
        DefaultTableModel patientDM = (DefaultTableModel) patientDataTable.getModel();
        TableRowSorter<DefaultTableModel> patientTR = new TableRowSorter<>(patientDM);
        patientDataTable.setRowSorter(patientTR);
        patientTR.setRowFilter(RowFilter.regexFilter(query));
    }

    final void showDate() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateLabel.setText(simpleDateFormat.format(date));
        dateLabelPrivateTab.setText(simpleDateFormat.format(date));
    }

    final void showDatePrivateTab() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM dd, yyyy");
        dateLabelPrivateTab.setText(simpleDateFormat.format(date));
    }

    final void showTime() {
        new Timer(0, (ActionEvent e) -> {
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss a");
            timeLabel.setText(simpleDateFormat.format(date));
            timeLabelPrivateTab.setText(simpleDateFormat.format(date));
        }).start();
    }

    private void determineEmployeeRowCount() {

        PreparedStatement pstmt;
        ResultSet rs;
        DefaultTableModel dm = (DefaultTableModel) employeeListTable.getModel();
        dm.fireTableDataChanged();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String username = "root";
            String password = "root";
            java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/casawave_identification_system_database", username, password);
            String sql = "SELECT count(employeeId) FROM employees";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                String sum = rs.getString("count(employeeId)");
                employeeCountLabel.setText("Registered Employee Count: " + sum);
                totalEmployeeCountLabel.setText("Total Employee Count: " + sum);
            }

        } catch (ClassNotFoundException | SQLException err) {
            JOptionPane.showMessageDialog(null, err);
        }
    }

    private void determinePatientRowCount() {

        PreparedStatement pstmt;
        ResultSet rs;
        DefaultTableModel dm = (DefaultTableModel) employeeListTable.getModel();
        dm.fireTableDataChanged();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String username = "root";
            String password = "root";
            java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/casawave_identification_system_database", username, password);
            String sql = "SELECT count(id) FROM patients";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                String sum = rs.getString("count(id)");
                patientCountLabel.setText("Registered Patient Count: " + sum);
                totalPatientCountLabel.setText("Total Patient Count: " + sum);
            }

        } catch (ClassNotFoundException | SQLException err) {
            JOptionPane.showMessageDialog(null, err);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        leftPanel = new javax.swing.JPanel();
        HomeTab = new javax.swing.JPanel();
        HomeLabel = new javax.swing.JLabel();
        EmployeeTab = new javax.swing.JPanel();
        EmployeeLabel = new javax.swing.JLabel();
        PatientTab = new javax.swing.JPanel();
        PatientLabel = new javax.swing.JLabel();
        ExitTab = new javax.swing.JPanel();
        ExitLabel = new javax.swing.JLabel();
        loggedInUsername = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        displayTimeAndDateTab = new javax.swing.JPanel();
        PatientLabel1 = new javax.swing.JLabel();
        mainWindowPanel = new javax.swing.JPanel();
        layeredPanel = new javax.swing.JLayeredPane();
        displayDateAndTimePanel = new javax.swing.JPanel();
        dateLabelPrivateTab = new javax.swing.JLabel();
        timeLabelPrivateTab = new javax.swing.JLabel();
        dashboardPanel = new javax.swing.JPanel();
        statPanel = new javax.swing.JPanel();
        patientCountLabel = new javax.swing.JLabel();
        employeeCountLabel = new javax.swing.JLabel();
        backuporrestorePanel = new javax.swing.JPanel();
        backupBrowsePathButton = new javax.swing.JButton();
        pathToBackup = new javax.swing.JTextField();
        backupEntireDatabaseButton = new javax.swing.JButton();
        backupEntireDatabaseLabel = new javax.swing.JLabel();
        backupResetButton = new javax.swing.JButton();
        employeePanel = new javax.swing.JPanel();
        employeeHeaderLabel = new javax.swing.JLabel();
        employeeTrackerPanel = new javax.swing.JPanel();
        totalEmployeeCountLabel = new javax.swing.JLabel();
        searchEmployeeButton = new javax.swing.JButton();
        filterSearchTf = new javax.swing.JTextField();
        filterSearchLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        employeeListTable = new javax.swing.JTable();
        manageEmployeesButton = new javax.swing.JButton();
        labelImageEmployee = new javax.swing.JLabel();
        employeeImageLabel = new javax.swing.JLabel();
        patientPanel = new javax.swing.JPanel();
        patientTrackerPanel1 = new javax.swing.JPanel();
        totalPatientCountLabel = new javax.swing.JLabel();
        PatientHeader = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        patientDataTable = new javax.swing.JTable();
        patientFilterSearchLabel = new javax.swing.JLabel();
        patientSearchTf = new javax.swing.JTextField();
        managePatientsButton = new javax.swing.JButton();
        patientImageLabel = new javax.swing.JLabel();
        labelImagePatient = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setName("mainProgram"); // NOI18N
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        topPanel.setBackground(new java.awt.Color(235, 241, 253));

        logoLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CasaWaveIdentificationSystem/APP_IMAGES/mainprogram/CWIS HEADER.png"))); // NOI18N

        timeLabel.setFont(new java.awt.Font("Century Gothic", 1, 30)); // NOI18N
        timeLabel.setForeground(new java.awt.Color(0, 0, 51));
        timeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        timeLabel.setText("Time");
        timeLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        timeLabel.setRequestFocusEnabled(false);

        dateLabel.setFont(new java.awt.Font("Century Gothic", 1, 28)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(0, 0, 51));
        dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dateLabel.setText("Date");
        dateLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dateLabel.setRequestFocusEnabled(false);

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1145, Short.MAX_VALUE)
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(topPanelLayout.createSequentialGroup()
                        .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5))
                    .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(topPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, -1));

        leftPanel.setBackground(new java.awt.Color(118, 164, 255));

        HomeTab.setBackground(new java.awt.Color(238, 238, 254));
        HomeTab.setMaximumSize(new java.awt.Dimension(100, 100));
        HomeTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeTabMouseClicked(evt);
            }
        });

        HomeLabel.setBackground(new java.awt.Color(238, 238, 254));
        HomeLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        HomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        HomeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CasaWaveIdentificationSystem/APP_IMAGES/mainprogram/dashboard64px.png"))); // NOI18N
        HomeLabel.setText(" Home");

        javax.swing.GroupLayout HomeTabLayout = new javax.swing.GroupLayout(HomeTab);
        HomeTab.setLayout(HomeTabLayout);
        HomeTabLayout.setHorizontalGroup(
            HomeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomeTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HomeTabLayout.setVerticalGroup(
            HomeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HomeLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        EmployeeTab.setBackground(new java.awt.Color(238, 238, 254));
        EmployeeTab.setMaximumSize(new java.awt.Dimension(100, 100));
        EmployeeTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EmployeeTabMouseClicked(evt);
            }
        });

        EmployeeLabel.setBackground(new java.awt.Color(255, 255, 255));
        EmployeeLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        EmployeeLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        EmployeeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CasaWaveIdentificationSystem/APP_IMAGES/mainprogram/employeeMain.png"))); // NOI18N
        EmployeeLabel.setText("Employee");

        javax.swing.GroupLayout EmployeeTabLayout = new javax.swing.GroupLayout(EmployeeTab);
        EmployeeTab.setLayout(EmployeeTabLayout);
        EmployeeTabLayout.setHorizontalGroup(
            EmployeeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(EmployeeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        EmployeeTabLayout.setVerticalGroup(
            EmployeeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EmployeeTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(EmployeeLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PatientTab.setBackground(new java.awt.Color(238, 238, 254));
        PatientTab.setMaximumSize(new java.awt.Dimension(100, 100));
        PatientTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PatientTabMouseClicked(evt);
            }
        });

        PatientLabel.setBackground(new java.awt.Color(255, 255, 255));
        PatientLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        PatientLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        PatientLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CasaWaveIdentificationSystem/APP_IMAGES/mainprogram/patientMain.png"))); // NOI18N
        PatientLabel.setText(" Patient");

        javax.swing.GroupLayout PatientTabLayout = new javax.swing.GroupLayout(PatientTab);
        PatientTab.setLayout(PatientTabLayout);
        PatientTabLayout.setHorizontalGroup(
            PatientTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PatientTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PatientLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PatientTabLayout.setVerticalGroup(
            PatientTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PatientLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ExitTab.setBackground(new java.awt.Color(238, 238, 254));
        ExitTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitTabMouseClicked(evt);
            }
        });

        ExitLabel.setBackground(new java.awt.Color(255, 255, 255));
        ExitLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        ExitLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ExitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CasaWaveIdentificationSystem/APP_IMAGES/mainprogram/exitIcon.png"))); // NOI18N
        ExitLabel.setText(" Exit");

        javax.swing.GroupLayout ExitTabLayout = new javax.swing.GroupLayout(ExitTab);
        ExitTab.setLayout(ExitTabLayout);
        ExitTabLayout.setHorizontalGroup(
            ExitTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ExitLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ExitTabLayout.setVerticalGroup(
            ExitTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExitTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ExitLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        loggedInUsername.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        loggedInUsername.setForeground(new java.awt.Color(255, 255, 255));
        CasaWaveIdentificationSystem.CWIS_LOGIN getUsername = new CasaWaveIdentificationSystem.CWIS_LOGIN();
        String getUsernameCredential = getUsername.username;
        loggedInUsername.setText("Logged in: " + getUsernameCredential);

        displayTimeAndDateTab.setBackground(new java.awt.Color(238, 238, 254));
        displayTimeAndDateTab.setMaximumSize(new java.awt.Dimension(100, 100));
        displayTimeAndDateTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displayTimeAndDateTabMouseClicked(evt);
            }
        });

        PatientLabel1.setBackground(new java.awt.Color(255, 255, 255));
        PatientLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        PatientLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        PatientLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CasaWaveIdentificationSystem/APP_IMAGES/mainprogram/dateAndTimeIcon.png"))); // NOI18N
        PatientLabel1.setText("Display Time and Date");

        javax.swing.GroupLayout displayTimeAndDateTabLayout = new javax.swing.GroupLayout(displayTimeAndDateTab);
        displayTimeAndDateTab.setLayout(displayTimeAndDateTabLayout);
        displayTimeAndDateTabLayout.setHorizontalGroup(
            displayTimeAndDateTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, displayTimeAndDateTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PatientLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
        );
        displayTimeAndDateTabLayout.setVerticalGroup(
            displayTimeAndDateTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayTimeAndDateTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PatientLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HomeTab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ExitTab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(EmployeeTab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PatientTab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(loggedInUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(displayTimeAndDateTab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loggedInUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(HomeTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(EmployeeTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PatientTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 375, Short.MAX_VALUE)
                .addComponent(displayTimeAndDateTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ExitTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        getContentPane().add(leftPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 390, 970));

        mainWindowPanel.setBackground(new java.awt.Color(235, 241, 253));
        mainWindowPanel.setMaximumSize(new java.awt.Dimension(1520, 970));
        mainWindowPanel.setRequestFocusEnabled(false);
        mainWindowPanel.setLayout(null);

        displayDateAndTimePanel.setBackground(new java.awt.Color(235, 241, 253));

        dateLabelPrivateTab.setFont(new java.awt.Font("Segoe UI", 1, 65)); // NOI18N
        dateLabelPrivateTab.setForeground(new java.awt.Color(0, 0, 51));
        dateLabelPrivateTab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateLabelPrivateTab.setText("Date");
        dateLabelPrivateTab.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dateLabelPrivateTab.setRequestFocusEnabled(false);

        timeLabelPrivateTab.setFont(new java.awt.Font("Segoe UI", 1, 100)); // NOI18N
        timeLabelPrivateTab.setForeground(new java.awt.Color(0, 0, 51));
        timeLabelPrivateTab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLabelPrivateTab.setText("Time");
        timeLabelPrivateTab.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        timeLabelPrivateTab.setRequestFocusEnabled(false);

        javax.swing.GroupLayout displayDateAndTimePanelLayout = new javax.swing.GroupLayout(displayDateAndTimePanel);
        displayDateAndTimePanel.setLayout(displayDateAndTimePanelLayout);
        displayDateAndTimePanelLayout.setHorizontalGroup(
            displayDateAndTimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayDateAndTimePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(displayDateAndTimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateLabelPrivateTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timeLabelPrivateTab, javax.swing.GroupLayout.DEFAULT_SIZE, 1500, Short.MAX_VALUE))
                .addContainerGap())
        );
        displayDateAndTimePanelLayout.setVerticalGroup(
            displayDateAndTimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayDateAndTimePanelLayout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addComponent(dateLabelPrivateTab)
                .addGap(18, 18, 18)
                .addComponent(timeLabelPrivateTab)
                .addContainerGap(459, Short.MAX_VALUE))
        );

        dashboardPanel.setBackground(new java.awt.Color(235, 241, 253));
        dashboardPanel.setMaximumSize(new java.awt.Dimension(1520, 970));
        dashboardPanel.setMinimumSize(new java.awt.Dimension(1520, 970));
        dashboardPanel.setPreferredSize(new java.awt.Dimension(1520, 970));

        statPanel.setBackground(new java.awt.Color(255, 255, 255));

        patientCountLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        patientCountLabel.setText("Registered Patient Count: ");

        employeeCountLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        employeeCountLabel.setText("Registered Employee Count: ");

        backuporrestorePanel.setBackground(new java.awt.Color(247, 255, 255));

        backupBrowsePathButton.setText("Choose a Path");
        backupBrowsePathButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backupBrowsePathButtonActionPerformed(evt);
            }
        });

        pathToBackup.setEditable(false);
        pathToBackup.setBackground(new java.awt.Color(255, 255, 255));
        pathToBackup.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pathToBackup.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        backupEntireDatabaseButton.setText("Backup Database");
        backupEntireDatabaseButton.setEnabled(false);
        backupEntireDatabaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backupEntireDatabaseButtonActionPerformed(evt);
            }
        });

        backupEntireDatabaseLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        backupEntireDatabaseLabel.setText("Create a Backup of the Database");

        backupResetButton.setText("RESET");
        backupResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backupResetButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backuporrestorePanelLayout = new javax.swing.GroupLayout(backuporrestorePanel);
        backuporrestorePanel.setLayout(backuporrestorePanelLayout);
        backuporrestorePanelLayout.setHorizontalGroup(
            backuporrestorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backuporrestorePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backuporrestorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pathToBackup)
                    .addGroup(backuporrestorePanelLayout.createSequentialGroup()
                        .addComponent(backupBrowsePathButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(backupEntireDatabaseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(backupResetButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(backuporrestorePanelLayout.createSequentialGroup()
                        .addComponent(backupEntireDatabaseLabel)
                        .addGap(0, 122, Short.MAX_VALUE)))
                .addContainerGap())
        );
        backuporrestorePanelLayout.setVerticalGroup(
            backuporrestorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backuporrestorePanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(backupEntireDatabaseLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pathToBackup, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backuporrestorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(backupEntireDatabaseButton, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(backupBrowsePathButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backupResetButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout statPanelLayout = new javax.swing.GroupLayout(statPanel);
        statPanel.setLayout(statPanelLayout);
        statPanelLayout.setHorizontalGroup(
            statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backuporrestorePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(employeeCountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(patientCountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        statPanelLayout.setVerticalGroup(
            statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(employeeCountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(patientCountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 579, Short.MAX_VALUE)
                .addComponent(backuporrestorePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout dashboardPanelLayout = new javax.swing.GroupLayout(dashboardPanel);
        dashboardPanel.setLayout(dashboardPanelLayout);
        dashboardPanelLayout.setHorizontalGroup(
            dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(statPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(989, Short.MAX_VALUE))
        );
        dashboardPanelLayout.setVerticalGroup(
            dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardPanelLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(statPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        employeePanel.setBackground(new java.awt.Color(235, 241, 253));
        employeePanel.setMaximumSize(new java.awt.Dimension(1520, 970));
        employeePanel.setMinimumSize(new java.awt.Dimension(1520, 970));

        employeeHeaderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        employeeHeaderLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CasaWaveIdentificationSystem/APP_IMAGES/mainprogram/CWIS_TOPPANEL_EMPLOYEES_fit.png"))); // NOI18N
        employeeHeaderLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        employeeTrackerPanel.setBackground(new java.awt.Color(255, 255, 255));
        employeeTrackerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Tracker", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24))); // NOI18N
        employeeTrackerPanel.setMaximumSize(new java.awt.Dimension(318, 120));

        totalEmployeeCountLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        totalEmployeeCountLabel.setText("Total Employee Count: ");
        DefaultTableModel employeeTableModel=(DefaultTableModel)employeeListTable.getModel();
        int number_of_rows = employeeTableModel.getRowCount();
        int numOne = 1;
        if (number_of_rows == 0) {
            totalEmployeeCountLabel.setText("Total Employee Count: 0");
        }
        else if (number_of_rows >= 1) {
            totalEmployeeCountLabel.setText("Total Employee Count: " + Integer.sum(number_of_rows, numOne));
        }

        javax.swing.GroupLayout employeeTrackerPanelLayout = new javax.swing.GroupLayout(employeeTrackerPanel);
        employeeTrackerPanel.setLayout(employeeTrackerPanelLayout);
        employeeTrackerPanelLayout.setHorizontalGroup(
            employeeTrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeeTrackerPanelLayout.createSequentialGroup()
                .addComponent(totalEmployeeCountLabel)
                .addGap(0, 53, Short.MAX_VALUE))
        );
        employeeTrackerPanelLayout.setVerticalGroup(
            employeeTrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeeTrackerPanelLayout.createSequentialGroup()
                .addComponent(totalEmployeeCountLabel)
                .addGap(0, 57, Short.MAX_VALUE))
        );

        searchEmployeeButton.setBackground(new java.awt.Color(153, 204, 255));
        searchEmployeeButton.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        searchEmployeeButton.setText("Search Employee");
        searchEmployeeButton.setBorderPainted(false);
        searchEmployeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchEmployeeButtonActionPerformed(evt);
            }
        });

        filterSearchTf.setBackground(new java.awt.Color(204, 204, 255));
        filterSearchTf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        filterSearchTf.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        filterSearchTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filterSearchTfKeyReleased(evt);
            }
        });

        filterSearchLabel.setBackground(new java.awt.Color(235, 241, 253));
        filterSearchLabel.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        filterSearchLabel.setText("Filter Search:");

        employeeListTable.setFillsViewportHeight(true);
        employeeListTable.setBackground(new Color(235, 240, 255));
        employeeListTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        employeeListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "FIRST NAME", "MIDDLE NAME", "LAST NAME", "Address", "Sex", "Birthday", "Blood Type", "Cellphone Number", "Civil Status", "Religion", "Nationality", "Father's Email Ad.", "Mother's Email Ad"
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
        employeeListTable.setGridColor(new java.awt.Color(255, 255, 255));
        employeeListTable.setMaximumSize(new java.awt.Dimension(1920, 1080));
        employeeListTable.setMinimumSize(new java.awt.Dimension(1920, 1080));
        employeeListTable.setRowHeight(40);
        employeeListTable.setShowGrid(false);
        employeeListTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeeListTableMouseClicked(evt);
            }
        });
        employeeListTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                employeeListTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(employeeListTable);

        manageEmployeesButton.setBackground(new java.awt.Color(15, 79, 157));
        manageEmployeesButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        manageEmployeesButton.setForeground(new java.awt.Color(255, 255, 255));
        manageEmployeesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CasaWaveIdentificationSystem/APP_IMAGES/mainprogram/employeeIcon.png"))); // NOI18N
        manageEmployeesButton.setText("Manage Employees");
        manageEmployeesButton.setToolTipText("Full admin commands of the database");
        manageEmployeesButton.setActionCommand("");
        manageEmployeesButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255)));
        manageEmployeesButton.setBorderPainted(false);
        manageEmployeesButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        manageEmployeesButton.setEnabled(false);
        manageEmployeesButton.setHideActionText(true);
        manageEmployeesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEmployeesButtonActionPerformed(evt);
            }
        });

        labelImageEmployee.setBackground(new java.awt.Color(102, 102, 102));
        labelImageEmployee.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelImageEmployee.setForeground(new java.awt.Color(255, 255, 255));
        labelImageEmployee.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelImageEmployee.setOpaque(true);

        employeeImageLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        employeeImageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        employeeImageLabel.setText("Employee Image");

        javax.swing.GroupLayout employeePanelLayout = new javax.swing.GroupLayout(employeePanel);
        employeePanel.setLayout(employeePanelLayout);
        employeePanelLayout.setHorizontalGroup(
            employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(employeeHeaderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 1500, Short.MAX_VALUE)
                    .addGroup(employeePanelLayout.createSequentialGroup()
                        .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(employeeTrackerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelImageEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(employeeImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(employeePanelLayout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(filterSearchLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filterSearchTf))
                    .addGroup(employeePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(manageEmployeesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 908, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchEmployeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        employeePanelLayout.setVerticalGroup(
            employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeePanelLayout.createSequentialGroup()
                .addComponent(employeeHeaderLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(employeePanelLayout.createSequentialGroup()
                        .addComponent(employeeTrackerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(employeeImageLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelImageEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterSearchTf, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterSearchLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchEmployeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(manageEmployeesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        patientPanel.setBackground(new java.awt.Color(235, 241, 253));
        patientPanel.setMaximumSize(new java.awt.Dimension(1520, 970));
        patientPanel.setMinimumSize(new java.awt.Dimension(1520, 970));
        patientPanel.setPreferredSize(new java.awt.Dimension(1520, 970));

        patientTrackerPanel1.setBackground(new java.awt.Color(255, 255, 255));
        patientTrackerPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Tracker", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24))); // NOI18N
        patientTrackerPanel1.setMaximumSize(new java.awt.Dimension(318, 120));
        patientTrackerPanel1.setPreferredSize(new java.awt.Dimension(318, 120));

        totalPatientCountLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        totalPatientCountLabel.setText("Total Patient Count: ");
        DefaultTableModel patientTableModel = (DefaultTableModel)patientDataTable.getModel();
        int patient_number_of_rows = patientTableModel.getRowCount();
        int patient_numOne = 1;
        if (patient_number_of_rows == 0) {
            totalPatientCountLabel.setText("Total Patient Count: 0");
        }
        else {
            totalPatientCountLabel.setText("Total Patient Count: " + Integer.sum(patient_number_of_rows, patient_numOne));
        }

        javax.swing.GroupLayout patientTrackerPanel1Layout = new javax.swing.GroupLayout(patientTrackerPanel1);
        patientTrackerPanel1.setLayout(patientTrackerPanel1Layout);
        patientTrackerPanel1Layout.setHorizontalGroup(
            patientTrackerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientTrackerPanel1Layout.createSequentialGroup()
                .addComponent(totalPatientCountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        patientTrackerPanel1Layout.setVerticalGroup(
            patientTrackerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientTrackerPanel1Layout.createSequentialGroup()
                .addComponent(totalPatientCountLabel)
                .addGap(0, 57, Short.MAX_VALUE))
        );

        PatientHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PatientHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CasaWaveIdentificationSystem/APP_IMAGES/mainprogram/CWIS_TOPPANEL_PATIENTS_fit.png"))); // NOI18N
        PatientHeader.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        patientDataTable.setFillsViewportHeight(true);
        patientDataTable.setBackground(new Color(235, 240, 255));
        patientDataTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        patientDataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Name", "Middle Name", "Last Name", "Gender", "Birthday", "Blood Type", "Civil Status", "Religion", "Nationality", "Cellphone Number"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        patientDataTable.setGridColor(new java.awt.Color(204, 204, 255));
        patientDataTable.setMaximumSize(new java.awt.Dimension(800, 0));
        patientDataTable.setMinimumSize(new java.awt.Dimension(800, 0));
        patientDataTable.setRowHeight(40);
        patientDataTable.setShowGrid(false);
        patientDataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patientDataTableMouseClicked(evt);
            }
        });
        patientDataTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                patientDataTableKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(patientDataTable);
        if (patientDataTable.getColumnModel().getColumnCount() > 0) {
            patientDataTable.getColumnModel().getColumn(0).setMinWidth(45);
            patientDataTable.getColumnModel().getColumn(0).setMaxWidth(66);
        }

        patientFilterSearchLabel.setBackground(new java.awt.Color(235, 241, 253));
        patientFilterSearchLabel.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        patientFilterSearchLabel.setText("Filter Search:");

        patientSearchTf.setBackground(new java.awt.Color(204, 204, 255));
        patientSearchTf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        patientSearchTf.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        patientSearchTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                patientSearchTfKeyReleased(evt);
            }
        });

        managePatientsButton.setBackground(new java.awt.Color(15, 79, 157));
        managePatientsButton.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        managePatientsButton.setForeground(new java.awt.Color(255, 255, 255));
        managePatientsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CasaWaveIdentificationSystem/APP_IMAGES/mainprogram/patientIcon.png"))); // NOI18N
        managePatientsButton.setText("Manage Patients");
        managePatientsButton.setToolTipText("Full admin commands of the database");
        managePatientsButton.setActionCommand("");
        managePatientsButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255)));
        managePatientsButton.setBorderPainted(false);
        managePatientsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        managePatientsButton.setHideActionText(true);
        managePatientsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managePatientsButtonActionPerformed(evt);
            }
        });

        patientImageLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        patientImageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageLabel.setText("Patient Image");

        labelImagePatient.setBackground(new java.awt.Color(102, 102, 102));
        labelImagePatient.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelImagePatient.setForeground(new java.awt.Color(255, 255, 255));
        labelImagePatient.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelImagePatient.setOpaque(true);

        javax.swing.GroupLayout patientPanelLayout = new javax.swing.GroupLayout(patientPanel);
        patientPanel.setLayout(patientPanelLayout);
        patientPanelLayout.setHorizontalGroup(
            patientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PatientHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1520, Short.MAX_VALUE)
            .addGroup(patientPanelLayout.createSequentialGroup()
                .addGroup(patientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(patientPanelLayout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(patientFilterSearchLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(patientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(managePatientsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(patientSearchTf, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(patientPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(patientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(patientTrackerPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                            .addComponent(patientImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelImagePatient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1244, Short.MAX_VALUE)))
                .addContainerGap())
        );
        patientPanelLayout.setVerticalGroup(
            patientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientPanelLayout.createSequentialGroup()
                .addComponent(PatientHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(patientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(patientPanelLayout.createSequentialGroup()
                        .addComponent(patientTrackerPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(patientImageLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelImagePatient, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(patientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(patientFilterSearchLabel)
                    .addComponent(patientSearchTf, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(managePatientsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layeredPanel.setLayer(displayDateAndTimePanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layeredPanel.setLayer(dashboardPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layeredPanel.setLayer(employeePanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layeredPanel.setLayer(patientPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layeredPanelLayout = new javax.swing.GroupLayout(layeredPanel);
        layeredPanel.setLayout(layeredPanelLayout);
        layeredPanelLayout.setHorizontalGroup(
            layeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1530, Short.MAX_VALUE)
            .addGroup(layeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layeredPanelLayout.createSequentialGroup()
                    .addGap(0, 5, Short.MAX_VALUE)
                    .addGroup(layeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(patientPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dashboardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(employeePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 5, Short.MAX_VALUE)))
            .addGroup(layeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layeredPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(displayDateAndTimePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layeredPanelLayout.setVerticalGroup(
            layeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 972, Short.MAX_VALUE)
            .addGroup(layeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layeredPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(patientPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dashboardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(employeePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(displayDateAndTimePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainWindowPanel.add(layeredPanel);
        layeredPanel.setBounds(0, 0, 1530, 972);

        getContentPane().add(mainWindowPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 1530, 970));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void HomeTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeTabMouseClicked
        employeePanel.setVisible(false);
        patientPanel.setVisible(false);
        displayDateAndTimePanel.setVisible(false);
        dashboardPanel.setVisible(true);

        HomeTab.setBackground(Color.white);
        EmployeeTab.setBackground(new Color(238, 238, 254));
        PatientTab.setBackground(new Color(238, 238, 254));
        displayTimeAndDateTab.setBackground(new Color(238, 238, 254));

        dateLabel.setVisible(true);
        timeLabel.setVisible(true);
    }//GEN-LAST:event_HomeTabMouseClicked

    private void EmployeeTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmployeeTabMouseClicked
        dashboardPanel.setVisible(false);
        patientPanel.setVisible(false);
        displayDateAndTimePanel.setVisible(false);
        employeePanel.setVisible(true);

        EmployeeTab.setBackground(Color.white);
        HomeTab.setBackground(new Color(238, 238, 254));
        PatientTab.setBackground(new Color(238, 238, 254));
        displayTimeAndDateTab.setBackground(new Color(238, 238, 254));

        dateLabel.setVisible(true);
        timeLabel.setVisible(true);

        EmployeeDisplayTable();
    }//GEN-LAST:event_EmployeeTabMouseClicked

    private void PatientTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PatientTabMouseClicked
        dashboardPanel.setVisible(false);
        employeePanel.setVisible(false);
        displayDateAndTimePanel.setVisible(false);
        patientPanel.setVisible(true);

        HomeTab.setBackground(new Color(238, 238, 254));
        EmployeeTab.setBackground(new Color(238, 238, 254));
        displayTimeAndDateTab.setBackground(new Color(238, 238, 254));
        PatientTab.setBackground(Color.white);

        dateLabel.setVisible(true);
        timeLabel.setVisible(true);

        dao.populatepatientDataTableFromMySQLDatabase(model, patientDataTable);

    }//GEN-LAST:event_PatientTabMouseClicked

    private void ExitTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitTabMouseClicked
        JPanel passwordPanel = new JPanel();
        JLabel passwordLabelText = new JLabel("Confirm Password:");
        JPasswordField passwordField = new JPasswordField(10);
        passwordPanel.requestFocus();
        passwordField.requestFocusInWindow();
        passwordPanel.setBackground(new Color(0xccf5ff));

        passwordPanel.add(passwordLabelText);
        passwordPanel.add(passwordField);
        String[] options = new String[]{"CANCEL", "CONFIRM"};
        int option = JOptionPane.showOptionDialog(null, passwordPanel, "Please input your password in the field",
                JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[1]); // default selection
        if (option == 1) // pressing ACCESS button
        {
            PreparedStatement st;
            ResultSet rs;
            // get the password
            String getPasswordCredential = String.valueOf(CWIS_LOGIN.password);
            String password = String.valueOf(passwordField.getPassword());
            //create a select query to check if the username and the password exist in the database
            String query = "SELECT * FROM users WHERE passwordString = ?";
            try {
                st = CASAWAVE_IDENTIFICATION_SYSTEM_DATABASE.getConnection().prepareStatement(query);
                st.setString(1, password);
                rs = st.executeQuery();

                if (rs.next()) {
                    if (getPasswordCredential.equals(password)) {
                        CWIS_LOGIN showLoginForm = new CWIS_LOGIN();
                        showLoginForm.setVisible(true);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Password.\nPlease try again.", "Incorrect Input", 2);
                    }

                } else {
                    // error message
                    JOptionPane.showMessageDialog(null, "Invalid Password.\nPlease try again.", "Incorrect Input", 2);
                }

            } catch (SQLException ex) {
                Logger.getLogger(CWIS_LOGIN.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "SQL Server Error. Please contact administrator.");
            }
        }
    }//GEN-LAST:event_ExitTabMouseClicked

    private void searchEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchEmployeeButtonActionPerformed
        CWIS_SEARCHEMPLOYEE searchEmployeeForm = new CWIS_SEARCHEMPLOYEE();
        searchEmployeeForm.setVisible(true);
    }//GEN-LAST:event_searchEmployeeButtonActionPerformed

    private void filterSearchTfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterSearchTfKeyReleased
        String query = filterSearchTf.getText();
        employeeFilter(query);
    }//GEN-LAST:event_filterSearchTfKeyReleased
    int patientDataTableSelectedRow;
    private void patientDataTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientDataTableMouseClicked
        patientDataTableSelectedRow = patientDataTable.getSelectedRow();
        selectPatient(patientDataTableSelectedRow);
        // make currentPosition start counting from the selected JTable Row
        currentPosition = patientDataTableSelectedRow;
    }//GEN-LAST:event_patientDataTableMouseClicked
    int employeeDataTableSelectedRow;
    private void patientDataTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_patientDataTableKeyReleased
        // Get the selected row index
        patientDataTableSelectedRow = patientDataTable.getSelectedRow();
        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            selectPatient(patientDataTableSelectedRow);
        }
    }//GEN-LAST:event_patientDataTableKeyReleased
    private void selectPatient(int counter) {
        try {
            try {
                labelImagePatient.setIcon(new ImageIcon(new ImageIcon(dao.patientList().get(counter).getimagePath()).getImage().getScaledInstance(labelImagePatient.getWidth(), labelImagePatient.getHeight(), Image.SCALE_SMOOTH)));
            } catch (Exception err) {
                labelImagePatient.setText("no image found.");
                this.invalidate();
                this.validate();
                this.repaint();
            }
        } catch (IndexOutOfBoundsException err) {
            labelImagePatient.setText("no image found.");
            this.repaint();
        }
    }

    private void selectEmployee(int counter) {
        try {
            try {
                labelImageEmployee.setIcon(new ImageIcon(new ImageIcon(dao.employeeList().get(counter).getimagePath()).getImage().getScaledInstance(labelImageEmployee.getWidth(), labelImageEmployee.getHeight(), Image.SCALE_SMOOTH)));
            } catch (Exception err) {
                labelImageEmployee.setText("no image found.");
                this.invalidate();
                this.validate();
                this.repaint();
            }
        } catch (IndexOutOfBoundsException err) {
            labelImageEmployee.setText("no image found.");
            this.repaint();
        }
    }
    private void patientSearchTfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_patientSearchTfKeyReleased
        String query = filterSearchTf.getText();
        patientFilter(query);
    }//GEN-LAST:event_patientSearchTfKeyReleased

    private void managePatientsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managePatientsButtonActionPerformed
        try {
            CWIS_PATIENT_MANAGEMENTSYSTEM showPatientDataList = new CWIS_PATIENT_MANAGEMENTSYSTEM();
            showPatientDataList.setVisible(true);
            this.dispose();
        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(null, "Try again.");
        } catch (Exception ex) {
            Logger.getLogger(CWIS_ADMINFORM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_managePatientsButtonActionPerformed

    private void backupBrowsePathButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backupBrowsePathButtonActionPerformed

        JFileChooser backupFileChooser = new JFileChooser();
        backupFileChooser.showOpenDialog(this);
        String backupDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        try {
            File file = backupFileChooser.getSelectedFile();
            backupRestorePath = file.getAbsolutePath();
            backupRestorePath = backupRestorePath.replace('\\', '/');
            backupRestorePath = backupRestorePath + "_" + backupDate + ".sql";
            pathToBackup.setText(backupRestorePath);
            backupEntireDatabaseButton.setEnabled(true);
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Backup failed or Window closed.\nTry again.");
        }

    }//GEN-LAST:event_backupBrowsePathButtonActionPerformed

    private void backupEntireDatabaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backupEntireDatabaseButtonActionPerformed
        Process process = null;
        try {
            Runtime runtime = Runtime.getRuntime();
            process = runtime.exec("C:/xampp/mysql/bin/mysqldump.exe -uroot -proot --add-drop-database -B casawave_identification_system_database -r" + backupRestorePath);

            int processComplete = process.waitFor();
            if (processComplete == 0) {
                pathToBackup.setText("Backup created successfully.");
                backupEntireDatabaseButton.setEnabled(false);
            } else {
                pathToBackup.setText("Backup failed.");
            }
        } catch (IOException | InterruptedException err) {
            JOptionPane.showMessageDialog(null, "Backup failed.\n Try again.");
        }
    }//GEN-LAST:event_backupEntireDatabaseButtonActionPerformed

    private void backupResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backupResetButtonActionPerformed
        pathToBackup.setText("");
        backupEntireDatabaseButton.setEnabled(false);
    }//GEN-LAST:event_backupResetButtonActionPerformed

    private void manageEmployeesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEmployeesButtonActionPerformed
        JOptionPane.showMessageDialog(null, "You cannot manage employees database.\nPlease contact administrator.");
    }//GEN-LAST:event_manageEmployeesButtonActionPerformed

    private void displayTimeAndDateTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayTimeAndDateTabMouseClicked
        dashboardPanel.setVisible(false);
        employeePanel.setVisible(false);
        patientPanel.setVisible(false);
        displayDateAndTimePanel.setVisible(true);
        displayTimeAndDateTab.setBackground(Color.white);
        HomeTab.setBackground(new Color(238, 238, 254));
        EmployeeTab.setBackground(new Color(238, 238, 254));
        PatientTab.setBackground(new Color(238, 238, 254));
        dateLabel.setVisible(false);
        timeLabel.setVisible(false);

    }//GEN-LAST:event_displayTimeAndDateTabMouseClicked

    private void employeeListTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_employeeListTableKeyReleased
        // Get the selected row index
        employeeDataTableSelectedRow = employeeListTable.getSelectedRow();
        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            selectEmployee(employeeDataTableSelectedRow);
        }
    }//GEN-LAST:event_employeeListTableKeyReleased

    private void employeeListTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeListTableMouseClicked
        employeeDataTableSelectedRow = employeeListTable.getSelectedRow();
        selectEmployee(employeeDataTableSelectedRow);
        // make currentPosition start counting from the selected JTable Row
        currentPosition = employeeDataTableSelectedRow;
    }//GEN-LAST:event_employeeListTableMouseClicked

    public static void main(String args[]) {
        // sets the look and feel to be that of the operating system's
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            System.out.println(e + "\n The UI is not compatible for this Operating System. Please contact admin.");
        }

        java.awt.EventQueue.invokeLater(() -> {

            new CWIS_MAIN().setVisible(true);

        });
    }

    void getTableModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EmployeeLabel;
    private javax.swing.JPanel EmployeeTab;
    private javax.swing.JLabel ExitLabel;
    private javax.swing.JPanel ExitTab;
    private javax.swing.JLabel HomeLabel;
    private javax.swing.JPanel HomeTab;
    private javax.swing.JLabel PatientHeader;
    private javax.swing.JLabel PatientLabel;
    private javax.swing.JLabel PatientLabel1;
    private javax.swing.JPanel PatientTab;
    private javax.swing.JButton backupBrowsePathButton;
    private javax.swing.JButton backupEntireDatabaseButton;
    private javax.swing.JLabel backupEntireDatabaseLabel;
    private javax.swing.JButton backupResetButton;
    private javax.swing.JPanel backuporrestorePanel;
    private javax.swing.JPanel dashboardPanel;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel dateLabelPrivateTab;
    private javax.swing.JPanel displayDateAndTimePanel;
    private javax.swing.JPanel displayTimeAndDateTab;
    private javax.swing.JLabel employeeCountLabel;
    private javax.swing.JLabel employeeHeaderLabel;
    private javax.swing.JLabel employeeImageLabel;
    public javax.swing.JTable employeeListTable;
    private javax.swing.JPanel employeePanel;
    public javax.swing.JPanel employeeTrackerPanel;
    private javax.swing.JLabel filterSearchLabel;
    private javax.swing.JTextField filterSearchTf;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelImageEmployee;
    private javax.swing.JLabel labelImagePatient;
    private javax.swing.JLayeredPane layeredPanel;
    private javax.swing.JPanel leftPanel;
    public static javax.swing.JLabel loggedInUsername;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JPanel mainWindowPanel;
    private javax.swing.JButton manageEmployeesButton;
    private javax.swing.JButton managePatientsButton;
    private javax.swing.JTextField pathToBackup;
    public javax.swing.JLabel patientCountLabel;
    public static javax.swing.JTable patientDataTable;
    private javax.swing.JLabel patientFilterSearchLabel;
    private javax.swing.JLabel patientImageLabel;
    private javax.swing.JPanel patientPanel;
    private javax.swing.JTextField patientSearchTf;
    public javax.swing.JPanel patientTrackerPanel1;
    private javax.swing.JButton searchEmployeeButton;
    private javax.swing.JPanel statPanel;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JLabel timeLabelPrivateTab;
    private javax.swing.JPanel topPanel;
    public javax.swing.JLabel totalEmployeeCountLabel;
    public javax.swing.JLabel totalPatientCountLabel;
    // End of variables declaration//GEN-END:variables
}
