package personne;
import connexionn.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.ejb.Stateless;
@Stateless
public class Olona implements OlonaLocal {
    String idOlona;
    String nom;
    String prenom;
    Date dtn;
    String adresse;
    String commune;

    public Olona() {
    }
    public Olona(String idOlona, String nom, String prenom, java.sql.Date dtn, String adresse, String commune) {
        this.idOlona = idOlona;
        this.nom = nom;
        this.prenom = prenom;
        this.dtn = dtn;
        this.adresse = adresse;
        this.commune = commune;   
    }
     public Olona getOlonabyId(String idolona){
        Connexion con = new Connexion();
        ArrayList<Olona> liste = new ArrayList<Olona>();
        try{
           Connection connect = con.login();
            Statement stm=connect.createStatement();
            String sql = "select * from Olona where idOlona='"+idolona+"'";
            System.out.println(sql);
            ResultSet res=stm.executeQuery(sql);
//            idolona   |  nom   | prenom  |    dtn     |      adresse      | idcommune  
           while (res.next()){
               Olona terre = new Olona(res.getString(1),res.getString(2),res.getString(3),res.getDate(4),res.getString(5),res.getString(6));
               liste.add(terre);
           }
           connect.close();
           }catch (Exception e) {
               System.out.println("ERROR :"+e.getMessage());
           }
        Olona[] terra = new Olona[liste.size()];
        Olona test = new Olona();
        test.setIdOlona("OLona");
        liste.toArray(terra);
        if(terra.length!=0){
            return terra[0]; 
        }
        return test ; 
    }

    public String getIdOlona() {
        return idOlona;
    }

    public void setIdOlona(String idOlona) {
        this.idOlona = idOlona;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDtn() {
        return dtn;
    }

    public void setDtn(Date dtn) {
        this.dtn = dtn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }
}
