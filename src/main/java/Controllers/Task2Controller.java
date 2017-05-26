/**
 * Kisallatoktato
 * Copyright (C) 2017  University of Debrecen
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.Pictures;
import Model.Result;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Task2Controller implements Initializable {

    public static Result result = new Result();
    Pictures pic = new Pictures();
    private Logger logger;

    @FXML
    private ImageView swallow_pic, ladybird_pic, cat_pic;

    @FXML
    private Label Info;

    @FXML
    private RadioButton t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12;

    @FXML
    void setOnMouseEntered(MouseEvent event) {
        ImageView target = (ImageView) event.getTarget();
        if (target.getImage() == swallow_pic.getImage()) {
            Info.setText(pic.getSwallow_info());
        } else if (target.getImage() == cat_pic.getImage()) {
            Info.setText(pic.getCat_info());
        } else if (target.getImage() == ladybird_pic.getImage()){
            Info.setText(pic.getLadybird_info());
        }
    }

    @FXML
    void setOnMouseExited(MouseEvent event) {
        Info.setText(" ");
    }

    @FXML
    void CheckButton(ActionEvent event){
        if (t1.isSelected()) {
            result.AddPoint(1);
        }
        if (t2.isSelected()) {
            result.AddPoint(1);
        }
        if (t3.isSelected()) {
            result.AddPoint(1);
        }
        if (t4.isSelected()) {
            result.AddPoint(1);
        }
        if (t5.isSelected()) {
            result.AddPoint(1);
        }
        if (t6.isSelected()) {
            result.AddPoint(1);
        }
        if (t7.isSelected()) {
            result.AddPoint(1);
        }
        if (t8.isSelected()) {
            result.AddPoint(1);
        }
        if (t9.isSelected()) {
            result.AddPoint(1);
        }
        if (t10.isSelected()) {
            result.AddPoint(1);
        }
        if (t11.isSelected()) {
            result.AddPoint(1);
        }
        if (t12.isSelected()) {
            result.AddPoint(1);
        }
        logger = LoggerFactory.getLogger(Task2Controller.class);
        try{
        ((Node) (event.getSource())).getScene().getWindow().hide();

        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/User.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Oktat? Program");
        stage.show();
        }catch(IOException e){
            logger.error("error is ", e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        swallow_pic.setImage(new Image(getClass().getResource(pic.getSwallow()).toExternalForm(),200, 200, true, true));
        ladybird_pic.setImage(new Image(getClass().getResource(pic.getLadybird()).toExternalForm(),200, 200, true, true));
        cat_pic.setImage(new Image(getClass().getResource(pic.getCat()).toExternalForm(),200, 200, true, true));
        Info.setStyle("-fx-border-color: black;");
    }

}
