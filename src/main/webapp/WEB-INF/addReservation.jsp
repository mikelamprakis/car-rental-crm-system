<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Reservation</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
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
		          <a class="nav-link active"  href="homepage">Home</a>
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
	
	<sf:form action="insertRes" method="post" modelAttribute="reservation">
	<div class="card">
       <div class="card-body">
       <h1>  Add Reservation</h1>
       <br>
				<div>${message}</div>
				<div>${message2}</div>
				<br>
				<div class="form-group">
					<sf:label  class="form-label"  path="customer" > <h4>  Customer </h4></sf:label>
					<sf:select path="customer" class="form-select" items="${allCustomers}" itemLabel="name" required="required" label="--Please Select"/>
				</div>
				<br>
				<div class="form-group">
					<sf:label class="form-label"  path="car" > <h4>  Car  </h4> </sf:label>
					<sf:select path="car" class="form-select" items="${allCars}" itemLabel="model" required="required" label="--Please Select"/>
				</div>
				<br>
				<div class="form-group">
					<sf:label  class="form-label" path="dateFrom"> <h4> From </h4> </sf:label>
					<sf:input  class="form-control" type="text"   path="dateFrom" required="required"/>
				</div>
				<br>
				<div class="form-group">
					<sf:label  class="form-label" path="dateTo"> <h4>To </h4></sf:label>
					<sf:input   type="text" class="form-control" path="dateTo" required="required"/>
				</div >
				<br>
				<div class="form-group" style={{ padding-top: 20% }}>
				<button type="submit" class="btn btn-primary btn-lg">Add</button>
				</div>	
		</div>
			   
	</div>
				
				
		
	</sf:form> 
</body>
</html>