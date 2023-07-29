package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Role;
import models.User;


public class UserDB {
    public List<User> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<User> users = em.createNamedQuery("User.findAll", User.class).getResultList();
            return users;
        } finally {
            em.close();
        }
    }
    
    public User get(String email) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            User u = em.find(User.class, email);
            return u;
        } finally {
            em.close();
        }
    }
    
    public void insert(User user) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            Role r = user.getRole();
            r.getUserList().add(user);
            
            trans.begin();
            em.persist(user);
            em.merge(r);
            trans.commit();
        } catch(Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
    public void update(User user) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(user);
            trans.commit();
        } catch(Exception ex) {
            trans.rollback();
        } finally {
              em.close();
        }
    }
    
    public void delete(User user) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            // Have to do this because we are inserting into the many side
            Role r = user.getRole();
            r.getUserList().remove(user);
            
            trans.begin();
            em.remove(em.merge(user));
            em.merge(r);
            trans.commit();
        } catch(Exception ex) {
            trans.rollback();
        } finally {
              em.close();
        }
    }
}
