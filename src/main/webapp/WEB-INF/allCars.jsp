<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cars</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/navbar-static/">
<!-- Bootstrap core CSS -->
<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>
	
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
    </style>

    
    <!-- Custom styles for this template -->
    <link href="navbar-top.css" rel="stylesheet">
  </head>
  <body>
    
		<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
		  <div class="container-fluid">
		    <a class="navbar-brand" href="homepage"> <h4>Car Rental CRM System </h4>  </a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarCollapse">
		      <ul class="navbar-nav me-auto mb-2 mb-md-0">
		        <li class="nav-item">
		          <a class="nav-link active" aria-current="homepage" href="homepage">Home</a>
		        </li>
		        <li class="nav-item">
		          <a href="checkAvailability" class="nav-link" > Find Availability</a>
		        </li>
		      </ul>
			     <form class="d-flex"> 
			       <a href="logout"  class="btn btn-outline-success">Logout</a>
			     </form>
		    </div>
		  </div>
		</nav>
</head>
<body>
	<h1>All Cars</h1>
	<br>
	<table class="table table-hover">
		<thead>
			<tr>
				<th scope="col">CAR ID</th>
				<th scope="col">MODEL</th>
				<th scope="col">DAY RATE</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cars}" var="car">
				<tr>
					<td scope="row">${car.id}</td>
					<td scope="row">${car.model}</td>
					<td scope="row">${car.day_rate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>