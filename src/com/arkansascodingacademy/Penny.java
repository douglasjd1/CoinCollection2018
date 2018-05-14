package com.arkansascodingacademy;

import java.math.BigDecimal;

public class Penny implements ICurrency
{
    private int year;

    public Penny(int year)
    {
        this.year = year;
    }

    public int getYear()
    {
        return year;
    }

    @Override
    public BigDecimal getFaceValue()
    {
        return new BigDecimal(".01");
    }

    @Override
    public BigDecimal getCollectibleValue()
    {
        BigDecimal value = new BigDecimal(.01);

        if(year < 1945)
        {
            BigDecimal factor = new BigDecimal(.03 * (1945 - year));
            value = value.add(factor);
        }

        return value;
    }

    @Override
    public String getName()
    {
        return "Penny";
    }

}
