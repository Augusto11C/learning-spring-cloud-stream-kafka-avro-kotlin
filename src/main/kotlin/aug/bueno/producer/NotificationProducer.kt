package aug.bueno.producer

import aug.bueno.entity.Notification
import mu.KLogger
import mu.KotlinLogging
import org.springframework.cloud.stream.function.StreamBridge
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Component

@Component("notificationProducer")
class NotificationProducer(private val logger: KLogger = KotlinLogging.logger {},
                           private val bridge: StreamBridge) {

    infix fun send(event: Notification) {
            this.logger.info { "m=send, event=$event" }
        val message = MessageBuilder.withPayload(event).build()
        this.bridge.send("notification-topic-v1", message)
    }
}