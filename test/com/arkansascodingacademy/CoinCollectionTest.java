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
    void addOne()
    {
        coinCollection.addOne(2000, 1000);
        coinCollection.addOne(2000, 1000);
    }

    @Test
    void addFive()
    {
        coinCollection.addFive(1990, 1560);
        coinCollection.addFive(1990, 150);
    }

    @Test
    void addTen()
    {
        coinCollection.addTen(1977, 3340);
        coinCollection.addTen(1977, 340);
    }

    @Test
    void addTwenty()
    {
        coinCollection.addTwenty(2018, 1067);
        coinCollection.addTwenty(2018, 106);
    }

    @Test
    void addOneHundred()
    {
        coinCollection.addOneHundred(2001, 1067);
        coinCollection.addOneHundred(2001, 67);
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
        coinCollection.setCurrentYear(2028);

        assertEquals(new BigDecimal("1.64"), coinCollection.getPenniesCollectibleValue());
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
        coinCollection.setCurrentYear(2028);

        assertEquals(new BigDecimal("3.55"), coinCollection.getNickelsCollectibleValue());
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
        coinCollection.setCurrentYear(2028);

        assertEquals(new BigDecimal("0.80"), coinCollection.getDimesCollectibleValue());
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
        coinCollection.setCurrentYear(2028);

        assertEquals(new BigDecimal("6.40"), coinCollection.getQuartersCollectibleValue());
    }

    @Test
    void getOnesFaceValue()
    {
        coinCollection.addOne(1999,1000);
        coinCollection.addOne(1987, 100);

        assertEquals(new BigDecimal("2.00"), coinCollection.getOnesFaceValue());
    }

    @Test
    void getFivesFaceValue()
    {
        coinCollection.addFive(1987, 4567);
        coinCollection.addFive(1988, 100);

        assertEquals(new BigDecimal("10.00"), coinCollection.getFivesFaceValue());
    }

    @Test
    void getTensFaceValue()
    {
        coinCollection.addTen(1987, 4567);
        coinCollection.addTen(1988, 458);

        assertEquals(new BigDecimal("20.00"), coinCollection.getTensFaceValue());
    }

    @Test
    void getTwentiesFaceValue()
    {
        coinCollection.addTwenty(1987, 4567);
        coinCollection.addTwenty(1988, 458);

        assertEquals(new BigDecimal("40.00"), coinCollection.getTwentiesFaceValue());
    }
    @Test
    void getOneHundredsFaceValue()
    {
        coinCollection.addOneHundred(1987, 4567);
        coinCollection.addOneHundred(1988, 458);

        assertEquals(new BigDecimal("200.00"), coinCollection.getOneHundredsFaceValue());
    }

    @Test
    void getOnesCollectibleValue()
    {
        coinCollection.addOne(1999,1039);
        coinCollection.addOne(1987, 10);

        assertEquals(new BigDecimal("11.00"), coinCollection.getOnesCollectibleValue());
    }

    @Test
    void getFivesCollectibleValue()
    {
        coinCollection.addFive(1987, 4567);
        coinCollection.addFive(1988, 100);

        assertEquals(new BigDecimal("55.00"), coinCollection.getFivesCollectibleValue());
    }

    @Test
    void getTensCollectibleValue()
    {
        coinCollection.addTen(1987, 4567);
        coinCollection.addTen(1988, 458);

        assertEquals(new BigDecimal("110.00"), coinCollection.getTensCollectibleValue());
    }

    @Test
    void getTwentiesCollectibleValue()
    {
        coinCollection.addTwenty(1987, 4567);
        coinCollection.addTwenty(1988, 458);

        assertEquals(new BigDecimal("220.00"), coinCollection.getTwentiesCollectibleValue());
    }
    @Test
    void getOneHundredsCollectibleValue()
    {
        coinCollection.addOneHundred(1987, 4567);
        coinCollection.addOneHundred(1988, 458);

        assertEquals(new BigDecimal("1100.00"), coinCollection.getOneHundredsCollectibleValue());
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