package foncier;

import javax.ejb.Local;
@Local
public interface FoncierLocal {
    public Foncier[] selectTerrain(String cin);
}
