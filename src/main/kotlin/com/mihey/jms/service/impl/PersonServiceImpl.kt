package com.mihey.jms.service.impl

import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.mihey.jms.model.Person
import com.mihey.jms.repository.PersonRepository
import com.mihey.jms.service.PersonService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class PersonServiceImpl(private val personRepository: PersonRepository) : PersonService {

    private val logger = LoggerFactory.getLogger(javaClass)
    private val xmlMapper = XmlMapper()

    fun getPersonFromQueue(personXml: String) {
        try {
            val persons: List<Person> = xmlMapper.readValue(personXml, Array<Person>::class.java).toList()
            for (person in persons) {
                if (isPersonPresent(person.name, person.lastName)) {
                    logger.info("ignoring Person{ ${person.name}, ${person.lastName} }")
                } else {
                    savePerson(person)
                }
            }
        } catch (e: Exception) {
            logger.error(e.message)
        }
    }

    override fun savePerson(person: Person): Person? {
        return personRepository.save(person)
    }

    override fun isPersonPresent(name: String, lastName: String): Boolean {
        return personRepository.findPersonByFullName(name, lastName) != null
    }
}