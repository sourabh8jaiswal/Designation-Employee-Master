package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import java.util.*;
import java.text.*;
import java.math.*;
public class AddEmployee extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
EmployeeBean employeeBean=(EmployeeBean)request.getAttribute("employeeBean");
String name=employeeBean.getName();
int designationCode=employeeBean.getDesignationCode();
Date dateOfBirth=simpleDateFormat.parse(employeeBean.getDateOfBirth());
String gender=employeeBean.getGender();
boolean isIndian=employeeBean.getIsIndian();
BigDecimal basicSalary=new BigDecimal(employeeBean.getBasicSalary());
String panNumber=employeeBean.getPANNumber();
String aadharCardNumber=employeeBean.getAadharCardNumber();
EmployeeDTO employeeDTO=new EmployeeDTO();
employeeDTO.setName(name);
employeeDTO.setDesignationCode(designationCode);
employeeDTO.setDateOfBirth(dateOfBirth);
employeeDTO.setGender(gender);
employeeDTO.setIsIndian(isIndian);
employeeDTO.setBasicSalary(basicSalary);
employeeDTO.setPANNumber(panNumber);
employeeDTO.setAadharCardNumber(aadharCardNumber);
try
{
EmployeeDAO employeeDAO=new EmployeeDAO();
DesignationDAO designationDAO=new DesignationDAO();
boolean designationCodeExists=designationDAO.designationCodeExists(designationCode);
boolean panNumberExists=employeeDAO.panNumberExists(panNumber);
boolean aadharCardNumberExists=employeeDAO.aadharCardNumberExists(aadharCardNumber);
if(designationCodeExists==false || panNumberExists || aadharCardNumberExists)
{
EmployeeErrorBean employeeErrorBean=new EmployeeErrorBean();
if(designationCodeExists==false) employeeErrorBean.setDesignationCodeError("Invalid designation");
if(panNumberExists) employeeErrorBean.setPanNumberError("PAN number exists");
if(aadharCardNumberExists) employeeErrorBean.setAadharCardNumberError("Aadhar card number exists");
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/EmployeeAddForm.jsp");
request.setAttribute("employeeBean",employeeBean);
request.setAttribute("employeeErrorBean",employeeErrorBean);
requestDispatcher.forward(request,response);
return;
}

employeeDAO.add(employeeDTO);
MessageBean messageBean=new MessageBean();
messageBean.setHeading("Employees (Add Module)");
messageBean.setMessage("Employee added, add more ?");
messageBean.setGenerateButtons(true);
messageBean.setGenerateTwoButtons(true);
messageBean.setButtonOneText("Yes");
messageBean.setButtonOneAction("EmployeeAddForm.jsp");
messageBean.setButtonTwoText("No");
messageBean.setButtonTwoAction("Employees.jsp");
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
requestDispatcher=request.getRequestDispatcher("/EmployeeAddForm.jsp");
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