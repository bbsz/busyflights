package com.travix.busyflights.service;

import com.google.common.collect.Lists;
import com.travix.busyflights.domain.Flight;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by sergej on 13.2.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class FlightsSearchServiceTest {

    private static final String ORIGIN = "LDN";
    private static final String DESTINATION = "BRB";
    private static final int NUMBER_OF_PASSENGERS = 4;
    private static final String SEARCH_URL_CRAZY_AIR = "http://localhost:8080/flightsSearch/crayzAir";
    private static final String SEARCH_URL_TOUGH_JET = "http://localhost:8080/flightsSearch/toughJet";

    private RestTemplate restTemplate;
    @Mock
    private Flight flight_ldn2Mlb;
    @Mock
    private Flight flight_mlb2Ldn;
    private SearchCriteria searchCriteria;
    private List<Flight> flights;
    private FlightsSearchService searchService;

    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
        searchService = new FlightsSearchService(restTemplate, SEARCH_URL_CRAZY_AIR, SEARCH_URL_TOUGH_JET);
    }

    @Test
    public void getFlights() {
        givenASearchCriteria();
        whenICallGetFlights();
        flightsAreReturned();
    }
//    @Test
//    public void getFlights() {
//        givenARestTemplate();
//        givenASearchCriteria();
//        whenICallGetFlights();
//        flightsAreReturned();
//    }

    private void givenARestTemplate() {
        List<Flight> orig2dest = Lists.newArrayList(flight_ldn2Mlb);
        List<Flight> dest2orig = Lists.newArrayList(flight_mlb2Ldn);
//        when(restTemplate.findCrazyAirFlights(eq(ORIGIN), eq(DESTINATION), any(Date.class), any(Date.class))).thenReturn(orig2dest);
//        when(restTemplate.findCrazyAirFlights(eq(DESTINATION), eq(ORIGIN), any(Date.class), any(Date.class))).thenReturn(dest2orig);
    }

    private void givenASearchCriteria() {
        searchCriteria = new SearchCriteria();
        searchCriteria.setOrigin(ORIGIN);
        searchCriteria.setDestination(DESTINATION);
        searchCriteria.setDepartureDate(toDate(2017, 3, 14));
        searchCriteria.setReturnDate(toDate(2017, 3, 21));
        searchCriteria.setNumberOfPassengers(NUMBER_OF_PASSENGERS);
    }

    private void whenICallGetFlights() {
        flights = searchService.getFlights(searchCriteria);
    }

    private void flightsAreReturned() {
        assertThat(flights.size(), is(2));
//        assertTrue(flights.contains(flight_ldn2Mlb));
//        assertTrue(flights.contains(flight_mlb2Ldn));
    }

    private Date toDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(year, month - 1, day);
        return cal.getTime();
    }

}