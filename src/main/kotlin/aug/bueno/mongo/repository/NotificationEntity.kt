package aug.bueno.mongo.repository

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class NotificationEntity(
    @Id
    val id: String, val from: String, val to: String, val msg: String
) {}
