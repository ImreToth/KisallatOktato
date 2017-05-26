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
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 * Json fájl írásáért felelő osztály.
 * <p>Lásd {@link #WriteJson(java.lang.String, java.lang.Integer, java.lang.String) }
 * 
 * @author MrSvand
 * @version 1.0
 */
public class WriteJson {
    /**
     * Json fájl írása.
     * 
     * <p>Követelmény a helyes íráshoz, a json fájlnak alapból tartalmaznia kell : {@code { "users":[] }} a users listát.
     * 
     * <p>Ebbe a listába kerülnek be a felhasználó adatai a lista egy elemeként egy Json objektum íródik.
     * 
     * <p>Első lépésként kiolvassa a json fájl eddigi tartalmát(Lásd {@link ReadJson}) , ehhez hozzá fűzi az újabb felhasználó adatait,majd mindennel együtt felülírja a json fájl-t. 
     * 
     * @param username felhasználó neve
     * @param point felhasználó pontja
     * @param rating felhasználó százalékos értékelése.
     * @throws IOException I/O hiba.
     * @throws ParseException Olvasáskor fellépő hiba.
     */
    public WriteJson(String username, Integer point, String rating) throws IOException, ParseException {        
            String path = System.getProperty("user.home") + "/.Kisallatoktato/Users.json";
            ReadJson r = new ReadJson(path);
            
            JSONObject newObject = new JSONObject();
            newObject.put("username", username);
            newObject.put("point", point);
            newObject.put("rating", rating);
            r.getUser().add(newObject);
            
            FileWriter Fw = new FileWriter(r.getJsonfile());
            Fw.write(r.getJsonObject().toJSONString());
            Fw.flush();
    }
    
}
    

