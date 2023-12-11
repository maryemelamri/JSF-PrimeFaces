/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractFacade;


import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author casper
 */
public abstract class AbstractFacade<T> {

    protected abstract Class<T> getEntityClass();

    // Utilisez cette méthode pour obtenir le nom de la classe d'entité (pour la requête HQL)
    private String getEntityClassName() {
        return getEntityClass().getSimpleName();
    }

    // Méthode pour ajouter une entité à la base de données
    public void create(T entity) {
        // Implémenter la logique de création ici
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
            System.out.println("done Create ");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.out.println("Rolling back ");

            session.getTransaction().rollback();
        } finally {
            System.out.println("close time");

            if (session != null) {
                session.close();
            }
        }
    }

    // Méthode pour mettre à jour une entité dans la base de données
    public void edit(T entity) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.out.println("Rolling back transaction.");
        } finally {
            System.out.println("close time");

            if (session != null) {
                session.close();
            }
        }
    }

    // Méthode pour supprimer une entité de la base de données
    public void remove(T entity) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
            System.out.println("done remove ");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.out.println("Rolling back transaction.");
        } finally {
            System.out.println("close time");

            if (session != null) {
                session.close();
            }
        }
    }

    // Méthode pour rechercher une entité par son identifiant
    public T find(int id) {
         Session session = null;
          try  {  session = HibernateUtil.getSession();
            return (T) session.get(getEntityClass(), id);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    // Méthode pour obtenir toutes les entités de la base de données
    public List<T> findAll() {
        List<T> entities =null;
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        entities = session.createQuery("from " + getEntityClassName()).list();
        session.getTransaction().commit();
        return entities;
    }

    // Méthode pour obtenir une liste d'entités à partir d'une plage donnée
    public List<T> findRange(int[] range) {
        // Implémenter la logique pour récupérer une plage d'entités ici
        return null;
    }

    // Méthode pour obtenir le nombre total d'entités dans la base de données
    public int count() {
        // Implémenter la logique pour compter le nombre total d'entités ici
        return 0;
    }
}
