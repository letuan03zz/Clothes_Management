 // Source code is unavailable, and was generated by the Fernflower decompiler.
 package dao;

 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.SQLException;
 
 public class ConnectMySQL {
    public static Connection getConnection() {
       String urlDB = "jdbc:mysql://localhost:3306/product";
       String username = "root";
       String password = "1234";
       return getConnection(urlDB, username, password);
    }
 
    private static Connection getConnection(String urlDB, String username, String password) {
       Connection conn = null;
 
       try {
          Class.forName("com.mysql.cj.jdbc.Driver");
 
          try {
             conn = DriverManager.getConnection(urlDB, username, password);
             System.out.println("connect thanh cong");
             System.out.println(password);
          } catch (SQLException var5) {
             var5.printStackTrace();
          }
       } catch (ClassNotFoundException var6) {
          var6.printStackTrace();
       }
 
       return conn;
    }
 
    public static void main(String[] args) {
        // Gọi phương thức getConnection để thiết lập kết nối
        Connection connection = getConnection();
        // Nếu connection không null, có nghĩa là kết nối đã được thiết lập thành công
        if (connection != null) {
        }
    }
 }
 