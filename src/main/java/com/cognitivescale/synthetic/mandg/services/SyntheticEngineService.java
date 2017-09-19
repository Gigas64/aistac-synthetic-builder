/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * @(#)SyntheticEngineService.java
 */
package com.cognitivescale.synthetic.mandg.services;

import com.oathouse.oss.storage.exceptions.PersistenceException;

/**
 * The {@code SyntheticEngineService} Class is a encapsulated API, service level singleton that provides
 * access to related underlying manager instances. The class provides three distinct sections:
 * <h2>Manager Retrieval</h2>
 * <p>
 * This section allows the retrieval of the instance of the manager to use as part of this service. For
 * ease of reference each manager has both a long and a short name method call. ALL manager instances should
 * be referenced through the Service and not instantiated directly.
 * </p>
 *
 * <h2>Service Level get Methods</h2>
 * <p>
 * This section is for all get methods that require information outside their own data store. All other
 * get methods can be found up the tree in the manager or bean of the bean type.
 * </p>
 *
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
public class SyntheticEngineService {
    // Singleton Instance
    private volatile static SyntheticEngineService INSTANCE;
    // to stop initialising when initialised
    private volatile boolean initialise = true;
    // Manager declaration and instantiation
    // TODO declareyour manager and instanciate
    // private final Manager manager = new Manager("manager");

    //<editor-fold defaultstate="collapsed" desc="Singleton Methods">
    // private Method to avoid instantiation externally
    private SyntheticEngineService() {
        // this should be empty
    }

    /**
     * Singleton pattern to get the instance of the {@code SyntheticEngineService} class
     * @return instance of the {@code SyntheticEngineService}
     * @throws PersistenceException
     */
    public static SyntheticEngineService getInstance() throws PersistenceException {
        if(INSTANCE == null) {
            synchronized (SyntheticEngineService.class) {
                // Check again just incase before we synchronised an instance was created
                if(INSTANCE == null) {
                    INSTANCE = new SyntheticEngineService().init();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Used to check if the {@code SyntheticEngineService} class has been initialised. This is used
     * mostly for testing to avoid initialisation of managers when the underlying
     * elements of the initialisation are not available.
     * @return true if an instance has been created
     */
    public static boolean hasInstance() {
        if(INSTANCE != null) {
            return(true);
        }
        return(false);
    }

    /**
     * initialise all the managed classes in the {@code SyntheticEngineService}. The
     * method returns an instance of the {@code SyntheticEngineService} so it can be chained.
     * This must be called before a the {@code SyntheticEngineService} is used. e.g  {@code SyntheticEngineService mySyntheticEngineService = }
     * @return instance of the {@code SyntheticEngineService}
     * @throws PersistenceException
     */
    public synchronized SyntheticEngineService init() throws PersistenceException {
        if(initialise) {
            // TODO Add your manager class init() method here
            // Manager.init();
        }
        initialise = false;
        return (this);
    }

    /**
     * Reinitialises all the managed classes in the {@code SyntheticEngineService}. The
     * method returns an instance of the {@code SyntheticEngineService} so it can be chained.
     * @return instance of the {@code SyntheticEngineService}
     * @throws PersistenceException
     */
    public SyntheticEngineService reInitialise() throws PersistenceException {
        initialise = true;
        return (init());
    }

    /**
     * Clears all the managed classes in the {@code SyntheticEngineService}. This is
     * generally used for testing. If you wish to refresh the object store
     * reInitialise() should be used.
     * @return true if all the managers were cleared successfully
     * @throws PersistenceException
     */
    public boolean clear() throws PersistenceException {
        boolean success = true;
        // TODO clear each manager. e.g.
        // success = myManager.clear()?success:false;
        INSTANCE = null;
        return success;
    }

    /**
     * TESTING ONLY. Use reInitialise() if you wish to reload memory.
     * <p>
     * Used to reset the {@code SyntheticEngineService} class instance by setting the INSTANCE reference
     * to null. This is mostly used for testing to clear and reset internal memory stores
     * when the underlying persistence data has been removed.
     * </p>
     */
    public static void removeInstance() {
        INSTANCE = null;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Manager Retrieval">
    /* ***************************************************
     * M A N A G E R   R E T R I E V A L
     *
    //</editor-fold>
     * This section allows the retrieval of the instance
     * of the manager to use as part of this service. For
     * ease of reference each manager has both a long and
     * a short name method call. ALL manager instances should
     * be referenced through the Service and not instantiated
     * directly.
     * ***************************************************/
    
    //</editor-fold>
}
