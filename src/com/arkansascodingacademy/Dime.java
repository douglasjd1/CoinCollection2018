package com.arkansascodingacademy;

import java.math.BigDecimal;

public class Dime
{
    private int year;

    public Dime(int year)
    {
        this.year = year;
    }

    public int getYear()
    {
        return year;
    }

    public BigDecimal getFaceValue()
    {
        return new BigDecimal(".10");
    }

    public BigDecimal getCollectibleValue( int year)
    {
        return new BigDecimal(".10");
    }
}
