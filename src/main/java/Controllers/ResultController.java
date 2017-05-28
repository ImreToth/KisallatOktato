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
package Controllers;

import Model.ReadJson;
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
import javafx.stage.Stage;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResultController implements Initializable {
    private Logger logger = LoggerFactory.getLogger(ResultController.class);
    private final String filePath = System.getProperty("user.home") + "/.Kisallatoktato/Users.json";
    
    @FXML
    private Label ownresult, allusername, allpoint, allrating;

    @FXML
    private void quit(ActionEvent event) {
        Runtime.getRuntime().exit(0);
    }

    @FXML
    private void replay(ActionEvent event) {
        try {
            ((Node) (event.getSource())).getScene().getWindow().hide();

            Parent parent = FXMLLoader.load(getClass().getResource("/fxml/Intro.fxml"));
            Scene scene = new Scene(parent);
            scene.getStylesheets().add("/styles/Styles.css");
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Második Feladat");
            stage.show();

            logger.info("Push the button.");
        } catch (IOException e) {
            logger.error("error is ", e);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            ReadJson r = new ReadJson(filePath);
            allrating.setText(r.getAllRating());
            allpoint.setText(r.getAllPoint());
            allusername.setText(r.getAllUsername());
            ownresult.setText(r.getCurrentUsername() + " Eredménye: Pont: "
                    + String.valueOf(r.getCurrentPoint()) + "\t Értékelés: "
                    + r.getCurrentRating());

            logger.info("Initialize the window details.");
        } catch (IOException | ParseException ex) {
            logger.error("error is ", ex);
        }
        allrating.setStyle("-fx-border-color: black;");
        allpoint.setStyle("-fx-border-color: black;");
        allusername.setStyle("-fx-border-color: black;");

    }

}
