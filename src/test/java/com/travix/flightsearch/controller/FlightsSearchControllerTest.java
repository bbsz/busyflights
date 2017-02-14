package com.travix.flightsearch.controller;

import com.google.common.collect.Lists;
import com.travix.flightsearch.controller.dto.CrazyAirFlightDto;
import com.travix.flightsearch.controller.dto.CrazyAirSearchRequest;
import com.travix.flightsearch.domain.Flight;
import com.travix.flightsearch.service.CrazyAirSearchService;
import com.travix.flightsearch.service.SearchCriteria;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by sergej on 13.2.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class FlightsSearchControllerTest {

    @Mock
    private CrazyAirSearchService searchService;
    @Mock
    private CrazyAirSearchRequest request;
    private FlightsSearchController controller;
    private Flight flight;
    private List<CrazyAirFlightDto> dtos;

    @Before
    public void setUp() {
        controller = new FlightsSearchController(searchService);
    }

    @Test
    public void searchCrazyAir() {
        givenASearchService();
        whenICallSearchCrazyAir();
        dtosAreReturned();
    }

    private void givenASearchService() {
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
        assertThat(dto.getArrivalDate(), is(flight.getArrivalDate()));
        assertThat(dto.getDepartureDate(), is(flight.getDepartureDate()));

    }
}