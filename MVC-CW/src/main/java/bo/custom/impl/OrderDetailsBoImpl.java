package bo.custom.impl;

import bo.custom.OrderDetailsBo;
import dao.DaoFactory;
import dao.custom.OrderDetailsDao;
import dao.util.DaoType;
import dto.OrderDetailsDto;
import entity.OrderDetails;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class OrderDetailsBoImpl implements OrderDetailsBo {

    private OrderDetailsDao orderDetailsDao = DaoFactory.getInstance().getDao(DaoType.ORDER_DETAIL);

    @Override
    public List<OrderDetailsDto> allOrderDetails() throws SQLException, ClassNotFoundException {
        List<OrderDetails> entityList = orderDetailsDao.getAll();
        List<OrderDetailsDto> list = new ArrayList<>();
        for(OrderDetails orderDetails : entityList){
            list.add(new OrderDetailsDto(
                    orderDetails.getOrderId(),
                    orderDetails.getItemCode(),
                    orderDetails.getQty(),
                    orderDetails.getUnitPrice()

            ));
        }
        return list;
    }
}
