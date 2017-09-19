/*
 * @(#)OutputAccountHandler.java
 */
package com.cognitivescale.synthetic.mandg.data.handlers;

import com.cognitivescale.synthetic.mandg.data.entities.AccountBean;
import com.cognitivescale.synthetic.mandg.file.CSV.CSVFileWriter;
import com.cognitivescale.synthetic.mandg.services.EntitiesService;
import com.cognitivescale.synthetic.mandg.services.SyntheticEngineService;
import com.oathouse.oss.server.OssProperties;
import com.oathouse.oss.storage.exceptions.NoSuchIdentifierException;
import com.oathouse.oss.storage.exceptions.PersistenceException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * The {@code OutputAccountHandler} Class
 *
 * @author Darryl Oatridge
 * @version 1.00 16-Sep-2017
 */
public class OutputAccountHandler extends OutputAbstractHandle{

    /**
     * Write all account information to the CSV file
     *
     * @throws PersistenceException
     * @throws NoSuchIdentifierException
     * @throws IOException
     */
    @Override
    public void writeCSV() throws PersistenceException, NoSuchIdentifierException, IOException {
        SyntheticEngineService ses = SyntheticEngineService.getInstance();

        // get the root directory
        File csvPath = Paths.get(OssProperties.getInstance().getStorePath(), "data", "output").toFile();
        csvPath.mkdirs();
        File csvFile = Paths.get(csvPath.toString(), "Accounts.csv").toFile();
        FileWriter writer = new FileWriter(csvFile, false);
        // Set the header
        List<String> header = new LinkedList<>(Arrays.asList("ANNUAL_PREMIUM_AMT", "CS_ID", "D_ACCO_ID", "DD_FIRST_CONTRIB_DATE", "DD_NXT_CONTRIB_DATE", "JOINT_PRODUCT_IND", "LAST_LMP_SUM_AMT", "LAST_LMP_SUM_DATE", "OPEN_FUNDS", "PROD_DESC", "SERV_AGENT_MNEMONIC", "SRC_OF_BUS", "STAFF_TERMS_APPLIED", "STATUS", "VAL"));
        CSVFileWriter.writeLine(writer, header);
        // Print lines
        for(AccountBean a : EntitiesService.getInstance().getAccountManager().getAllObjects()) {
            int accountId = a.getId();
            List<String> list = new ArrayList<>();
            list.add(String.valueOf(getAccountAnnualPremiumAmount(accountId)));
            list.add(String.valueOf(a.getCustomerId()));
            list.add(String.valueOf(a.getId()));
            list.add(getAccountFirstDDContributionDate(accountId));
            list.add(getAccountNextDDContributionDate(accountId));
            list.add(a.getJointProduct());
            list.add(String.valueOf(getAccountLastLumpSumAmount(accountId)));
            list.add(getAccountLastLumpSumAmountDate(accountId));
            list.add(String.valueOf(getAccountTotalNumberOpenFunds(accountId)));
            list.add(a.getProductDesc());
            list.add(a.getServicingAgent());
            list.add(a.getSourceOfBusiness());
            list.add(a.getStaffTermsApplied());
            list.add(a.getStatus());
            list.add(String.valueOf(getAccountTotalValue(accountId)));
            CSVFileWriter.writeLine(writer, list);
        }
        writer.flush();
    }

    /* ***************************************************
     * This is all the calls for the Account CSV
     * ***************************************************/
    private int getAccountAnnualPremiumAmount(int accountId) {
        return 0;
    }

    private String getAccountNextDDContributionDate(int accountId) {
        return "";
    }

    private String getAccountLastLumpSumAmountDate(int accountId) {
        return "";
    }

    private int getAccountTotalNumberOpenFunds(int accountId) {
        return 0;
    }

    private int getAccountTotalValue(int accountId) {
        return 0;
    }

    private int getAccountLastLumpSumAmount(int accountId) {
        return 0;
    }

    private String getAccountFirstDDContributionDate(int accountId) {
        return "";
    }

}
