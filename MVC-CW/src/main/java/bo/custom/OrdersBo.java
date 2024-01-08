package bo.custom;

import bo.SuperBo;
import dto.ItemDto;
import dto.OrderDto;

import java.sql.SQLException;
import java.util.List;

public interface OrdersBo extends SuperBo {
    boolean saveOrder (OrderDto dto) throws SQLException, ClassNotFoundException;

    List<OrderDto> allOrders() throws SQLException, ClassNotFoundException;

}
