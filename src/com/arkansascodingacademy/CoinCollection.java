package com.arkansascodingacademy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CoinCollection
{
    public List<Quarter> quarters = new ArrayList<>();
    public List<Dime> dimes = new ArrayList<>();
    public List<Nickel> nickels = new ArrayList<>();
    public List<Penny> pennies = new ArrayList<>();
    public List<One> ones = new ArrayList<>();
    public List<Five> fives = new ArrayList<>();
    public List<Ten> tens = new ArrayList<>();
    public List<Twenty> twenties = new ArrayList<>();
    public List<OneHundred> oneHundreds = new ArrayList<>();
    Exception e = new Exception();
    Random random = new Random();
    int currentYear = 2018;

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

    public CoinCollection(BigDecimal amount)
    {
        int numOneHundreds;
        int numTwenties;
        int numTens;
        int numFives;
        int numOnes;
        int numQuarters;
        int numDimes;
        int numNickels;
        int numPennies;

        amount = amount.multiply(new BigDecimal(100));

        numOneHundreds = (amount.divide(new BigDecimal(10000))).intValue();
        for(int i = 0; i < numOneHundreds; i++)
        {
            OneHundred oneHundred = new OneHundred(2000, random.nextInt(5000 + 1));
            oneHundreds.add(oneHundred);
        }
        amount = amount.subtract(new BigDecimal(numOneHundreds * 10000)).setScale(0, RoundingMode.HALF_UP);

        numTwenties = (amount.divide(new BigDecimal(2000))).intValue();
        for(int i = 0; i < numTwenties; i++)
        {
            Twenty twenty = new Twenty(2000, random.nextInt(5000 + 1));
            twenties.add(twenty);
        }
        amount = amount.subtract(new BigDecimal(numTwenties * 2000)).setScale(0, RoundingMode.HALF_UP);

        numTens = (amount.divide(new BigDecimal(1000))).intValue();
        for(int i = 0; i < numTens; i++)
        {
            Ten ten = new Ten(2000, random.nextInt(5000 + 1));
            tens.add(ten);
        }
        amount = amount.subtract(new BigDecimal(numTens * 1000)).setScale(0, RoundingMode.HALF_UP);

        numFives = (amount.divide(new BigDecimal(500))).intValue();
        for(int i = 0; i < numFives; i++)
        {
            Five five= new Five(2000, random.nextInt(5000 + 1));
            fives.add(five);
        }
        amount = amount.subtract(new BigDecimal(numFives * 500)).setScale(0, RoundingMode.HALF_UP);

        numOnes = (amount.divide(new BigDecimal(100))).intValue();
        for(int i = 0; i < numOnes; i++)
        {
            One one = new One(2000, random.nextInt(5000 + 1));
            ones.add(one);
        }
        amount = amount.subtract(new BigDecimal(numOnes * 100)).setScale(0, RoundingMode.HALF_UP);

        numQuarters = (amount.divide(new BigDecimal(25))).intValue();
        for(int i = 0; i < numQuarters; i++)
        {
            Quarter quarter = new Quarter(2000);
            quarters.add(quarter);
        }
        amount = amount.subtract(new BigDecimal(numQuarters * 25)).setScale(0, RoundingMode.HALF_UP);

        numDimes = (amount.divide(new BigDecimal(10))).intValue();
        for(int i = 0; i < numDimes; i++)
        {
            Dime dime = new Dime(2000);
            dimes.add(dime);
        }
        amount = amount.subtract(new BigDecimal(numDimes * 10)).setScale(0, RoundingMode.HALF_UP);

        numNickels = (amount.divide(new BigDecimal(5))).intValue();
        for(int i = 0; i < numNickels; i++)
        {
            Nickel nickel = new Nickel(2000);
            nickels.add(nickel);
        }
        amount = amount.subtract(new BigDecimal(numNickels * 5)).setScale(0, RoundingMode.HALF_UP);

        numPennies = (amount.divide(new BigDecimal(1))).intValue();
        for(int i = 0; i < numPennies; i++)
        {
            Penny penny = new Penny(2000);
            pennies.add(penny);
        }
        amount = amount.subtract(new BigDecimal(numPennies * 01)).setScale(0, RoundingMode.HALF_UP);
    }

    public void setCurrentYear(int currentYear)
    {
        this.currentYear = currentYear;
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

    public void addOne(int year, int serialNumber)
    {
        One one = new One(year, serialNumber);
        try
        {
            for (One bill : ones)
            {
                if (bill.getSerialNumber() == one.getSerialNumber())
                {
                    throw new Exception();
                }
            }

        }
        catch(Exception e)
        {
            System.out.println("That bill was already added.");
        }
        ones.add(one);
    }

    public void addFive(int year, int serialNumber)
    {
        Five five = new Five(year, serialNumber);
        fives.add(five);
    }

    public void addTen(int year, int serialNumber)
    {
        Ten ten = new Ten(year, serialNumber);
        tens.add(ten);
    }

    public void addTwenty(int year, int serialNumber)
    {
        Twenty twenty = new Twenty(year, serialNumber);
        twenties.add(twenty);
    }

    public void addOneHundred(int year, int serialNumber)
    {
        OneHundred oneHundred = new OneHundred(year, serialNumber);
        oneHundreds.add(oneHundred);
    }

    public boolean oneBillAlreadyEntered(int serialNumber)
    {
        for(One one : ones)
        {
            if(one.getSerialNumber() == serialNumber);
            return true;
        }

        return false;
    }

    public boolean fiveBillAlreadyEntered(int serialNumber)
    {
        for(Five five : fives)
        {
            if(five.getSerialNumber() == serialNumber);
            return true;
        }

        return false;
    }

    public boolean tenBillAlreadyEntered(int serialNumber)
    {
        for(Ten ten : tens)
        {
            if(ten.getSerialNumber() == serialNumber);
            return true;
        }

        return false;
    }

    public boolean twentyBillAlreadyEntered(int serialNumber)
    {
        for(Twenty twenty : twenties)
        {
            if(twenty.getSerialNumber() == serialNumber);
            return true;
        }

        return false;
    }

    public boolean oneHundredBillAlreadyEntered(int serialNumber)
    {
        for(OneHundred oneHundred : oneHundreds)
        {
            if(oneHundred.getSerialNumber() == serialNumber);
            return true;
        }

        return false;
    }

    public BigDecimal getQuartersFaceValue()
    {
        return getUnitFaceValue(quarters);

    }

    public BigDecimal getDimesFaceValue()
    {
        return getUnitFaceValue(dimes);

    }

    public BigDecimal getNickelsFaceValue()
    {
        return getUnitFaceValue(nickels);

    }

    public BigDecimal getPenniesFaceValue()
    {
        return getUnitFaceValue(pennies);
    }


    public BigDecimal getOnesFaceValue()
    {
        return getUnitFaceValue(ones);
    }

    public BigDecimal getFivesFaceValue()
    {
        return getUnitFaceValue(fives);

    }

    public BigDecimal getTensFaceValue()
    {
        return getUnitFaceValue(tens);

    }

    public BigDecimal getTwentiesFaceValue()
    {
        return getUnitFaceValue(twenties);

    }

    public BigDecimal getOneHundredsFaceValue()
    {
        return getUnitFaceValue(oneHundreds);

    }
    public BigDecimal getQuartersCollectibleValue()
    {
        BigDecimal value = new BigDecimal("0");

        for(int year = 2018; year < currentYear; year++)
        {
            value = value.add(new BigDecimal(".01"));
        }
        return (getUnitCollectibleValue(quarters).add(value)).setScale(2,RoundingMode.HALF_UP);
    }

    public BigDecimal getDimesCollectibleValue()
    {
        BigDecimal value = new BigDecimal("0");

        for(int year = 2018; year < currentYear; year++)
        {
            value = value.add(new BigDecimal(".01"));
        }
        return (getUnitCollectibleValue(dimes).add(value)).setScale(2,RoundingMode.HALF_UP);
    }

    public BigDecimal getNickelsCollectibleValue()
    {
        BigDecimal value = new BigDecimal("0");

        for(int year = 2018; year < currentYear; year++)
        {
            value = value.add(new BigDecimal(".01"));
        }
        return (getUnitCollectibleValue(nickels).add(value)).setScale(2,RoundingMode.HALF_UP);
    }

    public BigDecimal getPenniesCollectibleValue()
    {
        BigDecimal value = new BigDecimal("0");

        for(int year = 2018; year < currentYear; year++)
        {
            value = value.add(new BigDecimal(".01"));
        }
        return (getUnitCollectibleValue(pennies).add(value)).setScale(2,RoundingMode.HALF_UP);
    }

    public BigDecimal getOnesCollectibleValue()
    {
        return getUnitCollectibleValue(ones);
    }

    public BigDecimal getFivesCollectibleValue()
    {
        return getUnitCollectibleValue(fives);
    }

    public BigDecimal getTensCollectibleValue()
    {
        return getUnitCollectibleValue(tens);
    }

    public BigDecimal getTwentiesCollectibleValue()
    {
        return getUnitCollectibleValue(twenties);
    }

    public BigDecimal getOneHundredsCollectibleValue()
    {
        return getUnitCollectibleValue(oneHundreds);
    }

    public BigDecimal getFaceValue()
    {
        BigDecimal value = new BigDecimal(0.0);

        value = value.add(getQuartersFaceValue());
        value = value.add(getDimesFaceValue());
        value = value.add(getNickelsFaceValue());
        value = value.add(getPenniesFaceValue());
        value = value.add(getOnesFaceValue());
        value = value.add(getFivesFaceValue());
        value = value.add(getTensFaceValue());
        value = value.add(getTwentiesFaceValue());
        value = value.add(getOneHundredsFaceValue());

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

    public BigDecimal getUnitFaceValue(List<? extends ICurrency> units)
    {
        BigDecimal faceValue = new BigDecimal("0");

        for(ICurrency unit : units)
        {
            faceValue = faceValue.add(unit.getFaceValue());
        }

        return faceValue.setScale(2,RoundingMode.HALF_UP);
    }

    public BigDecimal getUnitCollectibleValue(List<? extends ICurrency> units)
    {
        BigDecimal collectibleValue = new BigDecimal("0");

        for(ICurrency unit : units)
        {
            collectibleValue = collectibleValue.add(unit.getCollectibleValue());
        }

        return collectibleValue.setScale(2,RoundingMode.HALF_UP);
    }
}
