package com.supremepedro.validator.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    Set<AttributeValue> attributeValues;

    @OneToOne
    Subcategory subcategory;
}
