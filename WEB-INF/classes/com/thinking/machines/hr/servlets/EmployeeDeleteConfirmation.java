package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.text.*;
public class EmployeeDeleteConfirmation extends HttpServlet
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
EmployeeDTO employeeDTO;
SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");
try
{
employeeDTO=employeeDAO.getByEmployeeId(employeeId);
EmployeeBean employeeBean=new EmployeeBean();
employeeBean.setEmployeeId(employeeId);
employeeBean.setName(employeeDTO.getName());
employeeBean.setDesignationCode(employeeDTO.getDesignationCode());
employeeBean.setDesignation(employeeDTO.getDesignation());
employeeBean.setDateOfBirth(simpleDateFormat.format(employeeDTO.getDateOfBirth()));
employeeBean.setGender(employeeDTO.getGender());
employeeBean.setIsIndian(employeeDTO.getIsIndian());
employeeBean.setBasicSalary(employeeDTO.getBasicSalary().toPlainString());
employeeBean.setPANNumber(employeeDTO.getPANNumber());
employeeBean.setAadharCardNumber(employeeDTO.getAadharCardNumber());
request.setAttribute("employeeBean",employeeBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/EmployeeDeleteConfirmation.jsp");
requestDispatcher.forward(request,response);
}catch(DAOException daoException)
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/Employees.jsp");
requestDispatcher.forward(request,response);
}
}catch(Exception exception)
{
System.out.println(exception); // remove after testing
}
}
}