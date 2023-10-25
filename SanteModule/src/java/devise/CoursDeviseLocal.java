package devise;

import javax.ejb.Local;
@Local
public interface CoursDeviseLocal {
    public CoursDevise selectCoursDevise(int idDevise);
    public double valeurDeviseTA(double montant,double valeur);
    public double valeurDeviseTV(double montant,double valeur);
}
