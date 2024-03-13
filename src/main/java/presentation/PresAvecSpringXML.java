package presentation;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresAvecSpringXML {
    public static void main(String[] args) {
        ApplicationContext Springcontext = new ClassPathXmlApplicationContext("config.xml");
        IMetier metier = Springcontext.getBean(IMetier.class);
        System.out.println("Resultat :" + metier.calcul());
    }
}
