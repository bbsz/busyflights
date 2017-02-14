package com.travix.flightsearch.service;

import com.google.common.collect.Lists;
import com.travix.flightsearch.domain.Flight;
import com.travix.flightsearch.repository.FlightsRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

/**
 * Created by sergej on 13.2.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class ToughJetSearchServiceTest {

    private static final String ORIGIN = "LDN";
    private static final String DESTINATION = "MLB";

    @Mock
    private FlightsRepository repository;
    @Mock
    private Flight flight_ldn2Mlb;
    @Mock
    private Flight flight_mlb2Ldn;
    private SearchCriteria searchCriteria;
    private List<Flight> flights;
    private ToughJetSearchService searchService;

    @Before
    public void setUp() {
        searchService = new ToughJetSearchService(repository);
    }

    @Test
    public void getFlights() {
        givenARepository();
        givenASearchCriteria();
        whenICallGetFlights();
        flightsAreReturned();
    }

    private void givenARepository() {
        List<Flight> orig2dest = Lists.newArrayList(flight_ldn2Mlb);
        List<Flight> dest2orig = Lists.newArrayList(flight_mlb2Ldn);
        when(repository.findToughJetFlights(eq(ORIGIN), eq(DESTINATION), any(Date.class), any(Date.class))).thenReturn(orig2dest);
        when(repository.findToughJetFlights(eq(DESTINATION), eq(ORIGIN), any(Date.class), any(Date.class))).thenReturn(dest2orig);
    }

    private void givenASearchCriteria() {
        searchCriteria = new SearchCriteria();
        searchCriteria.setOrigin(ORIGIN);
        searchCriteria.setDestination(DESTINATION);
        searchCriteria.setDepartureDate(new Date());
        searchCriteria.setReturnDate(new Date());
    }

    private void whenICallGetFlights(){
        flights = searchService.getFlights(searchCriteria);
    }

    private void flightsAreReturned(){
        assertThat(flights.size(), is(2));
        assertTrue(flights.contains(flight_ldn2Mlb));
        assertTrue(flights.contains(flight_mlb2Ldn));
    }

}