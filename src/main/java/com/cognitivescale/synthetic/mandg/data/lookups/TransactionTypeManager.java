/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * @(#)TransactionTypeManager.java
 *
 * Copyright:       Copyright (c) 2017
 * Organisation:
 * Schema:
 */
package com.cognitivescale.synthetic.mandg.data.lookups;

import com.oathouse.oss.storage.objectstore.ObjectDataOptionsEnum;
import com.oathouse.oss.storage.objectstore.ObjectSetStore;

/**
 * The {@code TransactionTypeManager} Class extends the methods of the parent class.
 *
 * @author Darryl Oatridge
 * @version 1.00 17-Sep-2017
 */
public class TransactionTypeManager extends ObjectSetStore<TransactionTypeBean> {

    /**
     * Constructs a {@code TransactionTypeManager}, passing the manager name which is used to distinguish
     * the persistently held data from other managers. Normally the manager name would be
     * the name of the class
     *
     * @param managerName a unique name to identify the manager.
     * @param dataOptions an optional list of ObjectDataOptionsEnum
     * @see ObjectDataOptionsEnum
     */
    public TransactionTypeManager(String managerName, ObjectDataOptionsEnum... dataOptions) {
        super(managerName, dataOptions);
    }

}
