package aug.bueno.flight.infra.mongo

import aug.bueno.airport.Airport
import aug.bueno.flight.FlightStatus

import aug.bueno.plane.Plane
import org.springframework.data.mongodb.core.mapping.Document;

@Document
class FlightDocument(
    val id: String,
    val plane: Plane,
    val origin: Airport,
    val destination: Airport,
    val status: FlightStatus
) {
}