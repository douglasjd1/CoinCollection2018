package com.arkansascodingacademy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CoinCollectionTest
{
    private static final BigDecimal THREE_SEVENTEEN = new BigDecimal("3.17");

    private CoinCollection coinCollection;

    @BeforeEach
    void setUp()
    {
        coinCollection = new CoinCollection(10, 5, 3, 2);
    }

    @AfterEach
    void tearDown()
    {

    }

    @Test
    void addPenny()
    {
        coinCollection.addPenny(1900);
        coinCollection.addPenny(1940);
    }

    @Test
    void addNickel()
    {
        coinCollection.addNickel(1903);
        coinCollection.addNickel(1993);
    }

    @Test
    void addDime()
    {
        coinCollection.addDime(1905);
        coinCollection.addDime(1978);
    }

    @Test
    void addQuarter()
    {
        coinCollection.addQuarter(1908);
        coinCollection.addQuarter(2008);
    }

    @Test
    void getPenniesFaceValue()
    {
        coinCollection.addPenny(1900);
        coinCollection.addPenny(1940);

        assertEquals(new BigDecimal("0.04"), coinCollection.getPenniesFaceValue());
    }

    @Test
    void getPenniesCollectibleValue()
    {
        coinCollection.addPenny(1900);  //1.36
        coinCollection.addPenny(1940);  //0.16

        assertEquals(new BigDecimal("1.54"), coinCollection.getPenniesCollectibleValue());
    }

    @Test
    void getNickelsFaceValue()
    {
        coinCollection.addNickel(1903);
        coinCollection.addNickel(1993);

        assertEquals(new BigDecimal("0.25"), coinCollection.getNickelsFaceValue());

    }

    @Test
    void getNickelsCollectibleValue()
    {
        coinCollection.addNickel(1903); //3.25
        coinCollection.addNickel(1993); //0.05

        assertEquals(new BigDecimal("3.45"), coinCollection.getNickelsCollectibleValue());
    }

    @Test
    void getDimesFaceValue()
    {
        coinCollection.addDime(1905);
        coinCollection.addDime(1978);

        assertEquals(new BigDecimal("0.70"), coinCollection.getDimesFaceValue());

    }

    @Test
    void getDimesCollectibleValue()
    {
        coinCollection.addDime(1905);
        coinCollection.addDime(1978);

        assertEquals(new BigDecimal("0.70"), coinCollection.getDimesCollectibleValue());
    }

    @Test
    void getQuartersFaceValue()
    {
        coinCollection.addQuarter(1908);
        coinCollection.addQuarter(2008);

        assertEquals(new BigDecimal("3.00"), coinCollection.getQuartersFaceValue());

    }

    @Test
    void getQuartersCollectibleValue()
    {
        coinCollection.addQuarter(1908); //3.55
        coinCollection.addQuarter(2008); //0.25

        assertEquals(new BigDecimal("6.30"), coinCollection.getQuartersCollectibleValue());
    }

    @Test
    void getFaceValue()
    {
        assertEquals(THREE_SEVENTEEN, coinCollection.getFaceValue());

        coinCollection.addPenny(1900);
        coinCollection.addNickel(1903);
        coinCollection.addDime(1905);
        coinCollection.addQuarter(1908);

        coinCollection.addPenny(1940);
        coinCollection.addNickel(1993);
        coinCollection.addDime(1978);
        coinCollection.addQuarter(2008);

        assertEquals(new BigDecimal("3.99"), coinCollection.getFaceValue());

    }

    @Test
    void getCollectibleValue()
    {
        assertEquals(THREE_SEVENTEEN, coinCollection.getCollectibleValue());

        coinCollection.addPenny(1900);
        coinCollection.addNickel(1903);
        coinCollection.addDime(1905);
        coinCollection.addQuarter(1908);

        coinCollection.addPenny(1940);
        coinCollection.addNickel(1993);
        coinCollection.addDime(1978);
        coinCollection.addQuarter(2008);

        assertEquals(new BigDecimal("11.99"), coinCollection.getCollectibleValue());
    }
}