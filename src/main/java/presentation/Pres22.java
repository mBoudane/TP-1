package presentation;


import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Pres22 {
    public static void main(String[] args) throws Exception{
        // DaoImpl dao = new DaoImpl(); //

        Scanner scan;
        scan = new Scanner(System.in);
        System.out.print("Donner la classe de la couche DAO:" );
        String daoClassName=scan.nextLine();
        Class<?> cDao = Class.forName(daoClassName);
        IDao dao = (IDao) cDao.getConstructor().newInstance(); // => new DaoImpl //
        System.out.println(dao.getData());

        //* MetierImpl metier = new MetierImpl();//
        System.out.print("Donner la classe de la couche METIER:" );
        String metierClassName = scan.nextLine();
        Class<?> cMetier = Class.forName(metierClassName);
        IMetier metier = (IMetier) cMetier.getConstructor().newInstance();

        // metier.setDao(dao); //
        Method setDao = cMetier.getDeclaredMethod("setDao", IDao.class);
        setDao.invoke(metier,dao); // => Injection des dépendances dynamique //
        System.out.println("RES est : " + metier.calcul());
   }
}
