package com.arkansascodingacademy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class CoinCollection
{
    List<Quarter> quarters = new ArrayList<>();
    List<Dime> dimes = new ArrayList<>();
    List<Nickel> nickels = new ArrayList<>();
    List<Penny> pennies = new ArrayList<>();

    public CoinCollection(int quarterCount, int dimeCount, int nickelCount, int pennyCount)
    {
        for(int i = 0; i < quarterCount; i++)
        {
            addQuarter(2000);
        }

        for(int i = 0; i < dimeCount; i++)
        {
            addDime(2000);
        }

        for(int i = 0; i < nickelCount; i++)
        {
            addNickel(2000);
        }

        for(int i = 0; i < pennyCount; i++)
        {
            addPenny(2000);
        }
    }

    public void addQuarter(int year)
    {
        Quarter quarter = new Quarter(year);
        quarters.add(quarter);
    }

    public void addDime(int year)
    {
        Dime dime = new Dime(year);
        dimes.add(dime);
    }

    public void addNickel(int year)
    {
        Nickel nickel = new Nickel(year);
        nickels.add(nickel);
    }

    public void addPenny(int year)
    {
        Penny penny = new Penny(year);
        pennies.add(penny);
    }

    public BigDecimal getQuartersFaceValue()
    {
        BigDecimal value = BigDecimal.ZERO;
        for(Quarter quarter : quarters)
        {
            value = value.add(quarter.getFaceValue());
        }

        return value.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getDimesFaceValue()
    {
        BigDecimal value = BigDecimal.ZERO;
        for(Dime dime : dimes)
        {
            value = value.add(dime.getFaceValue());
        }

        return value.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getNickelsFaceValue()
    {
        BigDecimal value = BigDecimal.ZERO;
        for(Nickel nickel : nickels)
        {
            value = value.add(nickel.getFaceValue());
        }

        return value.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getPenniesFaceValue()
    {
        BigDecimal value = BigDecimal.ZERO;
        for(Penny penny : pennies)
        {
            value = value.add(penny.getFaceValue());
        }

        return value.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getQuartersCollectibleValue()
    {
        BigDecimal value = BigDecimal.ZERO;
        for(Quarter quarter : quarters)
        {
            value = value.add(quarter.getCollectibleValue(quarter.getYear()));
        }

        return value.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getDimesCollectibleValue()
    {
        BigDecimal value = BigDecimal.ZERO;
        for (Dime dime : dimes)
        {
            value = value.add(dime.getCollectibleValue(dime.getYear()));
        }

        return value.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getNickelsCollectibleValue()
    {
        BigDecimal value = BigDecimal.ZERO;
        for (Nickel nickel : nickels)
        {
            value = value.add(nickel.getCollectibleValue(nickel.getYear()));
        }

        return value.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getPenniesCollectibleValue()
    {
        BigDecimal value = BigDecimal.ZERO;
        for (Penny penny : pennies)
        {
            value = value.add(penny.getCollectibleValue(penny.getYear()));
        }

        return value.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getFaceValue()
    {
        BigDecimal value = new BigDecimal(0.0);

        value = value.add(getQuartersFaceValue());
        value = value.add(getDimesFaceValue());
        value = value.add(getNickelsFaceValue());
        value = value.add(getPenniesFaceValue());

        return value;
    }

    public BigDecimal getCollectibleValue()
    {
        BigDecimal value = BigDecimal.ZERO;
        value = value.add(getQuartersCollectibleValue());
        value = value.add(getDimesCollectibleValue());
        value = value.add(getNickelsCollectibleValue());
        value = value.add(getPenniesCollectibleValue());

        return value;
    }
}
