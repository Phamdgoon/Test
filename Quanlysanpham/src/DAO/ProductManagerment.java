
package DAO;

import Model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProductManagerment extends JDBCConnection {
    public List<Product> getAllProduct() {
        List<Product> Product = new ArrayList<Product>();

        Connection conn = JDBCConnection.getJDBCConnection();
        String sqlQuerry = "select * from SanPham";

        try {
            PreparedStatement stm = conn.prepareStatement(sqlQuerry);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Product th = new Product();
                th.setID(rs.getInt("ID"));
                th.setTenSP(rs.getString("TenSP"));
                th.setSoluong(rs.getString("Soluong"));
                th.setGia(rs.getString("Gia"));


                Product.add(th);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Product;
    }


    public Product getProductByName(String TenSP) {
        Product th = new Product();
        Connection conn = JDBCConnection.getJDBCConnection();
        String sqlQuerry = "select * from Thuoc where TenSP = ?";
        try {
            PreparedStatement stm = conn.prepareStatement(sqlQuerry);
            stm.setString(1, TenSP);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                th.setID(rs.getInt("ID"));
                th.setTenSP(rs.getString("TenSP"));
                th.setSoluong(rs.getString("Soluong"));
                th.setGia(rs.getString("Gia"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return th;
    }
    
    public Product getProductById(String ID) {
        Product th = new Product();
        Connection conn = JDBCConnection.getJDBCConnection();
        String sqlQuerry = "select * from Thuoc where ID = ?";
        try {
            PreparedStatement stm = conn.prepareStatement(sqlQuerry);
            stm.setString(1, ID);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                th.setID(rs.getInt("ID"));
                th.setTenSP(rs.getString("TenSP"));
                th.setSoluong(rs.getString("Soluong"));
                th.setGia(rs.getString("Gia"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return th;
    }
    

    public void addProduct(Product product) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sqlQuerry = "insert into SanPham(ID, TenSP, Soluong, Gia) values(?,?,?,?)";

        try {
            PreparedStatement stm = conn.prepareStatement(sqlQuerry);
            stm.setInt(1, product.getID());
            stm.setString(2, product.getTenSP());
            stm.setString(3, product.getSoluong());
            stm.setString(4, product.getGia());

            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    int result;

    public int deleteProduct(int ID) {

        Connection conn = JDBCConnection.getJDBCConnection();
        String sqlQuerry = "delete from SanPham where ID = ?";

        try {
            PreparedStatement stm = conn.prepareStatement(sqlQuerry);
            stm.setInt(1, ID);
            result = stm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public void updateProduct(Product product) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sqlQuerry = "update SanPham set TenSP = ?, Soluong = ?,Gia = ? where ID = ?";

        try {
            PreparedStatement stm = conn.prepareStatement(sqlQuerry);
            stm.setString(1, product.getTenSP());
            stm.setString(2, product.getSoluong());
            stm.setString(3, product.getGia());
            stm.setInt(4, product.getID());
            stm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<String> getIds() {
        List<String> ids = new ArrayList<>();

        Connection conn = JDBCConnection.getJDBCConnection();
        String sqlQuerry = "select ID from SanPham";

        try {
            PreparedStatement stm = conn.prepareStatement(sqlQuerry);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                ids.add(rs.getString("ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ids;
    }
    
}
