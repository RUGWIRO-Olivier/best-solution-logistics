package com.bestSolutionCargo.exceptions;


import java.util.Date;



public class ApiException {
    public  String error;
    public  Integer status;
    public  String path;
    public String timestamp;

    

    /*
     * {
  "timestamp": "2022-12-10T10:37:50.340+00:00",
  "status": 500,
  "error": "Internal Server Error",
  "path": "/api/v1/vehicleManager/vehicle"
}
     * 
     */
    public ApiException() {       
    }

    public ApiException(String error, Integer status, String timestamp, String path) {

        this.error = error;
        this.status = status;
        this.timestamp = timestamp;
        this.path=path;
    }

    
    public ApiException(String error) {
        this.error = error;
        this.status = 400;
        this.timestamp = (new Date()).toString();
        this.path=null;
    }

    public ApiException(String error,Integer status) {
        this.error = error;
        this.status = status;
        this.timestamp = (new Date()).toString();
        this.path=null;
    }
}
