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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IntroController implements Initializable {
    @FXML
    private Label welcome,warning,task1,task2,click;
    
    @FXML
    private void nextButtonAction(ActionEvent event){
        Logger logger =LoggerFactory.getLogger(IntroController.class);
        try{
        ((Node) (event.getSource())).getScene().getWindow().hide();
        
        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/Task.fxml"));
        Scene scene = new Scene(parent);                
        scene.getStylesheets().add("/styles/Styles.css");
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Első Feladat");
        stage.show();
        
        logger.info("Push the button.");
        }catch(IOException e){
            logger.error("error is ", e);
        }

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {       
        welcome.setText("Üdvözellek a kisállat oktató programba!");
        task1.setText("Az első feladat: 3 állatot\n ábrázoló képet a helyes\n helyre kell húzni.");
        task2.setText("A második feladat: különböző\n állításokra kell válaszolni\n"
                + " az előző feladatban megismert\n állatokhoz kapcsolódóan");
        warning.setText("Ha figyelmesen elolvastad az utasításokat akkor kezdődjön a teszt.");
        click.setText("Kattints a Tovább gombra!");
        
    }    
    
}
