package aug.bueno.plane.infra.mongo

import aug.bueno.plane.Plane
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface PlaneMapper {

    fun toPlaneDocument(plane: Plane?): PlaneDocument;
}