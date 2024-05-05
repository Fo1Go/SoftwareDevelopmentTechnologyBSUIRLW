package com.RemoteFileManager.Repository;

import com.RemoteFileManager.Models.Catalogs;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.List;

public class CatalogRepository {
    private Session session;

    public CatalogRepository() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        session = factory.openSession();
    }

    public List<Catalogs> getAllCatalogs() {
        Query<Catalogs> query = session.createQuery("from catalogs", Catalogs.class);
        return query.getResultList();
    }

    public boolean addCatalog(Catalogs catalog) {
        try {
            session.beginTransaction();
            session.persist(catalog);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            session.getTransaction().rollback();
            return false;
        }
    }

    public boolean updateCatalog(Catalogs catalog) {
        try {
            Catalogs Catalogs = session.get(com.RemoteFileManager.Models.Catalogs.class, catalog.getId());
            Catalogs.setName(catalog.getName());
            session.beginTransaction();
            session.merge(Catalogs);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            session.getTransaction().rollback();
            return false;
        }
    }

    public boolean deleteCatalog(Catalogs catalog) {
        try {
            session.beginTransaction();
            session.remove(
                    session.get(Catalogs.class, catalog.getId())
            );
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            session.getTransaction().rollback();
            return false;
        }
    }
}
