 // Source code is unavailable, and was generated by the Fernflower decompiler.
 package dao;

 import java.sql.Connection;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.util.ArrayList;
 import java.util.List;
 import model.Product;
 
 public class ProductDAO implements IProductDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
 
    public List<Product> GetAllProduct() {
       List<Product> productList = new ArrayList();
       String sql = "select * from product";
 
       try {
          new ConnectMySQL();
          this.conn = ConnectMySQL.getConnection();
          this.ps = this.conn.prepareStatement(sql);
          this.rs = this.ps.executeQuery();
 
          while(this.rs.next()) {
             String id_product = this.rs.getString("id_product");
             String name_product = this.rs.getString("name");
             int unit = this.rs.getInt("unit");
             double price = this.rs.getDouble("price");
             String image = this.rs.getString("image");
             String description = this.rs.getString("description");
             Product product = new Product(id_product, name_product, unit, price, image, description);
             productList.add(product);
          }
       } catch (SQLException var11) {
          var11.printStackTrace();
       }
 
       return productList;
    }
 
    public List<Product> GetProductByName(String name_product) {
       List<Product> productList = new ArrayList();
       String sql = "select * from product where name =?";
 
       try {
          new ConnectMySQL();
          this.conn = ConnectMySQL.getConnection();
          this.ps = this.conn.prepareStatement(sql);
          this.ps.setString(1, name_product);
          this.rs = this.ps.executeQuery();
 
          while(this.rs.next()) {
             String id_product = this.rs.getString("id_product");
             String name = this.rs.getString("name");
             int unit = this.rs.getInt("unit");
             double price = this.rs.getDouble("price");
             String image = this.rs.getString("image");
             String description = this.rs.getString("description");
             Product product = new Product(id_product, name, unit, price, image, description);
             productList.add(product);
          }
       } catch (Exception var12) {
          var12.printStackTrace();
       }
 
       return productList;
    }
 
    public void InsertProduct(Product product) {
       String sql = "INSERT INTO PRODUCT(id_product,name,unit,price,image,description) VALUES(?,?,?,?,?,?)";
 
       try {
          new ConnectMySQL();
          this.conn = ConnectMySQL.getConnection();
          this.ps = this.conn.prepareStatement(sql);
          this.ps.setString(1, product.getId_product());
          this.ps.setString(2, product.getName_product());
          this.ps.setInt(3, product.getUnit());
          this.ps.setDouble(4, product.getPrice());
          this.ps.setString(5, product.getImage());
          this.ps.setString(6, product.getDescription());
          this.ps.executeUpdate();
       } catch (Exception var4) {
          var4.printStackTrace();
       }
 
    }
 
    public void UpdateProduct(Product product) {
       String sql = "UPDATE PRODUCT SET name = ?,unit = ?,price = ?,image = ?, description = ? WHERE id_product = ?";
 
       try {
          new ConnectMySQL();
          this.conn = ConnectMySQL.getConnection();
          this.ps = this.conn.prepareStatement(sql);
          this.ps.setString(6, product.getId_product());
          this.ps.setString(1, product.getName_product());
          this.ps.setInt(2, product.getUnit());
          this.ps.setDouble(3, product.getPrice());
          this.ps.setString(4, product.getImage());
          this.ps.setString(5, product.getDescription());
          this.ps.executeUpdate();
       } catch (Exception var4) {
          var4.printStackTrace();
       }
 
    }
 
    public void DeleteProduct(String id_product) {
       String sql = "delete from product where id_product=?";
 
       try {
          new ConnectMySQL();
          this.conn = ConnectMySQL.getConnection();
          this.ps = this.conn.prepareStatement(sql);
          this.ps.setString(1, id_product);
          this.ps.executeUpdate();
       } catch (Exception var4) {
          var4.printStackTrace();
       }
 
    }
 }
 