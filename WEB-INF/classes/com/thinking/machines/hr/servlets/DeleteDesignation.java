package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class DeleteDesignation extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
PrintWriter pw=response.getWriter();
response.setContentType("text/plain");
int code=Integer.parseInt(request.getParameter("code"));
DesignationDAO designationDAO=new DesignationDAO();
try
{
designationDAO.deleteByCode(code);
pw.print("deleted");
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
}
}
}
}