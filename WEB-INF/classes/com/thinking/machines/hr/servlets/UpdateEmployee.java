package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import java.util.*;
import java.text.*;
import java.math.*;
public class UpdateEmployee extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
EmployeeBean employeeBean=(EmployeeBean)request.getAttribute("employeeBean");
String employeeId=employeeBean.getEmployeeId();
String name=employeeBean.getName();
int designationCode=employeeBean.getDesignationCode();
Date dateOfBirth=simpleDateFormat.parse(employeeBean.getDateOfBirth());
String gender=employeeBean.getGender();
boolean isIndian=employeeBean.getIsIndian();
BigDecimal basicSalary=new BigDecimal(employeeBean.getBasicSalary());
String panNumber=employeeBean.getPANNumber();
String aadharCardNumber=employeeBean.getAadharCardNumber();
EmployeeDTO employee=new EmployeeDTO();
employee.setEmployeeId(employeeId);
employee.setName(name);
employee.setDesignationCode(designationCode);
employee.setDateOfBirth(dateOfBirth);
employee.setGender(gender);
employee.setIsIndian(isIndian);
employee.setBasicSalary(basicSalary);
employee.setPANNumber(panNumber);
employee.setAadharCardNumber(aadharCardNumber);
EmployeeDAO employeeDAO=new EmployeeDAO();
DesignationDAO designationDAO=new DesignationDAO();
try
{
if(employeeDAO.employeeIdExists(employeeId)==false)
{
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/Employees.jsp");
requestDispatcher.forward(request,response);
return;
}
boolean designationCodeExists=designationDAO.designationCodeExists(designationCode);
boolean panNumberExists=false;
EmployeeDTO employeeDTO;
try
{
employeeDTO=employeeDAO.getByPANNumber(panNumber);
if(employeeDTO.getEmployeeId().equals(employeeId)==false)
{
panNumberExists=true;
}
}catch(DAOException daoException)
{
panNumberExists=false;
}
boolean aadharCardNumberExists=false;
try
{
employeeDTO=employeeDAO.getByAadharCardNumber(aadharCardNumber);
if(employeeDTO.getEmployeeId().equals(employeeId)==false)
{
aadharCardNumberExists=true;
}
}catch(DAOException daoException)
{
aadharCardNumberExists=false;
}
if(designationCodeExists==false || panNumberExists || aadharCardNumberExists)
{
EmployeeErrorBean employeeErrorBean=new EmployeeErrorBean();
if(designationCodeExists==false) employeeErrorBean.setDesignationCodeError("Invalid designation");
if(panNumberExists) employeeErrorBean.setPanNumberError("PAN number exists");
if(aadharCardNumberExists) employeeErrorBean.setAadharCardNumberError("Aadhar card number exists");
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/EmployeeEditForm.jsp");
request.setAttribute("employeeBean",employeeBean);
request.setAttribute("employeeErrorBean",employeeErrorBean);
requestDispatcher.forward(request,response);
return;
}
employeeDAO.update(employee);
MessageBean messageBean=new MessageBean();
messageBean.setHeading("Employees (Edit Module)");
messageBean.setMessage("Employee updated.");
messageBean.setGenerateButtons(true);
messageBean.setGenerateTwoButtons(false);
messageBean.setButtonOneText("Ok");
messageBean.setButtonOneAction("Employees.jsp");
request.setAttribute("messageBean",messageBean);
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/Notification.jsp");
requestDispatcher.forward(request,response);
return;
}catch(DAOException daoException)
{
ErrorBean errorBean;
errorBean=new ErrorBean();
errorBean.setError(daoException.getMessage());
request.setAttribute("errorBean",errorBean);
request.setAttribute("employeeBean",employeeBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/EmployeeEditForm.jsp");
requestDispatcher.forward(request,response);
return;
}
}catch(Exception exception)
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/ErrorPage.jsp");
try
{
requestDispatcher.forward(request,response);
}catch(Exception e)
{
// do nothing
}
}
}
}