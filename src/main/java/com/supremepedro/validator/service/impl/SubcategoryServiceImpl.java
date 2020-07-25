package com.supremepedro.validator.service.impl;

import com.supremepedro.validator.model.Subcategory;
import com.supremepedro.validator.repository.SubcategoryRepository;
import com.supremepedro.validator.service.SubcategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubcategoryServiceImpl implements SubcategoryService {
    private final SubcategoryRepository subcategoryRepository;

    @Override
    public Page<Subcategory> getPageableCollectedSubcategory(Pageable pageable) {
        return subcategoryRepository.findAll(pageable);
    }
}
