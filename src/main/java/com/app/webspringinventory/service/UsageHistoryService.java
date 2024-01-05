package com.app.webspringinventory.service;

import com.app.webspringinventory.entity.UsageHistory;
import com.app.webspringinventory.repository.UsageHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsageHistoryService {
    @Autowired
    private UsageHistoryRepository repository;

    public void save(UsageHistory usageHistory) {
        repository.save(usageHistory);
    }
    public List<UsageHistory> get() {
        return repository.findAll();
    }
    public UsageHistory getById(int id) {
        return repository.findById(id).get();
    }
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
