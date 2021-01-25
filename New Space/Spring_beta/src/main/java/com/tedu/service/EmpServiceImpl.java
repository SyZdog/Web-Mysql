package com.tedu.service;
import com.tedu.dao.EmpDao;
import com.tedu.dao.EmpDaoImpl;


public class EmpServiceImpl implements EmpService{
	
	private EmpDao dao = new EmpDaoImpl();

	@Override
	public void addEmp() {
		// TODO Auto-generated method stub
		System.out.println("调用dao层的方法添加员工信息...");
		dao.addEmp();
	}
}
