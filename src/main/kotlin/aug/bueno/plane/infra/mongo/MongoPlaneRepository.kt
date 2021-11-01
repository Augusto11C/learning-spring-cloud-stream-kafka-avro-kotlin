package aug.bueno.plane.infra.mongo

import aug.bueno.plane.Plane
import aug.bueno.plane.PlaneRepository

class MongoPlaneRepository(
    private val planeMapper: PlaneMapper,
    private val springPlaneRepository: SpringPlaneRepository
) : PlaneRepository {
    override fun save(plane: Plane?): String? {
        val savedPlane: PlaneDocument = springPlaneRepository.save(planeMapper.toPlaneDocument(plane));
        return savedPlane.id;
    }
}