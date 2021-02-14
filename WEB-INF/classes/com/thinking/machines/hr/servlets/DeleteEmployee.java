package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class DeleteEmployee extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
EmployeeBean employeeBean=(EmployeeBean)request.getAttribute("employeeBean");
String employeeId=employeeBean.getEmployeeId();
EmployeeDAO employeeDAO=new EmployeeDAO();
try
{
employeeDAO.deleteByEmployeeId(employeeId);
MessageBean messageBean=new MessageBean();
messageBean.setHeading("Employee (Delete Module)");
messageBean.setMessage("Employee deleted");
messageBean.setGenerateButtons(true);
messageBean.setButtonOneText("OK");
messageBean.setButtonOneAction("Employees.jsp");
request.setAttribute("messageBean",messageBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/Notification.jsp");
requestDispatcher.forward(request,response);
}catch(DAOException daoException)
{
MessageBean messageBean=new MessageBean();
messageBean.setHeading("Employee (Delete Module)");
messageBean.setMessage("Unable to delete employee");
messageBean.setGenerateButtons(true);
messageBean.setButtonOneText("OK");
messageBean.setButtonOneAction("Employees.jsp");
request.setAttribute("messageBean",messageBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/Notification.jsp");
requestDispatcher.forward(request,response);
}
}catch(Exception exception)
{
System.out.println(exception); //remove after testing
}
}
}