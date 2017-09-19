/*
 * @(#)OutputContributionHandler.java
 *
 * Copyright:       Copyright (c) 2017
 * Organisation:
 * Schema:
 */
package com.cognitivescale.synthetic.mandg.data.handlers;

import com.cognitivescale.synthetic.mandg.data.entities.ContributionBean;
import com.cognitivescale.synthetic.mandg.data.entities.CustomerBean;
import com.cognitivescale.synthetic.mandg.file.CSV.CSVFileWriter;
import com.cognitivescale.synthetic.mandg.services.EntitiesService;
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
 * The {@code OutputContributionHandler} Class
 *
 * @author Darryl Oatridge
 * @version 1.00 17-Sep-2017
 */
public class OutputContributionHandler extends OutputAbstractHandle {
    /**
     * Write all account information to the CSV file
     *
     * @throws PersistenceException
     * @throws NoSuchIdentifierException
     * @throws IOException
     */
    @Override
    public void writeCSV() throws PersistenceException, NoSuchIdentifierException, IOException {
        // get the root directory
        File csvPath = Paths.get(OssProperties.getInstance().getStorePath(), "data", "output").toFile();
        csvPath.mkdirs();
        File csvFile = Paths.get(csvPath.toString(), "Contribution.csv").toFile();
        FileWriter writer = new FileWriter(csvFile, false);
        // Set the header
        List<String> header = new LinkedList<>(Arrays.asList("CS_ID", "FIRST_CONTRIB_DATE", "FUTURE_DD_PYMT", "PEP_LIMIT_EXCEEDED_DATE", "REM_ALLNCE", "TAX_YEAR_END_DATE", "TAX_YEAR_START_DATE", "TOTAL_CASH_CONTRIB", "TOTAL_EQTY_CONTRIB", "TOTAL_GROSS_CONTRIB"));
        CSVFileWriter.writeLine(writer, header);
        // Print lines
        for(ContributionBean c: EntitiesService.getInstance().getContributionManager().getAllObjects()) {
            int id = c.getId();
            List<String> list = new ArrayList<>();
            // list.add(String.valueOf(id)); No Contribution ID included in the file
            list.add(String.valueOf(c.getCsId()));
            list.add(c.getFirstContributionDate());
            list.add(String.valueOf(c.getFutureDirectDebitPayment()));
            list.add(""); // PEP limit exceeded won't apply
            list.add(String.valueOf(getRemainingIsaAllowance(id)));
            list.add(c.getTaxYearStartDate());
            list.add(c.getTaxYearEndDate());
            list.add(String.valueOf(getTotalCashContribution(id)));
            list.add(String.valueOf(getTotalEquityContribution(id)));
            list.add(String.valueOf(getTotalGrossContribution(id)));




            // write line
            CSVFileWriter.writeLine(writer, list);
        }
        writer.flush();
    }

    /* ***************************************************
     * This is all the calls for the Customer CSV
     * ***************************************************/
    private int getRemainingIsaAllowance(int contributionId) {
        return 0;
    }

    private int getTotalCashContribution(int contributionId) {
        return 0;
    }

    private int getTotalEquityContribution(int contributionId) {
        return 0;
    }

    private int getTotalGrossContribution(int contributionId) {
        return 0;
    }
}
