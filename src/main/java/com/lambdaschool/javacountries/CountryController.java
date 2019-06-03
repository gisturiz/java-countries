package com.lambdaschool.javacountries;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;

@RestController
@RequestMapping("/data")
public class CountryController
{
    @RequestMapping(value = "/names/all",
                    produces = {"application/json"})
    public ResponseEntity<?> getCountries()
    {
        JavaCountriesApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(JavaCountriesApplication.ourCountryList.countryList, HttpStatus.OK);
    }

    @GetMapping(value = "/names/start/{letter}",
                produces = {"application/json"})
    public ResponseEntity<?> getCountryStart (@PathVariable char letter)
    {
        JavaCountriesApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        ArrayList<Country> rtnCountry = JavaCountriesApplication.ourCountryList.checkCountry(c -> c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }

    @GetMapping(value ="/names/size/{number}",
                produces = {"application/json"})
    public ResponseEntity<?> getNameLength (@PathVariable int number)
    {
        JavaCountriesApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        ArrayList<Country> rtnCountry = JavaCountriesApplication.ourCountryList.checkCountry(c -> c.getName().length() >= number);
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }

    @GetMapping(value ="/population/size/{people}",
            produces = {"application/json"})
    public ResponseEntity<?> getCountryPop (@PathVariable int people)
    {
        JavaCountriesApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        ArrayList<Country> rtnCountry = JavaCountriesApplication.ourCountryList.checkCountry(c -> c.getPopulation() >= people);
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }

    @RequestMapping(value = "/population/min",
                produces = {"application/json"})
    public ResponseEntity<?> getMinPop()
    {
        JavaCountriesApplication.ourCountryList.countryList.sort(Comparator.comparing(Country::getPopulation));
        ArrayList<Country> rtnCountry = JavaCountriesApplication.ourCountryList.checkCountry(c -> c.getPopulation() < 96000);
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }

    @RequestMapping(value = "/population/max",
            produces = {"application/json"})
    public ResponseEntity<?> getMaxPop()
    {
        JavaCountriesApplication.ourCountryList.countryList.sort(Comparator.comparingInt(Country::getPopulation).reversed());
        ArrayList<Country> rtnCountry = JavaCountriesApplication.ourCountryList.checkCountry(c -> c.getPopulation() > 1380000000);
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }
}
