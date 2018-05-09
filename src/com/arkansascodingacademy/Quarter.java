package com.arkansascodingacademy;

import java.math.BigDecimal;

public class Quarter
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

    public BigDecimal getFaceValue()
    {
        return new BigDecimal(".25");
    }

    public BigDecimal getCollectibleValue(int year)
    {
        BigDecimal value = new BigDecimal(.25);

        if(year < 1923)
        {
            BigDecimal factor = new BigDecimal(.22 * (1923 - year));
            value = value.add(factor);
        }

        return value;
    }

}
