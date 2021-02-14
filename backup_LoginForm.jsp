<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.hr.beans.ErrorBean' />
<!DOCTYPE HTML>
<html lang='en'>
<head>
<title>HR Application</title>
<link rel='stylesheet' type='text/css' href='/styletwo/css/styles.css'>
</head>
<body>
<!--  Main container starts here  -->
<div class='main-container'>
<!--  Header starts here  -->
<div style='margin:5px;width:90hw;height:auto;background-color:#D6EAF8;border:1px solid black'>
<img src='/styletwo/images/logo.png' style='float:left;padding:5px'>
<div style='margin-top:9px;margin-bottom:9px;font-size:20pt'>Thinking Machines</div>
</div>  <!--  Header ends here  -->
<!-- content-section starts here -->
<div style='width:90hw;height:70vh;margin:5px;border:1px solid white'>
<center><h2><b>Authentication</b></h2></center>
<!-- Form section starts here -->
<div style='width:30hw;height:30vh;margin-left:350px;margin-right:350px;align:center;padding:20px;padding-top:80px;background-color:#D6EAF8;border:1px solid black'>
<form action='/styletwo/Login.jsp' method='POST'>
<center>

<table>
<tr>
<td colspan='2' align='right'>
<span style='color:red'>
<jsp:getProperty name='errorBean' property='error' />
</span>
</td>
</tr>
<tr>
<td>Username</td>
<td><input type='text' id='username' name='username' maxlength=15><br></td>
</tr>
<tr>
<td>Password</td>
<td><input type='password' id='password' name='password' maxlength=15><br></td>
</tr>
</table>
<br>
<button type='submit'>Login</button>
</center>
</form>
</div>
<!-- Form section ends Here -->
</div>
<!-- content-section ends here -->
<!-- footer starts here -->
<div style='widht:90hw;height:auto;margin:5px;text-align:center;border:1px solid white'>
&copy; Thinking Machines 2020
</div>
<!-- footer ends here -->
</div>  <!--  Main container ends here  -->
</body>
</html>