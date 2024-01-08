package bo.custom;

import bo.SuperBo;
import dto.OrderDetailsDto;

import java.sql.SQLException;
import java.util.List;

public interface OrderDetailsBo extends SuperBo {
    List<OrderDetailsDto> allOrderDetails() throws SQLException, ClassNotFoundException;
}
