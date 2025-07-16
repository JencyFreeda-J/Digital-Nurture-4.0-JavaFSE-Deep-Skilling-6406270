package com.cognizant.springlearn.service;

import com.cognizant.springlearn.model.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    private final ApplicationContext context;

    public CountryService() {
        // Load country.xml and fetch the country list once at service initialization
        context = new ClassPathXmlApplicationContext("country.xml");
    }

    @SuppressWarnings("unchecked")
    public Country getCountry(String code) {
        List<Country> countryList = (List<Country>) context.getBean("countryList");

        // Case-insensitive match using Java Streams
        Optional<Country> countryOpt = countryList.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst();

        // Return the found country or null (could throw exception or return Optional)
        return countryOpt.orElse(null);
    }
}