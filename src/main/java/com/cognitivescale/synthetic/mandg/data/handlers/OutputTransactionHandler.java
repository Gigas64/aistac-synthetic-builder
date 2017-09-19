/*
 * @(#)OutputTransactionHandler.java
 */
package com.cognitivescale.synthetic.mandg.data.handlers;

import com.cognitivescale.synthetic.mandg.data.entities.TransactionBean;
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
 * The {@code OutputTransactionHandler} Class
 *
 * @author Darryl Oatridge
 * @version 1.00 16-Sep-2017
 */
public class OutputTransactionHandler extends OutputAbstractHandle {

    @Override
    public void writeCSV() throws PersistenceException, NoSuchIdentifierException, IOException {
        // get the root directory
        File csvPath = Paths.get(OssProperties.getInstance().getStorePath(), "data", "output").toFile();
        csvPath.mkdirs();
        File csvFile = Paths.get(csvPath.toString(), "Transaction.csv").toFile();
        FileWriter writer = new FileWriter(csvFile, false);
        // Set the header
        List<String> header = new LinkedList<>(Arrays.asList("CANCEL_IND", "CASH_GROSS_AMT", "CS_ID", "D_TRAN_FUHO_ID", "D_TRAN_ID", "FUND_MNEMONIC", "FUND_NAME", "FUND_SHORT_NAME", "FUTY_DESC", "NET_MVMNT_AMT", "NET_MVMNT_UNITS", "PROACTIVE_DD_AMT", "PROACTIVE_DD_IND", "SRC_OF_BUS", "TRAN_DTE", "TYPE_DESC", "TYPE_ORIG_DESC"));
        CSVFileWriter.writeLine(writer, header);
        // Print lines
        for(TransactionBean t : EntitiesService.getInstance().getTransactionManager().getAllObjects()) {
            int id = t.getId();
            List<String> list = new ArrayList<>();
            list.add(Boolean.toString(t.isCancelled()));
            list.add(String.valueOf(t.getCashGrossAmount()));
            list.add(String.valueOf(t.getCsId()));
            list.add(String.valueOf(t.getFundId()));
            list.add(String.valueOf(t.getId())); // transaction ID
            list.add(t.getIfdsMnemonic());
            list.add(t.getFundName());
            list.add(t.getFundShortName());
            list.add(t.getFundTypeDesc());
            list.add(String.valueOf(t.getNetMovementAmount()));
            list.add(String.valueOf(t.getNetMovementUnits()));
            list.add(String.valueOf(t.getProactiveDirectDebitAmount()));
            list.add(t.getProactiveDirectDebitDesc());
            list.add(t.getBusinessSource());
            list.add(t.getTypeDate());
            list.add(t.getTypeDesc());
            list.add(t.getTypeOrigDesc()); // how was made Online / Post / Phone

            // Write the line to the file
            CSVFileWriter.writeLine(writer, list);
        }
        writer.flush();
    }

}
