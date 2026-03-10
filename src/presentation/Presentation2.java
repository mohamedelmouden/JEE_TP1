package presentation;
// import...
import dao.IDao;
import metier.IMetier;
// message personnelle::0637
import java.io.File;// message personnelle::0637
import java.lang.reflect.Method;// message personnelle::0637
import java.util.Scanner;
// 121212121221
public class Presentation2 {
    public static void main(String[] args) throws Exception {
        // Lecture du nom de la classe DAO depuis le fichier de configuration
        Scanner scanner = new Scanner(new File("config.txt"));// message personnelle::0637
        String daoClassName = scanner.nextLine();// message personnelle::0637

        // Utilisation de la réflexion pour charger la classe DAO et créer une instance
        Class<?> cDao = Class.forName(daoClassName);
        IDao dao = (IDao) cDao.getDeclaredConstructor().newInstance();

        // Lecture du nom de la classe Métier depuis le fichier de configuration
        String metierClassName = scanner.nextLine();// message personnelle::0637
        Class<?> cMetier = Class.forName(metierClassName);
        IMetier metier = (IMetier) cMetier.getDeclaredConstructor().newInstance();// message personnelle::0637

        // Injection de la DAO dans le Métier à l'aide de la réflexion
        Method setDaoMethod = cMetier.getMethod("setDao", IDao.class);// message personnelle::0637
        setDaoMethod.invoke(metier, dao);// message personnelle::0637
// invoke pour appeler la methode setDao
        // Invocation d'une méthode sur l'instance de Métier et affichage du résultat
        System.out.println("Résultats = " + metier.calcul());
// message personnelle::0637
        scanner.close();
    }// message personnelle::0637
    // voici la classe presentation 22332233
}
