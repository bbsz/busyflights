package com.travix.flightsearch.controller.dto;

import com.travix.flightsearch.domain.CabinClass;
import com.travix.flightsearch.domain.Flight;
import com.travix.flightsearch.domain.SearchProvider;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by sergej on 13.2.2017.
 */
public class ToughJetFlightDtoTest {

    @Test
    public void fromFlightToToughFlight() {
        Flight flight = getFlight();
        ToughJetFlightDto toughJetFlightDto = new ToughJetFlightDto(flight);
        assertFlights(toughJetFlightDto, flight);
    }

    private void assertFlights(ToughJetFlightDto dto, Flight flight) {
        assertThat(dto.getAirLine(), is(flight.getAirLine()));
        assertThat(dto.getBasePrice(), is(flight.getBasePrice()));
        assertThat(dto.getTax(), is(flight.getTax()));
        assertThat(dto.getDiscount(), is(flight.getDiscount()));
        assertThat(dto.getDepartureAirportCode(), is(flight.getOrigin()));
        assertThat(dto.getDestinationAirportCode(), is(flight.getDestination()));

        Date arrival = flight.getArrivalDate();
        assertThat(dto.getReturnDay(), is(getDay(arrival)));
        assertThat(dto.getReturnMonth(), is(getMonth(arrival)));
        assertThat(dto.getReturnYear(), is(getYear(arrival)));

        Date departure = flight.getArrivalDate();
        assertThat(dto.getDepartureDay(), is(getDay(departure)));
        assertThat(dto.getDepartureMonth(), is(getMonth(departure)));
        assertThat(dto.getDepartureYear(), is(getYear(departure)));
    }

    private Flight getFlight() {
        Flight flight = new Flight();
        flight.setDepartureDate(new Date());
        flight.setArrivalDate(new Date());
        flight.setAirLine("WhatEver");
        flight.setPassengersCount(250);
        flight.setDestination("destination");
        flight.setOrigin("origin");
        flight.setCabinClass(CabinClass.BUSINESS);
        flight.setProvider(SearchProvider.CRAZY_AIR);
        flight.setBasePrice(44);
        flight.setTax(10);
        flight.setDiscount(20);

        return flight;
    }

    private int getYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    private int getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH) + 1;
    }

    private int getDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

}