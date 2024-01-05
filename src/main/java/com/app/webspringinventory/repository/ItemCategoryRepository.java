package com.app.webspringinventory.repository;

import com.app.webspringinventory.entity.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemCategoryRepository extends JpaRepository<ItemCategory,Integer> {
}
