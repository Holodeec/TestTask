package com.example.TestTask.service;

import com.example.TestTask.model.request.EmployeeRequest;
import com.example.TestTask.model.response.EmployeeResponse;

public interface EmployeeService {
    EmployeeResponse findEmployeeMaxWorkTime(EmployeeRequest employeeRequest);
}
