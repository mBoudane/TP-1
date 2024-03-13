package presentation;

import dao.DaoImpl;
import dao.IDao;
import extension.DaoImpl2;
import metier.MetierImpl;

public class Pres1 {
    public static void main(String[] args) {
        DaoImpl dao = new DaoImpl(); // Ici, Il existe une instenciation statique //
        MetierImpl metier = new MetierImpl(dao);
        metier.setDao(dao); // Ici on a une Injection des dépendances //
        System.out.println("Le résultat est :" + metier.calcul());
    }
}
