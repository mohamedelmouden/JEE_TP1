package presentation;
// import...
import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;
// 121212121221
public class Presentation2 {
    public static void main(String[] args) throws Exception {
        // Lecture du nom de la classe DAO depuis le fichier de configuration
        Scanner scanner = new Scanner(new File("config.txt"));
        String daoClassName = scanner.nextLine();

        // Utilisation de la réflexion pour charger la classe DAO et créer une instance
        Class<?> cDao = Class.forName(daoClassName);
        IDao dao = (IDao) cDao.getDeclaredConstructor().newInstance();

        // Lecture du nom de la classe Métier depuis le fichier de configuration
        String metierClassName = scanner.nextLine();
        Class<?> cMetier = Class.forName(metierClassName);
        IMetier metier = (IMetier) cMetier.getDeclaredConstructor().newInstance();

        // Injection de la DAO dans le Métier à l'aide de la réflexion
        Method setDaoMethod = cMetier.getMethod("setDao", IDao.class);
        setDaoMethod.invoke(metier, dao);
// invoke pour appeler la methode setDao
        // Invocation d'une méthode sur l'instance de Métier et affichage du résultat
        System.out.println("Résultats = " + metier.calcul());

        scanner.close();
    }
    // voici la classe presentation 22332233
}