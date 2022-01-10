package com.revature.services;
import com.revature.beans.Employee;

public interface UserService {
	
	public Employee register(Employee newEmp);
	public Employee logIn(String username, String password);
	public Employee getUserById(int id);
	public Employee updateUser(Employee empToUpdate);

}
