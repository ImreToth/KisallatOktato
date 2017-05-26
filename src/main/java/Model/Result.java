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

/**
 * A feladat eredményét meghatározó osztály.
 *
 * @author MrSvand
 * @version 1.0
 */
public class Result {

    /**
     * Az eredmény pontja.
     */
    public int points;
    /**
     * Az eredmény százalékos értékelése.
     */
    public String rating;

    /**
     * Alapértelmezett konstruktor.
     */
    public Result() {
    }

    /**
     * Visszaadja a pont értékét.
     * @return {@link #points}
     */
    public int getPoints() {
        return points;
    }

    /**
     * Érték beállítása a {@link #points} értékének.
     * @param points Beállítandó érték.
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Visszaadja a százalékos értékelést.
     * @return {@link #rating}
     */
    public String getRating() {
        return rating;
    }

    /**
     * Érték beállítása a {@link #rating} értékének.
     * @param rating Beállítandó százalékos értékelés.
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    /**
     * {@link #points} értékének változtatása a megadott értékkel.
     * 
     * @param addpoint hozzáadni kívánt érték.
     * @return {@link #points}
     */
    public int AddPoint(int addpoint) {
        points += addpoint;
        return points;

    }

    /**
     * Százalékos értékelés beállítása.
     * @param points Az elért pontot tartalmazza.
     * @return {@link #rating}
     */
    public String Rating(int points) {
        switch (points) {
            case 12:
                return rating = "100%";
            case 11:
                return rating = "92%";
            case 10:
                return rating = "83%";
            case 9:
                return rating = "75%";
            case 8:
                return rating = "64%";
            case 7:
                return rating = "56%";
            case 6:
                return rating = "48%";
            case 5:
                return rating = "40%";
            case 4:
                return rating = "32%";
            case 3:
                return rating = "25%";
            case 2:
                return rating = "16%";
            case 1:
                return rating = "8%";
            case 0:
                return rating = "0%";
        }
        return null;
    }

}
