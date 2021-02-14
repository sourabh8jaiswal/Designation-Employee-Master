<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.hr.beans.ErrorBean' />
<!DOCTYPE HTML>
<html lang='en'>
<head>
<title>HR Application</title>
<link rel='stylesheet' type='text/css' href='/stylethree/css/styles.css'>
</head>
<body>
<!--  Main container starts here  -->
<div class='main-container'>
<!--  Header starts here  -->
<div class='header'>
<img src='/stylethree/images/logo.png' class='logo'>
<div class='brand-name'>Thinking Machines</div>
</div>  <!--  Header ends here  -->
<!-- content-section starts here -->
<div class='content'>
<center><h2><b>Authentication</b></h2></center>
<!-- Login Form section starts here -->
<div class='loginForm'>
<form action='/stylethree/Login.jsp' method='POST'>
<table align='center'>
<tr>
<td colspan='2' align='right'>
<span class='error'>
<jsp:getProperty name='errorBean' property='error' />
</span>
</td>
</tr>
<tr>
<td>Username</td>
<td><input type='text' id='username' name='username' maxlength=15 style='border:1px solid black'><br></td>
</tr>
<tr>
<td>Password</td>
<td><input type='password' id='password' name='password' maxlength=15 style='border:1px solid black'><br></td>
</tr>
<tr>
<td colspan='2' align='center'>
<br><button type='submit'>Login</button>
<td>
</tr>
</table>
</form>
</div>
<!-- Form section ends Here -->
</div>
<!-- content-section ends here -->
<!-- footer starts here -->
<div class='footer'>
&copy; Thinking Machines 2020
</div>
<!-- footer ends here -->
</div>  <!--  Main container ends here  -->
</body>
</html>