<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Module name='EMPLOYEE' />
<jsp:useBean id='employeeBean' scope='request' class='com.thinking.machines.hr.beans.EmployeeBean' />
<jsp:include page='/MasterPageTopSection.jsp' />
<script src='/styletwo/js/EmployeeDeleteConfirmation.js'></script>
<h2>Employee (Delete Module)</h2>
<form method='post' action='/styletwo/DeleteEmployee.jsp'>
<tm:FormID />
<input type='hidden' id='employeeId' name='employeeId' value='${employeeBean.employeeId}'>
<table>
<tr>
<td>Name</td>
<td><b>${employeeBean.name}</b></td>
</tr>
<tr>
<td>Designation</td>
<td><b>${employeeBean.designation}</b></td>
</tr>
<tr>
<td>Date of birth</td>
<td><b>${employeeBean.dateOfBirth}</b></td>
</tr>
<tr>
<td>Gender</td>
<td>
<tm:If condition='${employeeBean.gender=="M"}'>
<b>Male</b>
</tm:If>
<tm:If condition='${employeeBean.gender=="F"}'>
<b>Female</b>
</tm:If>
</td>
</tr> 
<tr>
<td>Indian</td>
<td>
<tm:If condition='${employeeBean.isIndian==true}'>
<b>Yes</b>
</tm:If>
<tm:If condition='${employeeBean.isIndian==false}'>
<b>No</b>
</tm:If>
</td>
</tr>
<tr>
<td>Basic salary</td>
<td><b>${employeeBean.basicSalary}</b></td>
</tr>
<tr>
<td>PAN Number</td>
<td><b>${employeeBean.panNumber}</b></td>
</tr>
<tr>
<td>Aadhar card number</td>
<td><b>${employeeBean.aadharCardNumber}</b></td>
</tr>
<tr>
<td colspan='2'><br><b>Are you sure, You want to delete this employee ? </b><br><br></td>
</tr>
<tr>
<td colspan='2'><button type='submit'>Delete</button>
&nbsp;&nbsp;<button type='button' onclick='cancelDeletion()'>Cancel</button></td>
</tr>
</table>
</form>
<form id='cancelDeletionForm' action='/styletwo/Employees.jsp'>
</form>
<jsp:include page='/MasterPageBottomSection.jsp' />