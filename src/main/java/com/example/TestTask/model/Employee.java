package com.example.TestTask.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @NotNull(message = "Id cannot be null")
    private Long id;

    @NotNull(message = "DateStart cannot be null")
    private LocalDateTime dateStart;

    @NotNull(message = "DateEnd cannot be null")
    private LocalDateTime dateEnd;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(dateStart, employee.dateStart) && Objects.equals(dateEnd, employee.dateEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateStart, dateEnd);
    }
}
