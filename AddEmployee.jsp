<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Backdoor>
<jsp:forward page='/LoginForm.jsp' />
</tm:Backdoor>
<tm:FormResubmitted>
<tm:Module name="HOME" />
<jsp:forward page='/notifyFormResubmission' />
</tm:FormResubmitted>
<tm:Module name='EMPLOYEE' />
<jsp:useBean id='employeeBean' scope='request' class='com.thinking.machines.hr.beans.EmployeeBean' />
<jsp:setProperty name='employeeBean' property='*' />
<jsp:forward page='/addEmployee' />