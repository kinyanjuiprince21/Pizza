package Shop.Controllers;


import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class PizzaController implements Initializable {


    public CheckBox ckbCheese,ckbPepperoni,chbSausage,chbPepper,chbOnion,chbAnchovies;
    public Label lblPizzaCost;


    public void updatePrice(CheckBox check) {
        double price = 0.50;
        double sum = 0;

//     To check whether a checkbox is checked or unchecked
        boolean checked = false;
//        increasing the price of the pizza when any of the toppings is checked
        if (check.isSelected()) {
            sum = Double.parseDouble(lblPizzaCost.getText()) + price;
            lblPizzaCost.setText(sum + "");
            checked = true;
        }
//        decreasing the price of the pizza by the price of the topping unchecked
        if (!checked) {
            double newSum = Double.parseDouble(lblPizzaCost.getText()) - price;
            lblPizzaCost.setText(newSum + "");
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        setting the initial $10 price of the pizza when any topping is not checked
        if(!(ckbCheese.isSelected() && ckbPepperoni.isSelected() && chbSausage.isSelected() && chbPepper.isSelected() && chbOnion.isSelected() && chbAnchovies.isSelected())) {
            lblPizzaCost.setText("10.00");
        }
        ckbCheese.setOnAction(e -> {
            updatePrice(ckbCheese);
        });
        ckbPepperoni.setOnAction(e -> {
            updatePrice(ckbPepperoni);
        });
        chbSausage.setOnAction(e -> {
            updatePrice(chbSausage);
        });
        chbPepper.setOnAction(e -> {
            updatePrice(chbPepper);
        });
        chbOnion.setOnAction(e -> {
            updatePrice(chbOnion);
        });
        chbAnchovies.setOnAction(e -> {
            updatePrice(chbAnchovies);
        });
    }
}
