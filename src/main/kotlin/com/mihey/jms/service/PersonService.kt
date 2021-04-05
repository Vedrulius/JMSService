package com.mihey.jms.service

import com.mihey.jms.model.Person

interface PersonService {
    fun savePerson(person: Person): Person?
    fun isPersonPresent(name: String, lastName: String): Boolean
}