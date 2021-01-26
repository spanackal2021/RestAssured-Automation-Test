package com.response;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static com.steps.StepDefinition.days;

public class DaysInformation {

    public static void getThursdayAndFridayInTheNext16Days(){

        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(16);

        while ( startDate.isBefore( endDate ) ) {
            DayOfWeek dayofWeek = startDate.getDayOfWeek() ;
            switch ( dayofWeek ) {
                case THURSDAY:
                case FRIDAY:
                    days.add( startDate) ;
                    break;

                default:
                    // Ignore any other day-of-week.
                    break;
            }
            // Set-up the next loop. Increment by one day at a time.
            startDate = startDate.plusDays( 1 ) ;
        }
    }
}
