package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.beans.*;
import com.thinking.machines.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class EditDesignation extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
int code=0;
try
{
code=Integer.parseInt(request.getParameter("code"));
}catch(NumberFormatException nfe)
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/Designations.jsp");
requestDispatcher.forward(request,response);
return;
}
DesignationDAO designationDAO=new DesignationDAO();
DesignationDTO designationDTO=null;
try
{
designationDTO=designationDAO.getByCode(code);
}catch(DAOException daoException)
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/Designations.jsp");
requestDispatcher.forward(request,response);
return;
}
DesignationBean designationBean;
designationBean=new DesignationBean();
designationBean.setCode(code);
designationBean.setTitle(designationDTO.getTitle());
request.setAttribute("designationBean",designationBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/DesignationEditForm.jsp");
requestDispatcher.forward(request,response);
}catch(Exception exception)
{
System.out.println(exception);
}
}
}