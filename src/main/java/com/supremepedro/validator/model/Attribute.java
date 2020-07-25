package com.supremepedro.validator.model;

import com.supremepedro.validator.enums.AttributeType;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToMany
    Set<AttributeValue> attributeValueSet;

    @Enumerated
    AttributeType attributeType;

    @ElementCollection
    List<String> possibleValues;
}
