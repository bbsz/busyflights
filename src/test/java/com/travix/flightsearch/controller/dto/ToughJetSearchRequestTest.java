package com.travix.flightsearch.controller.dto;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by sergej on 13.2.2017.
 */
public class ToughJetSearchRequestTest {

    @Test
    public void toDate() {
        assertDates(2017, 2, 13);
        assertDates(2017, 3, 29);
        assertDates(2017, 4, 21);
        assertDates(2017, 5, 1);
        assertDates(2017, 6, 30);
        assertDates(2017, 12, 20);
    }

    private void assertDates(int year, int month, int day) {
        ToughJetSearchRequest request = getInstance(year, month, day);
        assertDate(year, month, day, request.getDepartureDate());
        assertDate(year, month, day, request.getReturnDate());
    }

    private void assertDate(int year, int month, int day, Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        assertThat(cal.get(Calendar.MONTH), is(month - 1));
        assertThat(cal.get(Calendar.YEAR), is(year));
        assertThat(cal.get(Calendar.DAY_OF_MONTH), is(day));
        System.out.print(cal.getTime());
    }

    private ToughJetSearchRequest getInstance(int year, int month, int day) {
        ToughJetSearchRequest request = new ToughJetSearchRequest();
        request.setDepartureYear(year);
        request.setDepartureMonth(month);
        request.setDepartureDay(day);
        request.setReturnYear(year);
        request.setReturnMonth(month);
        request.setReturnDay(day);

        return request;
    }

}