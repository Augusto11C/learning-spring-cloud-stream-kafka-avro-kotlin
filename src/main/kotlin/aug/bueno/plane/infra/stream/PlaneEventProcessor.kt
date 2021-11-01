package aug.bueno.plane.infra.stream

import aug.bueno.flight.Flight
import aug.bueno.flight.FlightOperations
import org.springframework.stereotype.Component
import java.util.function.Function
import java.util.function.Supplier

@Component("planeEventProcessor")
class PlaneEventProcessor(val flightOperations: FlightOperations) : Function<PlaneEvent, FlightEvent> {

    override fun apply(planeEvent: PlaneEvent): FlightEvent {
        val planeId: String = planeEvent.planeId

        val flight: Flight = flightOperations.findConfirmedFlightByPlaneId(planeId)
            .orElseThrow { NoFlightFoundException(String.format("No flight found for plane id %s", planeId)) }

        return FlightEvent(flight.id, planeEvent.currentAirport)
    }

}