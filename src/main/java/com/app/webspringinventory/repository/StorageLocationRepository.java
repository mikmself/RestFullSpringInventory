package com.app.webspringinventory.repository;

import com.app.webspringinventory.entity.StorageLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageLocationRepository extends JpaRepository<StorageLocation, Integer> {
}
