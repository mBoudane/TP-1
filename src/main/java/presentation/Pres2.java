package presentation;


import dao.IDao;
import metier.IMetier;


import java.io.File;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Pres2 {
    public static void main(String[] args) throws Exception{
        // DaoImpl dao = new DaoImpl(); //

        Scanner scan;
        scan = new Scanner(new File("config.txt"));
        String daoClassName=scan.nextLine();
        Class<?> cDao = Class.forName(daoClassName);
        IDao dao = (IDao) cDao.getConstructor().newInstance(); // => new DaoImpl //
        System.out.println(dao.getData());

        //* MetierImpl metier = new MetierImpl();//
        String metierClassName = scan.nextLine();
        Class<?> cMetier = Class.forName(metierClassName);
        IMetier metier = (IMetier) cMetier.getConstructor(IDao.class).newInstance(dao);

        // metier.setDao(dao); //
        Method setDao = cMetier.getDeclaredMethod("setDao", IDao.class);
        setDao.invoke(metier,dao); // => Injection des dépendances dynamique //
        System.out.println("RES est : " + metier.calcul());
   }
}
