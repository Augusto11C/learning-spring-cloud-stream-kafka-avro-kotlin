package aug.bueno.producer

import aug.bueno.entity.Notification
import org.springframework.cloud.stream.function.StreamBridge
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Component

@Component("notificationProducer")
class NotificationProducer(private val bridge: StreamBridge) {

    infix fun send(event: Notification) {
        val message = MessageBuilder.withPayload(event).build()
        this.bridge.send("notification-topic-v1", message)
    }
}