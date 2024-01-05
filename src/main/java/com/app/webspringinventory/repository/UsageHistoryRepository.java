package com.app.webspringinventory.repository;

import com.app.webspringinventory.entity.UsageHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsageHistoryRepository extends JpaRepository<UsageHistory, Integer> {
}
