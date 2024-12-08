package com.sirius1b.lld.splitwise.repositories;

import com.sirius1b.lld.splitwise.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    Group add(Group group);
}
