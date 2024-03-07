package com.emmutua.branchsync.sales.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.File;

@Setter
@Getter
public class RequestSales {
    File excelFile;

    public RequestSales(File excelFile) {
        this.excelFile = excelFile;
    }

}
