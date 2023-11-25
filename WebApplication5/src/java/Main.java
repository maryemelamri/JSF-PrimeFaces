import domain.ServiceService;
import util.HibernateUtil;
import entities.Service;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

    public static void main(String[] args) {
ServiceService seviceService = new ServiceService(null);
        // Créer une instance de Service
        Service service = new Service();
        service.setCode("S1");
        service.setLibelle("Service 1");

      

     
         seviceService.create(service);
            // Valider la transaction
           

      

        // Fermer la SessionFactory (à la fin de l'application)
       // HibernateUtil.getSession().close();
    }
}
