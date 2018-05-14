package com.arkansascodingacademy;

import java.math.BigDecimal;

public class Quarter implements ICurrency
{
    private int year;

    public Quarter(int year)
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
        return new BigDecimal(".25");
    }

    @Override
    public BigDecimal getCollectibleValue()
    {
        BigDecimal value = new BigDecimal(.25);

        if(year < 1923)
        {
            BigDecimal factor = new BigDecimal(.22 * (1923 - year));
            value = value.add(factor);
        }

        return value;
    }

    @Override
    public String getName()
    {
        return "Quarter";
    }
}
