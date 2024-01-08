package bo;

import bo.custom.OrdersBo;
import bo.custom.impl.CustomerBoImpl;
import bo.custom.impl.ItemBoImpl;
import bo.custom.impl.OrderDetailsBoImpl;
import bo.custom.impl.OrdersBoImpl;
import dao.util.BoType;

public class BoFactory {

    private  static BoFactory boFactory;
    private  BoFactory(){

    }

    public static BoFactory getInstance(){
        return boFactory!= null ? boFactory:(boFactory = new BoFactory());
    }

    public <T extends  SuperBo>T getbo(BoType type){
        switch (type){
            case CUSTOMER: return  (T) new CustomerBoImpl();
            case ITEM: return (T) new ItemBoImpl();
            case ORDER:return (T) new OrdersBoImpl();
            case ORDER_DETAIL:return (T) new OrderDetailsBoImpl();

        }
        return null;
    }

}
