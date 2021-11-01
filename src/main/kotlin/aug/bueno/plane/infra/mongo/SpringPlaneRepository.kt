package aug.bueno.plane.infra.mongo

import org.springframework.data.mongodb.repository.MongoRepository;

interface SpringPlaneRepository: MongoRepository<PlaneDocument, String> {
}