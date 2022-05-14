
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCConnection {
    public static Connection getJDBCConnection() {
        final String user = "sa";
        final String password = "123456";
        final String url = "jdbc:sqlserver://localhost:1433;databaseName=SanPham;user="+user+";password="+password;
        
        try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
