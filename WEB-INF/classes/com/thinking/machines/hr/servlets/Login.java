package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.hr.beans.*;
import com.thinking.machines.hr.dl.*;
public class Login extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
doPost(request,response);
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
AdministratorBean administratorBean=(AdministratorBean)request.getAttribute("administratorBean");
if(administratorBean==null)
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
requestDispatcher.forward(request,response);
return;
}
AdministratorDTO administratorDTO;
AdministratorDAO administratorDAO;
administratorDAO=new AdministratorDAO();
try
{
administratorDTO=administratorDAO.getByUsername(administratorBean.getUsername());
String username=administratorDTO.getUsername();
String password=administratorDTO.getPassword();
if(administratorBean.getPassword().equals(password)==false)
{
ErrorBean errorBean=new ErrorBean();
errorBean.setError("Invalid username / password");
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
requestDispatcher.forward(request,response);
return;
}
HttpSession session=request.getSession();
session.setAttribute("username",username);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/index.jsp");
requestDispatcher.forward(request,response);
}catch(DAOException daoException)
{
ErrorBean errorBean=new ErrorBean();
errorBean.setError("Invalid username / password");
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
requestDispatcher.forward(request,response);
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