package dto;

import entity.OrderDetails;

import java.util.List;


public class OrderDto {
    private String orderId;
    private String date;
    private String custId;
    private List<OrderDetailsDto> list;

    public OrderDto(String orderId, String date, String custId, List<OrderDetailsDto> list) {
        this.orderId = orderId;
        this.date = date;
        this.custId = custId;
        this.list = list;
    }


    public OrderDto(String orderId, String date, String custId) {
        this.orderId = orderId;
        this.date = date;
        this.custId = custId;
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

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public List<OrderDetailsDto> getList() {
        return list;
    }

    public void setList(List<OrderDetailsDto> list) {
        this.list = list;
    }
}
