package dao.custom;

import dao.CrudDao;
import dao.SuperDao;
import dto.OrderDetailsDto;
import entity.OrderDetails;

import java.sql.SQLException;
import java.util.List;

public interface OrderDetailsDao extends CrudDao<OrderDetails> {

    boolean saveOrderDetails(List<OrderDetailsDto> list) throws SQLException, ClassNotFoundException;

}
