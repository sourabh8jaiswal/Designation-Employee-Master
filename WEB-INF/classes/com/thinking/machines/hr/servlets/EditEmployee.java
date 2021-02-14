package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.beans.*;
import com.thinking.machines.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.text.*;
public class EditEmployee extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
String employeeId=request.getParameter("employeeId");
if(employeeId==null)
{
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/Employees.jsp");
requestDispatcher.forward(request,response);
return;
}
EmployeeDAO employeeDAO=new EmployeeDAO();
EmployeeDTO employeeDTO=null;
try
{
employeeDTO=employeeDAO.getByEmployeeId(employeeId);
}catch(DAOException daoException)
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/Employees.jsp");
requestDispatcher.forward(request,response);
return;
}
DesignationDAO designationDAO=new DesignationDAO();
String designation=designationDAO.getByCode(employeeDTO.getDesignationCode()).getTitle();
SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
EmployeeBean employeeBean;
employeeBean=new EmployeeBean();
employeeBean.setEmployeeId(employeeId);
employeeBean.setName(employeeDTO.getName());
employeeBean.setDesignationCode(employeeDTO.getDesignationCode());
employeeBean.setDesignation(designation);
employeeBean.setDateOfBirth(simpleDateFormat.format(employeeDTO.getDateOfBirth()));
employeeBean.setGender(employeeDTO.getGender());
employeeBean.setBasicSalary(employeeDTO.getBasicSalary().toPlainString());
employeeBean.setIsIndian(employeeDTO.getIsIndian());
employeeBean.setPANNumber(employeeDTO.getPANNumber());
employeeBean.setAadharCardNumber(employeeDTO.getAadharCardNumber());
request.setAttribute("employeeBean",employeeBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/EmployeeEditForm.jsp");
requestDispatcher.forward(request,response);
return;
}catch(Exception exception)
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/ErrorPage.jsp");
try
{
requestDispatcher.forward(request,response);
}catch(Exception e)
{
//do nothing
}
}
}
}