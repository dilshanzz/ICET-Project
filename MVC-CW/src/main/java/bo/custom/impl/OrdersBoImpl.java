package bo.custom.impl;

import bo.BoFactory;
import bo.custom.OrdersBo;
import dao.DaoFactory;
import dao.custom.OrderDao;
import dao.util.BoType;
import dao.util.DaoType;
import dto.ItemDto;
import dto.OrderDto;
import entity.Item;
import entity.Orders;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdersBoImpl implements OrdersBo {

    private OrderDao ordersDao = DaoFactory.getInstance().getDao(DaoType.ORDER);


    @Override
    public boolean saveOrder(OrderDto dto) throws SQLException, ClassNotFoundException {
        return ordersDao.save(new Orders(
                dto.getOrderId(),
                dto.getDate(),
                dto.getCustId()

        ));
    }

    @Override
    public List<OrderDto> allOrders() throws SQLException, ClassNotFoundException {
        List<Orders> entityList = ordersDao.getAll();
        List<OrderDto> list = new ArrayList<>();
        for(Orders order : entityList){
            list.add(new OrderDto(
                    order.getOrderId(),
                    order.getDate(),
                    order.getCustomerId()

            ));
        }
        return list;

    }
}
