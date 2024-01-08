package controller;

import bo.BoFactory;
import bo.custom.OrderDetailsBo;
import dao.DaoFactory;
import dao.custom.OrderDetailsDao;
import dao.impl.OrderDetailsDaoImpl;
import dao.util.BoType;
import dao.util.DaoType;
import dto.OrderDetailsDto;
import dto.tm.OrdersTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class OrderFormController {

    @FXML
    private TableView<OrdersTm> ordertbl;

    @FXML
    private TableColumn<?, ?> orderIDCol;

    @FXML
    private TableColumn<?, ?> itemCODeCol;

    @FXML
    private TableColumn<?, ?> itmQtyCol;

    @FXML
    private TableColumn<?, ?> uPriceCol;
    private OrderDetailsBo orderDetailsBo = BoFactory.getInstance().getbo(BoType.ORDER_DETAIL);

    public void initialize() {
        orderIDCol.setCellValueFactory(new PropertyValueFactory<>("odrId"));
        itemCODeCol.setCellValueFactory(new PropertyValueFactory<>("code"));
        itmQtyCol.setCellValueFactory(new PropertyValueFactory<>("qty"));
        uPriceCol.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));

        loadOrderTable();

    }
    public void backBtnOnAction (ActionEvent actionEvent){
        Stage stage = (Stage) ordertbl.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/DashboardForm.fxml"))));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void loadOrderTable() {
        ObservableList<OrdersTm> tmList = FXCollections.observableArrayList();
        try {
            List<OrderDetailsDto> dtoList = orderDetailsBo.allOrderDetails();
            for (OrderDetailsDto dto:dtoList) {
                OrdersTm od = new OrdersTm(
                        dto.getOrderId(),
                        dto.getItemCode(),
                        dto.getQty(),
                        dto.getUnitPrice()
                );
                tmList.add(od);
            }

            ordertbl.setItems(tmList);
        } catch (
                SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
