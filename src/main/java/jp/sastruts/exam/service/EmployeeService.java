<<<<<<< HEAD
package jp.sastruts.exam.service;

import java.util.Random;

import jp.sastruts.exam.entity.Employee;
import jp.sastruts.exam.exception.ApplicationRuntimeException;
import jp.sastruts.exam.service.dto.EmployeeBizDto;
import jp.sastruts.exam.util.DateUtils;

import org.seasar.extension.jdbc.service.S2AbstractService;

/**
 * Employeeテーブルと対応するServiceクラスです。
 * @author W.Ryozo
 *
 */
public class EmployeeService extends S2AbstractService<Employee>{

	/**
	 * 入社する。
	 * @param dto 入社社員情報を保持するBizDto
	 * @return 処理結果
	 */
	public Employee join(EmployeeBizDto dto) {
		Employee employee = new Employee();
		employee.employeeNo = String.valueOf(new Random().nextInt(10000));
		employee.entranceDay = DateUtils.getCurrentSqlDate();
		int insertCount = insert(employee);
		
		if (insertCount != 1) {
			throw new ApplicationRuntimeException("MSG01");
		}

		return employee;
	}
	
	/**
	 * 退社する。
	 * @param dto 退社社員の社員番号を保持するBizDto
	 * @return 処理結果
	 */
	public Employee retire(EmployeeBizDto dto) {
		Employee retireEmp = select().where("EMPLOYEENO = ?", dto.employeeNo).getSingleResult();
		retireEmp.retireDay = DateUtils.getCurrentSqlDate();
		int deleteCount = delete(retireEmp);
		if (deleteCount != 1) {
			throw new ApplicationRuntimeException("MSG01");
		}
		
		return retireEmp;
	}
}
=======
package jp.sastruts.exam.service;

import java.util.List;

import jp.sastruts.exam.entity.Employee;
import jp.sastruts.exam.exception.ApplicationRuntimeException;
import jp.sastruts.exam.service.dto.EmployeeBizDto;
import jp.sastruts.exam.util.DateUtils;

import org.seasar.extension.jdbc.service.S2AbstractService;
import org.seasar.extension.jdbc.where.SimpleWhere;
import org.seasar.struts.annotation.Execute;

/**
 * Employeeテーブルと対応するServiceクラスです。
 * @author W.Ryozo
 *
 */
public class EmployeeService extends S2AbstractService<Employee>{
	
	/**
	 * 現在所属する社員の一覧取得。
	 * @return
	 */
	@Execute
	public List<Employee> findAllEffectiveEmployees() {
		return select().where(new SimpleWhere().isNull("retireday", Boolean.TRUE)).getResultList();
	}

	/**
	 * 入社する。
	 * @param dto 入社社員情報を保持するBizDto
	 * @return 処理結果
	 */
	public Employee join(EmployeeBizDto dto) {
		Employee employee = new Employee();
		employee.employeeNo = dto.employeeNo;
		employee.employeeName = dto.employeeName;
		employee.entranceDay = DateUtils.getCurrentSqlDate();
		int insertCount = insert(employee);
		
		if (insertCount != 1) {
			throw new ApplicationRuntimeException("MSG01");
		}

		return employee;
	}
	
	/**
	 * 退社する。
	 * @param dto 退社社員の社員番号を保持するBizDto
	 * @return 処理結果
	 */
	public Employee retire(EmployeeBizDto dto) {
		Employee retireEmp = select().where("EMPLOYEENO = ?", dto.employeeNo).getSingleResult();
		if (retireEmp == null) {
			throw new ApplicationRuntimeException("MSG");
		}
		retireEmp.retireDay = DateUtils.getCurrentSqlDate();
		int deleteCount = update(retireEmp);
		if (deleteCount != 1) {
			throw new ApplicationRuntimeException("MSG01");
		}
		
		return retireEmp;
	}
}
>>>>>>> eb5eebe1e06ecf1996ec9fe48387b87b03d55fdc
