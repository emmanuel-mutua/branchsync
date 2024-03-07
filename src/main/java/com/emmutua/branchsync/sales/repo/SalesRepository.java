package com.emmutua.branchsync.sales.repo;

import com.emmutua.branchsync.sales.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<Item, Long> {
}
