package com.mihey.jms.service.impl

import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Service

@Service
class MessageListener(private val personServiceImpl: PersonServiceImpl) {

    @JmsListener(destination = "\${spring.activemq.name}")
    fun listen(message: String) {
        personServiceImpl.getPersonFromQueue(message)
    }
}