package aug.bueno.flight.infra.stream

import aug.bueno.flight.FlightNotifications
import org.springframework.cloud.stream.function.StreamBridge
import org.springframework.stereotype.Component

@Component
class StreamFlightNotifications(private val streamBridge: StreamBridge) : FlightNotifications {

    override fun flightArrived(flightId: String) {
        streamBridge.send("flightArrived-out-0", FlightArrivedEvent(flightId));
    }
}