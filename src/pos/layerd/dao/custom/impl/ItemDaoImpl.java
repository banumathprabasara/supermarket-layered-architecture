/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layerd.dao.custom.impl;

import java.util.ArrayList;
import pos.layerd.dao.CrudUtil;
import pos.layerd.dao.custom.ItemDao;
import pos.layerd.entity.ItemEntity;
import java.sql.ResultSet;

/**
 *
 * @author banumathprabasara
 */
public class ItemDaoImpl implements ItemDao{

    @Override
    public boolean add(ItemEntity t) throws Exception {
        return CrudUtil.executUpdate("INSERT INTO Item VALUES(?,?,?,?,?)", 
                t.getItemCode(),
                t.getDescription(),
                t.getPackSize(),
                t.getUnitPrize(),
                t.getQoh());
    }

    @Override
    public boolean update(ItemEntity t) throws Exception {
        return CrudUtil.executUpdate("UPDATE Item SET Description=?, PackSize=?, UnitPrice=?, QtyOnHand=? WHERE ItemCode=?", 
                t.getDescription(),
                t.getPackSize(),
                t.getUnitPrize(),
                t.getQoh(),
                t.getItemCode());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executUpdate("DELETE FROM Item WHERE ItemCode=?", id);
    }

    @Override
    public ItemEntity get(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * from Item WHERE ItemCode = ?", id);
        
        while (rst.next()) {            
            return  new ItemEntity(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDouble(4),
                    rst.getInt(5));
            
        }
        return null;
    }

    @Override
    public ArrayList<ItemEntity> getAll() throws Exception {
        ArrayList<ItemEntity> itemEntitys = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("Select * from Item ");
        
        while (rst.next()) {            
            ItemEntity entity = new ItemEntity(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDouble(4),
                    rst.getInt(5));
            
            itemEntitys.add(entity);
            
        }
        return itemEntitys;
    }
    
}
