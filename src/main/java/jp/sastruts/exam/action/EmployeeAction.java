package jp.sastruts.exam.action;

import javax.annotation.Resource;

import jp.sastruts.exam.entity.Employee;
import jp.sastruts.exam.form.EmployeeForm;
import jp.sastruts.exam.service.EmployeeService;
import jp.sastruts.exam.service.dto.EmployeeBizDto;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

public class EmployeeAction {

	@Resource
	public EmployeeService employeeService;
	
	@ActionForm
	@Resource
	public EmployeeForm employeeForm;
	
	@Execute(input="employee.jsp")
	public String index() {
		return "employee.jsp";
	}
	
	@Execute(input="employee.jsp")
	public String join() {
		EmployeeBizDto bizDto = new EmployeeBizDto();
		bizDto.employeeNo = employeeForm.employeeNo;
		bizDto.employeeName = employeeForm.employeeName;
		
		Employee emp = employeeService.join(bizDto);
		
		return "employee.jsp";
	}
	
}
