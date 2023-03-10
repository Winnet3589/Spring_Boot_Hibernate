package com.springboot.hibernate.repositories.impl;

import com.springboot.hibernate.entities.BankCard;
import com.springboot.hibernate.repositories.IBankCardRepository;
import com.springboot.hibernate.repositories.base.BaseRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BankCardRepositoryImpl extends BaseRepositoryImpl<BankCard> implements
    IBankCardRepository {

}
