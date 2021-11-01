package aug.bueno.consumer

import aug.bueno.entity.Notification
import mu.KLogger
import mu.KotlinLogging.logger
import org.springframework.stereotype.Component
import java.util.function.Consumer

@Component("notificationConsumer")
class NotificationConsumer(
    private val logger: KLogger = logger {},
) : Consumer<Notification> {

    override fun accept(event: Notification) {
        this.logger.info { "m=accept, event=$event" }
    }
}
