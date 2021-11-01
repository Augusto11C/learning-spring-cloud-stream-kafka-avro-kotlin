package aug.bueno.plane.infra.stream

data class PlaneEvent(
    val planeId: String,
    val currentAirport: String
)
