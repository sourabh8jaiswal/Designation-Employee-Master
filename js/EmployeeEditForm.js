function validateForm(frm)
{
var firstInvalidComponent=null;
var valid=true;
var name=frm.name.value.trim();
var nameErrorSection=document.getElementById('nameErrorSection');
nameErrorSection.innerHTML='';
if(name.length==0)
{
nameErrorSection.innerHTML='Name required';
valid=false;
firstInvalidComponent=frm.name;
}

var designationCode=frm.designationCode.value;
var designationCodeErrorSection=document.getElementById('designationCodeErrorSection');
designationCodeErrorSection.innerHTML='';
if(designationCode==-1)
{
designationCodeErrorSection.innerHTML='Select designation';
valid=false;
if(firstInvalidComponent==null) firstInvalidComponent=frm.designationCode;
}

var dateOfBirth=frm.dateOfBirth.value;
var dateOfBirthErrorSection=document.getElementById('dateOfBirthErrorSection');
dateOfBirthErrorSection.innerHTML='';
if(dateOfBirth.length==0)
{
dateOfBirthErrorSection.innerHTML='Select date of birth';
valid=false;
if(firstInvalidComponent==null) firstInvalidComponent=frm.dateOfBirth;
}

var genderErrorSection=document.getElementById('genderErrorSection');
genderErrorSection.innerHTML='';
if(frm.gender[0].checked==false && frm.gender[1].checked==false)
{
genderErrorSection.innerHTML='Select gender';
valid=false;
}

var basicSalary=frm.basicSalary.value.trim()
var basicSalaryErrorSection=document.getElementById('basicSalaryErrorSection');
basicSalaryErrorSection.innerHTML='';
if(basicSalary.length==0)
{
basicSalaryErrorSection.innerHTML='Basic salary required';
valid=false;
if(firstInvalidComponent==null) firstInvalidComponent=frm.basicSalary;
}
else
{
var v='0123456789.';
var e=0;
var isBasicSalaryValid=true;
while(e<basicSalary.length)
{
if(v.indexOf(basicSalary.charAt(e))==-1)
{
basicSalaryErrorSection.innerHTML='Invalid basic salary';
valid=false;
if(firstInvalidComponent==null) firstInvalidComponent=frm.basicSalary;
isBasicSalaryValid=false;
break;
}
e++;
}
if(isBasicSalaryValid)
{
var dot=basicSalary.indexOf('.');
if(dot!=-1)
{
var numberOfFractions=basicSalary.length-(dot+1);
if(numberOfFractions>2)
{
basicSalaryErrorSection.innerHTML='Invalid basic salary';
valid=false;
if(firstInvalidComponent==null) firstInvalidComponent=frm.basicSalary;
}
}
}
}

var panNumber=frm.panNumber.value.trim();
var panNumberErrorSection=document.getElementById('panNumberErrorSection');
panNumberErrorSection.innerHTML='';
if(panNumber.length==0)
{
panNumberErrorSection.innerHTML='PAN number required';
valid=false;
if(firstInvalidComponent==null) firstInvalidComponent=frm.panNumber;
}

var aadharCardNumber=frm.aadharCardNumber.value.trim();
var aadharCardNumberErrorSection=document.getElementById('aadharCardNumberErrorSection');
aadharCardNumberErrorSection.innerHTML='';
if(aadharCardNumber.length==0)
{
aadharCardNumberErrorSection.innerHTML='Aadhar card number required';
valid=false;
if(firstInvalidComponent==null) firstInvalidComponent=frm.aadharCardNumber;
}

if(!valid) firstInvalidComponent.focus();

return valid;
}
function cancelEdition()
{
document.getElementById('cancelEditionForm').submit();
}