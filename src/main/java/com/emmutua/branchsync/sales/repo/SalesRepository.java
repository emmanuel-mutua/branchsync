package com.emmutua.branchsync.sales.repo;

import com.emmutua.branchsync.sales.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<Item, Long> {
    List<Item> findAllByMonth(String month);

    List<Item> findAllByLocalDate(LocalDate localDate);
}
