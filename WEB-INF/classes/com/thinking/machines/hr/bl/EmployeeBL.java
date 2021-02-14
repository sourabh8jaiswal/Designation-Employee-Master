package com.thinking.machines.hr.bl;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import java.util.*;
import java.text.*;
public class EmployeeBL
{
public List<EmployeeBean> getAll()
{
List<EmployeeBean> employees=new LinkedList<>();
try
{
EmployeeDAO employeeDAO=new EmployeeDAO();
List<EmployeeDTO> dlEmployees=employeeDAO.getAll();
SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");
EmployeeBean employeeBean;
for(EmployeeDTO employeeDTO:dlEmployees)
{
employeeBean=new EmployeeBean();
employeeBean.setEmployeeId(employeeDTO.getEmployeeId());
employeeBean.setName(employeeDTO.getName());
employeeBean.setDesignationCode(employeeDTO.getDesignationCode());
employeeBean.setDesignation(employeeDTO.getDesignation());
employeeBean.setDateOfBirth(simpleDateFormat.format(employeeDTO.getDateOfBirth()));
employeeBean.setGender(employeeDTO.getGender());
employeeBean.setIsIndian(employeeDTO.getIsIndian());
employeeBean.setBasicSalary(employeeDTO.getBasicSalary().toPlainString());
employeeBean.setPANNumber(employeeDTO.getPANNumber());
employeeBean.setAadharCardNumber(employeeDTO.getAadharCardNumber());
employees.add(employeeBean);
}
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}
return employees;
}
}