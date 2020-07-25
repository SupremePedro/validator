package com.supremepedro.validator.service;

import com.supremepedro.validator.model.Subcategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SubcategoryService {
    Page<Subcategory> getPageableCollectedSubcategory(Pageable pageable);
}
