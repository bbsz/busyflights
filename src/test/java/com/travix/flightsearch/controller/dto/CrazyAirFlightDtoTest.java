package com.travix.flightsearch.controller.dto;

import com.travix.flightsearch.domain.CabinClass;
import com.travix.flightsearch.domain.Flight;
import com.travix.flightsearch.domain.SearchProvider;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by sergej on 13.2.2017.
 */
public class CrazyAirFlightDtoTest {
    @Test
    public void fromFlightToCrazyAirFlight() {
        Flight flight = getFlight();
        CrazyAirFlightDto crazyAirFlightDto = new CrazyAirFlightDto(flight);
        assertFlights(crazyAirFlightDto, flight);
    }

    private void assertFlights(CrazyAirFlightDto dto, Flight flight) {
        assertThat(dto.getAirLine(), is(flight.getAirLine()));
        assertThat(dto.getPrice(), is(flight.getPrice()));
        assertThat(dto.getCabinClass(), is(flight.getCabinClass().getCode()));
        assertThat(dto.getArrivalDate(), is(flight.getArrivalDate()));
        assertThat(dto.getDepartureDate(), is(flight.getDepartureDate()));
        assertThat(dto.getDepartureAirportCode(), is(flight.getOrigin()));
        assertThat(dto.getDestinationAirportCode(), is(flight.getDestination()));

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
}