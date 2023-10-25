package personne;

import javax.ejb.Local;
@Local
public interface OlonaLocal {
    public Olona getOlonabyId(String idolona);
    
}
