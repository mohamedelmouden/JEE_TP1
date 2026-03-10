package metier;
// message personnelle::0637
import dao.IDao;
// message personnelle::0637
public class MetierImpl1 implements IMetier {
    private IDao dao;
// message personnelle::0637
    public void setDao(IDao dao) {
        this.dao = dao;
    }// message personnelle::0637

    @Override
    public double calcul() {
        return dao.getValue() * 42;// message personnelle::0637
    }
}
