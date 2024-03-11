package com.emmutua.branchsync.sales.service;

import com.emmutua.branchsync.util.CustomResponse;
import org.springframework.web.multipart.MultipartFile;

public interface SalesService {
    CustomResponse submitDailySales(
            MultipartFile requestSales
    );
}
