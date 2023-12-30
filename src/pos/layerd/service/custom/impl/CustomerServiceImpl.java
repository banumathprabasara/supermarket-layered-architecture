/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layerd.service.custom.impl;

import java.util.ArrayList;
import pos.layerd.dao.DaoFactory;
import pos.layerd.dao.custom.CustomerDao;
import pos.layerd.dto.CustomerDto;
import pos.layerd.entity.CustomerEntity;
import pos.layerd.service.custom.CustomerService;

/**
 *
 * @author banumathprabasara
 */
public class CustomerServiceImpl implements CustomerService{
    
    CustomerDao customerDao = (CustomerDao)DaoFactory.getInstance().getDao(DaoFactory.DaoType.CUSTOMER);

    public String addCustomer(CustomerDto customerDto) throws Exception {
                
        CustomerEntity ce = new CustomerEntity(customerDto.getCustID(),
                customerDto.getTitle(),
                customerDto.getName(),
                customerDto.getDob(),
                customerDto.getSalary(),
                customerDto.getAddress(),
                customerDto.getCity(),
                customerDto.getProvince(),
                customerDto.getZip());
        
        if(customerDao.add(ce)){
            return "Successfully Added";
        }else{
            return "Fail";
        }
    }

    @Override
    public String updateCustomer(CustomerDto customerDto) throws Exception {
        
        CustomerEntity ce = new CustomerEntity(customerDto.getCustID(),
                customerDto.getTitle(),
                customerDto.getName(),
                customerDto.getDob(),
                customerDto.getSalary(),
                customerDto.getAddress(),
                customerDto.getCity(),
                customerDto.getProvince(),
                customerDto.getZip());
        
        if(customerDao.update(ce)){
            return "Successfully Updated";
        }else{
            return "Fail";
        }
    }

    @Override
    public String deleteCustomer(String id) throws Exception {
        if(customerDao.delete(id)){
            return "Successfully Delete";
        }else{
            return "Fail";
        }
    }

    @Override
    public CustomerDto getCustomer(String id) throws Exception {
        CustomerEntity entity = customerDao.get(id);
        return new CustomerDto(entity.getCustID(),
                entity.getTitle(),
                entity.getName(),
                entity.getDob(),
                entity.getSalary(),
                entity.getAddress(),
                entity.getCity(),
                entity.getProvince(),
                entity.getZip());
    }

    @Override
    public ArrayList<CustomerDto> getAllCustomer() throws Exception {
        ArrayList<CustomerDto> customerDtos = new ArrayList<>();
        ArrayList<CustomerEntity> customerEntitys = customerDao.getAll();
        
        for (CustomerEntity entity : customerEntitys) {
            CustomerDto customerDto =new CustomerDto(entity.getCustID(),
                    entity.getTitle(),
                    entity.getName(),
                    entity.getDob(),
                    entity.getSalary(),
                    entity.getAddress(),
                    entity.getCity(),
                    entity.getProvince(),
                    entity.getZip());
            
            customerDtos.add(customerDto);
            
        }
        return  customerDtos;
    }
    
}
 