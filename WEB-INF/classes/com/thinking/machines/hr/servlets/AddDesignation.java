package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class AddDesignation extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
PrintWriter pw=response.getWriter();
response.setContentType("text/plain");
String title=request.getParameter("title").trim();
DesignationDTO designation;
designation=new DesignationDTO();
designation.setTitle(title);
DesignationDAO designationDAO;
designationDAO=new DesignationDAO();
try
{
designationDAO.add(designation);
pw.print("added");
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
// do nothing
}
}
}
}