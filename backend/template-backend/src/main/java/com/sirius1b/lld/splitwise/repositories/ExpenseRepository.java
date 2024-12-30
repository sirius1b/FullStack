package com.sirius1b.lld.splitwise.repositories;

import com.sirius1b.lld.splitwise.models.Expense;
import com.sirius1b.lld.splitwise.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByGroup(Group group);

    Expense add(Expense expense);
}
