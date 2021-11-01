package aug.bueno.consumer

import aug.bueno.entity.Notification
import mu.KLogger
import mu.KotlinLogging
import org.springframework.stereotype.Component
import java.util.function.Consumer

//@Component("notificationConsumerDLQ")
class NotificationConsumerDLQ(
    private val logger: KLogger = KotlinLogging.logger {},
) : Consumer<Notification> {

    override fun accept(event: Notification) {
        this.logger.info { "m=accept, Handling ERROR in the event=$event" }

        if (event.msg == "ERROR") {
            throw RuntimeException("problem msg with ERROR")
        }
    }
}