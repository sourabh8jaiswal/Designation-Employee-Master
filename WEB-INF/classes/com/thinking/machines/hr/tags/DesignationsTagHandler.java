package com.thinking.machines.hr.tags;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
public class DesignationsTagHandler extends BodyTagSupport
{
private List<DesignationBean> designations;
private int index;
public DesignationsTagHandler()
{
reset();
}
private void reset()
{
index=0;
if(designations!=null)
{
designations.clear();
designations=null;
}
}
public int doStartTag()
{
List<DesignationDTO> dlDesignations=null;
try
{
dlDesignations=new DesignationDAO().getAll();
}catch(DAOException daoException)
{
System.out.println(daoException);
return super.SKIP_BODY;
}
if(dlDesignations.size()==0) return super.SKIP_BODY;
designations=new LinkedList<>();
DesignationBean designationBean;
for(DesignationDTO dlDesignation:dlDesignations)
{
designationBean=new DesignationBean();
designationBean.setCode(dlDesignation.getCode());
designationBean.setTitle(dlDesignation.getTitle());
designations.add(designationBean);
}
index=0;
designationBean=designations.get(index);
pageContext.setAttribute("designationBean",designationBean,PageContext.REQUEST_SCOPE);
pageContext.setAttribute("serialNumber",new Integer(index+1));
return super.EVAL_BODY_INCLUDE;
}
public int doAfterBody()
{
index++;
if(designations.size()==index) return super.SKIP_BODY;
DesignationBean designationBean;
designationBean=designations.get(index);
pageContext.setAttribute("designationBean",designationBean,PageContext.REQUEST_SCOPE);
pageContext.setAttribute("serialNumber",new Integer(index+1));
return super.EVAL_BODY_AGAIN;
}
public int doEndTag()
{
reset();
return super.EVAL_PAGE;
}
}