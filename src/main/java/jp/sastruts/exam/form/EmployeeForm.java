package jp.sastruts.exam.form;

import java.io.Serializable;

import org.seasar.struts.annotation.Required;

public class EmployeeForm implements Serializable {
	
	@Required
	public String employeeNo;

	public String employeeName;

	public void reset() {}
}
