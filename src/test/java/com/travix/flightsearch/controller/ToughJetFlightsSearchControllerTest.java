package com.travix.flightsearch.controller;

import com.google.common.collect.Lists;
import com.travix.flightsearch.controller.dto.CrazyAirFlightDto;
import com.travix.flightsearch.controller.dto.CrazyAirSearchRequest;
import com.travix.flightsearch.controller.dto.ToughJetFlightDto;
import com.travix.flightsearch.controller.dto.ToughJetSearchRequest;
import com.travix.flightsearch.domain.CabinClass;
import com.travix.flightsearch.domain.Flight;
import com.travix.flightsearch.domain.SearchProvider;
import com.travix.flightsearch.service.CrazyAirSearchService;
import com.travix.flightsearch.service.SearchCriteria;
import com.travix.flightsearch.service.ToughJetSearchService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by sergej on 13.2.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class ToughJetFlightsSearchControllerTest {

    @Mock
    private ToughJetSearchService searchService;
    @Mock
    private ToughJetSearchRequest request;
    private ToughJetFlightsSearchController controller;
    private Flight flight;
    private List<ToughJetFlightDto> dtos;

    @Before
    public void setUp() {
        controller = new ToughJetFlightsSearchController(searchService);
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
        dtos = controller.searchToughJet(request);
    }

    private void dtosAreReturned(){
        assertThat(dtos.size(), is(1));
        assertFlights(dtos.get(0), flight);
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