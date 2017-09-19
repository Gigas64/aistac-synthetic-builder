package com.cognitivescale.synthetic.mandg.services;

import com.cognitivescale.synthetic.mandg.data.workers.PropertiesBean;
import com.cognitivescale.synthetic.mandg.data.workers.PropertiesManager;
import com.oathouse.oss.storage.exceptions.NoSuchIdentifierException;
import com.oathouse.oss.storage.exceptions.PersistenceException;

/**
 * The {@code PropertiesService} Class is a encapsulated API, service level singleton that provides
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
public class PropertiesService {
    // Singleton Instance
    private volatile static PropertiesService INSTANCE;
    // to stop initialising when initialised
    private volatile boolean initialise = true;
    // Manager declaration and instantiation
    private final PropertiesManager propertiesManager = new PropertiesManager("Properties");

    //<editor-fold defaultstate="collapsed" desc="Singleton Methods">
    // private Method to avoid instantiation externally
    private PropertiesService() {
        // this should be empty
    }

    /**
     * Singleton pattern to get the instance of the {@code PropertiesService} class
     * @return instance of the {@code PropertiesService}
     * @throws PersistenceException
     */
    public static PropertiesService getInstance() throws PersistenceException {
        if(INSTANCE == null) {
            synchronized (PropertiesService.class) {
                // Check again just incase before we synchronised an instance was created
                if(INSTANCE == null) {
                    INSTANCE = new PropertiesService().init();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Used to check if the {@code PropertiesService} class has been initialised. This is used
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
     * initialise all the managed classes in the {@code PropertiesService}. The
     * method returns an instance of the {@code PropertiesService} so it can be chained.
     * This must be called before a the {@code PropertiesService} is used. e.g  {@code PropertiesService myPropertiestService = }
     * @return instance of the {@code PropertiesService}
     * @throws PersistenceException
     */
    public synchronized PropertiesService init() throws PersistenceException {
        if(initialise) {
            propertiesManager.init();
        }
        initialise = false;
        return (this);
    }

    /**
     * Reinitialises all the managed classes in the {@code PropertiesService}. The
     * method returns an instance of the {@code PropertiesService} so it can be chained.
     * @return instance of the {@code PropertiesService}
     * @throws PersistenceException
     */
    public PropertiesService reInitialise() throws PersistenceException {
        initialise = true;
        return (init());
    }

    /**
     * Clears all the managed classes in the {@code PropertiesService}. This is
     * generally used for testing. If you wish to refresh the object store
     * reInitialise() should be used.
     * @return true if all the managers were cleared successfully
     * @throws PersistenceException
     */
    public boolean clear() throws PersistenceException {
        boolean success = true;
        success = propertiesManager.clear()?success:false;
        INSTANCE = null;
        return success;
    }

    /**
     * TESTING ONLY. Use reInitialise() if you wish to reload memory.
     * <p>
     * Used to reset the {@code PropertiesService} class instance by setting the INSTANCE reference
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
     * This section allows the retrieval of the instance
     * of the manager to use as part of this service. For
     * ease of reference each manager has both a long and
     * a short name method call. ALL manager instances should
     * be referenced through the Service and not instantiated
     * directly.
     * ***************************************************/
    /*
     * Returns the AccountHolderBean
     */
    /*
     * returns the SystemPropertiesBean
     */
    public PropertiesBean getSystemProperties() throws NoSuchIdentifierException, PersistenceException {
        return propertiesManager.getObject();
    }

    //</editor-fold>



    //<editor-fold defaultstate="expanded" desc="Service Level Get Methods">
    /* ***************************************************
     * S E R V I C E  L E V E L   G E T   M E T H O D S
     *
     * This section is for all get methods that require
     * information outside their own data store. All other
     * get methods can be found up the tree in the manager
     * or bean of the bean type.
     * ***************************************************/

    public String getRootPath() throws PersistenceException, NoSuchIdentifierException {
        return propertiesManager.getObject().getRootPath();
    }

    //</editor-fold>

    //<editor-fold defaultstate="expanded" desc="Service Level Set Methods">
    /* **************************************************
     * S E R V I C E   L E V E L   S E T   M E T H O D S
     *
     * All set methods should be interfaced at the Service
     * level as this allows consistency across the API and
     * security for the underlying sets. If we have sets at
     * the Service level, the Manager level and ObjectStore,
     * the inconsistency might cause a set to be made to the
     * manager when a set in the service adds additional logic
     * and thus is bypassed.
     * **************************************************/

    public void setStartupProperties(String rootPath, String owner) throws PersistenceException, NoSuchIdentifierException {
        propertiesManager.setRootPath(rootPath, owner);
    }

    //</editor-fold>

    //<editor-fold defaultstate="expanded" desc="Private Class Methods">
    /* ***************************************************
     * P R I V A T E   C L A S S   M E T H O D S
     *
     * This section is for all private methods for the
     * class. Private methods should be carefully used
     * so as to avoid multi jump calls and as a general
     * rule of thumb, only when multiple methods use a
     * common algorithm.
     * ***************************************************/

    //</editor-fold>
}
