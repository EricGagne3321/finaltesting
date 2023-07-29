package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Category;
import models.Role;
import models.Item;

public class ItemDB {
    public List<Item> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<Item> items = em.createNamedQuery("Item.findAll", Item.class).getResultList();
            return items;
        } finally {
            em.close();
        }
    }
    
    public Item get(int itemId) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Item item = em.find(Item.class, itemId);
            return item;
        } finally {
            em.close();
        }
    }
    
    public void insert(Item item) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            Category c = item.getCategory();
            c.getItemList().add(item);
            
            trans.begin();
            em.persist(item);
            em.merge(c);
            trans.commit();
        } catch(Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
    public void update(Item item) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(item);
            trans.commit();
        } catch(Exception ex) {
            trans.rollback();
        } finally {
              em.close();
        }
    }
    
    public void delete(Item item) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            // Have to do this because we are inserting into the many side
            Category c = item.getCategory();
            c.getItemList().remove(item);
            
            trans.begin();
            em.remove(em.merge(item));
            em.merge(c);
            trans.commit();
        } catch(Exception ex) {
            trans.rollback();
        } finally {
              em.close();
        }
    }
}
