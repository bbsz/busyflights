package com.travix.flightsearch.controller;

import com.travix.flightsearch.controller.dto.CrazyAirFlightDto;
import com.travix.flightsearch.controller.dto.CrazyAirSearchRequest;
import com.travix.flightsearch.domain.Flight;
import com.travix.flightsearch.service.SearchCriteria;
import com.travix.flightsearch.service.CrazyAirSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by sergej on 13.2.2017.
 */
@RestController
@RequestMapping("flightsSearch/")
public class CrazyAirFlightsSearchController {

    private CrazyAirSearchService crazyAirSearch;

    @Autowired
    public CrazyAirFlightsSearchController(CrazyAirSearchService crazyAirSearch) {
        this.crazyAirSearch = crazyAirSearch;
    }

    @RequestMapping(value = "crayzAir", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CrazyAirFlightDto> searchCrazyAir(@Valid @RequestBody CrazyAirSearchRequest request) {
        SearchCriteria criteria = toSearchCriteria(request);
        List<Flight> flights = crazyAirSearch.getFlights(criteria);
        List<CrazyAirFlightDto> dtos = toSearchResponse(flights);
        return dtos;
    }

    private SearchCriteria toSearchCriteria(CrazyAirSearchRequest request) {
        SearchCriteria criteria = new SearchCriteria();
        criteria.setDepartureDate(request.getDepartureDate());
        criteria.setReturnDate(request.getReturnDate());
        criteria.setDestination(request.getDestination());
        criteria.setOrigin(request.getOrigin());
        criteria.setPassengersCount(request.getPassengersCount());

        return criteria;
    }

    private List<CrazyAirFlightDto> toSearchResponse(List<Flight> flights) {
        Function<Flight, CrazyAirFlightDto> responseMapper = flight -> {
            CrazyAirFlightDto response = new CrazyAirFlightDto(flight);
            return response;
        };

        return flights.stream().map(responseMapper).collect(Collectors.toList());
    }
}
