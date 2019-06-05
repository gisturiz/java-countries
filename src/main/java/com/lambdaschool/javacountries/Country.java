package com.lambdaschool.javacountries;

public class Country
{
    private String name;
    private int population;
    private int landMass;
    private int medAge;

    public Country(String name, int population, int landMass, int medAge)
    {
        this.name = name;
        this.population = population;
        this.landMass = landMass;
        this.medAge = medAge;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getPopulation()
    {
        return population;
    }

    public void setPopulation(int population)
    {
        this.population = population;
    }

    public int getLandMass()
    {
        return landMass;
    }

    public void setLandMass(int landMass)
    {
        this.landMass = landMass;
    }

    public int getMedAge()
    {
        return medAge;
    }

    public void setMedAge(int medAge)
    {
        this.medAge = medAge;
    }

    @Override
    public String toString()
    {
        return "Country{" + "name: " + name + "population: " + population + "Land Mass: " + landMass + "Median Age: " + medAge + '}';
    }
}
