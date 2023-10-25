/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foncier;

import connex.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author Tsiky Aro
 */
@Stateless
public class TypeTerrain implements TypeTerrainLocal {
    int idTypeTerrain;
    String nomType;
    
    public TypeTerrain[] selectTerrain(){
         Connexion c = new Connexion();
            ArrayList<TypeTerrain> liste = new ArrayList<TypeTerrain>();
         try{
            Connection con = c.login();
             Statement stm=con.createStatement();
                String sql = "select * from TypeTany ";
             System.out.println(sql);
             ResultSet res=stm.executeQuery(sql);
            while (res.next()){
                TypeTerrain terre = new TypeTerrain(res.getInt("idType"),res.getString("nomType"));
                liste.add(terre);
            }
            con.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
         TypeTerrain[] terra = new TypeTerrain[liste.size()];
         liste.toArray(terra);
         return terra;
    }
    public TypeTerrain() {
    }

    public TypeTerrain(int idTypeTerrain, String nomType) {
        this.idTypeTerrain = idTypeTerrain;
        this.nomType = nomType;
    }
    

    public int getIdTypeTerrain() {
        return idTypeTerrain;
    }

    public void setIdTypeTerrain(int idTypeTerrain) {
        this.idTypeTerrain = idTypeTerrain;
    }

    public String getNomType() {
        return nomType;
    }

    public void setNomType(String nomType) {
        this.nomType = nomType;
    }
    
}
