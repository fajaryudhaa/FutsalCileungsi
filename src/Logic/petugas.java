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
public class petugas {

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
     * @return the alamat
     */
    public static String getAlamat() {
        return alamat;
    }

    /**
     * @param aAlamat the alamat to set
     */
    public static void setAlamat(String aAlamat) {
        alamat = aAlamat;
    }

    /**
     * @return the notlp
     */
    public static String getNotlp() {
        return notlp;
    }

    /**
     * @param aNotlp the notlp to set
     */
    public static void setNotlp(String aNotlp) {
        notlp = aNotlp;
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
    
    private static String nama;
    private static String alamat;
    private static String notlp;
    private static ResultSet RsLpg;
    
    public static boolean caripetugas(String nama) {
        setNama(nama);
        boolean b = false;
        String strSQL = "select * from petugas where nama='" + getNama()+"'";
         setRsLpg(Koneksi.KoneksiDB.getRS(strSQL));
        try {
            if (getRsLpg().next()) {
                b = true;
                setNama(getRsLpg().getString("nama"));
                setAlamat(getRsLpg().getString("alamat"));
                setNotlp(getRsLpg().getString("notlp"));
                }
        } catch (SQLException ex) {
            Logger.getLogger(petugas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getRsLpg().close();
            } catch (SQLException ex) {
                Logger.getLogger(petugas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return b;
    }

    public static int updatepetugas(String trans, String[] plg) {
        setNama(plg[0]);
        int n=0;
        String strSQL = null;
        if(trans.equals("tambah")) {
            strSQL = "insert into petugas (nama,alamat,notlp)"+
                     " values('"+plg[0]+"','"+plg[1]+"','"+plg[2]+"')";                    
        }else if(trans.equals("ubah")) {
            strSQL = "update petugas set alamat='"+plg[1]+"', notlp='"+plg[2]+ "'"
                    + "where nama = '"+plg [0]+"'";
        } else {
            strSQL = "delete from petugas where nama='"+plg[0]+"'";
        }
        n = KoneksiDB.execSQL(strSQL);
        return n;
    }
}
