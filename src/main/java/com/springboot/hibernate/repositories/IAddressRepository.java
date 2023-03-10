package com.springboot.hibernate.repositories;

import com.springboot.hibernate.entities.Address;
import com.springboot.hibernate.repositories.base.IBaseRepository;
import org.hibernate.LockMode;

public interface IAddressRepository extends IBaseRepository<Address> {

  // Flushing
  void autoFlushingPriorToCommiting(Address address);
  void autoFlushingHqlQuery(Address address);
  void autoFlushingNativeSql(Address address);

  void commitFlushingHqlQuery(Address address);
  void commitFlushingNativeSql(Address address);

  void alwaysFlushingHqlQuery(Address address);
  void alwaysFlushingNativeSql(Address address);

  void manualFlushingHqlQuery(Address address);
  void manualFlushingNativeSql(Address address);

  // pessimistic
  void pessimisticFindById(Long id, LockMode lockMode);

}
