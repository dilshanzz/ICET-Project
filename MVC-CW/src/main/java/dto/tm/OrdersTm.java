package dto.tm;

public class OrdersTm {
    private String odrId;
    private String code;
    private int qty;
    private double unitPrice;

    public OrdersTm() {

    }
    public OrdersTm(String odrId, String code, int qty, double unitPrice) {
        this.odrId = odrId;
        this.code = code;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public String getOdrId() {
        return odrId;
    }

    public void setOdrId(String odrId) {
        this.odrId = odrId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
