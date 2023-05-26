/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.Color;
import java.text.DecimalFormat;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import javax.swing.*;
import java.lang.*;
/**/

import javax.sound.sampled.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.jar.*;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Admin
 */
public class Home extends JFrame {

    public static void colorTableBlue(JTable table) {
        // Set the cell renderer to customize the appearance
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setBackground(new Color(65, 91, 65));
        cellRenderer.setForeground(new Color(213, 221, 205));
        table.setDefaultRenderer(Object.class, cellRenderer);

        // Update the table model to trigger the cell renderer
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.fireTableDataChanged();
    }

    public static void colorTableModelBlue(DefaultTableModel tableModel) {
        // Create a temporary table to apply the cell renderer
        JTable table = new JTable(tableModel);
        colorTableBlue(table);
    }
    private static boolean notInstalled=false;
    private static DefaultTableModel tableModel;
    private static String GPUNAME;
    private static String SCORE="-";
    private static String SCORE_3D="-", SCORE_CUDA="0", SCORE_TOTAL="-";
    private static String SCORE_3D_DIV="-", SCORE_CUDA_DIV="0", SCORE_TOTAL_DIV="-";
    private static boolean FLAG_CUDA = false, FLAG_3D = false;
    private static String finalPath;

    public static void appendToLog(String string1, String string2, String string3, String string4) {
        String filePath = finalPath +"\\log.txt";
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(string1 +",");
            writer.write(string2 + ",");
            writer.write(string3 + ",");
            writer.write(string4 + ",");
            writer.write(formattedDateTime + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Graphics Card", "3D Rendering score", "CUDA score", "Total score"});

        // Create a JTable using the DefaultTableModel
        jTable4 = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(jTable4);

        String filePatsh = finalPath+ "\\log.txt";
        parseFile(filePatsh);
        jTable4.setModel(tableModel);
        // Set the preferred size of the scroll pane






    }


    public static void parseFile(String filePath) {
        tableModel.setRowCount(0); // Clear the table before populating it again

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String graphicsCard = parts[0].trim();
                    int clockSpeed = Integer.parseInt(parts[1].trim());
                    int powerConsumption = parts[2].trim().equals("1") ? 1 : Integer.parseInt(parts[2].trim());
                    int temperature = Integer.parseInt(parts[3].trim());
                    String timestamp = parts[4].trim();

                    // Add the parsed data to the table model
                    tableModel.addRow(new Object[]{graphicsCard, clockSpeed, powerConsumption, temperature});
                } else {
                    System.out.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        setColor(btn_1);
        ind_1.setOpaque(true);
        resetColor(new JPanel[]{btn_2,btn_3,btn_4}, new JPanel[]{ind_2,ind_3, ind_4});
        jProgressBar1.setValue(50);
    }

    public void checkFlags(){
        if(FLAG_CUDA && FLAG_3D){

            System.out.println("Flags correct!");
            if(SCORE_CUDA=="1")SCORE_TOTAL=SCORE_3D;
            else
                SCORE_TOTAL = Integer.toString((Integer.parseInt(SCORE_3D) + Integer.parseInt(SCORE_CUDA))/2);
            SCORE_TOTAL_DIV = SCORE_TOTAL + "/1000";
            jLabel18.setText(SCORE_TOTAL);
            jLabel18.setVisible(true);
            jLabel20.setVisible(true);
            appendToLog(GPUNAME,SCORE_3D,SCORE_CUDA,SCORE_TOTAL);

        }
        System.out.println("Flags Checked!");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        side_pane = new JPanel();
        btn_1 = new JPanel();
        ind_1 = new JPanel();
        jLabel8 = new JLabel();
        btn_2 = new JPanel();
        ind_2 = new JPanel();
        btn_3 = new JPanel();
        ind_3 = new JPanel();
        btn_4 = new JPanel();
        ind_4 = new JPanel();
        btn_exit = new JLabel();
        jLabel16 = new JLabel();
        jPanel3 = new JPanel();
        jPanel4 = new JPanel();
        jLabel14 = new JLabel();
        jPanel5 = new JPanel();
        jProgressBar1 = new JProgressBar();
        jLabel13 = new JLabel();
        jLabel20 = new JLabel();
        jLabel18 = new JLabel();
        jLabel12 = new JLabel();
        jLabel2 = new JLabel();
        jPanel2 = new JPanel();
        jLabel21 = new JLabel();
        jLabel6 = new JLabel();
        jLabel19 = new JLabel();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jScrollPane2 = new JScrollPane();
        jTable2 = new JTable();
        jScrollPane3 = new JScrollPane();
        jTable3 = new JTable();
        jPanel1 = new JPanel();
        jScrollPane4 = new JScrollPane();
        jTable4 = new JTable();
        jPanel6 = new JPanel();
        canvas1 = new Canvas();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(255, 255, 255));
        setLocationByPlatform(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        side_pane.setBackground(new Color(46, 59, 41));
        side_pane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_1.setBackground(new Color(46, 59, 41));
        btn_1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                btn_1MousePressed(evt);
            }
        });

        ind_1.setOpaque(false);
        ind_1.setPreferredSize(new Dimension(3, 43));

        GroupLayout ind_1Layout = new GroupLayout(ind_1);
        ind_1.setLayout(ind_1Layout);
        ind_1Layout.setHorizontalGroup(
                ind_1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_1Layout.setVerticalGroup(
                ind_1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel8.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setForeground(new Color(255, 255, 255));
        jLabel8.setText("Home");

        GroupLayout btn_1Layout = new GroupLayout(btn_1);
        btn_1.setLayout(btn_1Layout);
        btn_1Layout.setHorizontalGroup(
                btn_1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(btn_1Layout.createSequentialGroup()
                                .addComponent(ind_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addGap(28, 28, 28))
        );
        btn_1Layout.setVerticalGroup(
                btn_1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(btn_1Layout.createSequentialGroup()
                                .addGroup(btn_1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ind_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        side_pane.add(btn_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 120, -1));

        btn_2.setBackground(new Color(46, 59, 41));
        /*
        btn_2.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent evt) {
                btn_2MouseReleased(evt);
            }
        });

         */

        ind_2.setOpaque(false);
        ind_2.setPreferredSize(new Dimension(3, 43));

        GroupLayout ind_2Layout = new GroupLayout(ind_2);
        ind_2.setLayout(ind_2Layout);
        ind_2Layout.setHorizontalGroup(
                ind_2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_2Layout.setVerticalGroup(
                ind_2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 43, Short.MAX_VALUE)
        );

        GroupLayout btn_2Layout = new GroupLayout(btn_2);
        btn_2.setLayout(btn_2Layout);
        btn_2Layout.setHorizontalGroup(
                btn_2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(btn_2Layout.createSequentialGroup()
                                .addComponent(ind_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 117, Short.MAX_VALUE))
        );
        btn_2Layout.setVerticalGroup(
                btn_2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(btn_2Layout.createSequentialGroup()
                                .addComponent(ind_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        btn_2.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                btn_2MousePressed(evt);
            }
        });

        //side_pane.add(btn_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 120, -1));

        btn_3.setBackground(new Color(46, 59, 41));
        btn_3.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                btn_3MousePressed(evt);
            }
        });

        ind_3.setOpaque(false);
        ind_3.setPreferredSize(new Dimension(3, 43));

        GroupLayout ind_3Layout = new GroupLayout(ind_3);
        ind_3.setLayout(ind_3Layout);
        ind_3Layout.setHorizontalGroup(
                ind_3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_3Layout.setVerticalGroup(
                ind_3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 43, Short.MAX_VALUE)
        );

        GroupLayout btn_3Layout = new GroupLayout(btn_3);
        btn_3.setLayout(btn_3Layout);
        btn_3Layout.setHorizontalGroup(
                btn_3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(btn_3Layout.createSequentialGroup()
                                .addComponent(ind_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(117, Short.MAX_VALUE))
        );
        btn_3Layout.setVerticalGroup(
                btn_3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(btn_3Layout.createSequentialGroup()
                                .addComponent(ind_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        side_pane.add(btn_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 120, -1));

        btn_4.setBackground(new Color(46, 59, 41));
        btn_4.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                btn_4MousePressed(evt);
            }
        });

        ind_4.setOpaque(false);
        ind_4.setPreferredSize(new Dimension(3, 43));

        GroupLayout ind_4Layout = new GroupLayout(ind_4);
        ind_4.setLayout(ind_4Layout);
        ind_4Layout.setHorizontalGroup(
                ind_4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_4Layout.setVerticalGroup(
                ind_4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 43, Short.MAX_VALUE)
        );

        GroupLayout btn_4Layout = new GroupLayout(btn_4);
        btn_4.setLayout(btn_4Layout);
        btn_4Layout.setHorizontalGroup(
                btn_4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(btn_4Layout.createSequentialGroup()
                                .addComponent(ind_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 117, Short.MAX_VALUE))
        );
        btn_4Layout.setVerticalGroup(
                btn_4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(btn_4Layout.createSequentialGroup()
                                .addComponent(ind_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        side_pane.add(btn_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 120, -1));

        btn_exit.setIcon(new ImageIcon(getClass().getResource("/swing/images/icons8_Exit_25px.png"))); // NOI18N
        btn_exit.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                btn_exitMousePressed(evt);
            }
        });
        side_pane.add(btn_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, 46));

        jLabel16.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        jLabel16.setForeground(new Color(255, 255, 255));

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDateTime = dateTime.format(formatter);
        jLabel16.setText(formattedDateTime);
        side_pane.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, 110, 30));

        getContentPane().add(side_pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 590));

        jPanel3.setBackground(new Color(116, 144, 89));

        jPanel4.setBackground(new Color(213, 221, 205));
        jPanel4.setForeground(new Color(213, 221, 205));
        jPanel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(MouseEvent evt) {
                jPanel4MouseDragged(evt);
            }
        });
        jPanel4.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                jPanel4MousePressed(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setIcon(new ImageIcon(getClass().getResource("/swing/images/previewpic.png")));
        jLabel14.setMaximumSize(new Dimension(100, 108));
        jLabel14.setMinimumSize(new Dimension(100, 108));
        jLabel14.setPreferredSize(new Dimension(192, 108));
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 450, 250));
        jLabel14.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jLabel14.setIcon(new ImageIcon(getClass().getResource("/swing/images/cat.gif")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLabel14.setIcon(new ImageIcon(getClass().getResource("/swing/images/previewpic.png")));
            }
        });

        jPanel5.setBackground(new Color(154, 171, 137));

        jProgressBar1.setBackground(new Color(154, 171, 137));
        jProgressBar1.setForeground(new Color(154, 171, 137));
        jProgressBar1.setPreferredSize(new Dimension(146, 10));
        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        jLabel13.setForeground(new Color(255, 255, 255));

        jLabel20.setPreferredSize(new Dimension(200, jLabel20.getPreferredSize().height));

        jLabel20.setFont(new Font("Segoe UI", 1, 16)); // NOI18N
        jLabel20.setForeground(new Color(255, 255, 255));
        jLabel20.setText("Total score:");
        jLabel20.setVisible(false);

        jLabel18.setFont(new Font("Segoe UI", 0, 36)); // NOI18N
        jLabel18.setForeground(new Color(255, 255, 255));
        jLabel18.setText("04");
        jLabel18.setVisible(false);
        //jLabel18.setHorizontalTextPosition(21);

        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(72, 72, 72)
                                                .addComponent(jProgressBar1, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel13)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(193, 193, 193)
                                                .addComponent(jLabel18))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(170, 170, 170)
                                                .addComponent(jLabel20, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(713, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel20, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18)
                                .addGap(109, 109, 109)
                                .addComponent(jLabel13)
                                .addGap(73, 73, 73)
                                .addComponent(jProgressBar1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 990, 90));

        jLabel12.setFont(new Font("Segoe UI", 1, 20)); // NOI18N
        jLabel12.setForeground(new Color(46, 59, 41));
        jLabel12.setText(GPUNAME);
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 270, 60));

        jLabel2.setIcon(new ImageIcon(getClass().getResource("/swing/images/gpumainou.png"))); // NOI18N
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 120, 110));

        jPanel2.setBackground(new Color(116, 144, 89));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        jLabel21.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        jLabel21.setForeground(new Color(46, 59, 41));
        jLabel21.setText("RUNTIME TERROR");
        jLabel20.setVisible(false);
        jLabel21.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(MouseEvent evt) {
                jLabel21MouseDragged(evt);
            }
        });

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabel21, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel21, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 340, 40));

        jLabel6.setFont(new Font("Segoe UI", 0, 36)); // NOI18N
        jLabel6.setForeground(new Color(213, 221, 205));
        jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel6.setText("-");

        jLabel19.setFont(new Font("Segoe UI", 0, 36)); // NOI18N
        jLabel19.setForeground(new Color(213, 221, 205));
        jLabel19.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel19.setText("-");

        jButton2.setBackground(new Color(213, 221, 205));
        jButton2.setForeground(new Color(46, 59, 41));
        //jButton2.setContentAreaFilled(false);
        jButton2.setText("3D Rendering");
        jButton2.setFont(new Font("Segoe UI", 1, 16));
        jButton2.setToolTipText("");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton2.setMinimumSize(new Dimension(76, 21));
        jButton2.setName(""); // NOI18N
        jButton2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new Color(213, 221, 205));
        jButton3.setForeground(new Color(46, 59, 41));
        jButton3.setText("CUDA Access Test");
        jButton3.setFont(new Font("Segoe UI", 1, 16));
        jButton3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //jButton3.setContentAreaFilled(false);
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable2.setModel(new DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane2.setViewportView(jTable2);

        jTable3.setModel(new DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane3.setViewportView(jTable3);

        jTable4.setBackground(new Color(154, 171, 137));
        jTable4.setBorder(BorderFactory.createLineBorder(new Color(154, 171, 137)));
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Graphics Card", "3D Rendering score", "CUDA score", "Total score"});

        // Create a JTable using the DefaultTableModel
        jTable4 = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(jTable4);

        String filePatsh = finalPath +"\\log.txt";
        parseFile(filePatsh);
        colorTableModelBlue(tableModel);
        jTable4.setModel(tableModel);
        colorTableBlue(jTable4);
        jTable4.setSelectionBackground(new Color(154, 171, 137));
        jTable4.setShowGrid(true);
        jScrollPane4.setViewportView(jTable4);
        if (jTable4.getColumnModel().getColumnCount() > 0) {
            jTable4.getColumnModel().getColumn(0).setHeaderValue("Graphics Card");
            jTable4.getColumnModel().getColumn(1).setHeaderValue("3D Rendering Score");
            jTable4.getColumnModel().getColumn(2).setHeaderValue("CUDA Score");
            jTable4.getColumnModel().getColumn(3).setHeaderValue("Total Score");
        }

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, 555, GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, 1026, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                                                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(141, 141, 141))
                                                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                                                .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(140, 140, 140))))
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                                .addComponent(jLabel19, GroupLayout.PREFERRED_SIZE, 432, GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                        .addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(38, 38, 38)))
                                .addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(143, 143, 143)
                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(132, 132, 132))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGap(25, 25, 25)
                                                                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabel19)
                                                                .addGap(33, 33, 33)
                                                                .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabel6)
                                                                .addGap(0, 0, Short.MAX_VALUE))))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addGap(0, 157, Short.MAX_VALUE)
                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane3, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 990, 590));

        jPanel6.setBackground(new Color(255, 255, 255));

        GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(462, 462, 462)
                                .addComponent(canvas1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(canvas1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(887, 887, 887))
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 50, 450, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_1MousePressed(MouseEvent evt) {//GEN-FIRST:event_btn_1MousePressed
        // TODO add your handling code here:
        setColor(btn_1);
        ind_1.setOpaque(true);
        resetColor(new JPanel[]{btn_2,btn_3,btn_4}, new JPanel[]{ind_2,ind_3, ind_4});
    }//GEN-LAST:event_btn_1MousePressed

    private void btn_2MousePressed(MouseEvent evt) {//GEN-FIRST:event_btn_1MousePressed
        // TODO add your handling code here:
        setColor(btn_2);
        ind_2.setOpaque(true);
        resetColor(new JPanel[]{btn_2,btn_3,btn_4}, new JPanel[]{ind_2,ind_3, ind_4});
    }//GEN-LAST:event_btn_1MousePressed


    private void btn_3MousePressed(MouseEvent evt) {//GEN-FIRST:event_btn_3MousePressed
        // TODO add your handling code here:
        setColor(btn_3);
        ind_3.setOpaque(true);
        resetColor(new JPanel[]{btn_2,btn_3,btn_4}, new JPanel[]{ind_2,ind_3, ind_4});
    }//GEN-LAST:event_btn_3MousePressed

    private void btn_4MousePressed(MouseEvent evt) {//GEN-FIRST:event_btn_4MousePressed
        // TODO add your handling code here:
        setColor(btn_4);
        ind_4.setOpaque(true);
        resetColor(new JPanel[]{btn_2,btn_3,btn_1}, new JPanel[]{ind_2,ind_3, ind_1});
    }//GEN-LAST:event_btn_4MousePressed

    private void btn_2MouseReleased(MouseEvent evt) {//GEN-FIRST:event_btn_2MouseReleased
        // TODO add your handling code here:
        setColor(btn_2);
        ind_2.setOpaque(true);
        resetColor(new JPanel[]{btn_1,btn_3,btn_4}, new JPanel[]{ind_1,ind_3, ind_4});
    }//GEN-LAST:event_btn_2MouseReleased

    private void btn_3MouseReleased(MouseEvent evt) {//GEN-FIRST:event_btn_2MouseReleased
        // TODO add your handling code here:
        setColor(btn_3);
        ind_3.setOpaque(true);
        resetColor(new JPanel[]{btn_1,btn_3,btn_4}, new JPanel[]{ind_1,ind_3, ind_4});
    }//GEN-LAST:event_btn_2MouseReleased


    int xx,xy;
    private void btn_exitMousePressed(MouseEvent evt) {//GEN-FIRST:event_btn_exitMousePressed
        // TODO add your handling code here:

        System.exit(0);
    }//GEN-LAST:event_btn_exitMousePressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        try {

            String currentDirectory = System.getProperty("user.dir");

            // Build the command to execute the jar file
            String jarCommand = "java -jar " + finalPath + "\\swing\\cuda.jar";

            System.out.println("The current direcoty you are in is: "+currentDirectory);

            // Start the process to execute the jar file
            Process process = Runtime.getRuntime().exec(jarCommand);

            // Wait for the process to complete
            int exitCode = process.waitFor();

            // Print the exit code of the process
            System.out.println("Process exited with code " + exitCode);
            // Get the current working directory

            String filePath = "./output.txt";
            //==================

            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            SCORE_CUDA=scanner.next();
            if(SCORE_CUDA==null)SCORE_CUDA="1";
            double score = Double.parseDouble(SCORE_CUDA);

            // the actual values that can be obtained when running the test
            double maxValue = 40000;
            double minValue = 0;

            // the upper and lower bounds which we have chosen for the score
            double minScore = 0;
            double maxScore = 1000;
            double finalScore = ((score - minValue) / (maxValue - minValue)) * (maxScore - minScore) + minScore;
            DecimalFormat decimalFormat = new DecimalFormat("#");
            SCORE_CUDA = decimalFormat.format(finalScore);
            SCORE_CUDA_DIV = SCORE_CUDA + "/1000";




            // Print the exit code of the process
            System.out.println("Process exited with code " + exitCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        jLabel6.setText(SCORE_CUDA);

        FLAG_CUDA = true;
        checkFlags();

        // jButton3.setVisible(false);
        try {
            // Delay for 100 milliseconds (1 second)
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {


            String path = System.getProperty("user.dir");
            String command =finalPath+ "\\swing\\lol\\LandscapePro.exe";
            Process process = Runtime.getRuntime().exec(command);
            System.out.println("The current direcoty you are in is: "+path);

            // Wait for the process to finish
            this.setVisible(false);
            process.waitFor();
            this.setVisible(true);
            System.out.println("read from file and calculate score ");
            File file = new File(finalPath+"\\swing\\lol\\LandscapePro\\FPS.txt");
            Scanner scanner = new Scanner(file);
            String line = "";
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
            }
            SCORE_3D=line.replace("Total number of Frames:", "");

            double score = Double.parseDouble(SCORE_3D);

            // the actual values that can be obtained when running the test
            double maxValue = 40000;
            double minValue = 0;

            // the upper and lower bounds which we have chosen for the score
            double minScore = 0;
            double maxScore = 1000;

            double finalScore = (((score - minValue) / (maxValue - minValue)) * (maxScore - minScore) + minScore);
            DecimalFormat decimalFormat = new DecimalFormat("#");
            SCORE_3D = decimalFormat.format(finalScore);
            SCORE_3D_DIV = SCORE_3D + "/1000";
            FLAG_3D = true;
            checkFlags();



            jLabel19.setText(SCORE_3D);



        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseClicked(MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked

        //jButton2.setContentAreaFilled(false);
        jButton2.setVisible(true);

        //jLabel19.setText("Running");



    }//GEN-LAST:event_jButton2MouseClicked

    private void jLabel21MouseDragged(MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseDragged
        jLabel21.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(MouseEvent evt) {
                jLabel21MouseDragged(evt);
            }
        });
    }//GEN-LAST:event_jLabel21MouseDragged

    private void jPanel2MouseDragged(MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        // TODO add your handling code here:

        //source to drag
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xx,y-xy);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        // TODO add your handling code here:
        //drag this pane
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel4MouseDragged(MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xx,y-xy);
    }//GEN-LAST:event_jPanel4MouseDragged

    private void jPanel4MousePressed(MouseEvent evt) {//GEN-FIRST:event_jPanel4MousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel4MousePressed
    private static File createTempDirectory() throws IOException {
        File tempDir = File.createTempFile("temp", Long.toString(System.nanoTime()));
        if (!tempDir.delete()) {
            throw new IOException("Failed to delete temp file: " + tempDir.getAbsolutePath());
        }
        if (!tempDir.mkdir()) {
            throw new IOException("Failed to create temp directory: " + tempDir.getAbsolutePath());
        }
        return tempDir;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        //appendToLog("gtx","100","1023","500");

        LoadingScreen loading = new LoadingScreen();

        loading.setVisible(true);
        //loading.setUndecorated(true);









        // Get the path to the JAR file
        String jarPath = JarExtractor.class.getProtectionDomain()
                .getCodeSource().getLocation().getPath();
        Installing lol = new Installing();
        Installing2 lol2 = new Installing2();
        try {
            File tempDir = new File(jarPath).getParentFile();
            tempDir = new File(tempDir.getAbsolutePath(), "lib");
            tempDir.mkdirs();

            // Create a temporary directory to extract the contents

            System.out.println(jarPath);

            // Open the JAR file
            JarFile jar;
            jar = new JarFile(jarPath);

            // Get the entries in the JAR file as an enumeration
            Enumeration<JarEntry> entries = jar.entries();

            // Iterate over the entries in the JAR file using a traditional for loop
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                if (!entry.isDirectory()) {
                    // Create a file for the current entry in the temporary directory
                    File currentFile = new File(tempDir, entry.getName());

                    // Check if the file already exists
                    if (!currentFile.exists()){
                        notInstalled=true;

                        // Create parent directories if they don't exist
                        if (!currentFile.getParentFile().exists()) {
                            currentFile.getParentFile().mkdirs();
                        }

                        // Extract the current entry from the JAR to the temporary directory
                        try (InputStream is = jar.getInputStream(entry);
                             FileOutputStream fos = new FileOutputStream(currentFile)) {
                            byte[] buffer = new byte[1024];
                            int bytesRead;
                            while ((bytesRead = is.read(buffer)) != -1) {
                                fos.write(buffer, 0, bytesRead);
                            }
                        }
                    }



                }

                if(notInstalled==true){

                    loading.setVisible(false);
                    lol.setVisible(true);
                }
            }

            jar.close();
            finalPath = tempDir.getAbsolutePath();
            System.out.println("Contents of JAR file extracted to: " + tempDir.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
        if(notInstalled==true){
            lol.setVisible(false);
            lol2.setVisible(true);
            try {
                // Pause the program for 3 seconds (3000 milliseconds)
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.exit(0);

        }


        try {

            String filePath = "./foo.txt";
            // Use "dxdiag /t" variant to redirect output to a given file
            ProcessBuilder pb = new ProcessBuilder("cmd.exe","/c","dxdiag","/t",filePath);
            System.out.println("-- Executing dxdiag command --");
            Process p = pb.start();
            p.waitFor();

            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            System.out.println(String.format("-- Printing %1$1s info --",filePath));
            while((line = br.readLine()) != null){
                if(line.trim().startsWith("Card name:")){



                    GPUNAME=line.trim();
                    GPUNAME=GPUNAME.replace("Card name:",  " ");
                    System.out.println(GPUNAME);
                    //
                    break;
                }
            }
        }
        catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
        loading.setVisible(false);
        //GPUNAME="This is a temporary GPUNAME";
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });

    }


    private void setColor(JPanel pane)
    {
        pane.setBackground(new Color(65, 91, 65));
    }

    private void resetColor(JPanel [] pane, JPanel [] indicators)
    {
        for(int i=0;i<pane.length;i++){
            pane[i].setBackground(new Color(46, 59, 41));

        } for(int i=0;i<indicators.length;i++){
        indicators[i].setOpaque(false);
    }

    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JPanel btn_1;
    private JPanel btn_2;
    private JPanel btn_3;
    private JPanel btn_4;
    private JLabel btn_exit;
    private Canvas canvas1;
    private JPanel ind_1;
    private JPanel ind_2;
    private JPanel ind_3;
    private JPanel ind_4;
    private JButton jButton2;
    private JButton jButton3;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel16;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel2;
    private JLabel jLabel20;
    private JLabel jLabel21;
    private JLabel jLabel6;
    private JLabel jLabel8;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JProgressBar jProgressBar1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JTable jTable2;
    private JTable jTable3;
    private static JTable jTable4;
    private JPanel side_pane;
    // End of variables declaration//GEN-END:variables
}
