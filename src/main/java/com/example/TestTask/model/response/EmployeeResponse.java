package com.example.TestTask.model.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeResponse {

    private Long id;

    private String time;

    public EmployeeResponse(Long id, String time) {
        this.id = id;
        this.time = time;
    }

    public EmployeeResponse(String time) {
        this.time = time;
    }
}
