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

package JUnit_Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import Model.ReadJson;

public class ReadJsonTest {
    ReadJson rj;
    public ReadJsonTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws IOException, FileNotFoundException, ParseException {
        rj = new ReadJson(this.getClass().getResource("/TestJson.json").getPath());
    }
    
    @After
    public void tearDown() {
        rj = null;
    }

    @org.junit.Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void currentUserameTest(){
            assertEquals("TestName1",rj.getCurrentUsername());
    }
    
    @Test
    public void currentRatingTest(){
            assertEquals("40%",rj.getCurrentRating());
        
    }
    
    @Test
    public void currentPointTest(){
            assertEquals( 5 ,rj.getCurrentPoint());
    }
    
    @Test
    public void allUsernameTest(){
            assertEquals("TestName3\nTestName2\n",rj.getAllUsername());
         }
    
    @Test
    public void allPointTest(){
            assertEquals("8\n10\n",rj.getAllPoint());
    }
    
    @Test
    public void allRatingTest(){
            assertEquals("64%\n83%\n",rj.getAllRating());
        
    }
}
