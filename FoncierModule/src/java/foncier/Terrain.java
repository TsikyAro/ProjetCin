
package foncier;

import connex.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.ejb.Stateless;
@Stateless
public class Terrain implements TerrainLocal {
    int idTerrain;
    String localisation;
    double superficie;
    
     public void insertTerrain(){
         Connexion c = new Connexion();
         try{
            Connection con = c.login();
             Statement stm=con.createStatement();
             String sql = "INSERT INTO Terrain (localisation,superficie) VALUES ('"+this.getLocalisation()+"',"+this.getSuperficie()+")";
             int res=stm.executeUpdate(sql);
            con.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
      public Terrain selectLastTerrain(){
        Connexion c = new Connexion();
        Terrain par = null;
        try{
           Connection con = c.login();
            Statement stm=con.createStatement();
            String sql = "select * from Terrain order by idTerrain desc";
            System.out.println(sql);
            ResultSet res=stm.executeQuery(sql);
           if (res.next()){
               par = new Terrain(res.getInt("IdTerrain"),res.getString("localisation"),res.getDouble("superficie"));
           }
           con.close();
           }catch (Exception e) {
               e.printStackTrace();
           }
        return par;
   }
    public Terrain() {
    }

    public Terrain(int idTerrain, String localisation, double superficie) {
        this.idTerrain = idTerrain;
        this.localisation = localisation;
        this.superficie = superficie;
    }

    public Terrain( String localisation, double superficie){
        this.localisation = localisation;
        this.superficie = superficie;
    }
    
    public int getIdTerrain() {
        return idTerrain;
    }

    public void setIdTerrain(int idTerrain) {
        this.idTerrain = idTerrain;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }
    
}
