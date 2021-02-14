package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
public class GetDesignations extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
PrintWriter pw=response.getWriter();
response.setContentType("text/plain");
List<DesignationDTO> designations;
DesignationDAO designationDAO;
designationDAO=new DesignationDAO();
designations=designationDAO.getAll();
int i=0;
for(DesignationDTO designation : designations)
{
i++;
pw.print(designation.getCode()+","+designation.getTitle());
if( i<designations.size()) pw.print(",");
}
}catch(Exception exception)
{
try
{
response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
}catch(Exception ee)
{
}
}
}
}