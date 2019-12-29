/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Koneksi.KoneksiDB;


/**
 *
 * @author Fajar Yuda Saputra
 */
public class pembayaran {

    /**
     * @return the nbook
     */
    public static String getNbook() {
        return nbook;
    }

    /**
     * @param aNbook the nbook to set
     */
    public static void setNbook(String aNbook) {
        nbook = aNbook;
    }

    /**
     * @return the nopembayran
     */
    public static String getNopembayran() {
        return nopembayran;
    }

    /**
     * @param aNopembayran the nopembayran to set
     */
    public static void setNopembayran(String aNopembayran) {
        nopembayran = aNopembayran;
    }

    /**
     * @return the tanggal
     */
    public static String getTanggal() {
        return tanggal;
    }

    /**
     * @param aTanggal the tanggal to set
     */
    public static void setTanggal(String aTanggal) {
        tanggal = aTanggal;
    }

    /**
     * @return the jammsk
     */
    public static String getJammsk() {
        return jammsk;
    }

    /**
     * @param aJammsk the jammsk to set
     */
    public static void setJammsk(String aJammsk) {
        jammsk = aJammsk;
    }

    /**
     * @return the jamkluar
     */
    public static String getJamkluar() {
        return jamkluar;
    }

    /**
     * @param aJamkluar the jamkluar to set
     */
    public static void setJamkluar(String aJamkluar) {
        jamkluar = aJamkluar;
    }

    /**
     * @return the totaljam
     */
    public static String getTotaljam() {
        return totaljam;
    }

    /**
     * @param aTotaljam the totaljam to set
     */
    public static void setTotaljam(String aTotaljam) {
        totaljam = aTotaljam;
    }

    /**
     * @return the namateam
     */
    public static String getNamateam() {
        return namateam;
    }

    /**
     * @param aNamateam the namateam to set
     */
    public static void setNamateam(String aNamateam) {
        namateam = aNamateam;
    }

    /**
     * @return the namapenyewa
     */
    public static String getNamapenyewa() {
        return namapenyewa;
    }

    /**
     * @param aNamapenyewa the namapenyewa to set
     */
    public static void setNamapenyewa(String aNamapenyewa) {
        namapenyewa = aNamapenyewa;
    }

    /**
     * @return the namalapangan
     */
    public static String getNamalapangan() {
        return namalapangan;
    }

    /**
     * @param aNamalapangan the namalapangan to set
     */
    public static void setNamalapangan(String aNamalapangan) {
        namalapangan = aNamalapangan;
    }

    /**
     * @return the hargasewalapangan
     */
    public static String getHargasewalapangan() {
        return hargasewalapangan;
    }

    /**
     * @param aHargasewalapangan the hargasewalapangan to set
     */
    public static void setHargasewalapangan(String aHargasewalapangan) {
        hargasewalapangan = aHargasewalapangan;
    }

    /**
     * @return the sewaalat
     */
    public static String getSewaalat() {
        return sewaalat;
    }

    /**
     * @param aSewaalat the sewaalat to set
     */
    public static void setSewaalat(String aSewaalat) {
        sewaalat = aSewaalat;
    }

    /**
     * @return the jumlahsewaalat
     */
    public static String getJumlahsewaalat() {
        return jumlahsewaalat;
    }

    /**
     * @param aJumlahsewaalat the jumlahsewaalat to set
     */
    public static void setJumlahsewaalat(String aJumlahsewaalat) {
        jumlahsewaalat = aJumlahsewaalat;
    }

    /**
     * @return the hargasewaalat
     */
    public static String getHargasewaalat() {
        return hargasewaalat;
    }

    /**
     * @param aHargasewaalat the hargasewaalat to set
     */
    public static void setHargasewaalat(String aHargasewaalat) {
        hargasewaalat = aHargasewaalat;
    }

    /**
     * @return the totalhargasewaalat
     */
    public static String getTotalhargasewaalat() {
        return totalhargasewaalat;
    }

    /**
     * @param aTotalhargasewaalat the totalhargasewaalat to set
     */
    public static void setTotalhargasewaalat(String aTotalhargasewaalat) {
        totalhargasewaalat = aTotalhargasewaalat;
    }

    /**
     * @return the totalpembayaran
     */
    public static String getTotalpembayaran() {
        return totalpembayaran;
    }

    /**
     * @param aTotalpembayaran the totalpembayaran to set
     */
    public static void setTotalpembayaran(String aTotalpembayaran) {
        totalpembayaran = aTotalpembayaran;
    }

    /**
     * @return the dp
     */
    public static String getDp() {
        return dp;
    }

    /**
     * @param aDp the dp to set
     */
    public static void setDp(String aDp) {
        dp = aDp;
    }

    /**
     * @return the sisapembayaran
     */
    public static String getSisapembayaran() {
        return sisapembayaran;
    }

    /**
     * @param aSisapembayaran the sisapembayaran to set
     */
    public static void setSisapembayaran(String aSisapembayaran) {
        sisapembayaran = aSisapembayaran;
    }

    /**
     * @return the status
     */
    public static String getStatus() {
        return status;
    }

    /**
     * @param aStatus the status to set
     */
    public static void setStatus(String aStatus) {
        status = aStatus;
    }

    /**
     * @return the RsLpg
     */
    public static ResultSet getRsLpg() {
        return RsLpg;
    }

    /**
     * @param aRsLpg the RsLpg to set
     */
    public static void setRsLpg(ResultSet aRsLpg) {
        RsLpg = aRsLpg;
    }
    
    public static boolean insertbokng(String Nobook) {
        setNbook(Nobook);
        boolean b = false;
        String strSQL = "select * from booking where nbooking='" + getNbook()+"'";
         setRsLpg(Koneksi.KoneksiDB.getRS(strSQL));
        try {
            if (getRsLpg().next()) {
                b = true;
                setNbook(getRsLpg().getString("nbooking"));
                setTanggal(getRsLpg().getString("tgl"));
                setNamateam(getRsLpg().getString("namateam"));
                setNamapenyewa(getRsLpg().getString("namasewa"));
                setNamalapangan(getRsLpg().getString("namalpg"));
                setHargasewalapangan(getRsLpg().getString("harga"));
                setDp(getRsLpg().getString("dp"));
                setJammsk(getRsLpg().getString("jammsk"));
                setJamkluar(getRsLpg().getString("jamkluar"));
                setStatus(getRsLpg().getString("status"));
           
            }
        } catch (SQLException ex) {
            Logger.getLogger(pembayaran.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getRsLpg().close();
            } catch (SQLException ex) {
                Logger.getLogger(pembayaran.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return b;
    }
    
    public static boolean caribayar(String NoPembayaran) {
        setNopembayran(NoPembayaran);
        boolean b = false;
        String strSQL = "select * from pembayaran where nobayar='" + getNopembayran()+"'";
         setRsLpg(Koneksi.KoneksiDB.getRS(strSQL));
        try {
            if (getRsLpg().next()) {
                b = true;
                setNopembayran(getRsLpg().getString("nobayar"));
                setTanggal(getRsLpg().getString("tglbayar"));
                setNamateam(getRsLpg().getString("nmteam"));
                setNamalapangan(getRsLpg().getString("lpg"));
                setHargasewalapangan(getRsLpg().getString("hargalpg"));
                setHargasewaalat(getRsLpg().getString("hargaalat"));
                setJammsk(getRsLpg().getString("jammsk"));
                setJamkluar(getRsLpg().getString("jamklr"));
                setTotaljam(getRsLpg().getString("totaljam"));
                setSisapembayaran(getRsLpg().getString("bayar"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(pembayaran.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getRsLpg().close();
            } catch (SQLException ex) {
                Logger.getLogger(pembayaran.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return b;
    }

    public static int updatebayar(String trans, String[] plg) {
        setNbook(plg[0]);
        int n=0;
        String strSQL = null;
        if(trans.equals("tambah")) {
            strSQL = "insert into pembayaran (nobayar,tglbayar,nmteam,lpg,hargalpg,hargaalat,jammsk,jamklr,totaljam,bayar)"+
                     " values('"+plg[0]+"','"+plg[1]+"','"+plg[2]+"','"+plg[3]+"','"
                    +plg[4]+"','"+plg[5]+"','"+plg[6]+"','"+plg[7]+"','"+plg[8]+"','"+plg[9]+"')";                    
        }else if(trans.equals("ubah")) {
            strSQL = "update pembayaran set tglbayar='"+plg[1]+"', nmteam='"+plg[2]+ "',lpg='"+plg[3]+
                    "',hargalpg='"+plg[4]+"', hargaalat='"+plg[5]+ "',jammsk='"+plg[6]+ "',jamklr='"+plg[7]+
                    "',totaljam='"+plg[8]+ "',bayar='"+plg[9]+ "'"
                    + "where nobayar = '"+plg [0]+"'";
        } else {
            strSQL = "delete from pembayaran where nobayar='"+plg[0]+"'";
        }
        n = KoneksiDB.execSQL(strSQL);
        return n;
    }

   private static String nopembayran;
    private static String tanggal;
    private static String jammsk;
    private static String jamkluar;
    private static String totaljam;
    private static String namateam;
    private static String namapenyewa;
    private static String namalapangan;
    private static String hargasewalapangan;
    private static String sewaalat;
    private static String jumlahsewaalat;
    private static String hargasewaalat;
    private static String totalhargasewaalat;
    private static String totalpembayaran;
    private static String dp;
    private static String sisapembayaran;
    private static String status;
    private static String nbook;
    private static ResultSet RsLpg;
    
}
