package com.mihey.jms.service.impl

import com.mihey.jms.service.MessageListenerService
import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Service

@Service
class MessageListenerImpl(private val personServiceImpl: PersonServiceImpl) : MessageListenerService {

    @JmsListener(destination = "\${spring.activemq.name}")
    override fun listen(message: String) {
        personServiceImpl.getPersonFromQueue(message)
    }
}