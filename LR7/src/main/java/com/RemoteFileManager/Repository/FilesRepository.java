package com.RemoteFileManager.Repository;

import com.RemoteFileManager.Models.Files;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.List;

public class FilesRepository {
    private SessionFactory sessionFactory;
    private Session session;

    public FilesRepository() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        session = sessionFactory.openSession();
    }

    public List<Files> getAllFiles() {
        Query<Files> query = sessionFactory.getCurrentSession().createQuery("from files", Files.class);
        return query.getResultList();
    }

    public boolean addFile(Files file) {
        try {
            session.beginTransaction();
            session.persist(file);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            session.getTransaction().rollback();
            return false;
        }
    }

    public boolean updateFile(Files file) {
        try {
            Files files = session.get(Files.class, file.getId());
            files.setName(file.getName());
            files.setSize(file.getSize());
            session.beginTransaction();
            session.merge(files);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            session.getTransaction().rollback();
            return false;
        }
    }

    public boolean deleteFile(Files file) {
        try {
            session.beginTransaction();
            session.remove(
                    session.get(Files.class, file.getId())
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
