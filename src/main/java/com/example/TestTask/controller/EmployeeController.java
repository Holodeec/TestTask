package com.example.TestTask.controller;

import com.example.TestTask.model.request.EmployeeRequest;
import com.example.TestTask.model.response.EmployeeResponse;
import com.example.TestTask.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/max-work-time")
    public ResponseEntity<EmployeeResponse> getMaxWorkTime(@RequestBody @Valid EmployeeRequest employeeRequest) {

        try {
            return ResponseEntity.ok(employeeService.findEmployeeMaxWorkTime(employeeRequest));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new EmployeeResponse(e.getMessage()));
        }
    }
}
