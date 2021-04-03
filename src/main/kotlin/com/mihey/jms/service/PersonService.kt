package com.mihey.jms.service

import com.mihey.jms.model.Person


interface PersonService {
    fun savePerson(person: Person)
}