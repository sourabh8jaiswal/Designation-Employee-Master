<%@ taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Module name='EMPLOYEE' />
<jsp:useBean id='employeeBean' scope='request' class='com.thinking.machines.hr.beans.EmployeeBean' />
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.hr.beans.ErrorBean' />
<jsp:useBean id='employeeErrorBean' scope='request' class='com.thinking.machines.hr.beans.EmployeeErrorBean' />
<jsp:include page='/MasterPageTopSection.jsp' />
<script src='/styletwo/js/EmployeeAddForm.js'></script>
<h2>Employee (Add Module)</h2>
<form method='post' action='/styletwo/AddEmployee.jsp' onsubmit='return validateForm(this)'>
<tm:FormID />
<table>
<tr>
<td>Name</td>
<td><input type='text' id='name' name='name' maxlength='50' size='51' value='${employeeBean.name}'>
<span id='nameErrorSection' style='color:red'>${employeeErrorBean.nameError}</span>
</td>
</tr>
<tr>
<td>Designation</td>
<td>
<select id='designationCode' name='designationCode'>
<option value='-1'>&lt;Select Designation&gt;</option>
<tm:EntityList populatorClass='com.thinking.machines.hr.bl.DesignationBL' populatorMethod='getAll' name='designationBean'>
<tm:If condition='${designationBean.code==employeeBean.designationCode}'>
<option selected value='${designationBean.code}'>${designationBean.title}</option>
</tm:If>
<tm:If condition='${designationBean.code!=employeeBean.designationCode}'>
<option value='${designationBean.code}'>${designationBean.title}</option>
</tm:If>
</tm:EntityList>
</select>
<span id='designationCodeErrorSection' style='color:red'>${employeeErrorBean.designationCodeError}</span>
</td>
</tr>
<tr>
<td>Date of birth</td>
<td><input type='date' id='dateOfBirth' name='dateOfBirth' value='${employeeBean.dateOfBirth}'>
<span id='dateOfBirthErrorSection' style='color:red'>${employeeErrorBean.dateOfBirthError}</span>
</td>
</tr>
<tr>
<td>Gender</td>
<td>
<tm:If condition='${employeeBean.gender=="M"}'>
<input checked type='radio' id='male' name='gender' value='M'>Male
&nbsp;&nbsp;&nbsp;&nbsp;
<input type='radio' id='female' name='gender' value='F'>Female
</tm:If>
<tm:If condition='${employeeBean.gender=="F"}'>
<input type='radio' id='male' name='gender' value='M'>Male
&nbsp;&nbsp;&nbsp;&nbsp;
<input checked type='radio' id='female' name='gender' value='F'>Female
</tm:If>
<tm:If condition='${employeeBean.gender==""}'>
<input type='radio' id='male' name='gender' value='M'>Male
&nbsp;&nbsp;&nbsp;&nbsp;
<input type='radio' id='female' name='gender' value='F'>Female
</tm:If>
<span id='genderErrorSection' style='color:red'>${employeeErrorBean.genderError}</span>
</td>
</tr> 
<tr>
<td>Indian</td>
<td>
<tm:If condition='${employeeBean.isIndian==true}'>
<input checked type='checkbox' id='isIndian' name='isIndian' value='true'>
</tm:If>
<tm:If condition='${employeeBean.isIndian==false}'>
<input type='checkbox' id='isIndian' name='isIndian' value='true'>
</tm:If>
</td>
</tr>
<tr>
<td>Basic salary</td>
<td><input type='text' style='text-align:right' id='basicSalary' name='basicSalary' value='${employeeBean.basicSalary}'>
<span id='basicSalaryErrorSection' style='color:red'>${employeeErrorBean.basicSalaryError}</span>
</td>
</tr>
<tr>
<td>PAN Number</td>
<td>
<input type='text' id='panNumber' name='panNumber' maxlength='15' size='16' value='${employeeBean.getPANNumber()}'>
<span id='panNumberErrorSection' style='color:red'>${employeeErrorBean.panNumberError}</span>
</td>
</tr>
<tr>
<td>Aadhar card number</td>
<td>
<input type='text' id='aadharCardNumber' name='aadharCardNumber' maxlength='15' size='16' value='${employeeBean.aadharCardNumber}'>
<span id='aadharCardNumberErrorSection' style='color:red'>${employeeErrorBean.aadharCardNumberError}</span>
</td>
</tr>
<tr>
<td colspan='2'><button type='submit'>Add</button>
&nbsp;&nbsp;<button type='button' onclick='cancelAddition()'>Cancel</button></td>
</tr>
</table>
</form>
<form id='cancelAdditionForm' action='/styletwo/Employees.jsp'>
</form>
<jsp:include page='/MasterPageBottomSection.jsp' />