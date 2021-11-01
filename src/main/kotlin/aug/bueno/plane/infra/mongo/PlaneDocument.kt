package aug.bueno.plane.infra.mongo

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
class PlaneDocument(

    @Id
    val id: String,
    val code: String,
    val type: String
) {
}