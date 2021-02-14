package com.thinking.machines.hr.beans;
public class EmployeeErrorBean implements java.io.Serializable
{
private String nameError;
private String designationCodeError;
private String dateOfBirthError;
private String genderError;
private String isIndianError;
private String basicSalaryError;
private String panNumberError;
private String aadharCardNumberError;
public EmployeeErrorBean()
{
this.nameError="";
this.designationCodeError="";
this.dateOfBirthError="";
this.genderError="";
this.isIndianError="";
this.basicSalaryError="";
this.panNumberError="";
this.aadharCardNumberError="";
}
public void setNameError(java.lang.String nameError)
{
this.nameError=nameError;
}
public java.lang.String getNameError()
{
return this.nameError;
}
public void setDesignationCodeError(java.lang.String designationCodeError)
{
this.designationCodeError=designationCodeError;
}
public java.lang.String getDesignationCodeError()
{
return this.designationCodeError;
}
public void setDateOfBirthError(java.lang.String dateOfBirthError)
{
this.dateOfBirthError=dateOfBirthError;
}
public java.lang.String getDateOfBirthError()
{
return this.dateOfBirthError;
}
public void setGenderError(java.lang.String genderError)
{
this.genderError=genderError;
}
public java.lang.String getGenderError()
{
return this.genderError;
}
public void setIsIndianError(java.lang.String isIndianError)
{
this.isIndianError=isIndianError;
}
public java.lang.String getIsIndianError()
{
return this.isIndianError;
}
public void setBasicSalaryError(java.lang.String basicSalaryError)
{
this.basicSalaryError=basicSalaryError;
}
public java.lang.String getBasicSalaryError()
{
return this.basicSalaryError;
}
public void setPanNumberError(java.lang.String panNumberError)
{
this.panNumberError=panNumberError;
}
public java.lang.String getPanNumberError()
{
return this.panNumberError;
}
public void setAadharCardNumberError(java.lang.String aadharCardNumberError)
{
this.aadharCardNumberError=aadharCardNumberError;
}
public java.lang.String getAadharCardNumberError()
{
return this.aadharCardNumberError;
}
}