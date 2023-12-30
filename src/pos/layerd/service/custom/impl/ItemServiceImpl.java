/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layerd.service.custom.impl;

import java.util.ArrayList;
import pos.layerd.dao.DaoFactory;
import pos.layerd.dao.custom.ItemDao;
import pos.layerd.dto.ItemDto;
import pos.layerd.entity.ItemEntity;
import pos.layerd.service.custom.ItemService;

/**
 *
 * @author banumathprabasara
 */
public class ItemServiceImpl implements ItemService{
    
    ItemDao itemDao =(ItemDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.ITEM);

    @Override
    public String addItem(ItemDto itemDto) throws Exception {
        if(itemDao.add(new ItemEntity(itemDto.getItemCode(),
                itemDto.getDescription(),
                itemDto.getPackSize(),
                itemDto.getUnitPrize(),
                itemDto.getQoh()))){
            return "Successfully Saved";
        }else{
            return "Fail";
        }
    }

    @Override
    public String updateItem(ItemDto itemDto) throws Exception {
        if(itemDao.update(new ItemEntity(itemDto.getItemCode(),
                itemDto.getDescription(),
                itemDto.getPackSize(),
                itemDto.getUnitPrize(),
                itemDto.getQoh()))){
            return "Successfully Saved";
        }else{
            return "Fail";
        }
    }

    @Override
    public String deleteItem(String id) throws Exception {
        if(itemDao.delete(id)){
            return "Successfully Deleted";
        }else{
            return "Fail";
        } 
    }

    @Override
    public ItemDto getItem(String id) throws Exception {
        ItemEntity entity = itemDao.get(id);
        return new ItemDto(entity.getItemCode(),
                entity.getDescription(),
                entity.getPackSize(),
                entity.getUnitPrize(),
                entity.getQoh());
    }

    @Override
    public ArrayList<ItemDto> getAllItem() throws Exception {
        ArrayList<ItemDto> itemDtos = new ArrayList<>();
        
        ArrayList<ItemEntity> itemEntitys = itemDao.getAll();
        for(ItemEntity entity : itemEntitys){
            ItemDto itemDto = new ItemDto(entity.getItemCode(),
                    entity.getDescription(),
                    entity.getPackSize(),
                    entity.getUnitPrize(),
                    entity.getQoh());
            itemDtos.add(itemDto);
        }
        return itemDtos;
    }
    
}
