package com.travix.flightsearch.controller;

import com.travix.flightsearch.controller.dto.ToughJetFlightDto;
import com.travix.flightsearch.controller.dto.ToughJetSearchRequest;
import com.travix.flightsearch.domain.Flight;
import com.travix.flightsearch.service.SearchCriteria;
import com.travix.flightsearch.service.ToughJetSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by sergej on 13.2.2017.
 */
@RestController
@RequestMapping("flightsSearch/")
public class ToughJetFlightsSearchController {

    private ToughJetSearchService toughJetSearchService;

    @Autowired
    public ToughJetFlightsSearchController(ToughJetSearchService toughJetSearchService) {
        this.toughJetSearchService = toughJetSearchService;
    }

    @RequestMapping(value = "toughJet", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ToughJetFlightDto> searchToughJet(@Valid @RequestBody ToughJetSearchRequest request) {
        SearchCriteria criteria = toSearchCriteria(request);
        List<Flight> flights = toughJetSearchService.getFlights(criteria);
        List<ToughJetFlightDto> dtos = toSearchResponse(flights);
        return dtos;
    }

    private SearchCriteria toSearchCriteria(ToughJetSearchRequest request) {
        SearchCriteria criteria = new SearchCriteria();
        criteria.setDepartureDate(request.getDepartureDate());
        criteria.setReturnDate(request.getReturnDate());
        criteria.setDestination(request.getDestination());
        criteria.setOrigin(request.getOrigin());
        criteria.setPassengersCount(request.getPassengersCount());

        return criteria;
    }

    private List<ToughJetFlightDto> toSearchResponse(List<Flight> flights) {
        Function<Flight, ToughJetFlightDto> responseMapper = flight -> {
            ToughJetFlightDto response = new ToughJetFlightDto(flight);
            return response;
        };

        return flights.stream().map(responseMapper).collect(Collectors.toList());
    }
}
