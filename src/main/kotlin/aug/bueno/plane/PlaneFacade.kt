package aug.bueno.plane

import org.springframework.stereotype.Service

@Service
class PlaneFacade(val planeRepository: PlaneRepository) : PlaneOperations {
    override fun create(plane: Plane) {
        planeRepository.save(plane);
    }
}