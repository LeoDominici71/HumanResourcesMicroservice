package com.HrPayroll.hrpayroll.services;

import com.HrPayroll.hrpayroll.entities.Payment;
import com.HrPayroll.hrpayroll.entities.Worker;
import com.HrPayroll.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

  

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WorkerFeignClient workerFeignClient;
    public Payment getPayment(long workerId, int days){

        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}
