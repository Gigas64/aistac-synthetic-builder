/*
 * @(#)OutputCustomerHandler.java
 *
 */
package com.cognitivescale.synthetic.mandg.data.handlers;

import com.cognitivescale.synthetic.mandg.data.entities.CustomerBean;
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
 * The {@code OutputCustomerHandler} Class
 *
 * @author Darryl Oatridge
 * @version 1.00 16-Sep-2017
 */
public class OutputCustomerHandler extends OutputAbstractHandle {

    /**
     * Write all Customer data to the CSV file
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
        File csvFile = Paths.get(csvPath.toString(), "Customer.csv").toFile();
        FileWriter writer = new FileWriter(csvFile, false);
        //for header
        List<String> header = new LinkedList<>(Arrays.asList("CS_ID", "FIRST_CONTRIB_DATE", "FUTURE_DD_PYMT", "PEP_LIMIT_EXCEEDED_DATE", "REM_ALLNCE", "TAX_YEAR_END_DATE", "TAX_YEAR_START_DATE", "TOTAL_CASH_CONTRIB", "TOTAL_EQTY_CONTRIB", "TOTAL_GROSS_CONTRIB"));
        CSVFileWriter.writeLine(writer, header);

        for(CustomerBean c : EntitiesService.getInstance().getCustomerManager().getAllObjects()) {
            int customerId = c.getId();
            List<String> list = new ArrayList<>();
            list.add(String.valueOf(getCusAccAnnualIsaAmount(customerId)));
            list.add(String.valueOf(getCusAnnualOeicAmount(customerId)));
            list.add("Direct"); // Direct / IFM / ISA
            list.add(String.valueOf(c.getId()));
            list.add(c.getStatus());
            list.add(c.getType());
            list.add(c.getDate());
            list.add(String.valueOf(c.getAge()));
            list.add(Boolean.toString(c.isDeceased()));
            list.add(Boolean.toString(this.isHeads(10))); // Emailable
            list.add(c.getGender());
            list.add(String.valueOf(getCusLastLumpSumDate(customerId)));
            list.add(""); // Campagn reference from last transaction
            list.add(Boolean.toString(this.isHeads(10))); // Mailable
            list.add(c.getMaritalStatus());
            list.add("");
            list.add("");
            list.add(String.valueOf(getCusNumOfAcc(customerId)));
            list.add(String.valueOf(getCusNumFundHoldings(customerId)));
            list.add(String.valueOf(getCusNumOfFundTypes(customerId)));
            list.add(String.valueOf(getCusNumOfIsaAcc(customerId)));
            list.add(String.valueOf(getCusNumOfIsaFundTypes(customerId)));
            list.add(String.valueOf(getCusNumOfLumpOeicAcc(customerId)));
            list.add(String.valueOf(getCusNumOfLumpOeicFundsTypes(customerId)));
            list.add(String.valueOf(getCusNumOfOeicAcc(customerId)));
            list.add(String.valueOf(getCusNumOfOeicFundsTypes(customerId)));
            list.add(String.valueOf(0)); // Number of PEP's
            list.add(String.valueOf(0)); // Number of PEP fund types
            list.add(String.valueOf(getCusNumOfProducts(customerId)));
            list.add(String.valueOf(getCusNumOfProducts(customerId)));
            list.add(String.valueOf(getCusNumOfRegOeicAcc(customerId)));
            list.add(String.valueOf(getCusNumOfRegOeicFundsTypes(customerId)));
            list.add(Boolean.toString(c.isOverseasResident()));
            list.add(c.getPostcode());
            list.add(Boolean.toString(this.isHeads(20))); // Phoneable
            list.add(c.getStaffTerms());
            list.add(c.getStartDate());
            list.add(String.valueOf(getCusTotalAccValue(customerId)));
            list.add(String.valueOf(getCusTotalIsaValue(customerId)));
            list.add(String.valueOf(getCusTotalLumpOeicValue(customerId)));
            list.add(String.valueOf(0)); // Total PEP Value
            list.add(String.valueOf(getCusTotalRegOeicValue(customerId)));
            // Write the line to the file
            CSVFileWriter.writeLine(writer, list);
        }
        writer.flush();
    }

    /* ***************************************************
     * This is all the calls for the Customer CSV
     * ***************************************************/
    public int getCusAccAnnualIsaAmount(int customerId) {
        return 0;
    }

    public String getCusLastLumpSumDate(int customerId) {
        return "";
    }

    public int getCusNumOfAcc(int customerId) {
        return getCusNumOfIsaAcc(customerId) + getCusNumOfOeicAcc(customerId);
    }

    public int getCusNumOfOeicAcc(int customerId) {
        return getCusNumOfLumpOeicAcc(customerId) + getCusNumOfRegOeicAcc(customerId);
    }

    public int getCusNumOfProducts(int customerId) {
        return 0;
    }

    public int getCusTotalLumpOeicValue(int customerId) {
        return 0;
    }

    public int getCusNumOfLumpOeicFundsTypes(int customerId) {
        return 0;
    }

    public int getCusNumFundHoldings(int customerId) {
        return 0;
    }

    public int getCusNumOfRegOeicAcc(int customerId) {
        return 0;
    }

    public int getCusAnnualOeicAmount(int customerId) {
        return 0;
    }

    public int getCusNumOfFundTypes(int customerId) {
        return 0;
    }

    public int getCusNumOfIsaAcc(int customerId) {
        return 0;
    }

    public int getCusTotalIsaValue(int customerId) {
        return 0;
    }

    public int getCusNumOfRegOeicFundsTypes(int customerId) {
        return 0;
    }

    public int getCusTotalAccValue(int customerId) {
        return 0;
    }
    public int getCusNumOfOeicFundsTypes(int customerId) {
        return getCusNumOfLumpOeicFundsTypes(customerId) + getCusNumOfRegOeicFundsTypes(customerId);
    }

    public int getCusNumOfIsaFundTypes(int customerId) {
        return 0;
    }

    public int getCusNumOfLumpOeicAcc(int customerId) {
        return 0;
    }

    public int getCusTotalRegOeicValue(int customerId) {
        return 0;
    }


}
