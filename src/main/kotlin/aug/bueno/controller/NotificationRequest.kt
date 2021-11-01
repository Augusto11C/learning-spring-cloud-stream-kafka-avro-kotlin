package aug.bueno.controller

data class NotificationRequest(
    val from: String,
    val to: String,
    val msg: String
)