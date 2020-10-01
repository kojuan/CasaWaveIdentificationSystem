/*
 * Copyright (C) 2020 khian
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package healthMonitoringSystem;

import com.mysql.jdbc.PreparedStatement;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author khian
 */
public final class HMS_PATIENT_MANAGEMENTSYSTEM extends javax.swing.JFrame {

    // get database authentication
    String dbUsername = "root";
    String dbPassword = "root";
    String dbServerUrl = "jdbc:mysql://localhost:3306/health_monitoring_system_database";
    String dbClassPathUrl = "com.mysql.jdbc.Driver";

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
    Connection connx;
    DefaultTableModel model;
    int currentPosition = 0;

    /**
     * Creates new form HMS_PATIENT_MANAGEMENTSYSTEM
     */
    public HMS_PATIENT_MANAGEMENTSYSTEM() throws Exception {
        initComponents();
        connx = databaseConnection();
        // Populating patientDataTable
        populatepatientDataTableFromMySQLDatabase();
    }

    public Connection databaseConnection() {
        Connection conn;
        try {
            Class.forName(dbClassPathUrl); // load driver
            JOptionPane.showMessageDialog(null, "Driver loaded.");
            // connect to database 
            conn = DriverManager.getConnection(dbServerUrl, dbUsername, dbPassword);
            JOptionPane.showMessageDialog(null, "Connected.");
            return conn;
        } catch (SQLException ex) {
            return null;
        } catch (ClassNotFoundException ex) {
        }
        return null;
    }

    // Store database results in Arrayist Method
    public ArrayList<Patient> patientList() throws SQLException {
        ArrayList<Patient> patientList = new ArrayList<>();
        String selectAllSQLQuery = "SELECT * FROM `patients`";
        Statement stmt;
        ResultSet rs;

        try {
            stmt = connx.createStatement();
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
        }
        return patientList;
    }

    // Populate patientDataTable with Data from Database
    public void populatepatientDataTableFromMySQLDatabase() throws SQLException {
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genderGroup = new javax.swing.ButtonGroup();
        patientFullMainPanel = new javax.swing.JPanel();
        patientIDLabel = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        middleNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        dateOfBirthLabel = new javax.swing.JLabel();
        bloodTypeLabel = new javax.swing.JLabel();
        cellphoneNumberLabel = new javax.swing.JLabel();
        civilStatusLabel = new javax.swing.JLabel();
        religionLabel = new javax.swing.JLabel();
        nationalityLabel = new javax.swing.JLabel();
        imagePathLabel = new javax.swing.JLabel();
        patientIdTf = new javax.swing.JTextField();
        firstNameTf = new javax.swing.JTextField();
        middleNameTf = new javax.swing.JTextField();
        lastNameTf = new javax.swing.JTextField();
        dateOfBirthPicker = new com.github.lgooddatepicker.components.DatePicker();
        maleCbButton = new javax.swing.JCheckBox();
        femaleCbButton = new javax.swing.JCheckBox();
        bloodTypeCB = new javax.swing.JComboBox<>();
        civilStatusCB = new javax.swing.JComboBox<>();
        religionCB = new javax.swing.JComboBox<>();
        nationalityTf = new javax.swing.JTextField();
        phoneNumberTf = new javax.swing.JTextField();
        imagePathTf = new javax.swing.JTextField();
        labelImage = new javax.swing.JLabel();
        browseImageButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        exportExcelButton = new javax.swing.JButton();
        importExcelButton = new javax.swing.JButton();
        printButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        patientDataTable = new javax.swing.JTable();
        imageNameLabel = new javax.swing.JLabel();
        imageNameTf = new javax.swing.JTextField();
        firstItemInListButton = new javax.swing.JButton();
        lastItemInListButton = new javax.swing.JButton();
        nextItemInListButton = new javax.swing.JButton();
        previousItemInListButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MHMS Patient Data Management System");
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setName("patientMainFrame"); // NOI18N
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        setResizable(false);

        patientFullMainPanel.setBackground(new java.awt.Color(255, 255, 255));
        patientFullMainPanel.setMaximumSize(new java.awt.Dimension(1920, 1080));
        patientFullMainPanel.setPreferredSize(new java.awt.Dimension(1920, 1080));

        patientIDLabel.setText("Patient ID:");
        patientIDLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        firstNameLabel.setText("First Name:");
        firstNameLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        middleNameLabel.setText("Middle Name:");
        middleNameLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        lastNameLabel.setText("Last Name:");
        lastNameLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        genderLabel.setText("Gender:");
        genderLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        dateOfBirthLabel.setText("Date of Birth:");
        dateOfBirthLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        bloodTypeLabel.setText("Blood Type:");
        bloodTypeLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        cellphoneNumberLabel.setText("Cellphone Num. :");
        cellphoneNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        civilStatusLabel.setText("Civil Status:");
        civilStatusLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        religionLabel.setText("Religion:");
        religionLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        nationalityLabel.setText("Nationality:");
        nationalityLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        imagePathLabel.setText("Image Path:");
        imagePathLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        patientIdTf.setEnabled(false);

        firstNameTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                firstNameTfKeyTyped(evt);
            }
        });

        middleNameTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                middleNameTfKeyTyped(evt);
            }
        });

        lastNameTf.setMaximumSize(new java.awt.Dimension(7, 20));
        lastNameTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lastNameTfKeyTyped(evt);
            }
        });

        dateOfBirthPicker.setBackground(new java.awt.Color(255, 255, 255));
        dateOfBirthPicker.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        genderGroup.add(maleCbButton);
        maleCbButton.setText("Male");
        maleCbButton.setBackground(new java.awt.Color(255, 255, 255));
        maleCbButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        genderGroup.add(femaleCbButton);
        femaleCbButton.setText("Female");
        femaleCbButton.setBackground(new java.awt.Color(255, 255, 255));
        femaleCbButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        bloodTypeCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unspecified", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" }));
        bloodTypeCB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        civilStatusCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unspecified", "Single", "Married", "Divorced", "Widowed" }));
        civilStatusCB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        religionCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aglipayan", "Buddhism", "Catholic", "Hinduism", "Iglesia ni Cristo", "Islam", "Judaism", "Non-Roman Catholic and Protestant", "Seventh-day Adventist", "Unspecified", " " }));
        religionCB.setSelectedIndex(9);
        religionCB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        nationalityTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nationalityTfKeyTyped(evt);
            }
        });

        phoneNumberTf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        phoneNumberTf.setMaximumSize(new java.awt.Dimension(7, 20));
        phoneNumberTf.setPreferredSize(new java.awt.Dimension(7, 20));
        phoneNumberTf.setToolTipText("Please indicate your Phone number starting at 09xxxxxxxx");
        phoneNumberTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phoneNumberTfKeyTyped(evt);
            }
        });
        phoneNumberTf.setDocument(new JTextFieldLimit(11));

        imagePathTf.setEditable(false);
        imagePathTf.setBorder(null);
        imagePathTf.setEnabled(false);
        imagePathTf.setFocusable(false);

        labelImage.setBackground(new java.awt.Color(102, 102, 0));
        labelImage.setOpaque(true);

        browseImageButton.setText("Browse Image");
        browseImageButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        browseImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseImageButtonActionPerformed(evt);
            }
        });

        addButton.setText("Add");
        addButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Update");
        updateButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        jButton6.setText("Move Row Up");
        jButton6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jButton7.setText("Move Row Down");
        jButton7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jButton8.setText("View Selected");
        jButton8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jButton9.setText("List Selected");
        jButton9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        exportExcelButton.setText("Export (Excel)");
        exportExcelButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        exportExcelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportExcelButtonActionPerformed(evt);
            }
        });

        importExcelButton.setText("Import (Excel)");
        importExcelButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        printButton.setText("Print");
        printButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

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
        patientDataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patientDataTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(patientDataTable);
        if (patientDataTable.getColumnModel().getColumnCount() > 0) {
            patientDataTable.getColumnModel().getColumn(0).setMaxWidth(50);
            patientDataTable.getColumnModel().getColumn(6).setMaxWidth(100);
        }

        imageNameLabel.setText("Image Name:");
        imageNameLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        imageNameTf.setEditable(false);
        imageNameTf.setBorder(null);
        imageNameTf.setEnabled(false);
        imageNameTf.setFocusable(false);

        firstItemInListButton.setText("First");
        firstItemInListButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        firstItemInListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstItemInListButtonActionPerformed(evt);
            }
        });

        lastItemInListButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lastItemInListButton.setText("Last");
        lastItemInListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastItemInListButtonActionPerformed(evt);
            }
        });

        nextItemInListButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nextItemInListButton.setText("Next");
        nextItemInListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextItemInListButtonActionPerformed(evt);
            }
        });

        previousItemInListButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        previousItemInListButton.setText("Previous");
        previousItemInListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousItemInListButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout patientFullMainPanelLayout = new javax.swing.GroupLayout(patientFullMainPanel);
        patientFullMainPanel.setLayout(patientFullMainPanelLayout);
        patientFullMainPanelLayout.setHorizontalGroup(
            patientFullMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, patientFullMainPanelLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(patientFullMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(patientFullMainPanelLayout.createSequentialGroup()
                        .addGroup(patientFullMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(patientFullMainPanelLayout.createSequentialGroup()
                                .addGroup(patientFullMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(firstNameLabel)
                                    .addComponent(patientIDLabel)
                                    .addComponent(middleNameLabel)
                                    .addComponent(lastNameLabel)
                                    .addComponent(genderLabel)
                                    .addComponent(dateOfBirthLabel)
                                    .addComponent(bloodTypeLabel)
                                    .addComponent(civilStatusLabel)
                                    .addComponent(religionLabel)
                                    .addComponent(nationalityLabel)
                                    .addComponent(cellphoneNumberLabel))
                                .addGap(19, 19, 19)
                                .addGroup(patientFullMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(middleNameTf, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lastNameTf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(patientFullMainPanelLayout.createSequentialGroup()
                                        .addComponent(maleCbButton)
                                        .addGap(29, 29, 29)
                                        .addComponent(femaleCbButton))
                                    .addComponent(dateOfBirthPicker, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bloodTypeCB, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(phoneNumberTf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nationalityTf)
                                    .addComponent(religionCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(civilStatusCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(firstNameTf)
                                    .addComponent(patientIdTf, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(patientFullMainPanelLayout.createSequentialGroup()
                                .addGroup(patientFullMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(imagePathLabel)
                                    .addComponent(imageNameLabel))
                                .addGap(68, 68, 68)
                                .addGroup(patientFullMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(imagePathTf)
                                    .addComponent(imageNameTf))))
                        .addGap(18, 18, 18)
                        .addGroup(patientFullMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(browseImageButton, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(patientFullMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(deleteButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(updateButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .addComponent(addButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(patientFullMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(patientFullMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(importExcelButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(printButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(exportExcelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(patientFullMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstItemInListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lastItemInListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nextItemInListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(previousItemInListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52))
                    .addGroup(patientFullMainPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(125, 125, 125))))
        );
        patientFullMainPanelLayout.setVerticalGroup(
            patientFullMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientFullMainPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(patientFullMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(patientFullMainPanelLayout.createSequentialGroup()
                        .addGroup(patientFullMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(patientIDLabel)
                            .addComponent(patientIdTf, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(patientFullMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstNameLabel)
                            .addComponent(firstNameTf, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(patientFullMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(middleNameLabel)
                            .addComponent(middleNameTf, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(patientFullMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lastNameLabel)
                            .addComponent(lastNameTf, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(patientFullMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(genderLabel)
                            .addComponent(maleCbButton)
                            .addComponent(femaleCbButton))
                        .addGap(18, 18, 18)
                        .addGroup(patientFullMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dateOfBirthLabel)
                            .addComponent(dateOfBirthPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(patientFullMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bloodTypeLabel)
                            .addComponent(bloodTypeCB))
                        .addGap(18, 18, 18)
                        .addGroup(patientFullMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(civilStatusLabel)
                            .addComponent(civilStatusCB))
                        .addGap(18, 18, 18)
                        .addGroup(patientFullMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(religionLabel)
                            .addComponent(religionCB))
                        .addGap(18, 18, 18)
                        .addGroup(patientFullMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nationalityLabel)
                            .addComponent(nationalityTf, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(patientFullMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cellphoneNumberLabel)
                            .addComponent(phoneNumberTf, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(patientFullMainPanelLayout.createSequentialGroup()
                        .addGroup(patientFullMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(patientFullMainPanelLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(patientFullMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(patientFullMainPanelLayout.createSequentialGroup()
                                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(patientFullMainPanelLayout.createSequentialGroup()
                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(patientFullMainPanelLayout.createSequentialGroup()
                                        .addGroup(patientFullMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(firstItemInListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(patientFullMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(importExcelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lastItemInListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(patientFullMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(exportExcelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(nextItemInListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(patientFullMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(previousItemInListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(15, 15, 15)))
                .addGroup(patientFullMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(patientFullMainPanelLayout.createSequentialGroup()
                        .addGroup(patientFullMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(imagePathTf, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(imagePathLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(patientFullMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(imageNameLabel)
                            .addComponent(imageNameTf, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(browseImageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(patientFullMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(patientFullMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void selectPatient(int counter) {
        try {
            patientIdTf.setText(Integer.toString(patientList().get(counter).getID()));
            firstNameTf.setText(patientList().get(counter).getfirstName());
            middleNameTf.setText(patientList().get(counter).getMiddleName());
            lastNameTf.setText(patientList().get(counter).getLastName());
            String gender = patientList().get(counter).getGender();
            if (gender.equals("Male")) {
                maleCbButton.setSelected(true);
            } else if (gender.contains("Female")) {
                femaleCbButton.setSelected(true);
            }

            String bloodTypeString = patientList().get(counter).getbloodType();
            for (int row = 0; row < bloodTypeCB.getItemCount(); row++) {
                if (bloodTypeCB.getItemAt(row).equalsIgnoreCase(bloodTypeString)) {
                    bloodTypeCB.setSelectedIndex(row);
                }
            }

            String civilStatusString = patientList().get(counter).getcivilStatus();
            for (int row = 0; row < civilStatusCB.getItemCount(); row++) {
                if (civilStatusCB.getItemAt(row).equalsIgnoreCase(civilStatusString)) {
                    civilStatusCB.setSelectedIndex(row);
                }
            }

            String religionString = patientList().get(counter).getReligion();
            for (int row = 0; row < religionCB.getItemCount(); row++) {
                if (religionCB.getItemAt(row).equalsIgnoreCase(religionString)) {
                    religionCB.setSelectedIndex(row);
                }
            }

            nationalityTf.setText(patientList().get(counter).getNationality());
            phoneNumberTf.setText(patientList().get(counter).getphoneNumber());
            labelImage.setIcon(new ImageIcon(new ImageIcon(patientList().get(counter).getimagePath()).getImage().getScaledInstance(labelImage.getWidth(), labelImage.getHeight(), Image.SCALE_SMOOTH)));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    // limit phone number max

    public class JTextFieldLimit extends PlainDocument {

        private final int limit;

        JTextFieldLimit(int limit) {
            super();
            this.limit = limit;
        }

        @Override
        public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
            if (str == null) {
                return;
            }

            if ((getLength() + str.length()) <= limit) {
                super.insertString(offset, str, attr);
            }
        }
    }
    private void phoneNumberTfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneNumberTfKeyTyped
        // allow only numbers
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_phoneNumberTfKeyTyped

    private void browseImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseImageButtonActionPerformed
        // Default image location

        String currentDirectoryPath = "C:\\Users\\Public\\Pictures\\";
        JFileChooser imageFileChooser = new JFileChooser(currentDirectoryPath);
        int imageChooser = imageFileChooser.showOpenDialog(null);
        imageFileChooser.setDialogTitle("Chose Image...");
        //Only choose "png", "jpg", "jpeg" files
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES", "png", "jpg", "jpeg");
        imageFileChooser.setFileFilter(fnef);

        if (imageChooser == JFileChooser.APPROVE_OPTION) {
            File imageFile = imageFileChooser.getSelectedFile();
            String imageFileName = imageFile.getName();
            String imageFilePath = imageFile.getAbsolutePath();
            imageNameTf.setText(imageFileName); // display image name in the textfield

            ImageIcon imageIcon = new ImageIcon(imageFilePath);
            // resize image to fill LabelImage
            Image image = imageIcon.getImage().getScaledInstance(labelImage.getWidth(), labelImage.getHeight(), Image.SCALE_SMOOTH);
            // Display Image on LabelImage
            ImageIcon resizedImagedIcon = new ImageIcon(image);
            labelImage.setIcon(resizedImagedIcon);
            // Display Image Path in imagePathTf
            imagePathTf.setText(imageFilePath);
            image_path = imageFilePath;
        }

    }//GEN-LAST:event_browseImageButtonActionPerformed
    public boolean verifyFields() throws ParseException {
        String firstNameString = firstNameTf.getText();
        String middleNameString = middleNameTf.getText();
        String lastNameString = lastNameTf.getText();
        String selectedbDay = dateOfBirthPicker.getText();
        String nationalityString = nationalityTf.getText();
        // Check empty fields
        if (firstNameString.trim().equals("") || middleNameString.trim().equals("")
                || lastNameString.trim().equals("") || selectedbDay.trim().equals("")
                || nationalityString.equals("")) {
            JOptionPane.showMessageDialog(null, "One or more fields are empty.\nPlease fill-up all forms.", "Empty fields", JOptionPane.INFORMATION_MESSAGE);
            this.repaint();
            return false;
        } // If everything is okay...
        else {
            return true;
        }
    }
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        try {
            firstName = firstNameTf.getText();
            middleName = middleNameTf.getText();
            lastName = lastNameTf.getText();

            if (maleCbButton.isSelected()) {
                genderSelect = "Male";
            } else if (femaleCbButton.isSelected()) {
                genderSelect = "Female";
            }

            dateOfBirth = dateOfBirthPicker.getDateStringOrEmptyString(); // bday
            bloodType = String.valueOf(bloodTypeCB.getSelectedItem());
            civilStatus = String.valueOf(civilStatusCB.getSelectedItem());
            religion = String.valueOf(religionCB.getSelectedItem());
            nationality = nationalityTf.getText();
            cellphoneNumber = phoneNumberTf.getText();

            if (verifyFields()) {
                PreparedStatement pst;
                String registerPatientQuery = "INSERT INTO `patients`(`FirstName`, `MiddleName`, `LastName`, `Gender`, `DateOfBirth`, `BloodType`, `CivilStatus`, `Religion`, `Nationality`, `CellphoneNumber`, `ImagePath`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

                try {

                    pst = (PreparedStatement) HEALTH_MONITORING_SYSTEM_DATABASE.getConnection().prepareStatement(registerPatientQuery);
                    pst.setString(1, firstName);
                    pst.setString(2, middleName);
                    pst.setString(3, lastName);
                    pst.setString(4, genderSelect);
                    pst.setString(5, dateOfBirth);
                    pst.setString(6, bloodType);
                    pst.setString(7, civilStatus);
                    pst.setString(8, religion);
                    pst.setString(9, nationality);
                    pst.setString(10, cellphoneNumber);

                    try {
                        // Save the image as BLOB in the Database
                        if (image_path != null) {

                            InputStream image = new FileInputStream(new File(image_path));
                            pst.setBlob(11, image);
                        } else if (image_path == null) {
                            pst.setNull(11, java.sql.Types.NULL);
                            System.out.println("No image attached.");
                        } else {
                            pst.setNull(1, java.sql.Types.NULL);
                            System.out.println("No image attached.");
                        }
                        if (pst.executeUpdate() != 0) {
                            JOptionPane.showMessageDialog(null, "Patient data added.");
                            clearAllInputFields();
                            // Refresh patientDataTable after adding new entry to database
                            populatepatientDataTableFromMySQLDatabase();
                        } else {
                            JOptionPane.showMessageDialog(null, "Error: Check your Information.");
                        }
                        pst.setNull(11, java.sql.Types.NULL);
                    } catch (FileNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                } catch (HeadlessException | SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }

            }
        } catch (ParseException ex) {
            Logger.getLogger(HMS_PATIENT_MANAGEMENTSYSTEM.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_addButtonActionPerformed

    private void nationalityTfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nationalityTfKeyTyped
        char charInputOnly = evt.getKeyChar();
        if (!(Character.isAlphabetic(charInputOnly) || (charInputOnly == KeyEvent.VK_BACK_SPACE) || charInputOnly == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_nationalityTfKeyTyped

    private void firstNameTfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstNameTfKeyTyped
        char charInputOnly = evt.getKeyChar();
        if (!(Character.isAlphabetic(charInputOnly) || (charInputOnly == KeyEvent.VK_BACK_SPACE) || charInputOnly == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_firstNameTfKeyTyped

    private void middleNameTfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_middleNameTfKeyTyped
        char charInputOnly = evt.getKeyChar();
        if (!(Character.isAlphabetic(charInputOnly) || (charInputOnly == KeyEvent.VK_BACK_SPACE) || charInputOnly == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_middleNameTfKeyTyped

    private void lastNameTfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lastNameTfKeyTyped
        char charInputOnly = evt.getKeyChar();
        if (!(Character.isAlphabetic(charInputOnly) || (charInputOnly == KeyEvent.VK_BACK_SPACE) || charInputOnly == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_lastNameTfKeyTyped
    private void clearAllInputFields() {
        patientIdTf.setText("");
        firstNameTf.setText("");
        middleNameTf.setText("");
        lastNameTf.setText("");
        genderGroup.clearSelection();
        bloodTypeCB.setSelectedIndex(0);
        civilStatusCB.setSelectedIndex(0);
        religionCB.setSelectedIndex(9);
        nationalityTf.setText("");
        phoneNumberTf.setText("");
        labelImage.setIcon(null);
        image_path = null;

    }
    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clearAllInputFields();
    }//GEN-LAST:event_clearButtonActionPerformed


    private void patientDataTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientDataTableMouseClicked
        int patientDataTableSelectedRow = patientDataTable.getSelectedRow();

        // make currentPosition start counting from the selected JTable Row
        currentPosition = patientDataTableSelectedRow;
        selectPatient(patientDataTableSelectedRow);
    }//GEN-LAST:event_patientDataTableMouseClicked

    private void firstItemInListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstItemInListButtonActionPerformed
        currentPosition = 0;
        selectPatient(currentPosition);
    }//GEN-LAST:event_firstItemInListButtonActionPerformed

    private void lastItemInListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastItemInListButtonActionPerformed
        try {
            currentPosition = patientList().size() - 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        selectPatient(currentPosition);
    }//GEN-LAST:event_lastItemInListButtonActionPerformed

    private void nextItemInListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextItemInListButtonActionPerformed
        // Increment currentPosition to display  next item on input fields

        currentPosition++;

        try {
            if (currentPosition > patientList().size() - 1) {
                currentPosition = 0;
            }

            // If you reach the last item , move back to the first item.
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        selectPatient(currentPosition);
    }//GEN-LAST:event_nextItemInListButtonActionPerformed

    private void previousItemInListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousItemInListButtonActionPerformed
        // Decrenebt currentPosition to access/view previous item in a list

        currentPosition--;
        if (currentPosition < 0) {
            try {
                currentPosition = patientList().size() - 1;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        selectPatient(currentPosition);
    }//GEN-LAST:event_previousItemInListButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed

        // first check if the ID field is Empty.)
        if (patientIdTf.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "ID Field is Empty.");
        } else {

            // Delete data from MySQL Database
            Connection dbconnection = null;
            PreparedStatement pst = null;
            String deleteSQLQuery = "DELETE FROM `patients` WHERE id = ?";

            try {
                dbconnection = this.connx;
                pst = (PreparedStatement) dbconnection.prepareStatement(deleteSQLQuery);
                pst.setInt(1, Integer.parseInt(patientIdTf.getText()));
                int deleteSTMT = pst.executeUpdate();

                if (deleteSTMT > 0) {
                    JOptionPane.showMessageDialog(null, "Deleted Data Successfully!");
                    // Close inpt fields after deleting  
                    clearAllInputFields();
                    // Refresh JTable to remove deleted row
                    populatepatientDataTableFromMySQLDatabase();

                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            } finally {
                // Close Connection
                try {
                    if (pst != null) {
                        pst.close();
                    }
//                    if (dbconnection != null) {
//                        dbconnection.close();
//                    }
                } catch (SQLException sQLException) {
                    sQLException.getMessage();
                }
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        if (patientIdTf.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "ID Field is Empty.");
        } else {
            try {
                firstName = firstNameTf.getText();
                middleName = middleNameTf.getText();
                lastName = lastNameTf.getText();

                if (maleCbButton.isSelected()) {
                    genderSelect = "Male";
                } else if (femaleCbButton.isSelected()) {
                    genderSelect = "Female";
                }

                dateOfBirth = dateOfBirthPicker.getDateStringOrEmptyString(); // bday
                bloodType = String.valueOf(bloodTypeCB.getSelectedItem());
                civilStatus = String.valueOf(civilStatusCB.getSelectedItem());
                religion = String.valueOf(religionCB.getSelectedItem());
                nationality = nationalityTf.getText();
                cellphoneNumber = phoneNumberTf.getText();

                if (verifyFields()) {
                    PreparedStatement pst;
                    String updatePatientQuery = "UPDATE `patients` SET `FirstName`=?,`MiddleName`=?,`LastName`=?,`Gender`=?,`DateOfBirth`=?,`BloodType`=?,`CivilStatus`=?,`Religion`=?,`Nationality`=?,`CellphoneNumber`=?,`ImagePath`=? WHERE id = " + patientIdTf.getText();

                    try {

                        pst = (PreparedStatement) HEALTH_MONITORING_SYSTEM_DATABASE.getConnection().prepareStatement(updatePatientQuery);
                        pst.setString(1, firstName);
                        pst.setString(2, middleName);
                        pst.setString(3, lastName);
                        pst.setString(4, genderSelect);
                        pst.setString(5, dateOfBirth);
                        pst.setString(6, bloodType);
                        pst.setString(7, civilStatus);
                        pst.setString(8, religion);
                        pst.setString(9, nationality);
                        pst.setString(10, cellphoneNumber);

                        try {
                            // Save the image as BLOB in the Database
                            if (image_path != null) {

                                InputStream image = new FileInputStream(new File(image_path));
                                pst.setBlob(11, image);
                            } else if (image_path == null) {
                                pst.setNull(11, java.sql.Types.NULL);
                                System.out.println("No image attached.");
                            } else {
                                pst.setNull(1, java.sql.Types.NULL);
                                System.out.println("No image attached.");
                            }
                            if (pst.executeUpdate() != 0) {
                                JOptionPane.showMessageDialog(null, "Patient data has been updated.");
                                clearAllInputFields();
                                // Refresh patientDataTable after adding new entry to database
                                populatepatientDataTableFromMySQLDatabase();
                            } else {
                                JOptionPane.showMessageDialog(null, "Error: Check your Information.");
                            }
                            pst.setNull(11, java.sql.Types.NULL);
                        } catch (FileNotFoundException ex) {
                            JOptionPane.showMessageDialog(null, ex);
                        }
                    } catch (HeadlessException | SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }

                }
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }


    }//GEN-LAST:event_updateButtonActionPerformed

    private void exportExcelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportExcelButtonActionPerformed
        String currentDirectoryFilePathToExport = "C:\\Users\\Public\\Desktop";
        JFileChooser excelExportChooser = new JFileChooser(currentDirectoryFilePathToExport);
        // Filter only excel files
        FileNameExtensionFilter excelFNEF = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        excelExportChooser.setFileFilter(excelFNEF);
        // Set Dialogue Box Title
        excelExportChooser.setDialogTitle("Export Patient Database");
        int excelChooser = excelExportChooser.showSaveDialog(null);

        if (excelChooser == JFileChooser.APPROVE_OPTION) {

            // Add Excel Library to ClassPath.
            XSSFWorkbook excelXSSFWorkBookExporter = new XSSFWorkbook();
            XSSFSheet excelSheet = excelXSSFWorkBookExporter.createSheet("Patient's Data");
            // Loop through JTable columns and rows

            for (int i = 0; i < model.getRowCount(); i++) {
                XSSFRow excelRow = excelSheet.createRow(i);
                for (int j = 0; j < model.getColumnCount(); j++) {
                    XSSFCell excelCell = excelRow.createCell(j);

                    excelCell.setCellValue(model.getValueAt(i, j).toString());
                }
            }
            // Create unique name by using existing excel file names and appending .xlsx

            FileOutputStream excelFIS;
            BufferedOutputStream excelBOS;
            try {
                excelFIS = new FileOutputStream(excelExportChooser.getSelectedFile() + ".xlsx");
                excelBOS = new BufferedOutputStream(excelFIS);
                excelXSSFWorkBookExporter.write(excelBOS);
                excelBOS.close();
                excelXSSFWorkBookExporter.close();
            } catch (IOException iOException) {
            }
        }


    }//GEN-LAST:event_exportExcelButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed

        try {
            boolean printPatientTable = patientDataTable.print();
            
            if (!printPatientTable) {  
            } else {
                JOptionPane.showMessageDialog(null, "Printed successfully.");
            }
            
            
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_printButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException
                | InstantiationException
                | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            System.out.println(e);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new HMS_PATIENT_MANAGEMENTSYSTEM().setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(HMS_PATIENT_MANAGEMENTSYSTEM.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JComboBox<String> bloodTypeCB;
    private javax.swing.JLabel bloodTypeLabel;
    private javax.swing.JButton browseImageButton;
    private javax.swing.JLabel cellphoneNumberLabel;
    private javax.swing.JComboBox<String> civilStatusCB;
    private javax.swing.JLabel civilStatusLabel;
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel dateOfBirthLabel;
    private com.github.lgooddatepicker.components.DatePicker dateOfBirthPicker;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton exportExcelButton;
    private javax.swing.JCheckBox femaleCbButton;
    private javax.swing.JButton firstItemInListButton;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField firstNameTf;
    private javax.swing.ButtonGroup genderGroup;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel imageNameLabel;
    private javax.swing.JTextField imageNameTf;
    private javax.swing.JLabel imagePathLabel;
    private javax.swing.JTextField imagePathTf;
    private javax.swing.JButton importExcelButton;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelImage;
    private javax.swing.JButton lastItemInListButton;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField lastNameTf;
    private javax.swing.JCheckBox maleCbButton;
    private javax.swing.JLabel middleNameLabel;
    private javax.swing.JTextField middleNameTf;
    private javax.swing.JLabel nationalityLabel;
    private javax.swing.JTextField nationalityTf;
    private javax.swing.JButton nextItemInListButton;
    private javax.swing.JTable patientDataTable;
    private javax.swing.JPanel patientFullMainPanel;
    private javax.swing.JLabel patientIDLabel;
    private javax.swing.JTextField patientIdTf;
    private javax.swing.JTextField phoneNumberTf;
    private javax.swing.JButton previousItemInListButton;
    private javax.swing.JButton printButton;
    private javax.swing.JComboBox<String> religionCB;
    private javax.swing.JLabel religionLabel;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
