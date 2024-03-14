package metier;
import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
public class MetierImpl implements IMetier{
    private IDao dao; // Couplage faible pour l'indépandence de l'interface IDao //
    public MetierImpl(IDao dao) {
        this.dao = dao;
    }
    @Override
    public double calcul() {
        double data = dao.getData();
        double res=data*12.5;
        return res;
    }
    /*
        -> Pour permettre d'injecter dans la valeur dao / -> Un objet d'une classe qui implémente l'interface IDao
     */
    public void setDao(IDao dao)
    {
        this.dao=dao;
    }
}
