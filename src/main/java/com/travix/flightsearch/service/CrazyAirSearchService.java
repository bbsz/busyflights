package com.travix.flightsearch.service;

import com.travix.flightsearch.domain.Flight;
import com.travix.flightsearch.repository.FlightsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by sergej on 13.2.2017.
 */
@Service
public class CrazyAirSearchService {

    private FlightsRepository flightsRepository;

    @Autowired
    public CrazyAirSearchService(FlightsRepository repository) {
        this.flightsRepository = repository;
    }

    public List<Flight> getFlights(SearchCriteria sc) {
        Date departureDateFrom = sc.getDepartureDate();
        Date departureDateTo = datePlusDay(sc.getDepartureDate());
        Date returnDateFrom = sc.getReturnDate();
        Date returnDateTo = datePlusDay(sc.getReturnDate());

        List<Flight> flightsDeparture = flightsRepository.findCrazyAirFlights(sc.getOrigin(), sc.getDestination(), departureDateFrom, departureDateTo);
        List<Flight> flightsReturn = flightsRepository.findCrazyAirFlights(sc.getDestination(), sc.getOrigin(), returnDateFrom, returnDateTo);

        List<Flight> flights = new ArrayList<>();
        flights.addAll(flightsDeparture);
        flights.addAll(flightsReturn);
        return flights;
    }

    private Date datePlusDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }


}
