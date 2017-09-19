/*
 * @(#)XmlDataMain.java
 *
 * Copyright:	Copyright (c) 2010
 * Company:		Oathouse.com Ltd
 */
package com.cognitivescale.synthetic.mandg.main;

import com.oathouse.oss.server.OssProperties;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * The {@code ObjectStoreServer} Class
 *
 * @author Darryl Oatridge
 * @version 1.00 05-Apr-2011
 */
public class SyntheticEngineStarter {

    private static final Logger LOGGER = Logger.getLogger(SyntheticEngineStarter.class);

    /**
     * @param args the command line arguments
     * @throws Exception
     */
    @SuppressWarnings("static-access")
    public static void main(String[] args) throws Exception {
        // create the command line parser
        final CommandLineParser parser = new PosixParser();
        // create the Options
        final Options options = new Options();
        Option rootDirOption = OptionBuilder.withArgName("rootdir").hasArg().withDescription("the root directory of the data store").create("rootdir");
        Option logConfigOption = OptionBuilder.withArgName("logconfig").hasArg().withDescription("the path of the log config file").create("logconfig");

        options.addOption("h", "help", false, "Prints this usage message");
        options.addOption(rootDirOption);
        options.addOption(logConfigOption);

        CommandLine cmdLine = null;
        try {
            cmdLine = parser.parse(options, args);
            // parse the command line arguments
        } catch(ParseException exp) {
            System.err.println("Unexpected exception when reading command line options: " + exp.getMessage());
            usage(options);
        }
        if(cmdLine.hasOption('h') || cmdLine.hasOption("help")) {
            usage(options);
        }
        // create logger
        final String rootStorePath = cmdLine.getOptionValue("rootdir", "./datastore");
        final String logConfigFile = cmdLine.getOptionValue("logconfig", "./datastore/conf/oss_log4j.properties");
        PropertyConfigurator.configure(logConfigFile);
        // start up the logger
        LOGGER.debug("Command Line Options:");
        LOGGER.debug("   rootDir        = " + rootStorePath);
        LOGGER.debug("   logConfig      = " + logConfigFile);
        LOGGER.debug("   LogLevel       = " + LOGGER.getEffectiveLevel().toString());

        OssProperties.getInstance().setAuthority("SyntheticEngine");
        OssProperties.getInstance().setLogConfigFile(logConfigFile);
        OssProperties.getInstance().setStorePath(rootStorePath);

        SyntheticEngineHandler handler = new SyntheticEngineHandler();
        handler.run();
    }

    private static void usage(Options options) {
        // automatically generate the help statement
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("java SyntheticDataHandler", options);
        System.exit(0);

    }

    // this is an entry point classand thus should not be instanciated
    private SyntheticEngineStarter() {
    }
}
