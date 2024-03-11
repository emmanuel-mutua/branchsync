package com.emmutua.branchsync.sales.apis;

import com.emmutua.branchsync.sales.model.Item;
import com.emmutua.branchsync.util.CustomResponse;
import com.emmutua.branchsync.sales.service.SalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

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
   @GetMapping("/all")
    public List<Item> getAllSales(){
        return salesService.getAllSales();
    }
    @GetMapping("/month/{id}")
    public List<Item> getMonthlySales(@PathVariable String id){
        return salesService.getAllSalesInACertainMonth(id);
    }

    @GetMapping("/day/{localdate}")
    public List<Item> getDailySales(@PathVariable LocalDate localDate){
        return salesService.getDailySales(localDate);
    }

}
