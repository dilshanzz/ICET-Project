package entity;

import dto.OrderDetailsDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor

@Data
@ToString
public class Orders {
    String orderId;
    String date;
    String customerId;
    private List<OrderDetails> list;

    public Orders(String orderId, String date, String customerId, List<OrderDetails> list) {
        this.orderId = orderId;
        this.date = date;
        this.customerId = customerId;
        this.list = list;
    }

    public Orders(String orderId, String date, String customerId) {
        this.orderId = orderId;
        this.date = date;
        this.customerId = customerId;

    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public OrderDetails getList() {
        return (OrderDetails) list;
    }

    public void setList(List<OrderDetails> list) {
        this.list = list;
    }
}
