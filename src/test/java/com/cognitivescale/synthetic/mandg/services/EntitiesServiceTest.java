/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cognitivescale.synthetic.mandg.services;

// common imports
import com.cognitivescale.synthetic.mandg.data.entities.AccountBean;
import com.cognitivescale.synthetic.mandg.services.PropertiesService;
import com.oathouse.oss.server.OssProperties;
import com.oathouse.oss.storage.exceptions.MaxCountReachedException;
import com.oathouse.oss.storage.exceptions.NoSuchIdentifierException;
import com.oathouse.oss.storage.exceptions.PersistenceException;
import com.oathouse.oss.storage.objectstore.ObjectDBMS;
import com.oathouse.oss.storage.objectstore.BeanBuilder;
import com.oathouse.oss.storage.objectstore.BuildBeanTester;
import com.oathouse.oss.storage.objectstore.ObjectBean;
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
public class EntitiesServiceTest {

    public EntitiesServiceTest() {
    }

    @Before
    public void setUp() throws Exception {
        String rootPath = Paths.get(".", "datastore").toString();
        OssProperties.getInstance().setAuthority("SyntheticEngine");
        OssProperties.getInstance().setStorePath(rootPath);
    }

    @After
    public void tearDown() {
    }

 }
