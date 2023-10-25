package foncier;
import connex.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.ejb.Stateless;
@Stateless
public class Foncier implements FoncierLocal {
    String cin;
    String localisation;
    double superficie;
    Date datedetraitement;
    double prix ;
    int idTerrain;

    public Date getDatedetraitement() {
        return datedetraitement;
    }

    public void setDatedetraitement(Date datedetraitement) {
        this.datedetraitement = datedetraitement;
    }

    public int getIdTerrain() {
        return idTerrain;
    }

    public void setIdTerrain(int idTerrain) {
        this.idTerrain = idTerrain;
    }

    public Foncier() {
    }
    public Foncier[] selectTerrain(String cin){
         Connexion c = new Connexion();
            ArrayList<Foncier> liste = new ArrayList<Foncier>();
         try{
            Connection con = c.login();
             Statement stm=con.createStatement();
             String sql = "select * from Foncier where cin ='"+cin+"'";
             System.out.println(sql);
             ResultSet res=stm.executeQuery(sql);
            while (res.next()){
                Foncier terre = new Foncier(res.getString("cin"),res.getString("localisation"),res.getDouble("superficie"),res.getDouble("prix"),res.getInt("idTerrain"));
                liste.add(terre);
            }
            con.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
         Foncier[] terra = new Foncier[liste.size()];
         liste.toArray(terra);
         return terra;
    }
     public Foncier(String cin, String localisation, double superficie, double prix,int idTerrain) {
        this.cin = cin;
        this.localisation = localisation;
        this.superficie = superficie;
        this.prix = prix;
        this.idTerrain = idTerrain;
    }


    public Foncier(String cin, String localisation, double superficie, double prix) {
        this.cin = cin;
        this.localisation = localisation;
        this.superficie = superficie;
        this.prix = prix;
    }
    

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
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

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
