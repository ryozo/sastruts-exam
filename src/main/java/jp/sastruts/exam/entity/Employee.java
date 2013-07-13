package jp.sastruts.exam.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Employeeテーブルと対応するEntityクラスです。
 * @author W.Ryozo
 *
 */
@Entity
@Table(name="Employee")
public class Employee {
	
	/** 主キー */
	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="employee_gen")
//	@SequenceGenerator(name="employee_gen", sequenceName="employee_seq")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public Long id;
	
	/** ビジネスキー */
	@Column(name="employeeno")
	public String employeeNo;

	/** value */
	@Column(name="employeename")
	public String employeeName;

	/** 入社日 */
	@Column(name="entranceday")
	public Date entranceDay;
	
	/** 退職日 */
	@Column(name="retireday")
	public Date retireDay;
	
	/** Version */
	@Version
	@Column(name="version")
	public Long version;
}
