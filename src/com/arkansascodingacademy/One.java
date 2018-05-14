package com.arkansascodingacademy;

import java.math.BigDecimal;

public class One implements ICurrency
{
    private int serialNumber;
    private int year;

    public One(int year, int serialNumber)
    {
        this.serialNumber = serialNumber;
        this.year = year;
    }

    public int getYear()
    {
        return this.year;
    }

    public int getSerialNumber()
    {
        return serialNumber;
    }

    @Override
    public BigDecimal getFaceValue()
    {
        return new BigDecimal("1");
    }

    @Override
    public BigDecimal getCollectibleValue()
    {
        BigDecimal value = new BigDecimal(1);

        if(serialNumber < 1000)
        {
            BigDecimal factor = new BigDecimal(10);
            value = value.multiply(factor);
        }

        return value;
    }

    @Override
    public String getName()
    {
        return "One";
    }
}
