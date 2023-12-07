package com.example.TestTask.service.imp;

import com.example.TestTask.model.Employee;
import com.example.TestTask.model.request.EmployeeRequest;
import com.example.TestTask.model.response.EmployeeResponse;
import com.example.TestTask.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;


@Service
public class EmployeeServiceImp implements EmployeeService {

    @Override
    public EmployeeResponse findEmployeeMaxWorkTime(EmployeeRequest employeeRequest) {

        List<Employee> employees = employeeRequest.getEmployees();

        if (employees.isEmpty()) {
            throw new IllegalArgumentException("Массив сотрудников не найден.");
        }

        for (Employee employee : employees) {
            if (isNull(employee.getDateEnd())) continue;
            if (employee.getDateStart().isAfter(employee.getDateEnd())) {
                throw new IllegalArgumentException("Дата начала работы не может быть позже даты окончания работы.");
            }
        }
        return findEmployeeWithMaxWorkPeriod(employees);
    }

    public EmployeeResponse findEmployeeWithMaxWorkPeriod(List<Employee> employees) {
        Map<Long, Duration> employeeWorkPeriods = new HashMap<>();

        for (Employee employee : employees) {
            Duration workTime = Duration.between(employee.getDateStart(), employee.getDateEnd());

            if (employeeWorkPeriods.containsKey(employee.getId())) {
                Duration currentPeriod = employeeWorkPeriods.get(employee.getId());
                employeeWorkPeriods.put(employee.getId(), currentPeriod.plus(workTime));
            } else {
                employeeWorkPeriods.put(employee.getId(), workTime);
            }
        }

        long id = 0;
        Duration maxWorkPeriod = Duration.ZERO;

        for (Map.Entry<Long, Duration> entry : employeeWorkPeriods.entrySet()) {
            if (entry.getValue().compareTo(maxWorkPeriod) > 0) {
                maxWorkPeriod = entry.getValue();
                id = entry.getKey();
            }
        }

        return new EmployeeResponse(id, formatDuration(maxWorkPeriod));
    }

    private String formatDuration(Duration duration) {
        long seconds = duration.getSeconds();
        long hours = seconds / 3600;
        long minutes = (seconds % 3600) / 60;
        long remainingSeconds = seconds % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, remainingSeconds);
    }
}
