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
public class alat {
    
    private static String kodealat;
    private static String namaalat;
    private static String harga;
    private static ResultSet RsLpg;

    /**
     * @return the kodealat
     */
    public static String getKodealat() {
        return kodealat;
    }

    /**
     * @param aKodealat the kodealat to set
     */
    public static void setKodealat(String aKodealat) {
        kodealat = aKodealat;
    }

    /**
     * @return the namaalat
     */
    public static String getNamaalat() {
        return namaalat;
    }

    /**
     * @param aNamaalat the namaalat to set
     */
    public static void setNamaalat(String aNamaalat) {
        namaalat = aNamaalat;
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
    
    public static boolean carialat(String Kode) {
        setKodealat(Kode);
        boolean b = false;
        String strSQL = "select * from alat where kode='" + getKodealat() +"'";
         setRsLpg(Koneksi.KoneksiDB.getRS(strSQL));
        try {
            if (getRsLpg().next()) {
                b = true;
                setKodealat(getRsLpg().getString("kode"));
                setNamaalat(getRsLpg().getString("nama"));
                setHarga(getRsLpg().getString("harga"));
                }
        } catch (SQLException ex) {
            Logger.getLogger(alat.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getRsLpg().close();
            } catch (SQLException ex) {
                Logger.getLogger(alat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return b;
    }

    public static int updatealat(String trans, String[] plg) {
        setKodealat(plg[0]);
        int n=0;
        String strSQL = null;
        if(trans.equals("tambah")) {
            strSQL = "insert into alat (kode,nama,harga)"+
                     " values('"+plg[0]+"','"+plg[1]+"','"+plg[2]+"')";                    
        }else if(trans.equals("ubah")) {
            strSQL = "update alat set nama='"+plg[1]+"', harga='"+plg[2]+ "'"
                    + "where kode = '"+plg [0]+"'";
        } else {
            strSQL = "delete from alat where kode='"+plg[0]+"'";
        }
        n = KoneksiDB.execSQL(strSQL);
        return n;
    }
}
