package com.emmutua.branchsync.sales.service;

import com.emmutua.branchsync.sales.model.Item;
import com.emmutua.branchsync.util.CustomResponse;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public interface SalesService {
    CustomResponse submitDailySales(
            MultipartFile requestSales
    );

    List<Item> getAllSales();

    List<Item> getAllSalesInACertainMonth(String month);

    List<Item> getDailySales(LocalDate localDate);
}
