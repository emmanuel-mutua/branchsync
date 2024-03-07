package com.emmutua.branchsync.sales.apis;

import com.emmutua.branchsync.Response.CustomResponse;
import com.emmutua.branchsync.sales.service.SalesService;
import com.emmutua.branchsync.sales.dto.RequestSales;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sales/")
@RequiredArgsConstructor
public class SalesController {

    private final SalesService salesService;
    @PostMapping("/new")
    ResponseEntity<CustomResponse> submitDailySales(
            @RequestBody RequestSales requestSales
    ){
        var response =  salesService.submitDailySales(
                requestSales
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
