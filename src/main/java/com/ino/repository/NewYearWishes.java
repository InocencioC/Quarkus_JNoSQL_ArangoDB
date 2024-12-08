package com.ino.repository;

import com.ino.model.Goal;
import jakarta.data.repository.BasicRepository;
import jakarta.data.repository.Repository;

@Repository
public interface NewYearWishes extends BasicRepository<Goal, String> {}
