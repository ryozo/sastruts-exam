package sastruts.exam.action.browse;

import java.util.List;

import javax.annotation.Resource;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import sastruts.exam.entity.Employee;
import sastruts.exam.form.EmployeeForm;
import sastruts.exam.service.EmployeeService;
import sastruts.exam.service.dto.EmployeeBizDto;

/**
 * 社員関連の処理を行うActionクラスです。
 * @author W.Ryozo
 *
 */
public class EmployeeAction {

	@Resource
	public EmployeeService employeeService;
	
	@ActionForm
	@Resource
	public EmployeeForm employeeForm;
	
	public List<Employee> employees;
	
	@Execute(validator=false)
	public String index() {
		employees = employeeService.findAllEffectiveEmployees();
		return "employee.jsp";
	}
	
	@Execute(input="employee.jsp")
	public String join() {
		EmployeeBizDto bizDto = new EmployeeBizDto();
		bizDto.employeeNo = employeeForm.employeeNo;
		bizDto.employeeName = employeeForm.employeeName;
		
		employeeService.join(bizDto);
		
		return "/browse/employee";
	}
	
	@Execute(input="employee.jsp")
	public String retire() {
		EmployeeBizDto bizDto = new EmployeeBizDto();
		bizDto.employeeNo = employeeForm.employeeNo;
		
		employeeService.retire(bizDto);
		
		return "/browse/employee";
	}
	
}
