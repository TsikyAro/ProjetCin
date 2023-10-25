package devise;

import connexionn.Connexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.ejb.Stateless;
@Stateless
public class CoursDevise implements CoursDeviseLocal {
    int idDevise;
    Date dates;
    double valeurAriaryTV;
    double valeurEuroTV;

    public CoursDevise() {
    }

    private CoursDevise(int aInt, Date date, double aDouble,double euro) {
       this.idDevise = aInt;
       this.dates = date;
       this.valeurAriaryTV = aDouble;
       this.valeurEuroTV = euro;
    }
    public double valeurDeviseTA(double montant,double valeur){
        double valiny = valeur*montant ;
        return valiny;
    }
    public double valeurDeviseTV(double montant,double valeur){
        double valiny = valeur*montant;
        return valiny;
    }
    public CoursDevise selectCoursDevise(int idDevise){
         Connexion c = new Connexion();
            ArrayList<CoursDevise> liste = new ArrayList<CoursDevise>();
         try{
            Connection con = c.login();
             Statement stm=con.createStatement();
             String sql = "select * from CoursDevise where idDevise ="+idDevise+" order by idCoursDevise desc";
             System.out.println(sql);
             ResultSet res=stm.executeQuery(sql);
            if (res.next()){
                CoursDevise terre = new CoursDevise(res.getInt(2),res.getDate(3),res.getDouble(4),res.getDouble(5));
                liste.add(terre);
            }
            con.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
         CoursDevise[] terra = new CoursDevise[liste.size()];
         liste.toArray(terra);
         return terra[0];
        }

    public int getIdDevise() {
        return idDevise;
    }

    public void setIdDevise(int idDevise) {
        this.idDevise = idDevise;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public double getValeurAriaryTV() {
        return valeurAriaryTV;
    }

    public void setValeurAriaryTV(double valeurAriaryTV) {
        this.valeurAriaryTV = valeurAriaryTV;
    }

    public double getValeurEuroTV() {
        return valeurEuroTV;
    }

    public void setValeurEuroTV(double valeurEuroTV) {
        this.valeurEuroTV = valeurEuroTV;
    }

    
    
}
