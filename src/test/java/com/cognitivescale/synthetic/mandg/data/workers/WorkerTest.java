/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cognitivescale.synthetic.mandg.data.workers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author Darryl Oatridge
 */
public class WorkerTest {

    public WorkerTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /*
     *
     */
    @Test
    public void StringTest() throws Exception {
        String str = "AB45 2WE";
        Matcher match = Pattern.compile("[A-Z]+").matcher(str);
        match.find();
        System.out.println("The First Letters are [" + match.group() + "}]");
    }

}