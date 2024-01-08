package dto;


public class ItemDto {
    private String code;
    private String des;
    private double unitPrice;
    private int qty;

    public ItemDto(String code, String des, double unitPrice, int qty) {
        this.code = code;
        this.des = des;
        this.unitPrice = unitPrice;
        this.qty = qty;
    }

    public ItemDto() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return des;
    }

    public void setDesc(String des) {
        this.des = des;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
