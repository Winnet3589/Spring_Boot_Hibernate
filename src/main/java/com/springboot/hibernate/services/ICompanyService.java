package com.springboot.hibernate.services;

import com.springboot.hibernate.entities.Company;
import com.springboot.hibernate.services.base.IBaseService;
import com.springboot.hibernate.utils.InvalidPayloadException;

public interface ICompanyService extends IBaseService<Company> {

  Company findByIdLazyEx(Long id);
}
