<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
 
    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sign-in/">  
    <!-- Bootstrap core CSS -->
<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
       }

       @media (min-width: 768px) {
         .bd-placeholder-img-lg {
           font-size: 3.5rem;
         }
       }
      
		html,
		body {
		  height: 100%;
		}
		
		body {
		  display: flex;
		  align-items: center;
		  padding-top: 40px;
		  padding-bottom: 40px;
		  background-color: #f5f5f5;
		}
		
		.form-signin {
		  width: 100%;
		  max-width: 330px;
		  padding: 15px;
		  margin: auto;
		}
		
		.form-signin .checkbox {
		  font-weight: 400;
		}
		
		.form-signin .form-floating:focus-within {
		  z-index: 2;
		}
		
		.form-signin input[type="email"] {
		  margin-bottom: -1px;
		  border-bottom-right-radius: 0;
		  border-bottom-left-radius: 0;
		}
		
		.form-signin input[type="password"] {
		  margin-bottom: 10px;
		  border-top-left-radius: 0;
		  border-top-right-radius: 0;
		}
</style>

</head>
<body class="text-center">
    






	<main class="form-signin">
	<h2> CRM System  </h2>
	<br>
	<sf:form action="LoginSubmit" method="post" modelAttribute="manager">
	<div>${message}</div>
	 <h3 class="h3 mb-3 fw-normal">Please sign in</h3>
		<div class="form-floating">
			<sf:input  class="form-control" for="floatingInput"  type="text" path="username" required="required" placeholder="username"/>
			<sf:label  for="floatingInput" path="username">Username</sf:label>
			
		</div>
		<div class="form-floating">
			<sf:input class="form-control" id="floatingPassword"  type="password" path="password" required="required" placeholder="Password"/>
			<sf:label for="floatingPassword" path="password">Password</sf:label>
		</div >
		<button class="w-100 btn btn-lg btn-primary" type="submit">Login</button>
		<input type="hidden" value="${id}" name="id" method="post">
	</sf:form>
	</main>
	
</body>
</html>