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
public class pemesanan {
    
    private static String namatim;
    private static String nbook;
    private static String tgl;
    private static String nteam;
    private static String nsewa;
    private static String nama;
    private static String harga;
    private static String dp;
    private static String jammsk;
    private static String jamkluar;
    private static String status;
    private static ResultSet RsLpg;
    
    public static boolean insertmemblap(String Nama) {
        setNama(Nama);
        boolean b = false;
        String strSQL = "select * from lapangan where nama='" + getNama()+"'";
         setRsLpg(Koneksi.KoneksiDB.getRS(strSQL));
        try {
            if (getRsLpg().next()) {
                b = true;
                setHarga(getRsLpg().getString("harga"));
           
            }
        } catch (SQLException ex) {
            Logger.getLogger(pemesanan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getRsLpg().close();
            } catch (SQLException ex) {
                Logger.getLogger(pemesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return b;
    }
    
    public static boolean insertmember(String Namatim) {
        setNamatim(Namatim);
        boolean b = false;
        String strSQL = "select * from team where nama='" + getNamatim()+"'";
         setRsLpg(Koneksi.KoneksiDB.getRS(strSQL));
        try {
            if (getRsLpg().next()) {
                b = true;
                setNamatim(getRsLpg().getString("nama"));
                setNama(getRsLpg().getString("status"));
                
           
            }
        } catch (SQLException ex) {
            Logger.getLogger(team.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getRsLpg().close();
            } catch (SQLException ex) {
                Logger.getLogger(team.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return b;
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

    /**
     * @return the kode
     */
    public static String getNamatim() {
        return namatim;
    }

    /**
     * @param aKode the kode to set
     */
    public static void setNamatim(String aKode) {
        namatim = aKode;
    }

    /**
     * @return the nteam
     */
    public static String getNteam() {
        return nteam;
    }

    /**
     * @param aNteam the nteam to set
     */
    public static void setNteam(String aNteam) {
        nteam = aNteam;
    }

    /**
     * @return the nsewa
     */
    public static String getNsewa() {
        return nsewa;
    }

    /**
     * @param aNsewa the nsewa to set
     */
    public static void setNsewa(String aNsewa) {
        nsewa = aNsewa;
    }

    /**
     * @return the tgl
     */
    public static String getTgl() {
        return tgl;
    }

    /**
     * @param aTgl the tgl to set
     */
    public static void setTgl(String aTgl) {
        tgl = aTgl;
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

    public static boolean caribook(String nbook) {
        setNbook(nbook);
        boolean b = false;
        String strSQL = "select * from booking where nbooking='" + getNbook()+"'";
         setRsLpg(Koneksi.KoneksiDB.getRS(strSQL));
        try {
            if (getRsLpg().next()) {
                b = true;
                setNbook(getRsLpg().getString("nbooking"));
                setTgl(getRsLpg().getString("tgl"));
                setNteam(getRsLpg().getString("namateam"));
                setNsewa(getRsLpg().getString("namasewa"));
                setNama(getRsLpg().getString("namalpg"));
                setHarga(getRsLpg().getString("harga"));
                setDp(getRsLpg().getString("dp"));
                setJammsk(getRsLpg().getString("jammsk"));
                setJamkluar(getRsLpg().getString("jamkluar"));
                setStatus(getRsLpg().getString("status"));
           
            }
        } catch (SQLException ex) {
            Logger.getLogger(pemesanan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getRsLpg().close();
            } catch (SQLException ex) {
                Logger.getLogger(pemesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return b;
    }

    public static int updatebook(String trans, String[] plg) {
        setNbook(plg[0]);
        int n=0;
        String strSQL = null;
        if(trans.equals("tambah")) {
            strSQL = "insert into booking (nbooking,tgl,namateam,namasewa,namalpg,harga,dp,jammsk,jamkluar,status)"+
                     " values('"+plg[0]+"','"+plg[1]+"','"+plg[2]+"','"+plg[3]+"','"
                    +plg[4]+"','"+plg[5]+"','"+plg[6]+"','"+plg[7]+"','"+plg[8]+"','"+plg[9]+"')";                    
        }else if(trans.equals("ubah")) {
            strSQL = "update booking set tgl='"+plg[1]+"', namateam='"+plg[2]+ "',namasewa='"+plg[3]+
                    "',namalpg='"+plg[4]+"', harga='"+plg[5]+ "',dp='"+plg[6]+ "',jammsk='"+plg[7]+
                    "',jamkluar='"+plg[8]+ "',status='"+plg[9]+ "'"
                    + "where nbooking = '"+plg [0]+"'";
        } else {
            strSQL = "delete from booking where nbooking='"+plg[0]+"'";
        }
        n = KoneksiDB.execSQL(strSQL);
        return n;
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
     * @return the id
     */
    
}
