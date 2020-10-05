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

import java.awt.print.PrinterException;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author khian
 */
public class ListSelectedJTableRowsJFrame extends javax.swing.JFrame {

    DefaultTableModel listSelectedJTableRowsJFrameModel;

    /**
     * Creates new form ListSelectedJTableRowsJFrame
     */
    public ListSelectedJTableRowsJFrame() {
        initComponents();
        listSelectedJTableRowsJFrameModel = listSelectedJTableRowsJFrameModel = (DefaultTableModel) selectedRowTable.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        selectedRowTable = new javax.swing.JTable();
        importToExcelButton = new javax.swing.JButton();
        deleteRowButton = new javax.swing.JButton();
        printButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1500, 720));
        setMinimumSize(new java.awt.Dimension(1500, 720));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setMaximumSize(new java.awt.Dimension(1500, 720));
        mainPanel.setMinimumSize(new java.awt.Dimension(1500, 720));

        selectedRowTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(selectedRowTable);
        if (selectedRowTable.getColumnModel().getColumnCount() > 0) {
            selectedRowTable.getColumnModel().getColumn(0).setMinWidth(35);
            selectedRowTable.getColumnModel().getColumn(0).setMaxWidth(45);
        }

        importToExcelButton.setBackground(new java.awt.Color(228, 228, 255));
        importToExcelButton.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        importToExcelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/healthMonitoringSystem/APP_IMAGES/mainprogram/excel.png"))); // NOI18N
        importToExcelButton.setText("Export (Excel)");
        importToExcelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importToExcelButtonActionPerformed(evt);
            }
        });

        deleteRowButton.setBackground(new java.awt.Color(228, 228, 255));
        deleteRowButton.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        deleteRowButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/healthMonitoringSystem/APP_IMAGES/mainprogram/deleteIcon.png"))); // NOI18N
        deleteRowButton.setText("Remove Rows");
        deleteRowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRowButtonActionPerformed(evt);
            }
        });

        printButton.setBackground(new java.awt.Color(228, 228, 255));
        printButton.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        printButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/healthMonitoringSystem/APP_IMAGES/mainprogram/printerIcon.png"))); // NOI18N
        printButton.setText("Print");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1500, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(importToExcelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteRowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(importToExcelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteRowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void importToExcelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importToExcelButtonActionPerformed
        if (selectedRowTable.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Please add atleast one row.");
        } else {
            exportToExcel(listSelectedJTableRowsJFrameModel, "Selected Patients");
        }
    }//GEN-LAST:event_importToExcelButtonActionPerformed

    private void deleteRowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRowButtonActionPerformed
        int tableRowCount = selectedRowTable.getRowCount();

        int tableRowCountToRemove = selectedRowTable.getRowCount();
        if (tableRowCountToRemove == 0) {
            JOptionPane.showMessageDialog(null, "No rows to remove.");
        } else {
        // Remove rows from the bottom of the jtable to the top
        for (int row = tableRowCount - 1; row >= 0; row--) {
            listSelectedJTableRowsJFrameModel.removeRow(row);
        }
        }
    }//GEN-LAST:event_deleteRowButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        try {
            boolean printSelectedRow = selectedRowTable.print();
            
            if (!printSelectedRow) {
                JOptionPane.showMessageDialog(null, "Print cancelled or unable to print..");
            } else {
                JOptionPane.showMessageDialog(null, "Printed successfully..");
            }
        } catch (PrinterException ex) {
            Logger.getLogger(ListSelectedJTableRowsJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_printButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ListSelectedJTableRowsJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListSelectedJTableRowsJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListSelectedJTableRowsJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListSelectedJTableRowsJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListSelectedJTableRowsJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteRowButton;
    private javax.swing.JButton importToExcelButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton printButton;
    public javax.swing.JTable selectedRowTable;
    // End of variables declaration//GEN-END:variables

    private void exportToExcel(DefaultTableModel model, String sheetName) {
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
            XSSFSheet excelSheet = excelXSSFWorkBookExporter.createSheet(sheetName);
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
            JOptionPane.showMessageDialog(null, "Exported data successfully.");
        }
    }
}
