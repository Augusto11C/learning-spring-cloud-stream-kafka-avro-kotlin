package aug.bueno.mongo.repository

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository


@Repository
interface NotificationRepository : MongoRepository<NotificationEntity, String> {
    fun findByFrom(from: String): List<NotificationEntity>
    fun findByFromAndTo(from: String, to: String): List<NotificationEntity>
}