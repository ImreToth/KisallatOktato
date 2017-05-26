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

package Model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A program indulásakor szükséges műveletek végrehajtása. 
 * Lásd {@link #emptyJsonFile(java.io.File, java.io.File)},{@link #start(javafx.stage.Stage)}
 * @author MrSvand
 * @version 1.0
 */
public class MainApp extends Application {

    private static Logger logger;

    /**
     * Létrehoz egy üres json fájlt a felhasználók tárolására.
     * @param dest A cél könyvtár elérési útvonala,ha nemlétezik létrejön.
     * @param jsonFile A létrehozni kívánt json fájl elérési útvonala.
     */
    public void emptyJsonFile(File dest, File jsonFile) {
        try {
            if (!dest.exists()) {
                dest.mkdir();
            }
            jsonFile.createNewFile();
            JSONObject obj = new JSONObject();
            JSONArray list = new JSONArray();
            obj.put("users", list);
            FileWriter file = new FileWriter(jsonFile);
            file.write(obj.toJSONString());
            file.flush();
        } catch (IOException ex) {
            logger.error("error is ", ex);
        }
    }

    /**
     * Az első fxml betöltése, majd megjelenítése és az üres json fájl létrehozása. 
     * @param stage módusítja a JavaFX felületet.
     * @throws IOException I/O kivétel
     */
    @Override
    public void start(Stage stage) throws IOException{
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Intro.fxml"));

            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");

            stage.setTitle("Oktató Program");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            logger.error("error is ", e);
        }
        logger = LoggerFactory.getLogger(MainApp.class);
        logger.info("User's name is {}", System.getProperty("user.name"));

        File destFolder = new File(System.getProperty("user.home") + "/.Kisallatoktato");
        File jsonFile = new File(System.getProperty("user.home") + "/.Kisallatoktato/Users.json");
        if (!jsonFile.exists()) {
            emptyJsonFile(destFolder, jsonFile);
        }
    }

    /**
     * A main() metódus figyelmen kívül marad egy jól megírt JavaFX aplikációban.
     * @param args parancssori argumentum.
     */
    public static void main(String[] args) {
        launch(args);

    }

}
