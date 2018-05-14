package com.arkansascodingacademy;

import javax.swing.*;
import java.math.BigDecimal;

public class Dime implements ICurrency
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

    @Override
    public BigDecimal getFaceValue()
    {
        return new BigDecimal(".10");
    }

    @Override
    public BigDecimal getCollectibleValue()
    {
        return new BigDecimal(".10");
    }

    @Override
    public String getName()
    {
        return "Dime";
    }
}
