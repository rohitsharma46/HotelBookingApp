
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" rel="stylesheet" crossorigin="anonymous">

<link href="https://fonts.googleapis.com/css2?family=Faster+One&family=Pacifico&family=Shadows+Into+Light&family=Warnes&display=swap" rel="stylesheet">    
<link rel="stylesheet" type="text/css" href="app.css">
    <title>Sharma Hotel</title>
</head>
<body>
<%
session =request.getSession();
String user = (String)session.getAttribute("user");

if (session!=null && user!=null){
	session.setAttribute("user",user);
	out.println("Hello "+user+", Welcome to your Account");
}
else{
	response.sendRedirect("index.jsp");	
}
%>


<section class="view">
  	<div class="container">
    <div class="row">
    	<div class="col-6 brand">
    	<a href="#"><i class="fab fa-fly"></i>Sharma<span class="fly">Hotels</span></a>
        </div>
    	<div class="col-6 d-flex justify-content-end">


    	<button class=" mr-3" onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Log Out</button>
         <button onclick="document.getElementById('id02').style.display='block'" style="width:auto;">Reset Password</button></div></div></div>
         
    <div id="id01" class="modal">
  
  <form class="modal-content animate" id="frm" action="Logout" method="post">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
      
    </div>

    <div class="container">    
      <button type="submit">Sign Out</button>
    </div>

    <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
    </div>
  </form>
</div>


<div id="id02" class="modal">
  
  <form class="modal-content animate" id="frm2" action="ResetPassword" method="post">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id02').style.display='none'" class="close" title="Close Modal">&times;</span>
      
    </div>

    <div class="container">
     <label for="nPwd" ><b>New Password</b></label>
    <input type="password" id="nPwd" placeholder="Enter Password"  name="nPwd"  required="required">

    <label for="rPwd" ><b>Repeat Password</b> <span id='message'></span></label>
    <input type="password" id="rPwd" placeholder="Repeat Password" onkeyup="check()" name="rPwd" required="required" >
      <button type="submit">Reset Password</button>
    </div>

    <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="document.getElementById('id02').style.display='none'" class="cancelbtn">Cancel</button>
    </div>
  </form>
</div>


<script>
// Get the modal
var modal = document.getElementById('id01');
var modal = document.getElementById('id02');


// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>
<script>

function checkAge(){
var age = document.getElementById('age').value;
	if (age<=17 || age>=100){
		var inp = document.getElementById('age').innerHTML='';
		document.getElementById('ageFactor').style.color = 'red';
		 document.getElementById('ageFactor').innerHTML = 'Age must be between 18-100';
		document.getElementById('signup').disabled = true;
		}
	else{
		document.getElementById('ageFactor').innerHTML='';
		document.getElementById('signup').disabled = false;
		}
}

function check() {
  
  var pwd1=document.getElementById('nPwd').value;
  var pwd2=document.getElementById('rPwd').value;
  if(pwd1 == pwd2){
  document.getElementById('message').style.color = 'green';
    document.getElementById('message').innerHTML = 'Password Matched';
  document.getElementById('signup').disabled = false;
  }
  else{
  document.getElementById('message').style.color = 'red';
    document.getElementById('message').innerHTML = 'Password Mismatch';
  document.getElementById('signup').disabled = true;
  }
  
  
}
</script>

<div class="container">
      <div class="content">
      <h2>One Booking Platform, Limitless Possibilities</h2>
      <!-- <button type="button" class="btn btn-primary btn-lg btn-block">Block level button</button> -->
      <button type="button" class="btn btn-lg button"> Make a Booking</button>
    </div></div>
  </section>



    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</body>
</html>