package dao;

import dao.custom.OrderDao;
import dao.impl.CustomerDaoImpl;
import dao.impl.ItemDaoImpl;
import dao.impl.OrderDaoImpl;
import dao.impl.OrderDetailsDaoImpl;
import dao.util.DaoType;

import static dao.util.BoType.CUSTOMER;

public class DaoFactory {

    private  static DaoFactory daoFactory;
    private DaoFactory(){

    }
    public static DaoFactory getInstance(){
        return daoFactory!= null ? daoFactory :(daoFactory = new DaoFactory());

    }
    public <T extends SuperDao>T getDao(DaoType type){
        switch (type){
            case CUSTOMER: return (T) new CustomerDaoImpl();
            case ITEM: return (T) new ItemDaoImpl();
            case ORDER: return (T) new OrderDaoImpl();
            case ORDER_DETAIL:return (T) new OrderDetailsDaoImpl();
        }
        return null;
    }

}
