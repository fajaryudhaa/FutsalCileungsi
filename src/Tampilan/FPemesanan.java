/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tampilan;

import Koneksi.KoneksiDB;
import Logic.pemesanan;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author PC-USER
 */
public class FPemesanan extends javax.swing.JInternalFrame {
private DefaultTableModel tabmode;
private ResultSet RsBook;
private String trans;
    /**
     * Creates new form FPemesanan
     */
    public FPemesanan() {
        initComponents();
        isiGrid();
        isiBrid();
        isiTrid();
        book();
    }
    
    private void book()
       {
        try {
            String sql="select * from booking order by nbooking desc";
            RsBook = KoneksiDB.getRS(sql); 
            if (RsBook.next()) {
                String book = RsBook.getString("nbooking").substring(3);
                String AN = "" + (Integer.parseInt(book) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}

               TBook.setText("PS-" + Nol + AN);
            } else {
               TBook.setText("PS-0001");
            }

           }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
           }
       }
    
    void emptyText(){
        TNamaTeam.setText("");
        TNsewa.setText("");
        TSewa.setText("");
        bg.clearSelection();
        THarga.setText("");
        TTgl.setDate(null);
        TDP.setSelectedItem("--Pilih--");
    }
    
    private void isiGrid() {
        delGrid(TTable);
        DefaultTableModel defGrid = (DefaultTableModel) TTable.getModel();
        RsBook = KoneksiDB.getRS("select * from lapangan");
        try {
            while (RsBook.next()) {
                String[] data = {RsBook.getString("nama"),RsBook.getString("harga")};
                defGrid.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FPemesanan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void delGrid(JTable gg) {
        DefaultTableModel defGrid = (DefaultTableModel) gg.getModel();
        int brs = gg.getRowCount();
        for(int i=0;i<brs;i++) {
            defGrid.removeRow(0);
        }
    }
    
    private void isiBrid() {
        delBrid(TTable2);
        DefaultTableModel defGrid = (DefaultTableModel) TTable2.getModel();
        RsBook = KoneksiDB.getRS("select * from team");
        try {
            while (RsBook.next()) {
                String[] data = {RsBook.getString("nama"),RsBook.getString("status")};
                defGrid.addRow(data);   
            }
        } catch (SQLException ex) {
            Logger.getLogger(FPemesanan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void delBrid(JTable gg) {
        DefaultTableModel defGrid = (DefaultTableModel) gg.getModel();
        int brs = gg.getRowCount();
        for(int i=0;i<brs;i++) {
            defGrid.removeRow(0);
        }
    }
    
    private void isiTrid() {
        delTrid(TTable1);
        DefaultTableModel defGrid = (DefaultTableModel) TTable1.getModel();
        RsBook = KoneksiDB.getRS("select * from booking");
        try {
            while (RsBook.next()) {
                String[] data = {RsBook.getString("nbooking"),RsBook.getString("tgl"),
                                 RsBook.getString("namateam"),RsBook.getString("namasewa"),
                                 RsBook.getString("namalpg"), RsBook.getString("harga"),
                                 RsBook.getString("dp"),RsBook.getString("jammsk"),
                                 RsBook.getString("jamkluar"),RsBook.getString("status")};
                defGrid.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FPemesanan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void delTrid(JTable gg) {
        DefaultTableModel defGrid = (DefaultTableModel) gg.getModel();
        int brs = gg.getRowCount();
        for(int i=0;i<brs;i++) {
            defGrid.removeRow(0);
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

        jSeparator4 = new javax.swing.JSeparator();
        bg = new javax.swing.ButtonGroup();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        TBook = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        TJklr = new javax.swing.JSpinner();
        TJmsk = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        rmember = new javax.swing.JRadioButton();
        rnonmmber = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        TNamaTeam = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TNsewa = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TTgl = new com.toedter.calendar.JDateChooser();
        TSewa = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        THarga = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TDP = new javax.swing.JComboBox();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        TTable = new javax.swing.JTable();
        txtcari = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TTable1 = new javax.swing.JTable();
        txtcari1 = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        BSimpan = new rojerusan.RSButtonHover();
        BUbah = new rojerusan.RSButtonHover();
        Bhapus = new rojerusan.RSButtonHover();
        BBatal = new rojerusan.RSButtonHover();
        Bcetak = new rojerusan.RSButtonHover();

        jSeparator4.setForeground(new java.awt.Color(204, 51, 0));

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(204, 0, 0));
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("No Booking");

        TBook.setEditable(false);
        TBook.setBackground(new java.awt.Color(255, 255, 255));
        TBook.setForeground(new java.awt.Color(204, 0, 0));
        TBook.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        TBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TBookActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(204, 0, 0));
        jLabel11.setForeground(new java.awt.Color(204, 0, 0));
        jLabel11.setText("Jam Masuk");

        jLabel12.setBackground(new java.awt.Color(204, 0, 0));
        jLabel12.setForeground(new java.awt.Color(204, 0, 0));
        jLabel12.setText("Jam Keluar");

        TJklr.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.HOUR_OF_DAY));
        TJklr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        TJklr.setEditor(new javax.swing.JSpinner.DateEditor(TJklr, "HH:mm:ss"));

        TJmsk.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.HOUR_OF_DAY));
        TJmsk.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        TJmsk.setEditor(new javax.swing.JSpinner.DateEditor(TJmsk, "HH:mm:ss"));

        jPanel2.setBackground(new java.awt.Color(204, 0, 0));
        jPanel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Add Ticket_40px.png"))); // NOI18N
        jLabel1.setText("Data Pemesanan");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(21, 21, 21))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        rmember.setBackground(new java.awt.Color(255, 255, 255));
        bg.add(rmember);
        rmember.setForeground(new java.awt.Color(204, 0, 0));
        rmember.setText("Member");
        rmember.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rmemberMouseClicked(evt);
            }
        });

        rnonmmber.setBackground(new java.awt.Color(255, 255, 255));
        bg.add(rnonmmber);
        rnonmmber.setForeground(new java.awt.Color(204, 0, 0));
        rnonmmber.setText("Non Member");

        jLabel5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel5.setText("Nama Team");

        TNamaTeam.setEditable(false);
        TNamaTeam.setBackground(new java.awt.Color(255, 255, 255));
        TNamaTeam.setForeground(new java.awt.Color(204, 0, 0));
        TNamaTeam.setBorder(null);
        TNamaTeam.setCaretColor(new java.awt.Color(204, 0, 0));

        jLabel6.setForeground(new java.awt.Color(204, 0, 0));
        jLabel6.setText("Nama Penyewa");

        TNsewa.setForeground(new java.awt.Color(204, 0, 0));
        TNsewa.setBorder(null);
        TNsewa.setCaretColor(new java.awt.Color(204, 0, 0));

        jLabel8.setForeground(new java.awt.Color(204, 0, 0));
        jLabel8.setText("Tgl. Booking");

        TTgl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        TTgl.setForeground(new java.awt.Color(204, 0, 0));

        TSewa.setEditable(false);
        TSewa.setBackground(new java.awt.Color(255, 255, 255));
        TSewa.setForeground(new java.awt.Color(204, 0, 0));
        TSewa.setBorder(null);
        TSewa.setCaretColor(new java.awt.Color(204, 0, 0));

        jLabel13.setForeground(new java.awt.Color(204, 0, 0));
        jLabel13.setText("Sewa Lapangan");

        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setText("Harga Sewa");

        THarga.setEditable(false);
        THarga.setBackground(new java.awt.Color(255, 255, 255));
        THarga.setForeground(new java.awt.Color(204, 0, 0));
        THarga.setBorder(null);
        THarga.setCaretColor(new java.awt.Color(204, 0, 0));

        jLabel7.setForeground(new java.awt.Color(204, 0, 0));
        jLabel7.setText("DP");

        TDP.setForeground(new java.awt.Color(204, 0, 0));
        TDP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Pilih--", "50000", "70000" }));
        TDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TDPActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(204, 51, 0));

        jSeparator3.setForeground(new java.awt.Color(204, 51, 0));

        jSeparator5.setForeground(new java.awt.Color(204, 51, 0));

        jSeparator6.setForeground(new java.awt.Color(204, 51, 0));

        jSeparator7.setForeground(new java.awt.Color(204, 51, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(43, Short.MAX_VALUE)
                        .addComponent(rmember)
                        .addGap(40, 40, 40))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jLabel13)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator2)
                    .addComponent(TNsewa, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(TTgl, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(TNamaTeam, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(TSewa, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(rnonmmber)
                    .addComponent(THarga, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(TDP, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator6)
                    .addComponent(jSeparator7))
                .addGap(35, 35, 35))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rmember)
                    .addComponent(rnonmmber))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TNamaTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(1, 1, 1)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(TNsewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TTgl, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TSewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(2, 2, 2)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(THarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(0, 0, 0)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Team", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TTable2);

        TTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lapangan", "Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TTable);

        txtcari.setForeground(new java.awt.Color(204, 0, 0));
        txtcari.setBorder(null);
        txtcari.setCaretColor(new java.awt.Color(204, 0, 0));
        txtcari.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcariActionPerformed(evt);
            }
        });
        txtcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcariKeyPressed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(204, 51, 0));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Search_16px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        TTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Booking", "Tanggal", "Nama Team", "Nama Penyewa", "Sewa Lapangan", "Harga Sewa", "DP", "Jam Masuk", "Jam Keluar", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TTable1);

        txtcari1.setForeground(new java.awt.Color(204, 0, 0));
        txtcari1.setBorder(null);
        txtcari1.setCaretColor(new java.awt.Color(204, 0, 0));
        txtcari1.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtcari1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcari1ActionPerformed(evt);
            }
        });
        txtcari1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcari1KeyPressed(evt);
            }
        });

        jSeparator8.setForeground(new java.awt.Color(204, 51, 0));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Search_16px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 927, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtcari1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtcari1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        BSimpan.setBackground(new java.awt.Color(204, 0, 0));
        BSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Save_16px.png"))); // NOI18N
        BSimpan.setText("Simpan");
        BSimpan.setColorHover(new java.awt.Color(255, 51, 0));
        BSimpan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSimpanActionPerformed(evt);
            }
        });

        BUbah.setBackground(new java.awt.Color(204, 0, 0));
        BUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Renew Subscription_16px.png"))); // NOI18N
        BUbah.setText("Ubah");
        BUbah.setColorHover(new java.awt.Color(255, 51, 0));
        BUbah.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUbahActionPerformed(evt);
            }
        });

        Bhapus.setBackground(new java.awt.Color(204, 0, 0));
        Bhapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Delete_16px.png"))); // NOI18N
        Bhapus.setText("Hapus");
        Bhapus.setColorHover(new java.awt.Color(255, 51, 0));
        Bhapus.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BhapusActionPerformed(evt);
            }
        });

        BBatal.setBackground(new java.awt.Color(204, 0, 0));
        BBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Cancel_16px.png"))); // NOI18N
        BBatal.setText("Batal");
        BBatal.setColorHover(new java.awt.Color(255, 51, 0));
        BBatal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BBatalActionPerformed(evt);
            }
        });

        Bcetak.setBackground(new java.awt.Color(204, 0, 0));
        Bcetak.setText("Cetak");
        Bcetak.setColorHover(new java.awt.Color(255, 51, 0));
        Bcetak.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Bcetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BcetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TJmsk, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TJklr, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TBook, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(BUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(Bhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(BBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Bcetak, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(TBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(TJmsk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TJklr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(BUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bcetak, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        jScrollPane4.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1067, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TBookActionPerformed

    }//GEN-LAST:event_TBookActionPerformed

    private void rmemberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rmemberMouseClicked

    }//GEN-LAST:event_rmemberMouseClicked

    private void TTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TTable2MouseClicked
        int baris= TTable2.getSelectedRow();
        if (pemesanan.insertmember(TTable2.getValueAt
            (TTable2.getSelectedRow(),0).toString())==true) {
        TNamaTeam.setText(pemesanan.getNamatim());
        if("Member".equals(TTable2.getValueAt(baris,1).toString())){
            rmember.setSelected(true);
        }else{
            rnonmmber.setSelected(true);
        }
        }
    }//GEN-LAST:event_TTable2MouseClicked

    private void TTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TTableMouseClicked
        if (pemesanan.insertmemblap(TTable.getValueAt
            (TTable.getSelectedRow(),0).toString())==true) {
        TSewa.setText(pemesanan.getNama());
        THarga.setText(pemesanan.getHarga());
        }
    }//GEN-LAST:event_TTableMouseClicked

    private void TTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TTable1MouseClicked
    try {
        DefaultTableModel model = (DefaultTableModel) TTable1.getModel();
        int baris= TTable1.getSelectedRow();
        Date date = new SimpleDateFormat("dd MMMM yyyy").parse((String)model.getValueAt(baris, 1));
        String a = TTable1.getValueAt(baris, 6).toString();
        if (pemesanan.caribook(TTable1.getValueAt
                    (TTable1.getSelectedRow(),0).toString())==true) {
            TBook.setText(pemesanan.getNbook());
            TNamaTeam.setText(pemesanan.getNteam());
            TNsewa.setText(pemesanan.getNsewa());
            TTgl.setDate(date);
            TSewa.setText(pemesanan.getNama());
            THarga.setText(pemesanan.getHarga());
            TDP.setSelectedItem(a);
            TJmsk.toString();
            TJklr.toString();
            if("Member".equals(TTable1.getValueAt(baris,9).toString())){
                rmember.setSelected(true);
            }else{
                rnonmmber.setSelected(true);
            }
        }
    } catch (ParseException ex) {
        Logger.getLogger(FPemesanan.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_TTable1MouseClicked

    private void BSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSimpanActionPerformed
        String TStatus="";
        if  (rmember.isSelected())
        {   TStatus="Member";
        }
        else if (rnonmmber.isSelected())
        {   TStatus="Biasa";
        }
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        String tgl = dateFormat.format(TTgl.getDate());
        String waktu=sdf.format((Date)TJmsk.getValue());
        String waktut=sdf.format((Date)TJklr.getValue());
        String DP = TDP.getModel().getSelectedItem().toString();
        trans="tambah";
            String[] plg={TBook.getText(),tgl,TNamaTeam.getText(),TNsewa.getText(),TSewa.getText(),
            THarga.getText(),DP,waktu,waktut,TStatus};
              if (pemesanan.updatebook(trans,plg)>0){
                javax.swing.JOptionPane.showMessageDialog(this, "Data Pemesanan Telah Disimpan");
                emptyText();
                isiTrid();
                }
              else{javax.swing.JOptionPane.showMessageDialog(this,
                        "Terjadi kesalahan, Silahkan coba lagi", "Kesalahan",
                        javax.swing.JOptionPane.ERROR_MESSAGE);
    
     
    }
 book();
    }//GEN-LAST:event_BSimpanActionPerformed

    private void BUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUbahActionPerformed
        String TStatus="";
        if  (rmember.isSelected())
        {   TStatus="Member";
        }
        else if (rnonmmber.isSelected())
        {   TStatus="Biasa";
        }
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        String tgl = dateFormat.format(TTgl.getDate());
        String waktu=sdf.format((Date)TJmsk.getValue());
        String waktut=sdf.format((Date)TJklr.getValue());
        String DP = TDP.getModel().getSelectedItem().toString();
        trans="ubah";
            String[] plg={TBook.getText(),tgl,TNamaTeam.getText(),TNsewa.getText(),TSewa.getText(),
            THarga.getText(),DP,waktu,waktut,TStatus};
              if (pemesanan.updatebook(trans,plg)>0){
                javax.swing.JOptionPane.showMessageDialog(this, "Data Pemesanan Telah Diubah");
                emptyText();
                isiTrid();
                }
              else{javax.swing.JOptionPane.showMessageDialog(this,
                        "Terjadi kesalahan, Silahkan coba lagi", "Kesalahan",
                        javax.swing.JOptionPane.ERROR_MESSAGE);
    
     
                }
            book();
    }//GEN-LAST:event_BUbahActionPerformed

    private void BhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BhapusActionPerformed
        trans = "hapus";
        String[] plg = {TBook.getText()};
        if(javax.swing.JOptionPane.showConfirmDialog(this,
            "Anda yakin akan menghapus data ini ?", "Hati-hati !",
            javax.swing.JOptionPane.YES_NO_OPTION)==0) {
        if(pemesanan.updatebook(trans, plg)>0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Data Pemesanan Telah Terhapus");
            emptyText();
            isiTrid();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Terjadi kesalahan, Silahkan coba lagi", "Kesalahan",
                javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        book();
        }
    }//GEN-LAST:event_BhapusActionPerformed

    private void BBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBatalActionPerformed
        emptyText();
        book();
    }//GEN-LAST:event_BBatalActionPerformed

    private void BcetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BcetakActionPerformed
        try{
            String NamaFile = "./src/laporan/RBooking.jasper";
            String Logo = new File("src\\Gambar\\logo1.png").getAbsolutePath();
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/futsal","root","");
            HashMap param = new HashMap();
            //Mengambil parameter
            param.put("futsal",Logo);
            param.put("TGL",txtcari1.getText());
                   
            JasperPrint JPrint = JasperFillManager.fillReport(NamaFile, param, koneksi);
            JasperViewer.viewReport(JPrint,false);
        }catch(Exception ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Data tidak dapat di cetak","cetak data",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BcetakActionPerformed

    private void txtcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcariActionPerformed

    private void txtcariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
        Object[] Baris ={"Nama Team","Status"}; 
           tabmode = new DefaultTableModel(null, Baris); 
            String cariitem=txtcari.getText(); 
            
             try { 
                  String sql = "SELECT * FROM team where nama like '%"+cariitem+"%' order by nama asc"; 
                    RsBook = KoneksiDB.getRS(sql); 
                      while (RsBook.next()){
                           tabmode.addRow(new Object[]{
                            RsBook.getString(2),
                            RsBook.getString(5),
                            });
                      }
                      TTable2.setModel(tabmode);
             } catch (Exception e) {
             }
        }
    }//GEN-LAST:event_txtcariKeyPressed

    private void txtcari1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcari1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcari1ActionPerformed

    private void txtcari1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcari1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
         Object[] Baris ={"No Booking","Tanggal","Nama Team","Nama Penyewa","Sewa Lapangan","Harga Sewa","DP","Jam Masuk",
        "Jam Keluar","Status"}; 
           tabmode = new DefaultTableModel(null, Baris); 
            String cariitem=txtcari1.getText(); 
            
             try { 
                  String sql = "SELECT * FROM booking where nbooking like '%"+cariitem+"%' or namateam like"
                          + "'%"+cariitem+"%' order by nbooking asc"; 
                    RsBook = KoneksiDB.getRS(sql); 
                      while (RsBook.next()){
                           tabmode.addRow(new Object[]{
                            RsBook.getString(1),
                            RsBook.getString(2),
                            RsBook.getString(3),
                            RsBook.getString(4),
                            RsBook.getString(5),
                            RsBook.getString(6),
                            RsBook.getString(7),
                            RsBook.getString(8),
                            RsBook.getString(9),
                            RsBook.getString(10)
                            });
                      }
                      TTable1.setModel(tabmode);
             } catch (Exception e) {
             }
              book();
        }
    }//GEN-LAST:event_txtcari1KeyPressed

    private void TDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TDPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TDPActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonHover BBatal;
    private rojerusan.RSButtonHover BSimpan;
    private rojerusan.RSButtonHover BUbah;
    private rojerusan.RSButtonHover Bcetak;
    private rojerusan.RSButtonHover Bhapus;
    private javax.swing.JTextField TBook;
    private javax.swing.JComboBox TDP;
    private javax.swing.JTextField THarga;
    private javax.swing.JSpinner TJklr;
    private javax.swing.JSpinner TJmsk;
    private javax.swing.JTextField TNamaTeam;
    private javax.swing.JTextField TNsewa;
    private javax.swing.JTextField TSewa;
    private javax.swing.JTable TTable;
    private javax.swing.JTable TTable1;
    private javax.swing.JTable TTable2;
    private com.toedter.calendar.JDateChooser TTgl;
    private javax.swing.ButtonGroup bg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JRadioButton rmember;
    private javax.swing.JRadioButton rnonmmber;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txtcari1;
    // End of variables declaration//GEN-END:variables
}
