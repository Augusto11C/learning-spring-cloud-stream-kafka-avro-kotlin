package aug.bueno.flight.infra.mongo

import aug.bueno.flight.Flight
import aug.bueno.flight.FlightRepository
import aug.bueno.flight.FlightStatus
import org.springframework.stereotype.Component
import java.util.*
import java.util.stream.Collectors.toList

@Component
class FlightMongoRepository(val flightMapper: FlightMapper, val springFlightRepository: SpringFlightRepository) :
    FlightRepository {

    override fun save(flight: Flight): String {
        val saved: FlightDocument = springFlightRepository.save(flightMapper.toDocument(flight))
        return saved.id
    }

    override fun findConfirmedFlightsByPlaneId(planeId: String): List<Flight> {
        val documents: List<FlightDocument> = springFlightRepository.findByPlaneIdAndStatus(
            planeId,
            FlightStatus.CONFIRMED
        )
        return documents.stream().map { flight: FlightDocument? ->
            flightMapper.fromDocument(
                flight
            )
        }
            .collect(toList())
    }

    override fun findById(flightId: String): Optional<Flight> {
        return springFlightRepository.findById(flightId).map(flightMapper::fromDocument);
    }
}