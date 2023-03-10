package com.springboot.hibernate.services;

import com.springboot.hibernate.entities.CitizenIDCard;
import com.springboot.hibernate.entities.Employee;
import com.springboot.hibernate.services.base.IBaseService;

public interface IEmployeeService extends IBaseService<Employee> {

  Employee findByFullName(CitizenIDCard rs);
}
