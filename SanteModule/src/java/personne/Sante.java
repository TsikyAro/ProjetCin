package personne;
import connexionn.Connexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.ejb.Stateless;
@Stateless
public class Sante implements SanteLocal {
    String cin;
    String nomOperation;
    String nomMaladie;
    Date datedetraitement;
    double depense;

    public Sante(String cin, String nomOperation, String nomMaladie, Date datedetraitement, double depense) {
        this.cin = cin;
        this.nomOperation = nomOperation;
        this.nomMaladie = nomMaladie;
        this.datedetraitement = datedetraitement;
        this.depense = depense;
    }

    
    public Sante getSantebyId(String cin){
        Connexion con = new Connexion();
        ArrayList<Sante> liste = new ArrayList<Sante>();
        try{
           Connection connect = con.login();
            Statement stm=connect.createStatement();
            String sql = "select * from Sante where cin='"+cin+"'";
            System.out.println(sql);
            ResultSet res=stm.executeQuery(sql); 
           while (res.next()){
               Sante terre = new Sante(res.getString(1),res.getString(2),res.getString(3),res.getDate(4),res.getDouble(5));
               liste.add(terre);
           }
           connect.close();
           }catch (Exception e) {
               System.out.println("ERROR :"+e.getMessage());
           }
        Sante[] terra = new Sante[liste.size()];
        Sante test = new Sante();
        test.setCin("CIns");
        liste.toArray(terra);
        if(terra.length!=0){
            return terra[0]; 
        }
        return test ; 
    }

    public Sante() {
    }

    public Sante(String cin, String nomOperation, String nomMaladie, Date datedetraitement) {
        this.cin = cin;
        this.nomOperation = nomOperation;
        this.nomMaladie = nomMaladie;
        this.datedetraitement = datedetraitement;
    }
    
    public double getDepense() {
        return depense;
    }

    public void setDepense(double depense) {
        this.depense = depense;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNomOperation() {
        return nomOperation;
    }

    public void setNomOperation(String nomOperation) {
        this.nomOperation = nomOperation;
    }

    public String getNomMaladie() {
        return nomMaladie;
    }

    public void setNomMaladie(String nomMaladie) {
        this.nomMaladie = nomMaladie;
    }

    public Date getDatedetraitement() {
        return datedetraitement;
    }

    public void setDatedetraitement(Date datedetraitement) {
        this.datedetraitement = datedetraitement;
    }
    
    
}
