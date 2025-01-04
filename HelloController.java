package com.example.airlinereservation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class HelloController implements Initializable {

    @FXML
    private AnchorPane main_form;
    @FXML
    private TextField usertextfield;
    @FXML
    private PasswordField passfield;
    @FXML
    private Button closebutton;
    @FXML
    private Button login;

    // Second window controls
    @FXML
    private ComboBox<String> arrival;
    @FXML
    private ComboBox<String> dep;
    @FXML
    private ComboBox<String> disability;
    @FXML
    private ComboBox<String> gender;
    @FXML
    private Button bookflight;
    @FXML
    private AnchorPane flightinfo;
    @FXML
    private Button nextbutton;
    @FXML
    private AnchorPane passengerinfo;
    @FXML
    private AnchorPane intro_form;
    @FXML
    private AnchorPane intro_form2;
    @FXML
    private Button finish;
    @FXML
    private AnchorPane main2_form;


    private final ObservableList<String> defgender = FXCollections.observableArrayList("Male", "Female");
    private final ObservableList<String> isdisable = FXCollections.observableArrayList("Yes", "No");
    private final ObservableList<String> departureairports = FXCollections.observableArrayList(
            "Cairo International Airport (CAI)", "Hurghada International Airport (HRG)",
            "Sharm El Sheikh International Airport (SSH)", "Luxor International Airport (LXR)", "Borg El Arab Airport (HBE)");
    ObservableList<String> arrivalairports = FXCollections.observableArrayList(
            "Bahrain International Airport (BAH)", "Baghdad International Airport (BGW)",
            "Queen Alia International Airport (AMM)", "Kuwait International Airport (KWI)",
            "Beirut Rafic Hariri International Airport (BEY)", "Mitiga International Airport (MJI)",
            "Nouakchott–Oumtounsy International Airport (NKC)", "Mohammed V International Airport (CMN)",
            "Muscat International Airport (MCT)", "Hamad International Airport (DOH)",
            "King Khalid International Airport (RUH)", "King Abdulaziz International Airport (JED)",
            "Prince Mohammad bin Abdulaziz International Airport (MED)", "King Fahd International Airport (DMM)",
            "Mogadishu Aden Adde International Airport (MGQ)", "Khartoum International Airport (KRT)",
            "Damascus International Airport (DAM)", "Tunis–Carthage International Airport (TUN)", "Dubai International Airport (DXB)",
            "Abu Dhabi International Airport (AUH)", "Sharjah International Airport (SHJ)", "Sana'a International Airport (SAH)");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            if (gender != null) {
                gender.setItems(defgender);
                disability.setItems(isdisable);
                dep.setItems(departureairports);
                arrival.setItems(arrivalairports);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    public void continue11(ActionEvent event) {
        try {
            // Validate input
            if (usertextfield.getText().isEmpty() || passfield.getText().isEmpty()) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
                return;
            }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard2.fxml"));
            Parent root = loader.load();
            Stage dashboardStage = new Stage();
            dashboardStage.setTitle("Airline Booking System");
            dashboardStage.setScene(new Scene(root));
            ((Stage) login.getScene().getWindow()).close();
            dashboardStage.show();
            dashboardStage.setOnCloseRequest(e -> {
                e.consume();
                close(dashboardStage);
            });

        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Loading Error");
            alert.setContentText("Could not load dashboard: " + e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    public void close() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("EXIT");
        alert.setHeaderText("Are you sure you want to exit?");
        alert.setContentText("Do you want to save before exiting?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            Stage stage = (Stage) main_form.getScene().getWindow();
            stage.close();
        }
    }

    public void close(Stage stage) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("EXIT");
        alert.setHeaderText("Are you sure you want to exit?");
        alert.setContentText("Do you want to save before exiting?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            System.out.println("You exited the program.");
            stage.close();
        }
    }
    public void switchForm(ActionEvent event) {
        if (event.getSource() == bookflight) {
            passengerinfo.setVisible(true);
            flightinfo.setVisible(false);
            intro_form.setVisible(false);
            intro_form2.setVisible(false);
        }
    }
    @FXML
        void headtoflightinfo(ActionEvent event) {
        if (event.getSource() == nextbutton) {
            flightinfo.setVisible(true);
            passengerinfo.setVisible(false);
            intro_form.setVisible(false);
            intro_form2.setVisible(false);
        }
        }
    public void close2b(ActionEvent actionEvent) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("EXIT");
        alert.setHeaderText("Are you sure you want to exit?");
        alert.setContentText("Do you want to save before exiting?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            Stage stage = (Stage) main_form.getScene().getWindow();
            stage.close();
        }
    }
}