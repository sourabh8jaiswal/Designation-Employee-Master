package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class UpdateDesignation extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
PrintWriter pw=response.getWriter();
response.setContentType("text/plain");
int code=Integer.parseInt(request.getParameter("code"));
String title=request.getParameter("title");
DesignationDTO designation;
designation=new DesignationDTO();
designation.setCode(code);
designation.setTitle(title);
DesignationDAO designationDAO;
designationDAO=new DesignationDAO();
try
{
designationDAO.update(designation);
pw.print("updated");
}catch(DAOException daoException)
{
pw.print(daoException.getMessage());
}
}catch(Exception exception)
{
try
{
response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
}catch(Exception e)
{
//do nothing
}
}
}
}