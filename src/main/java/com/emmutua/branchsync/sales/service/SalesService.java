package com.emmutua.branchsync.sales.service;

import com.emmutua.branchsync.Response.CustomResponse;
import com.emmutua.branchsync.sales.dto.RequestSales;

public interface SalesService {
    CustomResponse submitDailySales(
            RequestSales requestSales
    );
}
