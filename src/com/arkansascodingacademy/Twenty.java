package com.arkansascodingacademy;

import java.math.BigDecimal;

public class Twenty implements ICurrency
{
    private int serialNumber = 0;
    private int year = 0;

    public Twenty(int year, int serialNumber)
    {
        this.serialNumber = serialNumber;
        this.year = year;
    }

    public int getYear()
    {
        return year;
    }

    public int getSerialNumber()
    {
        return serialNumber;
    }

    @Override
    public BigDecimal getFaceValue()
    {
        return new BigDecimal("20");
    }

    @Override
    public BigDecimal getCollectibleValue()
    {
        BigDecimal value = new BigDecimal(20);

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
        return "Twenty";
    }
}
