package com.mihey.jms.repository

import com.mihey.jms.model.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<Person, Int> {
}