package dto.tm;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.scene.control.Button;


public class ItemTm extends RecursiveTreeObject<ItemTm> {
    private String code;
    private String des;
    private double up;
    private int qty;
    private JFXButton btn;

    public ItemTm(String code, String des, double up, int qty, JFXButton btn) {
        this.code = code;
        this.des = des;
        this.up = up;
        this.qty = qty;
        this.btn = btn;
    }
    public ItemTm(String code, String des, double up, int qty ){
        this.code = code;
        this.des = des;
        this.up = up;
        this.qty = qty;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public double getUp() {
        return up;
    }

    public void setUp(double up) {
        this.up = up;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public JFXButton getBtn() {
        return btn;
    }

    public void setBtn(JFXButton btn) {
        this.btn = btn;
    }
}
