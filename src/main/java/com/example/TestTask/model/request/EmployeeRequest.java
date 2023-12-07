package com.example.TestTask.model.request;

import com.example.TestTask.model.Employee;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {

    @Valid
    @NonNull
    private List<Employee> employees;

}
