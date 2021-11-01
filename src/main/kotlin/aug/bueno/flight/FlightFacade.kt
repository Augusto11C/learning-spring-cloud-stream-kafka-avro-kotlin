package aug.bueno.flight

import aug.bueno.airport.Airport
import org.springframework.stereotype.Service
import java.util.*
import java.util.function.Supplier

@Service
class FlightFacade(val flightRepository: FlightRepository, val flightNotifications: FlightNotifications) :
    FlightOperations {

    override fun create(flight: Flight?): String {
        return flightRepository.save(flight!!);
    }

    override fun findConfirmedFlightByPlaneId(planeId: String?): Optional<Flight> {
        val flights = flightRepository.findConfirmedFlightsByPlaneId(planeId!!)
        if (flights.isEmpty()) {
            return Optional.empty()
        }
        check(flights.size <= 1) { "There should only be one confirmed flight for a plane" }
        return Optional.of(flights[0])
    }

    override fun flightArrivedIn(flightId: String?, airport: Airport?) {
        val flight = flightRepository
            .findById(flightId!!)
            .orElseThrow(Supplier<RuntimeException> { FlightNotFoundException(flightId) })

        val updatedFlight = flight.arrivedIn(airport!!)

        flightRepository.save(updatedFlight)

        if (updatedFlight.status == FlightStatus.ARRIVED) {
            flightNotifications.flightArrived(flightId);
        }
    }
}