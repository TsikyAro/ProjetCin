package foncier;

import connex.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.ejb.Stateless;
@Stateless
public class Propriete implements ProprieteLocal {
    int idPropriete;
    String cin;
    double longitude;
    double latitude;
    int idParsel;
    public void insertPropriete(){
        Connexion c = new Connexion();
         try{
            Connection con = c.login();
             Statement stm=con.createStatement();
             String sql = "INSERT INTO Propriete (cin,longitude,latitude,idterrain) VALUES ('"+this.getCin()+"',"+this.getLongitude()+","+this.getLatitude()+","+this.getIdParsel()+")";
            System.out.println(sql);
            int res=stm.executeUpdate(sql);
            con.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Propriete[] selectPropriete(String cin,int idTerre){
         Connexion c = new Connexion();
            ArrayList<Propriete> liste = new ArrayList<Propriete>();
         try{
            Connection con = c.login();
             Statement stm=con.createStatement();
                String sql = "select * from Propriete where cin= '"+cin+"' and idTerrain="+idTerre;
             System.out.println(sql);
             ResultSet res=stm.executeQuery(sql);
            while (res.next()){
                Propriete terre = new Propriete(res.getString("cin"),res.getDouble("longitude"),res.getDouble("latitude"),res.getInt("idTerrain"));
                liste.add(terre);
            }
            con.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
         Propriete[] terra = new Propriete[liste.size()];
         liste.toArray(terra);
         return terra;
    }

    public Propriete() {
    }

    public Propriete(String cin, double longitude, double latitude, int idParsel) {
        this.idPropriete = idPropriete;
        this.cin = cin;
        this.longitude = longitude;
        this.latitude = latitude;
        this.idParsel = idParsel;
    }

    public int getIdPropriete() {
        return idPropriete;
    }

    public void setIdPropriete(int idPropriete) {
        this.idPropriete = idPropriete;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getIdParsel() {
        return idParsel;
    }

    public void setIdParsel(int idParsel) {
        this.idParsel = idParsel;
    }
}
