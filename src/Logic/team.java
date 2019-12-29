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
public class team {
    private static String kode;
    private static String nama;
    private static String alamat;
    private static String notlp;
    private static String stus;
    private static ResultSet RsMbr;

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
     * @return the RsMbr
     */
    public static ResultSet getRsMbr() {
        return RsMbr;
    }

    /**
     * @param aRsMbr the RsMbr to set
     */
    public static void setRsMbr(ResultSet aRsMbr) {
        RsMbr = aRsMbr;
    }
    
    public static boolean carimember(String Kode) {
        setKode(Kode);
        boolean b = false;
        String strSQL = "select * from team where kode='" + getKode()+"'";
         setRsMbr(Koneksi.KoneksiDB.getRS(strSQL));
        try {
            if (getRsMbr().next()) {
                b = true;
                setKode(getRsMbr().getString("kode"));
                setNama(getRsMbr().getString("nama"));
                setAlamat(getRsMbr().getString("alamat"));
                setNotlp(getRsMbr().getString("notlp"));
                setStus(getRsMbr().getString("status"));
           
            }
        } catch (SQLException ex) {
            Logger.getLogger(team.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getRsMbr().close();
            } catch (SQLException ex) {
                Logger.getLogger(team.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return b;
    }

    public static int updatemember(String trans, String[] plg) {
        setKode(plg[0]);
        int n=0;
        String strSQL = null;
        if(trans.equals("tambah")) {
            strSQL = "insert into team (kode,nama,alamat,notlp,status)"+
                     " values('"+plg[0]+"','"+plg[1]+"','"+plg[2]+"','"+plg[3]+"','"+plg[4]+"')";                    
        }else if(trans.equals("ubah")) {
            strSQL = "update team set nama='"+plg[1]+"', alamat='"+plg[2]+ "',notlp='"+plg[3]+ "',status='"+plg[4]+"'"
                    + "where kode = '"+plg [0]+"'";
        } else {
            strSQL = "delete from team where kode='"+plg[0]+"'";
        }
        n = KoneksiDB.execSQL(strSQL);
        return n;
    }

    private static void setRsbrg(java.sql.ResultSet rS) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @return the stus
     */
    public static String getStus() {
        return stus;
    }

    /**
     * @param aStus the stus to set
     */
    public static void setStus(String aStus) {
        stus = aStus;
    }
}
