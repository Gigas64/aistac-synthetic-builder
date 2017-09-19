/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cognitivescale.synthetic.mandg.services;

import java.util.concurrent.ThreadLocalRandom;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author Darryl Oatridge
 */
public class SyntheticEngineServiceTest {

    public SyntheticEngineServiceTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() {
        int percentage = 80;
        int chance = 100/percentage;

        int counter = 0;
        // do it 100 time
        for(int i = 0; i < 100; i++) {
            int randNum = ThreadLocalRandom.current().nextInt(1, 1001);
            if((randNum % chance) == 0) {
                counter++;
            }
        }
        System.out.println("With a change of " + chance + " win came up " + counter + "% of the time");
    }

}
