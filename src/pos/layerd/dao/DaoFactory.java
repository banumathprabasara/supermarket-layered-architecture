/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layerd.dao;

import pos.layerd.dao.custom.impl.CustomerDaoImpl;
import pos.layerd.dao.custom.impl.ItemDaoImpl;

/**
 *
 * @author banumathprabasara
 */
public class DaoFactory {

    private static DaoFactory daoFactory;

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }

    public SuperDao getDao(DaoType type) {
        switch (type) {
            case CUSTOMER:

                return new CustomerDaoImpl();
            case ITEM:

                return new ItemDaoImpl();
            default:
                return null;
        }
    }

    public enum DaoType {
        CUSTOMER, ITEM
    }

}
