package com.mihey.jms.service

interface MessageListenerService {
    fun listen(message: String)
}