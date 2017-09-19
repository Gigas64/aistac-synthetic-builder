/*
 * @(#)OutputSuppressionHandler.java
 *
 * Copyright:       Copyright (c) 2017
 * Organisation:    Expression organisation is undefined on line 10, column 23 in Templates/Classes/Class.java.
 * Schema:          Expression schema is undefined on line 11, column 23 in Templates/Classes/Class.java.
 */
package com.cognitivescale.synthetic.mandg.data.handlers;

import com.cognitivescale.synthetic.mandg.data.entities.SuppressionBean;
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
 * The {@code OutputSuppressionHandler} Class
 *
 * @author Darryl Oatridge
 * @version 1.00 17-Sep-2017
 */
public class OutputSuppressionHandler extends OutputAbstractHandle {

    @Override
    public void writeCSV() throws PersistenceException, NoSuchIdentifierException, IOException {
        // get the root directory
        File csvPath = Paths.get(OssProperties.getInstance().getStorePath(), "data", "output").toFile();
        csvPath.mkdirs();
        File csvFile = Paths.get(csvPath.toString(), "Suppression.csv").toFile();
        FileWriter writer = new FileWriter(csvFile, false);
        // Set the header
        List<String> header = new LinkedList<>(Arrays.asList("CS_ID", "SUB_TYP", "TYP"));
        CSVFileWriter.writeLine(writer, header);
        // Print lines
        for(SuppressionBean s : EntitiesService.getInstance().getSuppressionManager().getAllObjects()) {
            int id = s.getId();
            List<String> list = new ArrayList<>();
            // list.add(String.valueOf(id)); // Suppression ID not included in file
            list.add(String.valueOf(s.getCsId()));
            list.add(s.getSubType());
            list.add(s.getType());

            // Write the line to the file
            CSVFileWriter.writeLine(writer, list);
        }
        writer.flush();

    }

}
