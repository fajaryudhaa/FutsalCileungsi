/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tampilan;

import Koneksi.KoneksiDB;
import Logic.pembayaran;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class FPembayaran extends javax.swing.JInternalFrame {
private ResultSet RsBook;
private String trans;
public String namaalt, hargaalt;
public String namaalt1, hargaalt1;
public String namaalt2, hargaalt2;
public String namaalt3, hargaalt3;
public String namaalt4, hargaalt4;
    int harga;
    int jam;
    int Htotal;
    int hargalpgn,hargaalat;
    int totalbayar,dp,sisabayar;
    private DefaultTableModel tabmode; 
    /**
     * Creates new form FPembayaran
     */
    public FPembayaran() {
        initComponents();
        isiGrid();
        bayar();
        tgl();
        isiTrid();
        
    }
    
    protected void datatable(){
        Object[] Baris ={"No Booking","Tanggal","Nama Tim","Nama Penyewa","Lapangan","Harga Lapangan","DP",
            "Jam Masuk","Jam Keluar","Status"};
        tabmode = new DefaultTableModel(null, Baris);
        String cariitem=txtcari1.getText();

            try {
                String sql = "SELECT * FROM pelanggan where id like '%"+cariitem+"%' or nama like"
                                 + "'%"+cariitem+"%' order by id asc"; 
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
                            RsBook.getString(9)
                            });
                    }
                TableBayar.setModel(tabmode);
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
        }
    }

    public void itemTerpilih(){
        FTAlat Pp = new FTAlat();
        Pp.plg = this;
        txtnamaalt1.setText(namaalt);
        txtharga1.setText(hargaalt);
}
    public void itemTerpilih1(){
        FTAlat1 Pp = new FTAlat1();
        Pp.plg1 = this;
        txtnamaalt2.setText(namaalt1);
        txtharga2.setText(hargaalt1);
}
    public void itemTerpilih2(){
        FTAlat2 Pp = new FTAlat2();
        Pp.plg2 = this;
        txtnamaalt3.setText(namaalt2);
        txtharga3.setText(hargaalt2);
}
    public void itemTerpilih3(){
        FTAlat3 Pp = new FTAlat3();
        Pp.plg3 = this;
        txtnamaalt4.setText(namaalt3);
        txtharga4.setText(hargaalt3);
}
    public void itemTerpilih4(){
        FTAlat4 Pp = new FTAlat4();
        Pp.plg4 = this;
        txtnamaalt5.setText(namaalt4);
        txtharga5.setText(hargaalt4);
}

    public void tgl(){
        Date ys= new Date();
        SimpleDateFormat a= new SimpleDateFormat("dd-MMMM-yyyy");
        txttglbayar.setText(a.format(ys));
}

private void bayar()
       {
        try {
            String sql="select * from pembayaran order by nobayar desc";
            RsBook = KoneksiDB.getRS(sql); 
            if (RsBook.next()) {
                String book = RsBook.getString("nobayar").substring(3);
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

               txtnobayar.setText("BK-" + Nol + AN);
            } else {
               txtnobayar.setText("BK-0001");
            }

           }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
           }
       }

    protected void kosong(){ 
         txtnobayar.setText("");
        txtjammsk.setText("");
        txtjamklr.setText("");
        TNTeam.setText("");
        TPenyewa.setText("");
        TNlpg.setText("");
        THsewalpg.setText("0");
        txtharga2.setText("");
        TNTeam.setText("");
        txtharga4.setText("");
        txtharga3.setText("");
        txttotalsewaalat.setText("0");
        txttotalpembayaran.setText("0");
        txtdp.setText("0");
        txtsisapembayaran.setText("");
        bg.clearSelection();
        txtpembayaran.setText("0");
        txthargalpg.setText("0");
        txtsisapembayaran.setText("0");
        txtkembalian.setText("0");
        cbjam.setSelectedItem("--pilih--");
        txtnamaalt1.setText("");
        txtnamaalt2.setText("");
        txtnamaalt3.setText("");
        txtnamaalt4.setText("");
        txtnamaalt5.setText("");
        jml1.setText("0");
        jml2.setText("0");
        jml3.setText("0");
        jml4.setText("0");
        jml5.setText("0");
        txtharga1.setText("0");
        txtharga2.setText("0");
        txtharga3.setText("0");
        txtharga4.setText("0");
        txtharga5.setText("0");
        total1.setText("0");
        total2.setText("0");
        total3.setText("0");
        total4.setText("0");
        total5.setText("0");
        }

void hargaalt(){
        int a1=Integer.parseInt(jml1.getText());
        int b1=Integer.parseInt(txtharga1.getText());
        int total=a1*b1;
        total1.setText(Integer.toString(total));
}

void hargaalt1(){
        int a2=Integer.parseInt(jml2.getText());
        int b2=Integer.parseInt(txtharga2.getText());
        int totall=a2*b2;
        total2.setText(Integer.toString(totall));
}

void hargaalt2(){
        int a3=Integer.parseInt(jml3.getText());
        int b3=Integer.parseInt(txtharga3.getText());
        int totalll=a3*b3;
        total3.setText(Integer.toString(totalll));
}

void hargaalt3(){
        int a4=Integer.parseInt(jml4.getText());
        int b4=Integer.parseInt(txtharga4.getText());
        int totallll=a4*b4;
        total4.setText(Integer.toString(totallll));
}

void hargaalt4(){
        int a5=Integer.parseInt(jml5.getText());
        int b5=Integer.parseInt(txtharga5.getText());
        int totalllll=a5*b5;
        total5.setText(Integer.toString(totalllll));
}


    void totalhargaalat(){
        int alat1=Integer.parseInt(total1.getText());
        int alat2=Integer.parseInt(total2.getText());
        int alat3=Integer.parseInt(total3.getText());
        int alat4=Integer.parseInt(total4.getText());
        int alat5=Integer.parseInt(total5.getText());
        int totalalat=alat1+alat2+alat3+alat4+alat5;
        txttotalsewaalat.setText(Integer.toString(totalalat));
    }

    void hrgatotal(){
        int a2=Integer.parseInt(txttotalsewaalat.getText());
        int b2=Integer.parseInt(txthargalpg.getText());
        int tot=b2+a2;
        txttotalpembayaran.setText(Integer.toString(tot));
    }

    void sisapembayaran(){
        int a3=Integer.parseInt(txttotalpembayaran.getText());
        int b3=Integer.parseInt(txtdp.getText());
        int totals=a3-b3;
        txtsisapembayaran.setText(Integer.toString(totals));
}
    private void hargasewa(){
        int baris= Tabelbooking.getSelectedRow();
            if("Member".equals(Tabelbooking.getValueAt(baris,8).toString())){
                mmber.setSelected(true);
                if (cbjam.getSelectedItem() == "1 Jam"){
                    int a = Integer.parseInt(THsewalpg.getText());
                    int b = a*20/100;
                    Htotal = a-b;
                }else if(cbjam.getSelectedItem() == "2 Jam"){
                    int a = Integer.parseInt(THsewalpg.getText());
                    int b = a*30/100;
                    Htotal = a-b;
                }else if(cbjam.getSelectedItem() == "3 Jam"){
                    int a = Integer.parseInt(THsewalpg.getText());
                    int b = a*30/100;
                    Htotal = a-b;
                }else if(cbjam.getSelectedItem() == "4 Jam"){
                    int a = Integer.parseInt(THsewalpg.getText());
                    int b = a*30/100;
                    Htotal = a-b;
                }
            else{
                    Htotal=0;
                    }
            }else{
                nonmmbr.setSelected(true);
                if  (cbjam.getSelectedItem() == "1 Jam"){
                    int a = Integer.parseInt(THsewalpg.getText());
                    Htotal = a;
                    }else if(cbjam.getSelectedItem() == "2 Jam"){
                    int a = Integer.parseInt(THsewalpg.getText());
                    Htotal = a*2;
                    }else if(cbjam.getSelectedItem() == "3 Jam"){
                    int a = Integer.parseInt(THsewalpg.getText());
                    Htotal = a*3;
                    }else if(cbjam.getSelectedItem() == "4 Jam"){
                    int a = Integer.parseInt(THsewalpg.getText());
                    Htotal = a*4;
                }
            else{
                Htotal=0;
                    }
               
        }
        String tot = Integer.toString(Htotal);
        txthargalpg.setText(tot);
    }
    
    private void isiGrid() {
        delGrid(Tabelbooking);
        DefaultTableModel defGrid = (DefaultTableModel) Tabelbooking.getModel();
        RsBook = KoneksiDB.getRS("select * from booking");
        try {
            while (RsBook.next()) {
                String[] data = {RsBook.getString("nbooking"),
                                 RsBook.getString("namateam"),RsBook.getString("namasewa"),
                                 RsBook.getString("namalpg"), RsBook.getString("harga"),
                                 RsBook.getString("dp"),RsBook.getString("jammsk"),
                                 RsBook.getString("jamkluar"),RsBook.getString("status")};
                defGrid.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FPembayaran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void delGrid(JTable gg) {
        DefaultTableModel defGrid = (DefaultTableModel) gg.getModel();
        int brs = gg.getRowCount();
        for(int i=0;i<brs;i++) {
            defGrid.removeRow(0);
        }
    }
    private void isiTrid() {
        delTrid(TableBayar);
        DefaultTableModel defGrid = (DefaultTableModel) TableBayar.getModel();
        RsBook = KoneksiDB.getRS("select * from pembayaran");
        try {
            while (RsBook.next()) {
                String[] data = {RsBook.getString("nobayar"),RsBook.getString("tglbayar"),
                                 RsBook.getString("nmteam"),RsBook.getString("lpg"),
                                 RsBook.getString("hargalpg"), RsBook.getString("hargaalat"),
                                 RsBook.getString("jammsk"),RsBook.getString("jamklr"),
                                 RsBook.getString("totaljam"),RsBook.getString("bayar")};
                defGrid.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FPembayaran.class.getName()).log(Level.SEVERE, null, ex);
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

        jSeparator13 = new javax.swing.JSeparator();
        jSeparator24 = new javax.swing.JSeparator();
        bg = new javax.swing.ButtonGroup();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        THsewalpg = new javax.swing.JTextField();
        TNlpg = new javax.swing.JTextField();
        TPenyewa = new javax.swing.JTextField();
        TNTeam = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        mmber = new javax.swing.JRadioButton();
        nonmmbr = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        cbjam = new javax.swing.JComboBox<>();
        txthargalpg = new javax.swing.JFormattedTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtharga2 = new javax.swing.JTextField();
        txtharga3 = new javax.swing.JTextField();
        txtharga1 = new javax.swing.JTextField();
        txtharga5 = new javax.swing.JTextField();
        jml1 = new javax.swing.JTextField();
        jml2 = new javax.swing.JTextField();
        jml3 = new javax.swing.JTextField();
        jml4 = new javax.swing.JTextField();
        jml5 = new javax.swing.JTextField();
        total1 = new javax.swing.JTextField();
        txtnamaalt1 = new javax.swing.JTextField();
        txtnamaalt2 = new javax.swing.JTextField();
        txtnamaalt3 = new javax.swing.JTextField();
        txtnamaalt4 = new javax.swing.JTextField();
        txtnamaalt5 = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator16 = new javax.swing.JSeparator();
        jSeparator17 = new javax.swing.JSeparator();
        jSeparator18 = new javax.swing.JSeparator();
        jSeparator19 = new javax.swing.JSeparator();
        jSeparator20 = new javax.swing.JSeparator();
        jSeparator21 = new javax.swing.JSeparator();
        jSeparator22 = new javax.swing.JSeparator();
        jSeparator23 = new javax.swing.JSeparator();
        jSeparator25 = new javax.swing.JSeparator();
        jSeparator26 = new javax.swing.JSeparator();
        jSeparator27 = new javax.swing.JSeparator();
        jSeparator28 = new javax.swing.JSeparator();
        jSeparator29 = new javax.swing.JSeparator();
        txttotalsewaalat = new javax.swing.JTextField();
        txtharga4 = new javax.swing.JTextField();
        total2 = new javax.swing.JTextField();
        jSeparator31 = new javax.swing.JSeparator();
        total3 = new javax.swing.JTextField();
        jSeparator32 = new javax.swing.JSeparator();
        total4 = new javax.swing.JTextField();
        jSeparator33 = new javax.swing.JSeparator();
        total5 = new javax.swing.JTextField();
        jSeparator34 = new javax.swing.JSeparator();
        Btambah1 = new rojerusan.RSButtonHover();
        Btambah = new rojerusan.RSButtonHover();
        Btambah2 = new rojerusan.RSButtonHover();
        Btambah3 = new rojerusan.RSButtonHover();
        Btambah4 = new rojerusan.RSButtonHover();
        Btambah5 = new rojerusan.RSButtonHover();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableBayar = new javax.swing.JTable();
        txtcari2 = new javax.swing.JTextField();
        jSeparator30 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtnobayar = new javax.swing.JTextField();
        txtjamklr = new javax.swing.JTextField();
        txtjammsk = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txttglbayar = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        Btambah6 = new rojerusan.RSButtonHover();
        jPanel6 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtdp = new javax.swing.JTextField();
        txtsisapembayaran = new javax.swing.JTextField();
        txttotalpembayaran = new javax.swing.JFormattedTextField();
        Bhitung = new rojerusan.RSButtonHover();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabelbooking = new javax.swing.JTable();
        txtcari1 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        txtpembayaran = new javax.swing.JTextField();
        txtkembalian = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        BSimpan = new rojerusan.RSButtonHover();
        BCetak = new rojerusan.RSButtonHover();
        BCetak1 = new rojerusan.RSButtonHover();

        jSeparator13.setForeground(new java.awt.Color(204, 51, 0));

        jSeparator24.setForeground(new java.awt.Color(204, 51, 0));

        setClosable(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("jam");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Booking", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 0, 0))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setForeground(new java.awt.Color(204, 0, 0));
        jLabel6.setText("Nama Team");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("Nama Penyewa");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("Nama Lapangan");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setText("Harga Sewa Lapangan");

        THsewalpg.setEditable(false);
        THsewalpg.setBackground(new java.awt.Color(255, 255, 255));
        THsewalpg.setForeground(new java.awt.Color(204, 0, 0));
        THsewalpg.setText("0");
        THsewalpg.setBorder(null);
        THsewalpg.setCaretColor(new java.awt.Color(204, 0, 0));

        TNlpg.setEditable(false);
        TNlpg.setBackground(new java.awt.Color(255, 255, 255));
        TNlpg.setForeground(new java.awt.Color(204, 0, 0));
        TNlpg.setBorder(null);
        TNlpg.setCaretColor(new java.awt.Color(204, 0, 0));

        TPenyewa.setEditable(false);
        TPenyewa.setBackground(new java.awt.Color(255, 255, 255));
        TPenyewa.setForeground(new java.awt.Color(204, 0, 0));
        TPenyewa.setBorder(null);
        TPenyewa.setCaretColor(new java.awt.Color(204, 0, 0));

        TNTeam.setEditable(false);
        TNTeam.setBackground(new java.awt.Color(255, 255, 255));
        TNTeam.setForeground(new java.awt.Color(204, 0, 0));
        TNTeam.setBorder(null);
        TNTeam.setCaretColor(new java.awt.Color(204, 0, 0));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("/Jam");

        mmber.setBackground(new java.awt.Color(255, 255, 255));
        bg.add(mmber);
        mmber.setForeground(new java.awt.Color(204, 0, 0));
        mmber.setText("Member");
        mmber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmberActionPerformed(evt);
            }
        });

        nonmmbr.setBackground(new java.awt.Color(255, 255, 255));
        bg.add(nonmmbr);
        nonmmbr.setForeground(new java.awt.Color(204, 0, 0));
        nonmmbr.setText("Non Member");
        nonmmbr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nonmmbrActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setForeground(new java.awt.Color(204, 0, 0));
        jLabel11.setText("Total Jam");

        cbjam.setForeground(new java.awt.Color(204, 0, 0));
        cbjam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--pilih--", "1 Jam", "2 Jam", "3 Jam", "4 Jam" }));
        cbjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbjamActionPerformed(evt);
            }
        });

        txthargalpg.setEditable(false);
        txthargalpg.setBackground(new java.awt.Color(255, 255, 255));
        txthargalpg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        txthargalpg.setForeground(new java.awt.Color(204, 0, 0));
        txthargalpg.setText("0");
        txthargalpg.setAlignmentX(10.0F);
        txthargalpg.setCaretColor(new java.awt.Color(204, 0, 0));
        txthargalpg.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txthargalpg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txthargalpgKeyReleased(evt);
            }
        });

        jSeparator6.setForeground(new java.awt.Color(204, 51, 0));

        jSeparator7.setForeground(new java.awt.Color(204, 51, 0));

        jSeparator8.setForeground(new java.awt.Color(204, 51, 0));

        jSeparator9.setForeground(new java.awt.Color(204, 51, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txthargalpg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                    .addComponent(TNlpg, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(THsewalpg, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TPenyewa, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TNTeam, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator8, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbjam, javax.swing.GroupLayout.Alignment.LEADING, 0, 107, Short.MAX_VALUE)
                                .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(mmber)
                                .addGap(18, 18, 18)
                                .addComponent(nonmmbr))
                            .addComponent(jLabel6))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1))
                    .addContainerGap(189, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mmber)
                    .addComponent(nonmmbr))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TNTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TPenyewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TNlpg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(THsewalpg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel9))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cbjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txthargalpg, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(83, 83, 83)
                    .addComponent(jLabel1)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel2)
                    .addContainerGap(132, Short.MAX_VALUE)))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Alat", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setForeground(new java.awt.Color(204, 0, 0));
        jLabel14.setText("Total Harga Sewa Alat");

        txtharga2.setEditable(false);
        txtharga2.setBackground(new java.awt.Color(255, 255, 255));
        txtharga2.setForeground(new java.awt.Color(204, 0, 0));
        txtharga2.setText("0");
        txtharga2.setBorder(null);
        txtharga2.setCaretColor(new java.awt.Color(204, 0, 0));

        txtharga3.setEditable(false);
        txtharga3.setBackground(new java.awt.Color(255, 255, 255));
        txtharga3.setForeground(new java.awt.Color(204, 0, 0));
        txtharga3.setText("0");
        txtharga3.setBorder(null);
        txtharga3.setCaretColor(new java.awt.Color(204, 0, 0));

        txtharga1.setEditable(false);
        txtharga1.setBackground(new java.awt.Color(255, 255, 255));
        txtharga1.setForeground(new java.awt.Color(204, 0, 0));
        txtharga1.setText("0");
        txtharga1.setBorder(null);
        txtharga1.setCaretColor(new java.awt.Color(204, 0, 0));

        txtharga5.setEditable(false);
        txtharga5.setBackground(new java.awt.Color(255, 255, 255));
        txtharga5.setForeground(new java.awt.Color(204, 0, 0));
        txtharga5.setText("0");
        txtharga5.setBorder(null);
        txtharga5.setCaretColor(new java.awt.Color(204, 0, 0));

        jml1.setForeground(new java.awt.Color(204, 0, 0));
        jml1.setText("0");
        jml1.setBorder(null);
        jml1.setCaretColor(new java.awt.Color(204, 0, 0));
        jml1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jml1ActionPerformed(evt);
            }
        });
        jml1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jml1KeyReleased(evt);
            }
        });

        jml2.setForeground(new java.awt.Color(204, 0, 0));
        jml2.setText("0");
        jml2.setBorder(null);
        jml2.setCaretColor(new java.awt.Color(204, 0, 0));
        jml2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jml2KeyReleased(evt);
            }
        });

        jml3.setForeground(new java.awt.Color(204, 0, 0));
        jml3.setText("0");
        jml3.setBorder(null);
        jml3.setCaretColor(new java.awt.Color(204, 0, 0));
        jml3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jml3KeyReleased(evt);
            }
        });

        jml4.setForeground(new java.awt.Color(204, 0, 0));
        jml4.setText("0");
        jml4.setBorder(null);
        jml4.setCaretColor(new java.awt.Color(204, 0, 0));
        jml4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jml4KeyReleased(evt);
            }
        });

        jml5.setForeground(new java.awt.Color(204, 0, 0));
        jml5.setText("0");
        jml5.setBorder(null);
        jml5.setCaretColor(new java.awt.Color(204, 0, 0));
        jml5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jml5KeyReleased(evt);
            }
        });

        total1.setEditable(false);
        total1.setBackground(new java.awt.Color(255, 255, 255));
        total1.setForeground(new java.awt.Color(204, 0, 0));
        total1.setText("0");
        total1.setBorder(null);
        total1.setCaretColor(new java.awt.Color(204, 0, 0));
        total1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                total1KeyReleased(evt);
            }
        });

        txtnamaalt1.setEditable(false);
        txtnamaalt1.setBackground(new java.awt.Color(255, 255, 255));
        txtnamaalt1.setForeground(new java.awt.Color(204, 0, 0));
        txtnamaalt1.setBorder(null);
        txtnamaalt1.setCaretColor(new java.awt.Color(204, 0, 0));

        txtnamaalt2.setEditable(false);
        txtnamaalt2.setBackground(new java.awt.Color(255, 255, 255));
        txtnamaalt2.setForeground(new java.awt.Color(204, 0, 0));
        txtnamaalt2.setBorder(null);
        txtnamaalt2.setCaretColor(new java.awt.Color(204, 0, 0));

        txtnamaalt3.setEditable(false);
        txtnamaalt3.setBackground(new java.awt.Color(255, 255, 255));
        txtnamaalt3.setForeground(new java.awt.Color(204, 0, 0));
        txtnamaalt3.setBorder(null);
        txtnamaalt3.setCaretColor(new java.awt.Color(204, 0, 0));

        txtnamaalt4.setEditable(false);
        txtnamaalt4.setBackground(new java.awt.Color(255, 255, 255));
        txtnamaalt4.setForeground(new java.awt.Color(204, 0, 0));
        txtnamaalt4.setBorder(null);
        txtnamaalt4.setCaretColor(new java.awt.Color(204, 0, 0));

        txtnamaalt5.setEditable(false);
        txtnamaalt5.setBackground(new java.awt.Color(255, 255, 255));
        txtnamaalt5.setForeground(new java.awt.Color(204, 0, 0));
        txtnamaalt5.setBorder(null);
        txtnamaalt5.setCaretColor(new java.awt.Color(204, 0, 0));

        jSeparator10.setForeground(new java.awt.Color(204, 51, 0));

        jSeparator11.setForeground(new java.awt.Color(204, 51, 0));

        jSeparator12.setForeground(new java.awt.Color(204, 51, 0));

        jSeparator14.setForeground(new java.awt.Color(204, 51, 0));

        jSeparator16.setForeground(new java.awt.Color(204, 51, 0));

        jSeparator17.setForeground(new java.awt.Color(204, 51, 0));

        jSeparator18.setForeground(new java.awt.Color(204, 51, 0));

        jSeparator19.setForeground(new java.awt.Color(204, 51, 0));

        jSeparator20.setForeground(new java.awt.Color(204, 51, 0));

        jSeparator21.setForeground(new java.awt.Color(204, 51, 0));

        jSeparator22.setForeground(new java.awt.Color(204, 51, 0));

        jSeparator23.setForeground(new java.awt.Color(204, 51, 0));

        jSeparator25.setForeground(new java.awt.Color(204, 51, 0));

        jSeparator26.setForeground(new java.awt.Color(204, 51, 0));

        jSeparator27.setForeground(new java.awt.Color(204, 51, 0));

        jSeparator28.setForeground(new java.awt.Color(204, 51, 0));

        jSeparator29.setForeground(new java.awt.Color(204, 51, 0));

        txttotalsewaalat.setEditable(false);
        txttotalsewaalat.setBackground(new java.awt.Color(255, 255, 255));
        txttotalsewaalat.setForeground(new java.awt.Color(204, 0, 0));
        txttotalsewaalat.setText("0");
        txttotalsewaalat.setBorder(null);
        txttotalsewaalat.setCaretColor(new java.awt.Color(204, 0, 0));
        txttotalsewaalat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttotalsewaalatKeyReleased(evt);
            }
        });

        txtharga4.setEditable(false);
        txtharga4.setBackground(new java.awt.Color(255, 255, 255));
        txtharga4.setForeground(new java.awt.Color(204, 0, 0));
        txtharga4.setText("0");
        txtharga4.setBorder(null);
        txtharga4.setCaretColor(new java.awt.Color(204, 0, 0));

        total2.setEditable(false);
        total2.setBackground(new java.awt.Color(255, 255, 255));
        total2.setForeground(new java.awt.Color(204, 0, 0));
        total2.setText("0");
        total2.setBorder(null);
        total2.setCaretColor(new java.awt.Color(204, 0, 0));

        jSeparator31.setForeground(new java.awt.Color(204, 51, 0));

        total3.setEditable(false);
        total3.setBackground(new java.awt.Color(255, 255, 255));
        total3.setForeground(new java.awt.Color(204, 0, 0));
        total3.setText("0");
        total3.setBorder(null);
        total3.setCaretColor(new java.awt.Color(204, 0, 0));

        jSeparator32.setForeground(new java.awt.Color(204, 51, 0));

        total4.setEditable(false);
        total4.setBackground(new java.awt.Color(255, 255, 255));
        total4.setForeground(new java.awt.Color(204, 0, 0));
        total4.setText("0");
        total4.setBorder(null);
        total4.setCaretColor(new java.awt.Color(204, 0, 0));

        jSeparator33.setForeground(new java.awt.Color(204, 51, 0));

        total5.setEditable(false);
        total5.setBackground(new java.awt.Color(255, 255, 255));
        total5.setForeground(new java.awt.Color(204, 0, 0));
        total5.setText("0");
        total5.setBorder(null);
        total5.setCaretColor(new java.awt.Color(204, 0, 0));

        jSeparator34.setForeground(new java.awt.Color(204, 51, 0));

        Btambah1.setBackground(new java.awt.Color(204, 0, 0));
        Btambah1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Plus_13px.png"))); // NOI18N
        Btambah1.setColorHover(new java.awt.Color(255, 51, 0));
        Btambah1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Btambah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btambah1ActionPerformed(evt);
            }
        });

        Btambah.setBackground(new java.awt.Color(204, 0, 0));
        Btambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Plus_13px.png"))); // NOI18N
        Btambah.setColorHover(new java.awt.Color(255, 51, 0));
        Btambah.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Btambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtambahActionPerformed(evt);
            }
        });

        Btambah2.setBackground(new java.awt.Color(204, 0, 0));
        Btambah2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Plus_13px.png"))); // NOI18N
        Btambah2.setColorHover(new java.awt.Color(255, 51, 0));
        Btambah2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Btambah2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btambah2ActionPerformed(evt);
            }
        });

        Btambah3.setBackground(new java.awt.Color(204, 0, 0));
        Btambah3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Plus_13px.png"))); // NOI18N
        Btambah3.setColorHover(new java.awt.Color(255, 51, 0));
        Btambah3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Btambah3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btambah3ActionPerformed(evt);
            }
        });

        Btambah4.setBackground(new java.awt.Color(204, 0, 0));
        Btambah4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Plus_13px.png"))); // NOI18N
        Btambah4.setColorHover(new java.awt.Color(255, 51, 0));
        Btambah4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Btambah4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btambah4ActionPerformed(evt);
            }
        });

        Btambah5.setBackground(new java.awt.Color(204, 0, 0));
        Btambah5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Refresh_16px.png"))); // NOI18N
        Btambah5.setText("Hitung");
        Btambah5.setColorHover(new java.awt.Color(255, 51, 0));
        Btambah5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Btambah5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btambah5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtnamaalt1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jml1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtharga1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(total1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(txtnamaalt2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jml2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtharga2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                            .addComponent(jSeparator23, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jSeparator18, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                    .addComponent(txtnamaalt3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jml3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                    .addComponent(jSeparator25, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                .addComponent(jSeparator26, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSeparator20, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtharga3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator10)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jSeparator31, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(total2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jSeparator32, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(total3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 8, Short.MAX_VALUE)))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Btambah, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btambah1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btambah2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btambah3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btambah4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(18, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(txtnamaalt5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jml5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jSeparator28, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparator22, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtharga5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jSeparator27, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator21, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtnamaalt4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jml4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtharga4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(Btambah5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator34, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(total5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator33, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(total4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator29, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttotalsewaalat, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtharga1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jml1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(total1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnamaalt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btambah, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator18, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator23, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtharga2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jml2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnamaalt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator25, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(total2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Btambah1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addComponent(jSeparator31, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnamaalt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jml3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtharga3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator20, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator26, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(total3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btambah2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator32, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jml4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnamaalt4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtharga4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator21, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator27, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(total4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btambah3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator33, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtharga5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jml5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnamaalt5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator22, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator28, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(total5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btambah4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator34, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btambah5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txttotalsewaalat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator29, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Pembayaran"));

        TableBayar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Bayar", "Tgl Bayar ", "Nama Team", "Lapangan", "Harga Lap", "Harga Alat", "Jam Masuk", "Jam Keluar", "Total Jam", "Pembayaran"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableBayar);

        txtcari2.setForeground(new java.awt.Color(204, 0, 0));
        txtcari2.setBorder(null);
        txtcari2.setCaretColor(new java.awt.Color(204, 0, 0));
        txtcari2.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtcari2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcari2ActionPerformed(evt);
            }
        });
        txtcari2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcari2KeyPressed(evt);
            }
        });

        jSeparator30.setForeground(new java.awt.Color(204, 51, 0));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Search_16px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtcari2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator30, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtcari2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator30, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Pembayaran", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setText("No. Pembayaran");

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setForeground(new java.awt.Color(204, 0, 0));
        jLabel13.setText("Jam Masuk");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setForeground(new java.awt.Color(204, 0, 0));
        jLabel10.setText("Jam Keluar");

        txtnobayar.setEditable(false);
        txtnobayar.setBackground(new java.awt.Color(255, 255, 255));
        txtnobayar.setForeground(new java.awt.Color(204, 0, 0));
        txtnobayar.setBorder(null);
        txtnobayar.setCaretColor(new java.awt.Color(204, 0, 0));

        txtjamklr.setEditable(false);
        txtjamklr.setBackground(new java.awt.Color(255, 255, 255));
        txtjamklr.setForeground(new java.awt.Color(204, 0, 0));
        txtjamklr.setBorder(null);
        txtjamklr.setCaretColor(new java.awt.Color(204, 0, 0));

        txtjammsk.setEditable(false);
        txtjammsk.setBackground(new java.awt.Color(255, 255, 255));
        txtjammsk.setForeground(new java.awt.Color(204, 0, 0));
        txtjammsk.setBorder(null);
        txtjammsk.setCaretColor(new java.awt.Color(204, 0, 0));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText("Tanggal Pembayaran");

        txttglbayar.setEditable(false);
        txttglbayar.setBackground(new java.awt.Color(255, 255, 255));
        txttglbayar.setForeground(new java.awt.Color(204, 0, 0));
        txttglbayar.setBorder(null);
        txttglbayar.setCaretColor(new java.awt.Color(204, 0, 0));

        jSeparator2.setForeground(new java.awt.Color(204, 51, 0));

        jSeparator3.setForeground(new java.awt.Color(204, 51, 0));

        jSeparator4.setForeground(new java.awt.Color(204, 51, 0));

        jSeparator5.setForeground(new java.awt.Color(204, 51, 0));

        Btambah6.setBackground(new java.awt.Color(204, 0, 0));
        Btambah6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Alarm Clock_16px.png"))); // NOI18N
        Btambah6.setText("Alarm");
        Btambah6.setColorHover(new java.awt.Color(255, 51, 0));
        Btambah6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Btambah6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btambah6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel4)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Btambah6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtjammsk, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                    .addComponent(txtjamklr)
                                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jSeparator5)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator2)
                                    .addComponent(txtnobayar, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                    .addComponent(txttglbayar)
                                    .addComponent(jSeparator3))))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnobayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txttglbayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtjammsk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(2, 2, 2)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtjamklr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Btambah6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pembayaran", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 0, 0));
        jLabel15.setText("Total Pembayaran");

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 0, 0));
        jLabel17.setText("DP");

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 0, 0));
        jLabel18.setText("Sisa Pembayaran");

        txtdp.setEditable(false);
        txtdp.setBackground(new java.awt.Color(255, 204, 51));
        txtdp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtdp.setText("0");

        txtsisapembayaran.setEditable(false);
        txtsisapembayaran.setBackground(new java.awt.Color(255, 255, 0));
        txtsisapembayaran.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtsisapembayaran.setText("0");

        txttotalpembayaran.setEditable(false);
        txttotalpembayaran.setBackground(new java.awt.Color(153, 255, 0));
        txttotalpembayaran.setText("0");
        txttotalpembayaran.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txttotalpembayaran.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                txttotalpembayaranAncestorRemoved(evt);
            }
        });

        Bhitung.setBackground(new java.awt.Color(204, 0, 0));
        Bhitung.setText("Hitung");
        Bhitung.setColorHover(new java.awt.Color(255, 51, 0));
        Bhitung.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Bhitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BhitungActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttotalpembayaran)
                            .addComponent(txtdp)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18))
                                .addGap(0, 167, Short.MAX_VALUE))
                            .addComponent(txtsisapembayaran))
                        .addContainerGap())
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(Bhitung, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttotalpembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtdp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtsisapembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(Bhitung, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Booking"));

        Tabelbooking.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Booking", "Nama Tim", "Nama Penyewa", "Lapangan", "Harga Lap", "DP", "Jam Masuk", "Jam Keluar", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabelbooking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelbookingMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Tabelbooking);

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

        jSeparator1.setForeground(new java.awt.Color(204, 51, 0));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Search_16px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtcari1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtcari1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(204, 0, 0));

        jLabel22.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Money_40px1.png"))); // NOI18N
        jLabel22.setText("Data Pembyaran");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel22)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addGap(40, 40, 40))
        );

        txtpembayaran.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtpembayaran.setForeground(new java.awt.Color(204, 0, 0));
        txtpembayaran.setText("0");
        txtpembayaran.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        txtpembayaran.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpembayaranKeyReleased(evt);
            }
        });

        txtkembalian.setEditable(false);
        txtkembalian.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtkembalian.setForeground(new java.awt.Color(204, 0, 0));
        txtkembalian.setText("0");
        txtkembalian.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));

        jLabel19.setBackground(new java.awt.Color(204, 0, 0));
        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 0, 0));
        jLabel19.setText("Pembayaran");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(204, 0, 0));
        jLabel20.setText("Kembalian");

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

        BCetak.setBackground(new java.awt.Color(204, 0, 0));
        BCetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Print_16px.png"))); // NOI18N
        BCetak.setText("Cetak");
        BCetak.setColorHover(new java.awt.Color(255, 51, 0));
        BCetak.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCetakActionPerformed(evt);
            }
        });

        BCetak1.setBackground(new java.awt.Color(204, 0, 0));
        BCetak1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Cancel_16px.png"))); // NOI18N
        BCetak1.setText("Batal");
        BCetak1.setColorHover(new java.awt.Color(255, 51, 0));
        BCetak1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BCetak1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCetak1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtpembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtkembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(BSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BCetak1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel20)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(221, 221, 221))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtkembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BCetak1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(256, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 224, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jScrollPane3.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1067, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mmberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmberActionPerformed
        
    }//GEN-LAST:event_mmberActionPerformed

    private void nonmmbrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nonmmbrActionPerformed
        
    }//GEN-LAST:event_nonmmbrActionPerformed

    private void cbjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbjamActionPerformed
        hargasewa();
    }//GEN-LAST:event_cbjamActionPerformed

    private void txthargalpgKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txthargalpgKeyReleased
        
    }//GEN-LAST:event_txthargalpgKeyReleased

    private void txttotalpembayaranAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txttotalpembayaranAncestorRemoved
        
    }//GEN-LAST:event_txttotalpembayaranAncestorRemoved

    private void TabelbookingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelbookingMouseClicked
        int baris= Tabelbooking.getSelectedRow();
        if (pembayaran.insertbokng(Tabelbooking.getValueAt
            (Tabelbooking.getSelectedRow(),0).toString())==true) {
        TNTeam.setText(pembayaran.getNamateam());
        TPenyewa.setText(pembayaran.getNamapenyewa());
        TNlpg.setText(pembayaran.getNamalapangan());
        THsewalpg.setText(pembayaran.getHargasewalapangan());
        txtdp.setText(pembayaran.getDp());
        txtjammsk.setText(pembayaran.getJammsk());
        txtjamklr.setText(pembayaran.getJamkluar());
        if("Member".equals(Tabelbooking.getValueAt(baris,8).toString())){
            mmber.setSelected(true);
        }else{
            nonmmbr.setSelected(true);
        }
        hargasewa();
        }
    }//GEN-LAST:event_TabelbookingMouseClicked

    private void txtpembayaranKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpembayaranKeyReleased
        int a1=Integer.parseInt(txtpembayaran.getText());
        int b1=Integer.parseInt(txtsisapembayaran.getText());
        int total = a1-b1;
        txtkembalian.setText(Integer.toString(total));
    }//GEN-LAST:event_txtpembayaranKeyReleased

    private void jml1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jml1ActionPerformed

    }//GEN-LAST:event_jml1ActionPerformed

    private void txtcari1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcari1ActionPerformed

    }//GEN-LAST:event_txtcari1ActionPerformed

    private void txtcari1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcari1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
        Object[] Baris ={"No Booking","Nama Team","Nama Penyewa","Lapangan","Harga Sewa","DP","Jam Masuk","Jam Keluar","Status"}; 
           tabmode = new DefaultTableModel(null, Baris); 
            String cariitem=txtcari1.getText(); 
            
             try { 
                  String sql = "SELECT * FROM booking where nbooking like '%"+cariitem+"%' or namateam like"
                          + "'%"+cariitem+"%' order by nbooking asc"; 
                    RsBook = KoneksiDB.getRS(sql); 
                      while (RsBook.next()){
                           tabmode.addRow(new Object[]{
                            RsBook.getString(1),
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
                      Tabelbooking.setModel(tabmode);
             } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_txtcari1KeyPressed

    private void txtcari2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcari2ActionPerformed
        
    }//GEN-LAST:event_txtcari2ActionPerformed

    private void txtcari2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcari2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
        Object[] Baris ={"No. Bayar","Tgl Bayar","Nama Tim","Lapangan","Harga Lap","Harga Alat","Jam Masuk","Jam Keluar",
        "Total Jam","Bayar"}; 
           tabmode = new DefaultTableModel(null, Baris); 
            String cariitem=txtcari2.getText(); 
            
             try { 
                  String sql = "SELECT * FROM pembayaran where nobayar like '%"+cariitem+"%' or nmteam like"
                          + "'%"+cariitem+"%' order by nobayar asc"; 
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
                      TableBayar.setModel(tabmode);
             } catch (Exception e) {
             }
        }
    }//GEN-LAST:event_txtcari2KeyPressed

    private void Btambah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btambah1ActionPerformed
        FTAlat1 Pp = new FTAlat1();
        Pp.plg1 = this;
        Pp.setVisible(true);
        Pp.setResizable(false);
    }//GEN-LAST:event_Btambah1ActionPerformed

    private void BtambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtambahActionPerformed
        FTAlat Pp = new FTAlat();
        Pp.plg = this;
        Pp.setVisible(true);
        Pp.setResizable(false);
    }//GEN-LAST:event_BtambahActionPerformed

    private void Btambah2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btambah2ActionPerformed
        FTAlat2 Pp = new FTAlat2();
        Pp.plg2 = this;
        Pp.setVisible(true);
        Pp.setResizable(false);
    }//GEN-LAST:event_Btambah2ActionPerformed

    private void Btambah3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btambah3ActionPerformed
        FTAlat3 Pp = new FTAlat3();
        Pp.plg3 = this;
        Pp.setVisible(true);
        Pp.setResizable(false);
    }//GEN-LAST:event_Btambah3ActionPerformed

    private void Btambah4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btambah4ActionPerformed
        FTAlat4 Pp = new FTAlat4();
        Pp.plg4 = this;
        Pp.setVisible(true);
        Pp.setResizable(false);
    }//GEN-LAST:event_Btambah4ActionPerformed

    private void txttotalsewaalatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttotalsewaalatKeyReleased

    }//GEN-LAST:event_txttotalsewaalatKeyReleased

    private void total1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_total1KeyReleased
        
    }//GEN-LAST:event_total1KeyReleased

    private void jml1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jml1KeyReleased
        hargaalt();
    }//GEN-LAST:event_jml1KeyReleased

    private void jml2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jml2KeyReleased
        hargaalt1();
    }//GEN-LAST:event_jml2KeyReleased

    private void jml3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jml3KeyReleased
        hargaalt2();
    }//GEN-LAST:event_jml3KeyReleased

    private void jml4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jml4KeyReleased
        hargaalt3();
    }//GEN-LAST:event_jml4KeyReleased

    private void jml5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jml5KeyReleased
        hargaalt4();
    }//GEN-LAST:event_jml5KeyReleased

    private void Btambah5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btambah5ActionPerformed
        totalhargaalat();
    }//GEN-LAST:event_Btambah5ActionPerformed

    private void BhitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BhitungActionPerformed
        hrgatotal();
        sisapembayaran();
    }//GEN-LAST:event_BhitungActionPerformed

    private void BSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSimpanActionPerformed
        String Jam = cbjam.getModel().getSelectedItem().toString();
        trans="tambah";
        String[] plg={txtnobayar.getText(),txttglbayar.getText(),TNTeam.getText(),TNlpg.getText(),txthargalpg.getText(),
            txttotalsewaalat.getText(),txtjammsk.getText(),txtjamklr.getText(),Jam,txtsisapembayaran.getText()};
        if (pembayaran.updatebayar(trans,plg)>0){
            javax.swing.JOptionPane.showMessageDialog(this, "Data Pembayaran Telah Disimpan");
            kosong();
            isiTrid();
        }
        else{javax.swing.JOptionPane.showMessageDialog(this,
            "Terjadi kesalahan, Silahkan coba lagi", "Kesalahan",
            javax.swing.JOptionPane.ERROR_MESSAGE);

        }
        bayar();
    }//GEN-LAST:event_BSimpanActionPerformed

    private void BCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCetakActionPerformed
        try{
            String Logo = new File("src\\Gambar\\logo1.png").getAbsolutePath();
            String NamaFile = "./src/laporan/RPembayaran.jasper";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/futsal","root","");
            HashMap param = new HashMap();
            
            param.put("futsal",Logo);
            param.put("TGL",txtcari2.getText());

            JasperPrint JPrint = JasperFillManager.fillReport(NamaFile, param, koneksi);
            JasperViewer.viewReport(JPrint,false);
        }catch(Exception ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Data tidak dapat di cetak","cetak data",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BCetakActionPerformed

    private void Btambah6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btambah6ActionPerformed
        new FAlarm().setVisible(true);
    }//GEN-LAST:event_Btambah6ActionPerformed

    private void BCetak1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCetak1ActionPerformed
        kosong();
        bayar();
        tgl();
        bg.clearSelection();
    }//GEN-LAST:event_BCetak1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonHover BCetak;
    private rojerusan.RSButtonHover BCetak1;
    private rojerusan.RSButtonHover BSimpan;
    private rojerusan.RSButtonHover Bhitung;
    private rojerusan.RSButtonHover Btambah;
    private rojerusan.RSButtonHover Btambah1;
    private rojerusan.RSButtonHover Btambah2;
    private rojerusan.RSButtonHover Btambah3;
    private rojerusan.RSButtonHover Btambah4;
    private rojerusan.RSButtonHover Btambah5;
    private rojerusan.RSButtonHover Btambah6;
    private javax.swing.JTextField THsewalpg;
    private javax.swing.JTextField TNTeam;
    private javax.swing.JTextField TNlpg;
    private javax.swing.JTextField TPenyewa;
    private javax.swing.JTable Tabelbooking;
    private javax.swing.JTable TableBayar;
    private javax.swing.ButtonGroup bg;
    private javax.swing.JComboBox<String> cbjam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JSeparator jSeparator26;
    private javax.swing.JSeparator jSeparator27;
    private javax.swing.JSeparator jSeparator28;
    private javax.swing.JSeparator jSeparator29;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator30;
    private javax.swing.JSeparator jSeparator31;
    private javax.swing.JSeparator jSeparator32;
    private javax.swing.JSeparator jSeparator33;
    private javax.swing.JSeparator jSeparator34;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField jml1;
    private javax.swing.JTextField jml2;
    private javax.swing.JTextField jml3;
    private javax.swing.JTextField jml4;
    private javax.swing.JTextField jml5;
    private javax.swing.JRadioButton mmber;
    private javax.swing.JRadioButton nonmmbr;
    private javax.swing.JTextField total1;
    private javax.swing.JTextField total2;
    private javax.swing.JTextField total3;
    private javax.swing.JTextField total4;
    private javax.swing.JTextField total5;
    private javax.swing.JTextField txtcari1;
    private javax.swing.JTextField txtcari2;
    private javax.swing.JTextField txtdp;
    private javax.swing.JTextField txtharga1;
    private javax.swing.JTextField txtharga2;
    private javax.swing.JTextField txtharga3;
    private javax.swing.JTextField txtharga4;
    private javax.swing.JTextField txtharga5;
    private javax.swing.JFormattedTextField txthargalpg;
    private javax.swing.JTextField txtjamklr;
    private javax.swing.JTextField txtjammsk;
    private javax.swing.JTextField txtkembalian;
    private javax.swing.JTextField txtnamaalt1;
    private javax.swing.JTextField txtnamaalt2;
    private javax.swing.JTextField txtnamaalt3;
    private javax.swing.JTextField txtnamaalt4;
    private javax.swing.JTextField txtnamaalt5;
    private javax.swing.JTextField txtnobayar;
    private javax.swing.JTextField txtpembayaran;
    private javax.swing.JTextField txtsisapembayaran;
    private javax.swing.JTextField txttglbayar;
    private javax.swing.JFormattedTextField txttotalpembayaran;
    private javax.swing.JTextField txttotalsewaalat;
    // End of variables declaration//GEN-END:variables
}
