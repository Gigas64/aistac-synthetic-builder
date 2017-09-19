/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cognitivescale.synthetic.mandg.data.entities;

import com.cognitivescale.synthetic.mandg.data.entities.ContributionBean;
import com.oathouse.oss.storage.objectstore.BuildBeanTester;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author Darryl Oatridge
 */
public class ContributionBeanTest {

    /**
     * Tests the underlying bean.
     */
    @Test
    public void test_ContributionBean() throws Exception {
        boolean isPrintXML = false;
        boolean isGroupKey = false;
        // Use this to exempt methods
//            List<String> exemptMethods = Stream.of("getId", "getKey").collect(Collectors.toList());
        BuildBeanTester.testObjectBean(ContributionBean.class.getName(), isPrintXML, isGroupKey);
    }
}