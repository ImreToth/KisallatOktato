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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 * Json fájl olvasásáért felelő osztály.
 * 
 * @author MrSvand
 * @version 1.0
 */
public class ReadJson {
    
    private final Object obj;
    private final File jsonfile;
    private final JSONParser parser;
    private final JSONObject jsonObject;
    private final JSONArray user;
    private final Iterator<String> iterator;
    
    
    /**
     *Konstruktor az olvasáshoz szükséges paramétereket állítja be.
     * 
     * <p>Követelmény az olvasáshoz, a json fájlnak alapból tartalmaznia kell : {@code { "users":[] }} a users listát.
     * 
     * @param path json fájl elérési útvonala.
     * @throws FileNotFoundException Ha nem találja a fájlt.
     * @throws IOException I/O hiba.
     * @throws ParseException Olvasáskor fellépő hiba.
     */
    public ReadJson(String path) throws FileNotFoundException, IOException, ParseException {
            parser = new JSONParser();
            jsonfile = new File(path);
            obj = parser.parse(new FileReader(jsonfile));
            jsonObject = (JSONObject) obj;
            user = (JSONArray) jsonObject.get("users");
            iterator = user.iterator();
   }
    /**
     * Az aktuális felhasználó nevének kiolvasásáért felel.
     * 
     * @return az aktuális felhasználó neve.
     */
    public String getCurrentUsername() {
            for (int i = user.size()-1; i < user.size(); i++) {
                JSONObject jsonObjectRow = (JSONObject) user.get(i);
                String username = (String) jsonObjectRow.get("username");
                
                return username;              
            }
         return null;   
    }
    /**
     * Az aktuális felhasználó pontjának kiolvasásáért felel.
     * 
     * @return az aktuális felhasználó pontja.
     */
    public int getCurrentPoint(){
            for (int i = user.size()-1; i < user.size(); i++) {
                JSONObject jsonObjectRow = (JSONObject) user.get(i);
                long point = (long) jsonObjectRow.get("point");
                
                return (int) point;              
            }
         return 0;   
    }
    /**
     * Az aktuális felhasználó százalékos értékelésének kiolvasásáért felel.
     * 
     * @return az aktuális felhasználó százalékos értékelése.
     */
    public String getCurrentRating(){
            for (int i = user.size()-1; i < user.size(); i++) {
                JSONObject jsonObjectRow = (JSONObject) user.get(i);
                String rating = (String) jsonObjectRow.get("rating");
                
                return rating;              
            }
         return null;   
    }
    /**
     * Az eddigi össze felhasználó nevének kiolvasásáért felel kivéve az aktuális felhasználóét.
     * 
     * @return Az eddigi össze felhasználó neve.
     */
    public String getAllUsername(){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < user.size()-1; i++) {
                JSONObject jsonObjectRow = (JSONObject) user.get(i);
                sb.append((String) jsonObjectRow.get("username"));
                sb.append("\n");
            }
            return sb.toString();
    }
    /**
     * Az eddigi össze felhasználó pontjának kiolvasásáért felel kivéve az aktuális felhasználóét.
     * 
     * @return Az eddigi össze felhasználó pontja.
     */
    public String getAllPoint(){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < user.size()-1; i++) {
                JSONObject jsonObjectRow = (JSONObject) user.get(i);
                sb.append(String.valueOf((long) jsonObjectRow.get("point")));
                sb.append("\n");
            }
            return sb.toString();
    }
    /**
     * Az eddigi össze felhasználó százalékos értékelésének kiolvasásáért felel kivéve az aktuális felhasználóét.
     * 
     * @return Az eddigi össze felhasználó százalékos értékelése.
     */
    public String getAllRating(){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < user.size()-1; i++) {
                JSONObject jsonObjectRow = (JSONObject) user.get(i);
                sb.append((String) jsonObjectRow.get("rating"));
                sb.append("\n");
        
            }
            return sb.toString();
        }
    /**
     * Visszaadja a Json Objektumot.
     * @return Json Objektum.
     */
    public JSONObject getJsonObject() {
        return jsonObject;
    }
    /**
     * Visszaadja a "users" listát a json fájlból
     * @return "users" lista.
     */
    public JSONArray getUser() {
        return user;
    }
    /**
     * Visszaadja a Json fájlt.
     * @return Json fájl.
     */
    public File getJsonfile() {
        return jsonfile;
    }
    
    }
    
    
    


