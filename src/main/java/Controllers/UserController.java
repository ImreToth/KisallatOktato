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

import Model.WriteJson;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserController {
    private Logger logger;
    @FXML
    private TextField username;

    @FXML
    void DoneButton(ActionEvent event){
        logger = LoggerFactory.getLogger(ResultController.class);
        try {
            WriteJson wr = new WriteJson(username.getText(),
                    Task2Controller.result.getPoints(),
                    Task2Controller.result.Rating(Task2Controller.result.getPoints()));

            ((Node) (event.getSource())).getScene().getWindow().hide();

            Parent parent = FXMLLoader.load(getClass().getResource("/fxml/Result.fxml"));
            Scene scene = new Scene(parent);
            scene.getStylesheets().add("/styles/Styles.css");
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Felhasználó");
            stage.show();
        }catch(IOException | ParseException e){
            logger.error("error is ", e);
        }
    }
}
