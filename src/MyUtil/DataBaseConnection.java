package MyUtil;

import java.sql.*;
import javax.swing.JOptionPane;

public class DataBaseConnection {

    public static Connection cnn ;
    public static String flightid = "";
    
    public static void setConnection() {
        String projectLocation = System.getProperty("user.dir");
        try {
//            Class.forName("oracle.jdbc.OracleDriver");
            cnn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ibrar", "abc");
            cnn.setAutoCommit(false);
        } catch (Exception e) {
            System.out.println("EXCEPTION IN DBCON /N"+e );
        }
    }

    public static ResultSet getData(String sql) {
        ResultSet rs = null;
        try {
            Statement st = cnn.createStatement();
            rs = st.executeQuery(sql);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }

    public static int insertData(String sql) {
        try {
            Statement st = cnn.createStatement();
            PreparedStatement ps = cnn.prepareStatement(sql);
            st.executeUpdate(sql);
            cnn.commit();
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }
    }

    public static int updateData(String sql) {
        try {
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.executeUpdate();
            cnn.commit();
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public static boolean deleteData(String sql) {
        boolean deleted = false;
        try {
            Statement ps = cnn.createStatement();
            int i = ps.executeUpdate(sql);
            if (i == 1) {
                deleted = true;
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null , "Unable to delete the parent record. Child records are associated with it.\n Please delete or update the associated child records first.");
        }
        return deleted;
    }
    
}
