package aug.bueno.controller

import aug.bueno.mapper.NotificationMapper
import aug.bueno.producer.NotificationProducer
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/notification")
class NotificationController (
    private val notificationProducer: NotificationProducer, private val mapper: NotificationMapper) {

    @PostMapping
    fun create(@RequestBody request: NotificationRequest) {
        val notification = this.mapper.toDomain(request);
        this.notificationProducer.send(notification)
    }
}