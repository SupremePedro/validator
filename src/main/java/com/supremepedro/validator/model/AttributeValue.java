package com.supremepedro.validator.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class AttributeValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    Attribute attribute;
}
