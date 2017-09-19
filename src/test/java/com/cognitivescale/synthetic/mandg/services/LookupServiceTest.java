/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cognitivescale.synthetic.mandg.services;

// common imports
import com.cognitivescale.synthetic.mandg.data.lookups.PostcodeManager;
import com.oathouse.oss.storage.objectstore.ObjectDBMS;
import com.oathouse.oss.storage.objectstore.BeanBuilder;
import com.oathouse.oss.storage.objectstore.ObjectBean;
import com.oathouse.oss.server.OssProperties;
import java.nio.file.Paths;
import java.util.*;
import static java.util.Arrays.*;
import java.util.concurrent.ConcurrentSkipListMap;
// Test Imports
import mockit.*;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author Darryl Oatridge
 */
public class LookupServiceTest {

    public LookupServiceTest() {
    }

    @Before
    public void setUp() {
        String rootPath = Paths.get(".", "datastore").toString();
        OssProperties.getInstance().setAuthority("SyntheticEngine");
        OssProperties.getInstance().setStorePath(rootPath);
    }

    @After
    public void tearDown() {
    }

    /*
     *
     */
    // @Test
    public void testPostcodeLoader() throws Exception {
        LookupService.getInstance().getPostcodeFromFile();
    }

    @Test
    public void testTransactionTypeLoader() throws Exception {
        LookupService.getInstance().getTransactionTypeFromFile();
    }

}
