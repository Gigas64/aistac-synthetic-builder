package com.cognitivescale.synthetic.mandg.file.CSV;

import com.oathouse.oss.storage.objectstore.ObjectBean;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * The {@code CSVFileReader} Class
 * Thanks mkyong.com for the code
 *
 * @author Darryl Oatridge
 * @version 1.00 14-Sep-2017
 */
public class CSVFileReader {

    private static final char DEFAULT_SEPARATOR = ',';
    private static final char DEFAULT_QUOTE = '"';

    /**
     * Static utility method to read in a CSV file. using the default comma separator and striping double quotes
     *
     * @param csvFile the location and name of the file
     * @return a line list of a row list of Strings
     * @throws FileNotFoundException
     */
    public static List<List<String>> readCSVFile(String csvFile) throws FileNotFoundException {
        return readCSVFile(csvFile, DEFAULT_SEPARATOR, DEFAULT_QUOTE);
    }

    /**
     * Static utility method to read in a CSV file.
     *
     * @param csvFile csvFile the location and name of the file
     * @param separator the file separator
     * @param quote the quote around entries, if any
     * @return a line list of a row list of Strings
     * @throws java.io.FileNotFoundException
     */
    public static List<List<String>> readCSVFile(String csvFile, char separator, char quote) throws FileNotFoundException {
        List<List<String>> rtnList = new LinkedList<>();

        File readFile = new File(csvFile);
        if(readFile.exists() && readFile.isFile()) {
            try (Scanner scanner = new Scanner(readFile)) {
                while (scanner.hasNext()) {
                    List<String> line = parseLine(scanner.nextLine());
                    rtnList.add(line);
                }
            }
        }
        return rtnList;
    }

    private static List<String> parseLine(String cvsLine) {
        return parseLine(cvsLine, DEFAULT_SEPARATOR, DEFAULT_QUOTE);
    }

    private static List<String> parseLine(String cvsLine, char separators) {
        return parseLine(cvsLine, separators, DEFAULT_QUOTE);
    }

    private static List<String> parseLine(String cvsLine, char separators, char customQuote) {

        List<String> result = new ArrayList<>();

        //if empty, return!
        if (cvsLine == null && cvsLine.isEmpty()) {
            return result;
        }

        if (customQuote == ' ') {
            customQuote = DEFAULT_QUOTE;
        }

        if (separators == ' ') {
            separators = DEFAULT_SEPARATOR;
        }

        StringBuffer curVal = new StringBuffer();
        boolean inQuotes = false;
        boolean startCollectChar = false;
        boolean doubleQuotesInColumn = false;

        char[] chars = cvsLine.toCharArray();

        for (char ch : chars) {

            if (inQuotes) {
                startCollectChar = true;
                if (ch == customQuote) {
                    inQuotes = false;
                    doubleQuotesInColumn = false;
                } else {

                    //Fixed : allow "" in custom quote enclosed
                    if (ch == '\"') {
                        if (!doubleQuotesInColumn) {
                            curVal.append(ch);
                            doubleQuotesInColumn = true;
                        }
                    } else {
                        curVal.append(ch);
                    }

                }
            } else {
                if (ch == customQuote) {

                    inQuotes = true;

                    //Fixed : allow "" in empty quote enclosed
                    if (chars[0] != '"' && customQuote == '\"') {
                        curVal.append('"');
                    }

                    //double quotes in column will hit this!
                    if (startCollectChar) {
                        curVal.append('"');
                    }

                } else if (ch == separators) {

                    result.add(curVal.toString());

                    curVal = new StringBuffer();
                    startCollectChar = false;

                } else if (ch == '\r') {
                    //ignore LF characters
                    continue;
                } else if (ch == '\n') {
                    //the end, break!
                    break;
                } else {
                    curVal.append(ch);
                }
            }

        }

        result.add(curVal.toString());

        return result;
    }

    private static void writeLine(FileWriter writer, List<String> list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private CSVFileReader() {
    }

}