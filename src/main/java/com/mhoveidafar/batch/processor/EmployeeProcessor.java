package com.mhoveidafar.batch.processor;

import org.springframework.batch.item.ItemProcessor;

import com.mhoveidafar.batch.entity.Employee;
import com.mhoveidafar.batch.entity.EmployeeDTO;

public class EmployeeProcessor implements ItemProcessor<Employee, EmployeeDTO> {

	@Override
	public EmployeeDTO process(final Employee employee) throws Exception {
		System.out.println("Transforming Employee(s) to EmployeeDTO(s)..");
		final EmployeeDTO empployeeDto = new EmployeeDTO(employee.getFirstName().toUpperCase(),
				employee.getLastName().toUpperCase(), employee.getCompanyName(), employee.getAddress(),
				employee.getCity(), employee.getCounty(), employee.getState(), employee.getZip());

		return empployeeDto;
	}
}
