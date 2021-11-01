package aug.bueno.flight

import aug.bueno.airport.Airport

import aug.bueno.plane.Plane

class Flight(
    val id: String,
    val plane: Plane,
    val origin: Airport,
    val destination: Airport,
    val status: FlightStatus){

    fun arrivedIn(airport: Airport): Flight {
        return if (airport == destination) {
            Flight(id, plane, origin, destination, FlightStatus.ARRIVED)
        } else this
    }
}