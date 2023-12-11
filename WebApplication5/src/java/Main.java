import domain.EmployeService;
import domain.ServiceService;
import entities.Employe;
import util.HibernateUtil;
import entities.Service;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

    public static void main(String[] args) {
        ServiceService seviceService = new ServiceService();
       /* // Créer une instance de Service
        Service service = new Service();
        service.setCode("S1");
        service.setLibelle("Service 1");
        
        
        
        
        seviceService.create(service);
        */          // Valider la transaction
           

      

        // Fermer la SessionFactory (à la fin de l'application)
       // HibernateUtil.getSession().close();
        EmployeService es= new EmployeService();
        Employe e = new Employe();
        e.setNom("ali");
        e.setDateNaissance(new Date(100, 11, 12));
        e.setPhoto("photo1");
        e.setService(seviceService.find(0));
        e.setChef(null);

           Employe e1 = new Employe();
        e1.setNom("aalouiiii");
        e1.setDateNaissance(new Date(100, 11, 12));
        e1.setPhoto("photo1");
        e1.setService(seviceService.find(0));
        e1.setChef(null);
        e1.setChef(es.find(1));
        System.out.println(es.find(1));

    }
}
