/*
 * @(#)LookupService.java
 */
package com.cognitivescale.synthetic.mandg.services;

import com.cognitivescale.synthetic.mandg.data.lookups.PostcodeBean;
import com.cognitivescale.synthetic.mandg.data.lookups.PostcodeManager;
import com.cognitivescale.synthetic.mandg.data.lookups.TransactionTypeBean;
import com.cognitivescale.synthetic.mandg.data.lookups.TransactionTypeManager;
import com.cognitivescale.synthetic.mandg.file.CSV.CSVFileReader;
import com.oathouse.oss.server.OssProperties;
import com.oathouse.oss.storage.exceptions.MaxCountReachedException;
import com.oathouse.oss.storage.exceptions.NullObjectException;
import com.oathouse.oss.storage.exceptions.PersistenceException;
import com.oathouse.oss.storage.objectstore.ObjectDataOptionsEnum;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.List;

/**
 * The {@code LookupService} Class is a encapsulated API, service level singleton that provides
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
 * @version 1.00 15-Sep-2017
 */
public class LookupService {
    // Singleton Instance
    private volatile static LookupService INSTANCE;
    // to stop initialising when initialised
    private volatile boolean initialise = true;
    // Manager declaration and instantiation
    private final PostcodeManager postcodeManager = new PostcodeManager("lookupPostcode", ObjectDataOptionsEnum.PERSIST);
    private final TransactionTypeManager transactionTypeManager = new TransactionTypeManager("lookupTransactionType");

    //<editor-fold defaultstate="collapsed" desc="Singleton Methods">
    // private Method to avoid instantiation externally
    private LookupService() {
        // this should be empty
    }

    /**
     * Singleton pattern to get the instance of the {@code LookupService} class
     * @return instance of the {@code LookupService}
     * @throws PersistenceException
     */
    public static LookupService getInstance() throws PersistenceException {
        if(INSTANCE == null) {
            synchronized (LookupService.class) {
                // Check again just incase before we synchronised an instance was created
                if(INSTANCE == null) {
                    INSTANCE = new LookupService().init();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Used to check if the {@code LookupService} class has been initialised. This is used
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
     * initialise all the managed classes in the {@code LookupService}. The
     * method returns an instance of the {@code LookupService} so it can be chained.
     * This must be called before a the {@code LookupService} is used. e.g  {@code LookupService myLookupService = }
     * @return instance of the {@code LookupService}
     * @throws PersistenceException
     */
    public synchronized LookupService init() throws PersistenceException {
        if(initialise) {
            postcodeManager.init();
            transactionTypeManager.init();
        }
        initialise = false;
        return (this);
    }

    /**
     * Reinitialises all the managed classes in the {@code LookupService}. The
     * method returns an instance of the {@code LookupService} so it can be chained.
     * @return instance of the {@code LookupService}
     * @throws PersistenceException
     */
    public LookupService reInitialise() throws PersistenceException {
        initialise = true;
        return (init());
    }

    /**
     * Clears all the managed classes in the {@code LookupService}. This is
     * generally used for testing. If you wish to refresh the object store
     * reInitialise() should be used.
     * @return true if all the managers were cleared successfully
     * @throws PersistenceException
     */
    public boolean clear() throws PersistenceException {
        boolean success = true;
        success = postcodeManager.clear()?success:false;
        success = transactionTypeManager.clear()?success:false;
        INSTANCE = null;
        return success;
    }

    /**
     * TESTING ONLY. Use reInitialise() if you wish to reload memory.
     * <p>
     * Used to reset the {@code LookupService} class instance by setting the INSTANCE reference
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

    public PostcodeManager getPostcodeManager() {
        return postcodeManager;
    }

    public TransactionTypeManager getTransactionTypeManager() {
        return transactionTypeManager;
    }

    //</editor-fold>

    //<editor-fold defaultstate="expanded" desc="Service Level Get Methods">
    /* ***************************************************
     * S E R V I C E  L E V E L   M E T H O D S
     *
     * This section is for all get methods that require
     * information outside their own data store. All other
     * get methods can be found up the tree in the manager
     * or bean of the bean type.
     * ***************************************************/

    public void getPostcodeFromFile() throws FileNotFoundException, PersistenceException, MaxCountReachedException, NullObjectException {
        String csvFile = Paths.get(OssProperties.getInstance().getStorePath(), "data", "lookups", "PostcodeSectors.csv").toString();
        List<List<String>> postcodeList = CSVFileReader.readCSVFile(csvFile);
        if(postcodeList.isEmpty()) {
           throw new PersistenceException("The Postcode lookup file '" + csvFile + "' does not exist or is unreadable");
        }
        // don't write if there are already PostcodeBeans
        if(!postcodeManager.getAllIdentifier().isEmpty()) {
            return;
        }
        // trim the first row as is the header
        postcodeList.remove(0);
        for(List<String> line : postcodeList) {
            int id = postcodeManager.regenerateIdentifier();
            if(line.size() < 10 || line.get(8).isEmpty() || line.get(8).equals("0")|| line.get(9).isEmpty() || line.get(9).equals("0")) {
                continue;
            }
            postcodeManager.setObject(new PostcodeBean(id, line.get(0), Integer.valueOf(line.get(8)), Integer.valueOf(line.get(9)), "LookupService"));
        }
    }

    public void getTransactionTypeFromFile() throws FileNotFoundException, PersistenceException, MaxCountReachedException, NullObjectException {
        String csvFile = Paths.get(OssProperties.getInstance().getStorePath(), "data", "lookups", "TransactionDataType.csv").toString();
        List<List<String>> transactionTypeList = CSVFileReader.readCSVFile(csvFile);
        if(transactionTypeList.isEmpty()) {
           throw new PersistenceException("The Transaction Type lookup file '" + csvFile + "' does not exist or is unreadable");
        }
        // don't write if there are already PostcodeBeans
        if(!transactionTypeManager.getAllIdentifier().isEmpty()) {
            return;
        }
        // trim the first row as is the header
        transactionTypeList.remove(0);
        for(List<String> line : transactionTypeList) {
            int id = transactionTypeManager.regenerateIdentifier();
            if(line.size() < 2) {
                continue;
            }
            transactionTypeManager.setObject(new TransactionTypeBean(id, Integer.valueOf(line.get(0)), line.get(1), "LookupService"));
        }
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
