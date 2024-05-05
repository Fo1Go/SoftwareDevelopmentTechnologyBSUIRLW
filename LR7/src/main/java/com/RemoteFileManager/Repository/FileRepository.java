package com.RemoteFileManager.Repository;

import com.RemoteFileManager.Models.Files;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.List;

public class FileRepository {
    private Session session;

    public FileRepository() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        session = factory.openSession();
    }

    public List<Files> getAllFiles() {
        Query<Files> query = session.createQuery("from files", Files.class);
        return query.getResultList();
    }

    public boolean addFile(Files file) {
        try {
            session.beginTransaction();
            session.persist(file);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
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
            System.out.println("Error" + e.getMessage());
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
            System.out.println("Error" + e.getMessage());
            session.getTransaction().rollback();
            return false;
        }
    }
}
