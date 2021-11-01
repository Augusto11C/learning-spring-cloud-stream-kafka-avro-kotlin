package aug.bueno.flight

import aug.bueno.airport.Airport
import java.util.Optional


interface FlightOperations {
    fun create(flight: Flight?): String

    fun findConfirmedFlightByPlaneId(planeId: String?): Optional<Flight>

    fun flightArrivedIn(flightId: String?, airport: Airport?)
}