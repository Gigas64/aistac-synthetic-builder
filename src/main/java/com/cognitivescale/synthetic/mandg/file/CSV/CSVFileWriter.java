/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * @(#)CSVFileWriter.java
 *
 * Copyright:	Copyright (c) 2017
 * Company:		Oathouse.com Ltd
 */
package com.cognitivescale.synthetic.mandg.file.CSV;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 * The {@code CSVFileWriter} Class
 * Thanks mkyong.com for the code
 *
 * @author Darryl Oatridge
 * @version 1.00 14-Sep-2017
 */
public class CSVFileWriter {
    private static final char DEFAULT_SEPARATOR = ',';

    public static void writeLine(Writer w, List<String> values) throws IOException {
        writeLine(w, values, DEFAULT_SEPARATOR, ' ');
    }

    public static void writeLine(Writer w, List<String> values, char separators) throws IOException {
        writeLine(w, values, separators, ' ');
    }

    public static void writeLine(Writer w, List<String> values, char separators, char customQuote) throws IOException {
        boolean first = true;

        //default customQuote is empty
        if (separators == ' ') {
            separators = DEFAULT_SEPARATOR;
        }

        StringBuilder sb = new StringBuilder();
        for (String value : values) {
            if (!first) {
                sb.append(separators);
            }
            if (customQuote == ' ') {
                sb.append(followCVSformat(value));
            } else {
                sb.append(customQuote).append(followCVSformat(value)).append(customQuote);
            }

            first = false;
        }
        sb.append("\n");
        w.append(sb.toString());
    }

    //https://tools.ietf.org/html/rfc4180
    private static String followCVSformat(String value) {

        String result = value;
        if (result.contains("\"")) {
            result = result.replace("\"", "\"\"");
        }
        return result;

    }



}
