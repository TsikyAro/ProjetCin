/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foncier;

import connex.Connexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import javax.ejb.Stateless;

/**
 *
 * @author Tsiky Aro
 */
@Stateless
public class ActeVente implements ActeVenteLocal {
    String cin;
    int idTerrain;
    int idTypeTany;
    Date date;
    double prix;
    public void insertActeVente(){
         Connexion c = new Connexion();
         try{
            Connection con = c.login();
             Statement stm=con.createStatement();
            String sql = "INSERT INTO ActeVente  (cin,idTerrain,idTypeTany,datedetraitement,prix) VALUES ('"+this.getCin()+"',"+this.getIdTerrain()+","+this.getIdTypeTany()+",'"+this.getDate()+"',"+this.getPrix()+")";
            int res=stm.executeUpdate(sql);
            con.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ActeVente() {
    }

    public ActeVente(String cin, int idTerrain, int idTypeTany, Date date, double prix) {
        this.cin = cin;
        this.idTerrain = idTerrain;
        this.idTypeTany = idTypeTany;
        this.date = date;
        this.prix = prix;
    }
    

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public int getIdTerrain() {
        return idTerrain;
    }

    public void setIdTerrain(int idTerrain) {
        this.idTerrain = idTerrain;
    }

    public int getIdTypeTany() {
        return idTypeTany;
    }

    public void setIdTypeTany(int idTypeTany) {
        this.idTypeTany = idTypeTany;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    
}
