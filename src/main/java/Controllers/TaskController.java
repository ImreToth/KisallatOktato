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

import Model.Pictures;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskController implements Initializable {

    Pictures pic = new Pictures();
    private Logger logger = LoggerFactory.getLogger(ResultController.class);

    @FXML
    private Button check;

    @FXML
    private ImageView swallow_pic, ladybird_pic, cat_pic, Task1, Task2, Task3;

    @FXML
    private Label Text;

    private boolean compareImage(Image target, Image source) {
        for (int i = 0; i < target.getWidth(); i++) {
            for (int j = 0; j < target.getHeight(); j++) {
                if (target.getPixelReader().getArgb(i, j) != source.getPixelReader().getArgb(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    @FXML
    private void checkButtonAction(ActionEvent event) {
        if (compareImage(Task1.getImage(), ladybird_pic.getImage())
                && compareImage(Task2.getImage(), cat_pic.getImage())
                && compareImage(Task3.getImage(), swallow_pic.getImage())) {
            check.setVisible(false);
            Text.setText("Helyes válasz!");
            logger.info("Push the button.");
        } else {
            Text.setText("Helytelen válasz!");
            logger.info("Push the button.");
        }
    }

    @FXML
    private void nextButtonAction(ActionEvent event) {
        try {
            ((Node) (event.getSource())).getScene().getWindow().hide();

            Parent parent = FXMLLoader.load(getClass().getResource("/fxml/Task2.fxml"));
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

    @FXML
    void setOnDragDetected(MouseEvent event) {
        ClipboardContent content = new ClipboardContent();
        ImageView source = (ImageView) event.getSource();
        Dragboard db = source.startDragAndDrop(TransferMode.COPY);
        content.putImage(source.getImage());
        db.setContent(content);
        event.consume();
        logger.info("set on drag detected.");
    }

    @FXML
    void setOnDragOver(DragEvent event) {
        Dragboard board = event.getDragboard();
        if (board.hasImage()) {
            event.acceptTransferModes(TransferMode.COPY);
        }
        event.consume();
        logger.info("set on drag over.");
    }

    @FXML
    void setOnDragEntered(DragEvent event) {
        ImageView source = (ImageView) event.getSource();
        ImageView target = (ImageView) event.getTarget();
        Dragboard board = event.getDragboard();
        if (board.hasImage()) {
            target.setImage(source.getImage());
        }
        event.consume();
        logger.info("set on drag entered.");

    }

    @FXML
    void setOnDragExited(DragEvent event) {
        ImageView source = (ImageView) event.getSource();
        ImageView target = (ImageView) event.getTarget();
        target.setImage(source.getImage());
        event.consume();
        logger.info("set on drag exited.");
    }

    @FXML
    void setOnDragDropped(DragEvent event) {
        Dragboard board = event.getDragboard();
        ImageView target = (ImageView) event.getTarget();
        boolean success = false;
        if (board.hasImage()) {
            target.setImage(board.getImage());
            success = true;
        }
        event.setDropCompleted(success);
        event.consume();
        logger.info("set on drag dropped.");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        swallow_pic.setImage(new Image(getClass().getResource(pic.getSwallow()).toExternalForm(), 200, 200, true, true));
        ladybird_pic.setImage(new Image(getClass().getResource(pic.getLadybird()).toExternalForm(), 200, 200, true, true));
        cat_pic.setImage(new Image(getClass().getResource(pic.getCat()).toExternalForm(), 200, 200, true, true));

        Task1.setImage(new Image(getClass().getResource(pic.getEmpty()).toExternalForm(), 200, 200, true, true));
        Task2.setImage(new Image(getClass().getResource(pic.getEmpty()).toExternalForm(), 200, 200, true, true));
        Task3.setImage(new Image(getClass().getResource(pic.getEmpty()).toExternalForm(), 200, 200, true, true));
        logger.info("Initialize the window details.");
    }

}
