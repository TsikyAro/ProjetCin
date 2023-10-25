package personne;

import connexionn.Connexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.ejb.Stateless;

@Stateless
public class Cins implements CinsLocal {
    String Cin;
    String idOlona;
    Date    datesortie;
    public Cins getCinbyId(String cin) {
        Connexion con = new Connexion();
        ArrayList<Cins> liste = new ArrayList<Cins>();
        try{
           Connection connect = con.login();
            Statement stm=connect.createStatement();
            String sql = "select * from CIns where cin='"+cin+"'";
            System.out.println(sql);
            ResultSet res=stm.executeQuery(sql);
           while (res.next()){
               Cins terre = new Cins(res.getString(1),res.getString(2),res.getDate(3));
               liste.add(terre);
           }
           connect.close();
           }catch (Exception e) {
               System.out.println("ERROR :"+e.getMessage());
               e.printStackTrace();
           }
      Cins[] terra = new Cins[liste.size()];
      Cins test = new Cins();
      test.setCin("CIN io");
      liste.toArray(terra);
      if(terra.length!=0){
          return terra[0]; 
      }
      return test ; 
    }

    public Cins() {
    }

    public Cins(String Cin, String idOlona, Date datesortie) {
        this.Cin = Cin;
        this.idOlona = idOlona;
        this.datesortie = datesortie;
    }

    public String getCin() {
        return Cin;
    }

    public void setCin(String Cin) {
        this.Cin = Cin;
    }

    public String getIdOlona() {
        return idOlona;
    }

    public void setIdOlona(String idOlona) {
        this.idOlona = idOlona;
    }

    public Date getDatesortie() {
        return datesortie;
    }

    public void setDatesortie(Date datesortie) {
        this.datesortie = datesortie;
    }
}
