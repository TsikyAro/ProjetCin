/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personne;

import javax.ejb.Local;
@Local
public interface CinsLocal {
    public Cins getCinbyId(String cin);
}
