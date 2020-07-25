package com.supremepedro.validator.service;

import com.supremepedro.validator.model.Product;

import java.util.List;

public interface CollectorService {
    List<Product> persistFromExcel(Long startAt, Long length);
}
