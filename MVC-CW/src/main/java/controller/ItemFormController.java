package controller;

import bo.BoFactory;
import bo.custom.ItemBo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dao.util.BoType;
import dto.ItemDto;
import dto.tm.ItemTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import dao.custom.ItemDao;
import dao.impl.ItemDaoImpl;


import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class ItemFormController {

    @FXML
    private JFXTextField codeTxt;

    @FXML
    private JFXTextField desTxt;

    @FXML
    private JFXTextField upTxt;

    @FXML
    private JFXTextField qtyTxt;

    @FXML
    private TableView<ItemTm> tblItem;

    @FXML
    private TableColumn colCode;

    @FXML
    private TableColumn colDesc;

    @FXML
    private TableColumn colUnitPrice;

    @FXML
    private TableColumn colQty;

    @FXML
    private TableColumn colOption;

    @FXML
    private JFXButton updateBtn;

    private ItemBo itemBo = BoFactory.getInstance().getbo(BoType.ITEM);

    public void initialize() {
        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colDesc.setCellValueFactory(new PropertyValueFactory<>("des"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("up"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("btn"));
        loadItemTable();
        tblItem.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            setData( newValue);

     });
    }
    private void setData(ItemTm newValue) {
        if(newValue!=null){
            codeTxt.setEditable(false);
            codeTxt.setText(newValue.getCode());
            desTxt.setText(newValue.getDes());
            upTxt.setText(String.valueOf(newValue.getUp()));
            qtyTxt.setText(String.valueOf(newValue.getQty()));
        }
    }

    private void loadItemTable() {
        ObservableList<ItemTm> tmList1 = FXCollections.observableArrayList();
        try {
            List<ItemDto> dtoList = itemBo.allItems();
            for (ItemDto dto:dtoList) {
                JFXButton btn = new JFXButton("Delete");

                ItemTm i = new ItemTm(
                        dto.getCode(),
                        dto.getDesc(),
                        dto.getUnitPrice(),
                        dto.getQty(),
                        btn
                );
                btn.setOnAction(actionEvent -> {
                    deleteItem(i.getCode());
                });

                tmList1.add(i);
            }

            tblItem.setItems(tmList1);
        } catch (
        SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void deleteItem(String code) {
        try {
            boolean isDeleted = itemBo.deleteItem(code);
            if (isDeleted) {
                new Alert(Alert.AlertType.INFORMATION, "Item Deleted!").show();
                loadItemTable();
            } else {
                new Alert(Alert.AlertType.ERROR, "Something went wrong!").show();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }




    public void updateBtnOnAction(javafx.event.ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try{
            boolean isUpdated = itemBo.updateItem(new ItemDto(
                    codeTxt.getText(),
                    desTxt.getText(),
                    Double.parseDouble(upTxt.getText()),
                    Integer.parseInt(qtyTxt.getText())

            ));
            if (isUpdated){
                new Alert(Alert.AlertType.INFORMATION,"Item Updated!").show();
                loadItemTable();

            }
        } catch (SQLException e) {
            e.printStackTrace(); // log or handle the exception appropriately
            throw e; // rethrow the exception if needed
        }
    }


    public void saveBtnOnaction(javafx.event.ActionEvent actionEvent) {
        try {
            boolean isSaved = itemBo.saveItem(new ItemDto(
                    codeTxt .getText(),
                    desTxt.getText(),
                    Double.parseDouble(upTxt.getText()) ,
                    Integer.parseInt(qtyTxt.getText())
            ));

            if (isSaved){
                new Alert(Alert.AlertType.INFORMATION,"Item Saved!").show();
                loadItemTable();
                //clearFields();
            }

        } catch (SQLIntegrityConstraintViolationException ex){
            new Alert(Alert.AlertType.ERROR,"Duplicate Entry").show();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void backBtnOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) tblItem.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/DashboardForm.fxml"))));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


