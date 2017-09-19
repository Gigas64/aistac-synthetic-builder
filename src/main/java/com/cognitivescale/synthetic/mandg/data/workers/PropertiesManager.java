/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * @(#)PropertiesManager.java
 *
 * Copyright:	Copyright (c) 2017
 * Company:		Oathouse.com Ltd
 */
package com.cognitivescale.synthetic.mandg.data.workers;

import com.oathouse.oss.storage.exceptions.NoSuchIdentifierException;
import com.oathouse.oss.storage.exceptions.PersistenceException;
import com.oathouse.oss.storage.objectstore.ObjectDataOptionsEnum;
import com.oathouse.oss.storage.objectstore.ObjectEnum;
import com.oathouse.oss.storage.objectstore.ObjectSingleStore;

/**
 * The {@code PropertiesManager} Class extends the methods of the parent class.
 *
 * @author Darryl Oatridge
 * @version 1.00 14-Sep-2017
 */
public class PropertiesManager extends ObjectSingleStore<PropertiesBean> {

    /**
     * Constructs a {@code PropertiesManager}, passing the manager name which is used to distinguish
     * the persistently held data from other managers. Normally the manager name would be
     * the name of the class
     *
     * @param managerName a unique name to identify the manager.
     * @param dataOptions an optional list of ObjectDataOptionsEnum
     * @see ObjectDataOptionsEnum
     */
    public PropertiesManager(String managerName, ObjectDataOptionsEnum... dataOptions) {
        super(managerName, dataOptions);
    }

    /**
     * Sets the root path in the Properties Bean
     * @param rootPath the root path
     * @param owner the owner of the change
     * @throws PersistenceException
     */
    public void setRootPath(String rootPath, String owner) throws PersistenceException {
        PropertiesBean bean;
        try {
            bean = getObject();
            bean.setRootPath(rootPath, owner);
            setObject(bean);
        } catch(NoSuchIdentifierException noSuchIdentifierException) {
            setObject(new PropertiesBean(ObjectEnum.DEFAULT_ID.value(), rootPath, owner));
        }
    }
}
