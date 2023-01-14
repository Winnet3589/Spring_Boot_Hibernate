package com.springboot.hibernate.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.springboot.hibernate.dtos.CompanyDto;
import com.springboot.hibernate.entities.Company;
import com.springboot.hibernate.entities.Department;
import com.springboot.hibernate.mappers.MapStructMapper;
import com.springboot.hibernate.services.impl.CompanyServiceImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CompanyController {

  private final CompanyServiceImpl companyService;

  @GetMapping(value = "/companies/dto")
  public List<CompanyDto> listCompanyDto() {
    return MapStructMapper.INSTANCE.mapCompanyFromEntityToDtoList(
        companyService.findAll());
  }

  @GetMapping(value = "/companies")
  public List<Company> listCompany() {
    return companyService.findAll();
  }

  @GetMapping(value = "/companies/{id}")
  public Company findById(@PathVariable Long id) throws JsonProcessingException {
    Company rs = companyService.findById(id);

    // Demo Lazy
    List<Department> departments = rs.getDepartments();
    return rs;
  }

  @GetMapping(value = "/companies/dto/{id}")
  public CompanyDto findByIdDto(@PathVariable Long id) {
    return MapStructMapper.INSTANCE.mapCompanyFromEntityToDto(companyService.findById(id));
  }

  //Cascade
  @GetMapping(value = "/companies/delete/{id}")
  public ResponseEntity delete(@PathVariable Long id) {
    int rt = companyService.delete(id);
    return ResponseEntity.ok(rt > 0 ? "Delete successful!" : "Delete failed!");
  }
}
