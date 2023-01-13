package com.springboot.hibernate.configs;

import com.springboot.hibernate.enums.JobType;
import com.springboot.hibernate.entities.Address;
import com.springboot.hibernate.entities.BankCard;
import com.springboot.hibernate.entities.CitizenIDCard;
import com.springboot.hibernate.entities.Employee;
import com.springboot.hibernate.entities.Job;
import com.springboot.hibernate.enums.Gender;
import com.springboot.hibernate.services.impl.AddressServiceImpl;
import com.springboot.hibernate.services.impl.BankCardServiceImpl;
import com.springboot.hibernate.services.impl.CitizenIDCardDServiceImpl;
import com.springboot.hibernate.services.impl.EmployeeServiceImpl;
import com.springboot.hibernate.services.impl.JobServiceImpl;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitData {

  private final CitizenIDCardDServiceImpl citizenIDCardDService;
  private final EmployeeServiceImpl employeeService;
  private final BankCardServiceImpl bankCardService;
  private final JobServiceImpl jobService;
  private final AddressServiceImpl addressService;

  @PostConstruct
  void init() {

    // CitizenIDCard
    CitizenIDCard citizenIDCard = CitizenIDCard.builder()
        .citizenIdNo("205467129")
        .dayOfBirth(new Date())
        .city("NewYork")
        .country("America")
        .state("A5AB5B")
        .build();
    CitizenIDCard citizenIDCard2 = CitizenIDCard.builder()
        .citizenIdNo("305467129")
        .dayOfBirth(Timestamp.valueOf("2019-09-01 09:01:15"))
        .city("Quang Nam")
        .country("Viet Nam")
        .state("CACD2D")
        .build();
    citizenIDCardDService.save(citizenIDCard);
    citizenIDCardDService.save(citizenIDCard2);

    //Job
    Job job = Job.builder()
        .jobName("Developer")
        .jobDescription("Code")
        .jobType(JobType.FULL_TIME)
        .build();
    Job job2 = Job.builder()
        .jobName("Tester")
        .jobDescription("Test")
        .jobType(JobType.PART_TIME)
        .build();

    // Employee
    Employee employee = Employee
        .builder()
        .fullName("Nguyen Thi A")
        .email("a@gmail.com")
        .gender(Gender.FEMALE)
        .citizenIDCard(citizenIDCard)
        .phoneNumber("0905 030589")
        .jobs(List.of(job))
        .build();
    Employee employee2 = Employee
        .builder()
        .fullName("Nguyen Van B")
        .gender(Gender.MALE)
        .email("b@gmail.com")
        .citizenIDCard(citizenIDCard2)
        .phoneNumber("0906 030589")
        .jobs(List.of(job, job2))
        .build();
    employeeService.save(employee);
    employeeService.save(employee2);

    // Bank Card
    BankCard bankCard = BankCard.builder()
        .bankCardNo("1111-2222")
        .bankCardName("TPBank")
        .bankCardSerial("1111-2222")
        .employee(employee)
        .build();
    BankCard bankCard2 = BankCard.builder()
        .bankCardNo("1111-3333")
        .bankCardName("Vietcombank")
        .bankCardSerial("1111-3333")
        .employee(employee)
        .build();
    BankCard bankCard3 = BankCard.builder()
        .bankCardNo("1111-4444")
        .bankCardName("Sacombank")
        .bankCardSerial("1111-4444")
        .employee(employee2)
        .build();
    bankCardService.save(bankCard);
    bankCardService.save(bankCard2);
    bankCardService.save(bankCard3);

    Address address = Address.builder()
        .city("Hue")
        .country("Viet Nam")
        .state("CACD2D")
        .build();
    Address address2 = Address.builder()
        .city("Da Nang")
        .country("Viet Nam")
        .state("BCAD2D")
        .build();
    addressService.save(address);
    addressService.save(address2);
  }
}
