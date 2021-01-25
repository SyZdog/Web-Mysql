package com.tedu.dao;
/**
 * 员工模块的Dao(持久层)接口实现类
 */
public class EmpDaoImpl implements EmpDao {

	@Override
	public void addEmp() {
		System.out.println(
			"dao层的addEmp()方法执行了..成功保存了一条员工信息.."
		);
	}
}
