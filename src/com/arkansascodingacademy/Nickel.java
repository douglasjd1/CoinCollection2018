package com.arkansascodingacademy;

import java.math.BigDecimal;

public class Nickel implements ICurrency
{
    private int year;

    public Nickel(int year)
    {
        this.year = year;
    }

    public BigDecimal getFaceValue()
    {
        return new BigDecimal(".05");
    }

    @Override
    public BigDecimal getCollectibleValue()
    {
        BigDecimal value = new BigDecimal(.05);

        if(year < 1935)
        {
            BigDecimal factor = new BigDecimal(.10 * (1935 - year));
            value = value.add(factor);
        }

        return value;
    }

    @Override
    public String getName()
    {
        return "Nickel";
    }

    public int getYear()
    {
        return year;
    }
}
