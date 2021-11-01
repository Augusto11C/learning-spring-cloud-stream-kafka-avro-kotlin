package aug.bueno.flight.infra.mongo

import aug.bueno.flight.FlightStatus
import org.springframework.data.mongodb.repository.MongoRepository


interface SpringFlightRepository: MongoRepository<FlightDocument, String> {
    fun findByPlaneIdAndStatus(planeId: String?, status: FlightStatus?): List<FlightDocument>
}