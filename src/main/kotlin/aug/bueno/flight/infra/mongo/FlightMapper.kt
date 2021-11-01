package aug.bueno.flight.infra.mongo

import aug.bueno.flight.Flight
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper(componentModel = "spring")
interface FlightMapper {
    @Mappings(
        Mapping(source = "plane.id", target = "planeId"),
        Mapping(source = "origin.code", target = "originCode"),
        Mapping(source = "destination.code", target = "destinationCode")
    )
    fun toDocument(flight: Flight?): FlightDocument


    @Mappings(
        Mapping(source = "planeId", target = "plane.id"),
        Mapping(source = "originCode", target = "origin.code"),
        Mapping(source = "destinationCode", target = "destination.code")
    )
    fun fromDocument(flight: FlightDocument?): Flight
}