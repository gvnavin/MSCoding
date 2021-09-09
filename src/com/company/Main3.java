package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Theater
 * Circular Seats
 * Sell ticket
 * maximize revenue = Sum of tickets sold
 * Ticket prices are not constant - pre-defined prices for the seat
 * At-least leave 1 seat in the middle
 *
 * Many Theaters in the country
 *
 * Input:
 * not required -- NoOfSeatsPlacedInCircularManner - N
 * List<Int> PricesForEachSeat
 * Not considering as input - Audience - max Audience
 */

/*
Team,
Webex
Bing ads corresponding to personalization
content feed
edge
platform pieces
Split between us and india
India in 100
growth with 30%
Team in in India
Crowd Testing - new initiative, no legacy, entrepreneur
Key value store - cosmos
Ranking service
 */
public class Main3 {

    /**
     * Start with 0 seats allocated
     * for every position, either
     * 1. you pick that seat
     * 2. you don't pick that seat
     *
     * Condition for picking that seat is diff(prev-curr) > 2
     *
     *
     *
     * @param prices
     * @return
     */
    int allocateSeats(List<Integer> prices) {
        int noOfSeats = prices.size();
        List<Integer> seatsAllocated = new ArrayList<>();
        for (int i = 0; i < noOfSeats; i++) {
            seatsAllocated.add(-1);
        }
        int currentSeatIndex = 0;
        return recursiveSeatAllocation(noOfSeats, prices, currentSeatIndex, seatsAllocated);
    }

    static int globalPrice = 0;

    int recursiveSeatAllocation(int noOfSeats, List<Integer> prices, int currentSeatIndex, List<Integer> seatsAllocated) {

        if (currentSeatIndex == noOfSeats) {
            int price = 0;
            for (int i = 0; i < noOfSeats; i++) {
                final Integer ind = seatsAllocated.get(i);
                if (ind > -1) {
                    final Integer pri = prices.get(ind);
                    price += pri;
                }
            }
            Math.max(globalPrice, price);
        }

        List<Integer> seatsAllocatedPick = new ArrayList<>(seatsAllocated);
        if (currentSeatIndex > 0 && seatsAllocated.get(currentSeatIndex-1) != -1) {
            seatsAllocatedPick.set(currentSeatIndex, 1);
        } else if (currentSeatIndex == 0) {
            seatsAllocatedPick.set(currentSeatIndex, 1);
        }

        recursiveSeatAllocation(noOfSeats, prices, currentSeatIndex+1, seatsAllocatedPick);
        recursiveSeatAllocation(noOfSeats, prices, currentSeatIndex+1, seatsAllocated);

        return 0;
    }

}
