package foncier;

import connex.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.ejb.Stateless;
@Stateless
public class Parsel implements ParselLocal {
    int idparsel;
    
    public void insertParsel(){
         Connexion c = new Connexion();
         try{
            Connection con = c.login();
             Statement stm=con.createStatement();
             String sql = "INSERT INTO PARSEL VALUES (NULL)";
             int res=stm.executeUpdate(sql);
            con.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Parsel selectLastParsel(){
        Connexion c = new Connexion();
        Parsel par = null;
        try{
           Connection con = c.login();
            Statement stm=con.createStatement();
            String sql = "select * from parsel order by idparsel desc";
            System.out.println(sql);
            ResultSet res=stm.executeQuery(sql);
           if (res.next()){
               par = new Parsel(res.getInt("idParsel"));
           }
           con.close();
           }catch (Exception e) {
               e.printStackTrace();
           }
        return par;
   }


    public Parsel() {
    }

    public Parsel(int idparsel) {
        this.idparsel = idparsel;
    }
    public int getIdparsel() {
        return idparsel;
    }

    public void setIdparsel(int idparsel) {
        this.idparsel = idparsel;
    }
}
