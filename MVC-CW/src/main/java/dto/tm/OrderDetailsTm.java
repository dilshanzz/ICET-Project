package dto.tm;


import lombok.Getter;


public class OrderDetailsTm {
    private String odrId;
    private String date1;
    private String custoId;

    public OrderDetailsTm(String odrId, String date1, String custoId) {
        this.odrId = odrId;
        this.date1 = date1;
        this.custoId = custoId;
    }

    public String getOdrId() {
        return odrId;
    }

    public void setOdrId(String odrId) {
        this.odrId = odrId;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getCustoId() {
        return custoId;
    }

    public void setCustoId(String custoId) {
        this.custoId = custoId;
    }
}
