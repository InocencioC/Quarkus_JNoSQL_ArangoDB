package com.ino.service;

import com.ino.model.Goal;
import jakarta.data.Order;
import jakarta.data.Sort;
import jakarta.data.page.PageRequest;
import jakarta.inject.Inject;
import org.eclipse.jnosql.mapping.Database;
import org.eclipse.jnosql.mapping.DatabaseType;

import java.util.List;
import java.util.Optional;

public class GoalService {
    private final NewYearWishes newYearWishes;

    @Inject
    public GoalService(@Database(DatabaseType.DOCUMENT) NewYearWishes newYearWishes) {
        this.newYearWishes = newYearWishes;
    }

    public List<Goal> findGoals(int page, int size) {
        PageRequest pageRequest = PageRequest.ofPage(page).size(size);
        return newYearWishes.findAll(pageRequest, Order.by(Sort.asc("priority"))).content();
    }

    public Goal save (Goal goal) {
        return newYearWishes.save(goal);
    }
    public Optional<Goal> findById(String id) {
        return newYearWishes.findById(id);
    }
}
