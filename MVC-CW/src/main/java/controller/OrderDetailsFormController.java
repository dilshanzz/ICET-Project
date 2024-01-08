package controller;

import bo.BoFactory;
import bo.custom.OrdersBo;
import dao.util.BoType;
import dto.OrderDto;
import dto.tm.OrderDetailsTm;
import entity.Orders;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import dao.custom.OrderDao;
import dao.impl.OrderDaoImpl;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class OrderDetailsFormController {

    @FXML
    private TableView<OrderDetailsTm> odrTable;

    @FXML
    private TableColumn<OrderDetailsTm, String> odrIDColumn;

    @FXML
    private TableColumn<OrderDetailsTm, String> date1Column;

    @FXML
    private TableColumn<OrderDetailsTm, String> custIdColumn;

    @FXML
    private TableView<?> ItemsTable;

    @FXML
    private TableColumn<?, ?> itmCodeColumn;

    @FXML
    private TableColumn<?, ?> itemDescColumn;

    @FXML
    private TableColumn<?, ?> uPriceColumn1;

    @FXML
    private TableColumn<?, ?> itmQtyColumn;

    @FXML
    private TableColumn<?, ?> itemAmountColumn;

    @FXML
    private TableColumn<?, ?> date2Column;
    private OrdersBo orderBo = BoFactory.getInstance().getbo(BoType.ORDER);

    public void initialize() {
        odrIDColumn.setCellValueFactory(new PropertyValueFactory<OrderDetailsTm, String>("odrId"));
        date1Column.setCellValueFactory(new PropertyValueFactory<OrderDetailsTm, String>("date1"));
        custIdColumn.setCellValueFactory(new PropertyValueFactory<OrderDetailsTm, String>("custoId"));
        loadOrderTable();

    }
    private void loadOrderTable() {
        ObservableList<OrderDetailsTm> tmList = FXCollections.observableArrayList();
        try {
            List<OrderDto> dtoList = orderBo.allOrders();
            for (OrderDto order:dtoList) {
                OrderDetailsTm od = new OrderDetailsTm(
                        order.getOrderId(),
                        order.getDate(),
                        order.getCustId()
                );
                tmList.add(od);
            }

            odrTable.setItems(tmList);
        } catch (
                SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void backBtnOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) odrTable.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/DashboardForm.fxml"))));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


