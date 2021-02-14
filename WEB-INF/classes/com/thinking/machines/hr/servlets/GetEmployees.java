package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import java.text.*;
import java.util.*;
import java.io.*;
import com.thinking.machines.hr.dl.*;

public class GetEmployees extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
}catch(Exception e)
{
// do nothing
}
}

public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
PrintWriter pw=response.getWriter();
response.setContentType("text/plain");
List<EmployeeDTO> employees=new EmployeeDAO().getAll();
int i=0;
String isIndian;
SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");
//Populating Employees in employees array
for(EmployeeDTO employee:employees)
{
i++;
if(employee.getIsIndian()==true)
{
isIndian="Y";
}else
{
isIndian="N";
}
pw.print(employee.getEmployeeId()+","+employee.getName()+","+employee.getDesignationCode()+","+employee.getDesignation()+","+simpleDateFormat.format(employee.getDateOfBirth())+","+employee.getGender()+","+isIndian+","+employee.getBasicSalary().toPlainString()+","+employee.getPANNumber()+","+employee.getAadharCardNumber());
if(i<employees.size()) pw.print(",");
}
}catch(Exception exception)
{
try
{
response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
}catch(Exception e)
{
// do nothing
}
}
}
}