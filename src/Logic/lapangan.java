/*
 * To change this template, choose Tools | Templates
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
public class lapangan {
    
    private static String kode;
    private static String nama;
    private static String jenislpg;
    private static String harga;
    private static String hargambr;
    private static ResultSet RsLpg;

    /**
     * @return the kode
     */
    public static String getKode() {
        return kode;
    }

    /**
     * @param aKode the kode to set
     */
    public static void setKode(String aKode) {
        kode = aKode;
    }

    /**
     * @return the nama
     */
    public static String getNama() {
        return nama;
    }

    /**
     * @param aNama the nama to set
     */
    public static void setNama(String aNama) {
        nama = aNama;
    }

    /**
     * @return the harga
     */
    public static String getHarga() {
        return harga;
    }

    /**
     * @param aHarga the harga to set
     */
    public static void setHarga(String aHarga) {
        harga = aHarga;
    }

    /**
     * @return the hargambr
     */
    public static String getHargambr() {
        return hargambr;
    }

    /**
     * @param aHargambr the hargambr to set
     */
    public static void setHargambr(String aHargambr) {
        hargambr = aHargambr;
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

    public static boolean carilapangan(String Kode) {
        setKode(Kode);
        boolean b = false;
        String strSQL = "select * from lapangan where kode='" + getKode()+"'";
         setRsLpg(Koneksi.KoneksiDB.getRS(strSQL));
        try {
            if (getRsLpg().next()) {
                b = true;
                setKode(getRsLpg().getString("kode"));
                setNama(getRsLpg().getString("nama"));
                setHarga(getRsLpg().getString("harga"));
                setHargambr(getRsLpg().getString("hargambr"));
           
            }
        } catch (SQLException ex) {
            Logger.getLogger(lapangan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getRsLpg().close();
            } catch (SQLException ex) {
                Logger.getLogger(lapangan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return b;
    }

    public static int updatelapangan(String trans, String[] plg) {
        setKode(plg[0]);
        int n=0;
        String strSQL = null;
        if(trans.equals("tambah")) {
            strSQL = "insert into lapangan (kode,nama,harga,hargambr)"+
                     " values('"+plg[0]+"','"+plg[1]+"','"+plg[2]+"','"+plg[3]+"')";                    
        }else if(trans.equals("ubah")) {
            strSQL = "update lapangan set nama='"+plg[1]+"',harga='"+plg[2]+ "',hargambr='"+plg[3]+"'"
                    + "where kode = '"+plg [0]+"'";
        } else {
            strSQL = "delete from lapangan where kode='"+plg[0]+"'";
        }
        n = KoneksiDB.execSQL(strSQL);
        return n;
    }

    /**
     * @return the jenislpg
     */
    public static String getJenislpg() {
        return jenislpg;
    }

    /**
     * @param aJenislpg the jenislpg to set
     */
    public static void setJenislpg(String aJenislpg) {
        jenislpg = aJenislpg;
    }
}
