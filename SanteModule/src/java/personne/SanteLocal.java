package personne;
import javax.ejb.Local;
@Local
public interface SanteLocal {
    public Sante getSantebyId(String cin);
}
