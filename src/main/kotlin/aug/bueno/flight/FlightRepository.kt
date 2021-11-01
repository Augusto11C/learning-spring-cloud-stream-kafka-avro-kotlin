package aug.bueno.flight

import java.util.Optional

interface FlightRepository {
    fun save(flight: Flight): String

    fun findConfirmedFlightsByPlaneId(planeId: String): List<Flight>

    fun findById(flightId: String): Optional<Flight>
}