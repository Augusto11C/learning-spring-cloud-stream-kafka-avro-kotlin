package aug.bueno.consumer

import aug.bueno.entity.Notification
import aug.bueno.mongo.repository.NotificationEntity
import aug.bueno.mongo.repository.NotificationRepository
import mu.KLogger
import mu.KotlinLogging.logger
import org.springframework.stereotype.Component
import java.util.function.Consumer

@Component("notificationConsumer")
class NotificationConsumer(
    private val repository: NotificationRepository,
    private val logger: KLogger = logger {},
) : Consumer<Notification> {

    override fun accept(event: Notification) {
        this.logger.info { "m=accept, event=$event" }


        if (event.msg == "ERROR") {
            throw RuntimeException("problem msg with ERROR")
        }

        repository.save(NotificationEntity("123", event.from, event.to, event.msg))
    }
}
