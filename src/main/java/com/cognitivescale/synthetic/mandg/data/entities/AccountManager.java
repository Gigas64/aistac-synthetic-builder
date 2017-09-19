package com.cognitivescale.synthetic.mandg.data.entities;

import com.oathouse.oss.storage.objectstore.ObjectDataOptionsEnum;
import com.oathouse.oss.storage.objectstore.ObjectSetStore;

/**
 * The {@code AccountManager} Class extends the methods of the parent class.
 *
 * @author Darryl Oatridge
 * @version 1.00 14-Sep-2017
 */
public class AccountManager extends ObjectSetStore<AccountBean> {

    /**
     * Constructs a {@code AccountManager}, passing the manager name which is used to distinguish
     * the persistently held data from other managers. Normally the manager name would be
     * the name of the class
     *
     * @param managerName a unique name to identify the manager.
     * @param dataOptions an optional list of ObjectDataOptionsEnum
     * @see ObjectDataOptionsEnum
     */
    public AccountManager(String managerName, ObjectDataOptionsEnum... dataOptions) {
        super(managerName, dataOptions);
    }

}
