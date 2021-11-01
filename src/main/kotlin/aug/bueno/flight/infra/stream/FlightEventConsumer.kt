package aug.bueno.flight.infra.stream

import aug.bueno.airport.Airport
import aug.bueno.flight.FlightOperations
import org.springframework.stereotype.Component
import java.util.function.Consumer


@Component("flightEventConsumer")
class FlightEventConsumer(val flightOperations: FlightOperations) : Consumer<FlightEvent> {
    override fun accept(flightEvent: FlightEvent) {
        val airport = Airport(flightEvent.currentAirport)

        flightOperations.flightArrivedIn(flightEvent.flightId, airport)
    }
}