/*
 * @(#)OutputAbstractHandle.java
 *
 * Copyright:       Copyright (c) 2017
 * Organisation:
 * Schema:          
 */
package com.cognitivescale.synthetic.mandg.data.handlers;

import com.oathouse.oss.storage.exceptions.NoSuchIdentifierException;
import com.oathouse.oss.storage.exceptions.PersistenceException;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The {@code OutputAbstractHandle} Abstract Class
 *
 * @author Darryl Oatridge
 * @version 1.00 17-Sep-2017
 */
public abstract class OutputAbstractHandle {
    public abstract void writeCSV() throws PersistenceException, NoSuchIdentifierException, IOException;

    /**
     * @param chance the chance of a heads being thrown (1 in x where x is the chance)
     * @return true if the chance happened else false
     */
    public boolean isHeads(int chance) {
        int randNum = ThreadLocalRandom.current().nextInt(1, 1001);
        return (randNum % chance) == 0;
    }

    public int getNum(int max) {
        return getNum(0, max);
    }

    public int getNum(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max+1);
    }

}
