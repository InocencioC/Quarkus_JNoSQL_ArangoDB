package com.ino.service;

import com.ino.model.Goal;
import com.ino.repository.NewYearWishes;
import jakarta.data.Order;
import jakarta.data.Sort;
import jakarta.data.page.Page;
import jakarta.data.page.PageRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.jnosql.mapping.Database;
import org.eclipse.jnosql.mapping.DatabaseType;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class GoalService {
    private final NewYearWishes newYearWishes;

    @Inject
    public GoalService(@Database(DatabaseType.DOCUMENT) NewYearWishes newYearWishes) {
        this.newYearWishes = newYearWishes;
    }

    @Deprecated
    GoalService() {
        this(null);
    }

    public List<Goal> findGoals(int page, int size) {
        PageRequest pageRequest = PageRequest.ofPage(page).size(size);
        Order<Goal> priority = Order.by(Sort.asc("priority"));
        Page<Goal> goals = newYearWishes.findAll(pageRequest, priority);
        return goals.content();
    }

    public Goal save (Goal goal) {
        return newYearWishes.save(goal);
    }
    public Optional<Goal> findById(String id) {
        var keyPrefix = "Goal/" +id;
        return newYearWishes.findById(keyPrefix);
    }
}
