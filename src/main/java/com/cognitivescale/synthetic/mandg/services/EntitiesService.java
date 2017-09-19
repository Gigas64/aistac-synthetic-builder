/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
 * @(#)EntitiesService.java
 */
package com.cognitivescale.synthetic.mandg.services;

import com.cognitivescale.synthetic.mandg.data.entities.AccountManager;
import com.cognitivescale.synthetic.mandg.data.entities.ContributionManager;
import com.cognitivescale.synthetic.mandg.data.entities.CustomerManager;
import com.cognitivescale.synthetic.mandg.data.entities.FundHoldingManager;
import com.cognitivescale.synthetic.mandg.data.entities.SuppressionManager;
import com.cognitivescale.synthetic.mandg.data.entities.TransactionManager;
import com.oathouse.oss.storage.exceptions.PersistenceException;
import com.oathouse.oss.storage.objectstore.ObjectDataOptionsEnum;

/**
 * The {@code EntitiesService} Class is a encapsulated API, service level singleton that provides
 * access to related underlying manager instances. The class provides three distinct sections:
 * <h2>Manager Retrieval</h2>
 * <p>
 * This section allows the retrieval of the instance of the manager to use as part of this service. For
 * ease of reference each manager has both a long and a short name method call. ALL manager instances should
 * be referenced through the Service and not instantiated directly.
 * </p>
 * <p>
 * <h2>Service Level get Methods</h2>
 * <p>
 * This section is for all get methods that require information outside their own data store. All other
 * get methods can be found up the tree in the manager or bean of the bean type.
 * </p>
 * <p>
 * <h2>Service Level set Methods</h2>
 * <p>
 * All set methods must be implemented up to the Service level as this allows consistency across the API and
 * security for the underlying sets. If we have sets at the Service level, the Manager level and ObjectStore,
 * the inconsistency might cause a set to be made to the manager when a set in the service adds additional logic
 * and thus is bypassed.
 * </p>
 *
 * @author Darryl Oatridge
 * @version 1.00 14-Sep-2017
 */
public class EntitiesService {

    // Singleton Instance
    private volatile static EntitiesService INSTANCE;
    // to stop initialising when initialised
    private volatile boolean initialise = true;
    // Manager declaration and instantiation
    private final AccountManager accountManager = new AccountManager("entityAccounts", ObjectDataOptionsEnum.PERSIST);
    private final ContributionManager contributionManager = new ContributionManager("entityContributions", ObjectDataOptionsEnum.PERSIST);
    private final CustomerManager customerManager = new CustomerManager("entityCustomers", ObjectDataOptionsEnum.PERSIST);
    private final FundHoldingManager fundHoldingManager = new FundHoldingManager("entityFundHoldings", ObjectDataOptionsEnum.PERSIST);
    private final SuppressionManager suppressionManager = new SuppressionManager("entitySuppressions", ObjectDataOptionsEnum.PERSIST);
    private final TransactionManager transactionManager = new TransactionManager("entityTransactions", ObjectDataOptionsEnum.PERSIST);

    //<editor-fold defaultstate="collapsed" desc="Singleton Methods">
    // private Method to avoid instantiation externally
    private EntitiesService() {
        // this should be empty
    }

    /**
     * Singleton pattern to get the instance of the {@code EntitiesService} class
     *
     * @return instance of the {@code EntitiesService}
     *
     * @throws PersistenceException
     */
    public static EntitiesService getInstance() throws PersistenceException {
        if(INSTANCE == null) {
            synchronized(EntitiesService.class) {
                // Check again just incase before we synchronised an instance was created
                if(INSTANCE == null) {
                    INSTANCE = new EntitiesService().init();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Used to check if the {@code EntitiesService} class has been initialised. This is used
     * mostly for testing to avoid initialisation of managers when the underlying
     * elements of the initialisation are not available.
     *
     * @return true if an instance has been created
     */
    public static boolean hasInstance() {
        if(INSTANCE != null) {
            return (true);
        }
        return (false);
    }

    /**
     * initialise all the managed classes in the {@code EntitiesService}. The
     * method returns an instance of the {@code EntitiesService} so it can be chained.
     * This must be called before a the {@code EntitiesService} is used. e.g {@code EntitiesService mySyntheticDataService = }
     *
     * @return instance of the {@code EntitiesService}
     *
     * @throws PersistenceException
     */
    public synchronized EntitiesService init() throws PersistenceException {
        if(initialise) {
            accountManager.init();
            contributionManager.init();
            customerManager.init();
            fundHoldingManager.init();
            suppressionManager.init();
            transactionManager.init();
       }
        initialise = false;
        return (this);
    }

    /**
     * Reinitialises all the managed classes in the {@code EntitiesService}. The
     * method returns an instance of the {@code EntitiesService} so it can be chained.
     *
     * @return instance of the {@code EntitiesService}
     *
     * @throws PersistenceException
     */
    public EntitiesService reInitialise() throws PersistenceException {
        initialise = true;
        return (init());
    }

    /**
     * Clears all the managed classes in the {@code EntitiesService}. This is
     * generally used for testing. If you wish to refresh the object store
     * reInitialise() should be used.
     *
     * @return true if all the managers were cleared successfully
     *
     * @throws PersistenceException
     */
    public boolean clear() throws PersistenceException {
        boolean success = true;
        success = accountManager.clear() ? success : false;
        success = contributionManager.clear() ? success : false;
        success = customerManager.clear() ? success : false;
        success = fundHoldingManager.clear() ? success : false;
        success = suppressionManager.clear() ? success : false;
        success = transactionManager.clear() ? success : false;
        INSTANCE = null;
        return success;
    }

    /**
     * TESTING ONLY. Use reInitialise() if you wish to reload memory.
     * <p>
     * Used to reset the {@code EntitiesService} class instance by setting the INSTANCE reference
     * to null. This is mostly used for testing to clear and reset internal memory stores
     * when the underlying persistence data has been removed.
     * </p>
     */
    public static void removeInstance() {
        INSTANCE = null;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Manager Retrieval">
    /*
     * ***************************************************
     * M A N A G E R R E T R I E V A L
     *
     * This section allows the retrieval of the instance
     * of the manager to use as part of this service. For
     * ease of reference each manager has both a long and
     * a short name method call. ALL manager instances should
     * be referenced through the Service and not instantiated
     * directly.
     * **************************************************
     */
    public AccountManager getAccountManager() {
        return accountManager;
    }

    public ContributionManager getContributionManager() {
        return contributionManager;
    }

    public CustomerManager getCustomerManager() {
        return customerManager;
    }

    public FundHoldingManager getFundHolderManager() {
        return fundHoldingManager;
    }

    public SuppressionManager getSuppressionManager() {
        return suppressionManager;
    }

    public TransactionManager getTransactionManager() {
        return transactionManager;
    }

    //</editor-fold>
    //<editor-fold defaultstate="expanded" desc="Service Level Get Methods">
    /*
     * ***************************************************
     * S E R V I C E     L E V E L     M E T H O D S
     *
     * This section is for all get methods that require
     * information outside their own data store. All other
     * methods can be found up the tree in the manager
     * or bean of the bean type.
     * **************************************************
     */

    //</editor-fold>

    //<editor-fold defaultstate="expanded" desc="Private Class Methods">
    /*
     * ***************************************************
     * P R I V A T E C L A S S M E T H O D S
     *
     * This section is for all private methods for the
     * class. Private methods should be carefully used
     * so as to avoid multi jump calls and as a general
     * rule of thumb, only when multiple methods use a
     * common algorithm.
     * **************************************************
     */

    //</editor-fold>
}
