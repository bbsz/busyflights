/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.travix.flightsearch.repository;

import com.travix.flightsearch.domain.Flight;
import com.travix.flightsearch.service.SearchCriteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Integration tests for {@link FlightsRepository}.
 *
 * @author Oliver Gierke
 * @author Andy Wilkinson
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTests {

    private static final String ORIGIN = "LDN";
    private static final String DESTINATION = "BRB";

    @Autowired
    private FlightsRepository repository;
    private SearchCriteria searchCriteria;

    @Test
    public void findCrazyAirFlights() {
        givenASearchCriteria();
        Date dateFrom = searchCriteria.getDepartureDate();
        Date dateTo = datePlusDay(dateFrom);

        List<Flight> flightList = repository.findCrazyAirFlights(searchCriteria.getOrigin(), searchCriteria.getDestination(), dateFrom, dateTo);
        assertThat(flightList.size(), is(1));
    }


    private void givenASearchCriteria() {
        searchCriteria = new SearchCriteria();
        searchCriteria.setOrigin(ORIGIN);
        searchCriteria.setDestination(DESTINATION);
        Calendar cal = Calendar.getInstance();
        cal.set(2017, 2, 14, 0, 0);
        Date deptDate = cal.getTime();
        cal = Calendar.getInstance();
        cal.set(2017, 2, 21, 0,0);
        Date rtnDate = cal.getTime();
        searchCriteria.setDepartureDate(deptDate);
        searchCriteria.setReturnDate(rtnDate);
    }

    private Date datePlusDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
