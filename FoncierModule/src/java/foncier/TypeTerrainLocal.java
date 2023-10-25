/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foncier;

import javax.ejb.Local;

/**
 *
 * @author Tsiky Aro
 */
@Local
public interface TypeTerrainLocal {
    public TypeTerrain[] selectTerrain();
}
