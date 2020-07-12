package com.example.shoppyshop.controllers;

import com.example.shoppyshop.dto.CategoryCreateRequestDto;
import com.example.shoppyshop.dto.CategoryResponseDto;
import com.example.shoppyshop.dto.CategoryUpdateRequestDto;
import com.example.shoppyshop.models.Category;
import com.example.shoppyshop.service.CategoryService;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("admin/api/categories")
public class CategoryController {

  private final CategoryService categoryService;
  private final ModelMapper modelMapper;

  public CategoryController(CategoryService categoryService, ModelMapper modelMapper) {
    this.categoryService = categoryService;
    this.modelMapper = modelMapper;
  }

  @GetMapping
  public List<CategoryResponseDto> findCategories() {
    List<CategoryResponseDto> ret = new ArrayList<>();
    categoryService
        .findAll()
        .forEach(cat -> ret.add(modelMapper.map(cat, CategoryResponseDto.class)));
    return ret;
  }

  @GetMapping("/{id}")
  public CategoryResponseDto findById(@PathVariable long id) {
    return modelMapper.map(categoryService.findById(id), CategoryResponseDto.class);
  }

  @PostMapping
  public CategoryResponseDto create(@RequestBody CategoryCreateRequestDto cdto) {
    Category cat = modelMapper.map(cdto, Category.class);
    return modelMapper.map(categoryService.save(cat), CategoryResponseDto.class);
  }

  @PutMapping("/{id}")
  public CategoryResponseDto update(
      @RequestBody CategoryUpdateRequestDto cdto, @PathVariable Long id) {
    Category cat = modelMapper.map(cdto, Category.class);
    return modelMapper.map(categoryService.update(id, cat), CategoryResponseDto.class);
  }

  @PatchMapping("/{id}")
  public CategoryResponseDto partialUpdate(
      @RequestBody CategoryUpdateRequestDto cdto, @PathVariable Long id) {
    Category cat = modelMapper.map(cdto, Category.class);
    return modelMapper.map(categoryService.partialUpdate(id, cat), CategoryResponseDto.class);
  }
}
