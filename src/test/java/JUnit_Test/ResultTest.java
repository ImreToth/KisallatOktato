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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnit_Test;

/*-
 * #%L
 * Kisallatoktato
$Id:$
$HeadURL:$
 * %%
 * Copyright (C) 2017 University of Debrecen
 * %%
 * This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as
published by the Free Software Foundation, either version 3 of the
License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public
License along with this program.  If not, see
<http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import Model.Result;

/**
 *
 * @author MrSvand
 */
public class ResultTest {
    Result r;
    
    public ResultTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {       
       r = new Result();
    }
    
    @After
    public void tearDown() {
        r = null;
    }

    @org.junit.Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
        
    @Test
    public void testRating(){
       assertEquals("0%", r.Rating(0));
       assertEquals("83%", r.Rating(10));
       assertEquals("64%", r.Rating(8));
       assertEquals("8%", r.Rating(1));
    }
    @Test
    public void testAddPoint(){
        assertEquals(0, r.AddPoint(0));
        assertEquals(1, r.AddPoint(1));
        assertEquals(2, r.AddPoint(1));
        assertEquals(12, r.AddPoint(10));
    }
    

}
