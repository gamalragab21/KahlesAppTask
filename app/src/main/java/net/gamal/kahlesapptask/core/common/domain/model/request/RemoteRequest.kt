package net.gamal.kahlesapptask.core.common.domain.model.request

data class RemoteRequest(
    val requestBody: HashMap<String, Any> = hashMapOf(),
    val requestQueries: HashMap<String, Any> = hashMapOf(),
    val requestHeaders: HashMap<String, Any> = hashMapOf()
)