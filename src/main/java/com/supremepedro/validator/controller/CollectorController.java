package com.supremepedro.validator.controller;

import com.supremepedro.validator.model.Product;
import com.supremepedro.validator.model.Subcategory;
import com.supremepedro.validator.service.CollectorService;
import com.supremepedro.validator.service.SubcategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/collector")
@RequiredArgsConstructor
public class CollectorController {
    private final SubcategoryService subcategoryService;
    private final CollectorService collectorService;

    @GetMapping
    public Page<Subcategory> getCollectedSubCategory(@PageableDefault Pageable pageable){
        return subcategoryService.getPageableCollectedSubcategory(pageable);
    }

//    @PostMapping("{subcategory}/{attribute}")
//    public List<Product> collectNewSubcategory(@PathVariable String subcategory, @PathVariable String attribute){
//            return  null;
//    }

    @GetMapping("/excel/{startAt}/{length}")
    public List<Product> persistFromExcel(@PathVariable Long startAt, @PathVariable Long length){
        return collectorService.persistFromExcel(startAt,length);
    }
}
