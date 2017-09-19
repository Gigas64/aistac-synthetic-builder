/*
 * @(#)OutputLocationHandler.java
 *
 * Copyright:       Copyright (c) 2017
 * Organisation:
 * Schema:
 */
package com.cognitivescale.synthetic.mandg.data.handlers;

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
 * The {@code OutputLocationHandler} Class
 *
 * @author Darryl Oatridge
 * @version 1.00 17-Sep-2017
 */
public class OutputLocationHandler extends OutputAbstractHandle {

    @Override
    public void writeCSV() throws PersistenceException, NoSuchIdentifierException, IOException {
        // get the root directory
        File csvPath = Paths.get(OssProperties.getInstance().getStorePath(), "data", "output").toFile();
        csvPath.mkdirs();
        File csvFile = Paths.get(csvPath.toString(), "Location.csv").toFile();
        FileWriter writer = new FileWriter(csvFile, false);
        // Set the header
        List<String> header = new LinkedList<>(Arrays.asList("CS_ID", "EMAIL_ADDRESS_AVAILABLE", "HOME_PHONE_AVAILABLE", "MOBILE_PHONE_AVAILABLE"));
        CSVFileWriter.writeLine(writer, header);
        // Print lines
        for(CustomerBean c : EntitiesService.getInstance().getCustomerManager().getAllObjects()) {
            int id = c.getId();
            List<String> list = new ArrayList<>();
            list.add(Boolean.toString(this.isHeads(5))); // Email Available
            list.add(Boolean.toString(this.isHeads(10))); // Home Phone Avsilable
            list.add(Boolean.toString(this.isHeads(10))); // Mobile Phone Available

            // Write the line to the file
            CSVFileWriter.writeLine(writer, list);
        }
        writer.flush();

    }


}
