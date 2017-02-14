package com.travix.flightsearch.controller;

import com.google.common.collect.Lists;
import com.travix.flightsearch.controller.dto.CrazyAirFlightDto;
import com.travix.flightsearch.controller.dto.CrazyAirSearchRequest;
import com.travix.flightsearch.domain.CabinClass;
import com.travix.flightsearch.domain.Flight;
import com.travix.flightsearch.domain.SearchProvider;
import com.travix.flightsearch.service.CrazyAirSearchService;
import com.travix.flightsearch.service.SearchCriteria;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by sergej on 13.2.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class CrazyAirFlightsSearchControllerTest {

    @Mock
    private CrazyAirSearchService searchService;
    @Mock
    private CrazyAirSearchRequest request;
    private CrazyAirFlightsSearchController controller;
    private Flight flight;
    private List<CrazyAirFlightDto> dtos;

    @Before
    public void setUp() {
        controller = new CrazyAirFlightsSearchController(searchService);
    }

    @Test
    public void searchCrazyAir() {
        givenASearchService();
        whenICallSearchCrazyAir();
        dtosAreReturned();
    }

    private void givenASearchService() {
        flight = getFlight();
        List<Flight> flights = Lists.newArrayList(flight);
        when(searchService.getFlights(any(SearchCriteria.class))).thenReturn(flights);
    }

    private void whenICallSearchCrazyAir() {
        dtos = controller.searchCrazyAir(request);
    }

    private void dtosAreReturned(){
        assertThat(dtos.size(), is(1));
        assertFlights(dtos.get(0), flight);
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