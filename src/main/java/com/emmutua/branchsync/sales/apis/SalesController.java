package com.emmutua.branchsync.sales.apis;

import com.emmutua.branchsync.util.CustomResponse;
import com.emmutua.branchsync.sales.service.SalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/sales/")
@RequiredArgsConstructor
public class SalesController {

    private final SalesService salesService;
    @PostMapping("/new")
    ResponseEntity<CustomResponse> submitDailySales(
            @RequestParam("file") MultipartFile file
    ){
        var response =  salesService.submitDailySales(
                file
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
