package services;

import dataaccess.ItemDB;
import dataaccess.UserDB;
import java.util.List;
import models.Category;
import models.Item;
import models.User;

public class ItemService {
    public Item get(int id) throws Exception {
        ItemDB itemDB = new ItemDB();
        Item item = itemDB.get(id);
        return item;
    }
    
    public List<Item> getAll() throws Exception {
        ItemDB itemDB = new ItemDB();
        List<Item> items = itemDB.getAll();
        return items;
    }
    
    public void insert(String itemName, double price, int categoryId, String ownerEmail) throws Exception {
        Item item = new Item(0, itemName, price);
        CategoryService categoryService = new CategoryService();
        Category category = categoryService.get(categoryId);
        item.setCategory(category);
        
        UserDB userDB = new UserDB();
        User owner = userDB.get(ownerEmail);
        item.setOwner(owner);
        
        ItemDB itemDB = new ItemDB();
        itemDB.insert(item);
    }
    
    public void update(int itemId, String itemName, double price, int categoryId, String ownerEmail) throws Exception {
        ItemDB itemDB = new ItemDB();
        Item item = itemDB.get(itemId);
        item.setItemName(itemName);
        item.setPrice(price);
        
        CategoryService categoryService = new CategoryService();
        Category category = categoryService.get(categoryId);
        item.setCategory(category);
        
        UserDB userDB = new UserDB();
        User owner = userDB.get(ownerEmail);
        item.setOwner(owner);
        
        itemDB.update(item);
    }
    
    public void delete(int itemId) throws Exception {
        ItemDB itemDB = new ItemDB();
        Item item = itemDB.get(itemId);
        itemDB.delete(item);
    }
}
