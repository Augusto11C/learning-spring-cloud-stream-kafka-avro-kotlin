package aug.bueno.plane

interface PlaneRepository {
    fun save(plane: Plane?): String?;
}