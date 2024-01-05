package com.app.webspringinventory.repository;

import com.app.webspringinventory.entity.Custodian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustodianRepository extends JpaRepository<Custodian, Integer> {
}
