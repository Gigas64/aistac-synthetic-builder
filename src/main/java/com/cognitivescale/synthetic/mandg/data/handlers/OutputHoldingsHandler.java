/*
 * @(#)OutputHoldingsHandler.java
 */
package com.cognitivescale.synthetic.mandg.data.handlers;

import com.cognitivescale.synthetic.mandg.data.entities.FundHoldingBean;
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
 * The {@code OutputHoldingsHandler} Class
 *
 * @author Darryl Oatridge
 * @version 1.00 16-Sep-2017
 */
public class OutputHoldingsHandler extends OutputAbstractHandle{

    @Override
    public void writeCSV() throws PersistenceException, NoSuchIdentifierException, IOException {
        // get the root directory
        File csvPath = Paths.get(OssProperties.getInstance().getStorePath(), "data", "output").toFile();
        csvPath.mkdirs();
        File csvFile = Paths.get(csvPath.toString(), "Fund_Holding.csv").toFile();
        FileWriter writer = new FileWriter(csvFile, false);
        // Set the header
        List<String> header = new LinkedList<>(Arrays.asList("D_FUHO_ACCO_ID", "D_FUHO_ID", "FUTY_DESC", "ISIN", "M&G_FUND_MNUEMONIC", "MNEMONIC", "PAY_FREQ_DESC", "REG_PREMIUM_AMT", "REINVEST_DIVI_IND", "SHORT_NAME", "STRT_DATE", "TOT_SET_UNITS", "TOTAL_CONTRIBUTIONS", "VAL", "VAPO_DATE"));
        CSVFileWriter.writeLine(writer, header);
        // Print lines
        for(FundHoldingBean f : EntitiesService.getInstance().getFundHolderManager().getAllObjects()) {
            int id = f.getId();
            List<String> list = new ArrayList<>();
            list.add(String.valueOf(f.getAccountId()));
            list.add(String.valueOf(id));
            list.add(f.getFundTypeDesc());
            list.add(f.getISIN());
            list.add(f.getMandgMnemonic());
            list.add(f.getIfdsMnemonic());
            list.add(f.getPayFreqDesc());
            list.add(String.valueOf(f.getRegPremiumAmt()));
            list.add(Boolean.toString(f.isReinvestDiv()));
            list.add(f.getShortName());
            list.add(f.getStartDate());
            list.add(String.valueOf(getFundTotalSetUnits(id)));
            list.add(String.valueOf(getFundTotalContribution(id)));
            list.add(String.valueOf(getFundTotalValue(id)));
            list.add(getDateLastValuation(id));

            // Write the line to the file
            CSVFileWriter.writeLine(writer, list);
        }
        writer.flush();
    }
    /* ***************************************************
     * This is all the calls for the CSV
     * ***************************************************/
    public int getFundTotalSetUnits(int fundId) {
        return 0;
    }

    public int getFundTotalContribution(int fundId) {
        return 0;
    }

    public int getFundTotalValue(int fundId) {
        return 0;
    }

    public String getDateLastValuation(int fundId) {
        return "";
    }

}
