package ConnDb;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

    private static java.sql.Connection con = null;

    public static java.sql.Connection getConnection() throws SQLException {
        if (con != null) {
            return con;
        } else {
            try {
                String driver = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://localhost:3306/internetpack";
                String user = "root";
                String password = "";
                Class.forName(driver);
                con = DriverManager.getConnection("jdbc:mysql://localhost/internetpack", "root", "");
            } catch (ClassNotFoundException | SQLException cnfe) {
                System.out.println(cnfe);
            }
            return con;
        }
    }
}
