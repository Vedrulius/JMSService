package com.mihey.jms.service.impl

import com.mihey.jms.model.Person
import com.mihey.jms.repository.PersonRepository
import com.mihey.jms.service.PersonService
import org.springframework.stereotype.Service

@Service
class PersonServiceImpl(private val personRepository: PersonRepository) : PersonService {
    override fun savePerson(person: Person) {
        TODO("Not yet implemented")
    }


}