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

import javafx.scene.image.Image;

/**
 * Pictures Modell Objektum.
 *
 * <p>A képekhez tartozó attribútumok és viselkedéseket tartalmazza.
 * <p>Lásd {@link #Pictures()} további információkért.
 *
 * @author MrSvand
 * @version 1.0
 */
public class Pictures {
    /**
     * A Fecske kép helyét adja meg.
     */
    public String swallow;
    /**
     * A Katicabogár kép helyét adja meg.
     */
    public String ladybird;
    /**
     * A Macska kép helyét adja meg.
     */
    public String cat;
    /**
     * Az Üres kép helyét adja meg.
     */
    public String empty;
    /**
     * A Fecskéről információt tartalmaz.
     */
    public String swallow_info;
    /**
     * A Katicabogárról információt tartalmaz.
     */
    public String ladybird_info;
    /**
     * A Macskáról információt tartalmaz.
     */
    public String cat_info;

    /**
     * A képek helyét és az arról való információkat állítja be.
     * <p>Lásd {@link Pictures#swallow},{@link Pictures#swallow_info},
     * {@link Pictures#ladybird},{@link Pictures#ladybird_info},
     * {@link Pictures#cat},{@link Pictures#cat_info},
     */
    public Pictures() {
        this.swallow = "/Image/Swallow.png";
        this.ladybird = "/Image/Ladybird.png";
        this.cat = "/Image/Cat.png";
        this.empty = "/Image/empty.png";

        this.cat_info = "A macska egy kisebb termetű húsevő emlősállat,\n"
                + " amely a macskafélék családjába tartozik";
        this.ladybird_info = "A katicabogárfélék a rovarok osztályának a bogarak rendjébe,\n"
                + " ezen belül a mindenevő bogarak alrendjébe tartozó család.";
        this.swallow_info = "A fecskefélék a madarak osztályának\n"
                + " a verébalakúak rendjébe tartozó család.";
    }

    /**
     * Visszaadja a fecskéről az információt.
     * @return {@link Pictures#swallow_info}
     */
    public String getSwallow_info() {
        return swallow_info;
    }

    /**
     * Visszaadja a katicabogárról az információt.
     * @return {@link Pictures#ladybird_info}
     */
    public String getLadybird_info() {
        return ladybird_info;
    }

    /**
     * Visszaadja a macskáról az információt.
     * @return {@link Pictures#cat_info}
     */
    public String getCat_info() {
        return cat_info;
    }

    /**
     * Visszaadja a fecske kép helyét.
     * @return {@link Pictures#swallow}
     */
    public String getSwallow() {
        return swallow;
    }

    /**
     * Visszaadja a katicabogár kép helyét.
     * @return {@link Pictures#ladybird}
     */
    public String getLadybird() {
        return ladybird;
    }

    /**
     * Visszaadja a macska kép helyét.
     * @return {@link Pictures#cat}
     */
    public String getCat() {
        return cat;
    }

    /**
     * Visszaadja az üres kép helyét.
     * @return {@link Pictures#empty}
     */
    public String getEmpty() {
        return empty;
    }

    /**
     * Beállítja a kép helyét.
     * @param swallow A fecske kép helye.
     */
    public void setSwallow(String swallow) {
        this.swallow = swallow;
    }

    /**
     * Beállítja a kép helyét.
     * @param ladybird A katicabogár kép helye.
     */
    public void setLadybird(String ladybird) {
        this.ladybird = ladybird;
    }

    /**
     * Beállítja a kép helyét.
     * @param cat A macska kép helye.
     */
    public void setCat(String cat) {
        this.cat = cat;
    }

    /**
     * Beállítja a kép helyét.
     * @param empty Az üres kép helye.
     */
    public void setEmpty(String empty) {
        this.empty = empty;
    }

    /**
     * Beállítja az információt a fecskéről.
     * @param swallow_info A fecskéről az információ.
     */
    public void setSwallow_info(String swallow_info) {
        this.swallow_info = swallow_info;
    }

    /**
     * Beállítja az információt a katicabogárról.
     * @param ladybird_info A katicabogárról az információ.
     */
    public void setLadybird_info(String ladybird_info) {
        this.ladybird_info = ladybird_info;
    }

    /**
     * Beállítja az információt a macskáról.
     * @param cat_info A macskáról az információ.
     */
    public void setCat_info(String cat_info) {
        this.cat_info = cat_info;
    }

}
