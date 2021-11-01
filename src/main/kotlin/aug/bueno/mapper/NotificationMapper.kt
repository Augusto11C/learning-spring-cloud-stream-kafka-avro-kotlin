package aug.bueno.mapper

import aug.bueno.controller.NotificationRequest
import aug.bueno.entity.Notification
import br.com.silveira.raphael.spring.cloud.stream.kafka.avro.infrastructure.schema.UserCreationEvent
import org.springframework.stereotype.Component

@Component
class NotificationMapper {
     fun toDomain(request: NotificationRequest) = Notification(request.from, request.to, request.msg)
//     fun toEvent(user: User) = UserCreationEvent(user.name, user.age, user.address, user.site, null)
}