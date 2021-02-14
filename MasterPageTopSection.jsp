<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Backdoor>
<jsp:forward page='/LoginForm.jsp' />
</tm:Backdoor>
<!DOCTYPE HTML>
<html lang='en'>
<head>
<title>HR Application</title>
<link rel='stylesheet' type='text/css' href='/stylethree/css/styles.css'>
</head>
<body>
<!-- Main Container starts here -->
<div class='main-container'>
<!-- Header starts here -->
<div class='header'>
<img src='/stylethree/images/logo.png' class='logo'>
<div class='brand-name'>Thinking Machines</div>
<div class='profile'>
<img src='/stylethree/images/user.png'>&nbsp;
${username} &nbsp;&nbsp;&nbsp;&nbsp;
<a href='/stylethree/logout'>Logout</a>
</div>
</div><!-- Header ends here -->
<!-- Content Section starts here -->
<div class='content'>
<!-- Left Panel starts here  -->
<div class='content-left-panel'>

<tm:If condition='${module==DESIGNATION}'>
<b>Designations</b><br>
</tm:If>
<tm:If condition='${module!=DESIGNATION}'>
<a href='/stylethree/Designations.jsp'>Designations</a><br>
</tm:If>

<tm:If condition='${module==EMPLOYEE}'>
<b>Employees</b><br>
</tm:If>
<tm:If condition='${module!=EMPLOYEE}'>
<a href='/stylethree/Employees.jsp'>Employees</a><br>
</tm:If>

<tm:If condition='${module!=HOME}'>
<br>
<a href='/stylethree/index.jsp'>Home</a><br>
</tm:If>

</div>
<!-- Left Panel ends here  -->
<!-- Right Panel starts here -->
<div class='content-right-panel'>