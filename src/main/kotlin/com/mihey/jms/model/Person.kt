package com.mihey.jms.model

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import javax.persistence.*

@Entity
@Table(name = "persons")
data class Person(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JacksonXmlProperty(localName = "id")
    val id: Int?,
    @JacksonXmlProperty(localName = "name")
    @Column(name = "name")
    val name: String,
    @Column(name = "last_name")
    @JacksonXmlProperty(localName = "last-name")
    val lastName: String
)