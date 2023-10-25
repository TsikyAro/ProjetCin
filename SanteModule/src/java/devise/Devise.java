package devise;

import connexionn.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.ejb.Stateless;
@Stateless
public class Devise implements DeviseLocal {
    int idDevise;
    String nomDevise;

    public Devise() {
    }

    private Devise(int aInt, String string) {
        
        this.idDevise = aInt;
        this.nomDevise = string;
    }
        public Devise[] selectDevise(){
         Connexion c = new Connexion();
            ArrayList<Devise> liste = new ArrayList<Devise>();
         try{
            Connection con = c.login();
             Statement stm=con.createStatement();
             String sql = "select * from Devise";
             System.out.println(sql);
             ResultSet res=stm.executeQuery(sql);
            while (res.next()){
                Devise terre = new Devise(res.getInt(1),res.getString(2));
                liste.add(terre);
            }
            con.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
         Devise[] terra = new Devise[liste.size()];
         liste.toArray(terra);
         return terra;
        }

    public int getIdDevise() {
        return idDevise;
    }

    public void setIdDevise(int idDevise) {
        this.idDevise = idDevise;
    }

    public String getNomDevise() {
        return nomDevise;
    }

    public void setNomDevise(String nomDevise) {
        this.nomDevise = nomDevise;
    }
    
}
