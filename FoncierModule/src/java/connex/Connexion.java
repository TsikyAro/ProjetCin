package connex;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Connexion {
    String user;
        String password;
        String req;
        Connection con;
        public Connection getCon() {
            return con;
        }
        public void setCon(Connection con) {
            this.con = con;
        }
        public String getReq() {
            return req;
        }
        public void setReq(String req) {
            this.req = req;
        }
        public String getUser() {
            return user;
        }
        public void setUser(String user) {
            this.user = password;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
        public Connexion() {
            setUser(user);
            setPassword(password);
            setReq(req);
        }
     public Connection login() throws ClassNotFoundException{
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cin", "cin", "cin");
        }
        catch(SQLException e){ 
            e.printStackTrace();
        }
        return con;
    }
    
}
