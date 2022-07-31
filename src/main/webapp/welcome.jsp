<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
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
		          <a class="nav-link active" aria-current="homepage" href="#">Home</a>
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
	
	<%-- <h2 style={foont:arial} >Welcome ${manager.username}</h2> --%>
	
	<div class="card text-center">
	  <div class="card-header">
		  </div>
			  <div class="card-body">
			    <h3 >Welcome ${manager.username}</h3>
			  </div>
		  <div class="card-footer text-muted">
	  </div>
	</div>
	
	<br>
	
		<div>
		 <div class="row">
			  <div class="col-sm-4">
			    <div class="card">
			      <div class="card-body">
			        <h5 class="card-title">Show Cars</h5>
			        <a href="showCars"  class="btn btn-primary">Show  </a>
			      </div>
			    </div>
			  </div>
			  <div class="col-sm-4">
			    <div class="card">
			      <div class="card-body">
			        <h5 class="card-title">Show Customers</h5>
			        <a href="showCustomers" class="btn btn-primary" >Show </a>
			      </div>
			    </div>
			  </div>
			  <div class="col-sm-4">
			    <div class="card">
			      <div class="card-body">
			        <h5 class="card-title">Show Reservations</h5>
			        <a href="showRes" class="btn btn-primary">Show </a>
			      </div>
			    </div>
			  </div>
		</div>
		<br>
		 <div class="row">
			  <div class="col-sm-4">
			    <div class="card">
			      <div class="card-body">
			        <h5 class="card-title">Add Car</h5>
			        <a href="addCar" class="btn btn-primary">Add</a>
			      </div>
			    </div>
			  </div>
			  <div class="col-sm-4">
			    <div class="card">
			      <div class="card-body">
			        <h5 class="card-title">Add Customer</h5>
			        <a href="addCustomer" class="btn btn-primary">Add</a>
			      </div>
			    </div>
			  </div>
			  <div class="col-sm-4">
			    <div class="card">
			      <div class="card-body">
			        <h5 class="card-title">Add Reservation</h5>
			        <a href="addRes" class="btn btn-primary">Add</a>
			      </div>
			    </div>
			  </div>
		</div>
	<br>
	
<!-- 	<nav class="navbar navbar-light bg-light">
	  <div class="container-fluid">
	    <a style={position:center} class="navbar-brand" href="#">Default</a>
	  </div>
	</nav>
	
	<br>
	
	<div class="card text-center">
	  <div class="card-header">
		  </div>
			  <div class="card-body">
			    <h5 class="card-title">Logout</h5>
			    <a href="logout"  class="btn btn-outline-success">Logout</a>
			  </div>
		  <div class="card-footer text-muted">
	  </div>
	</div>
		 -->
		 
	<!-- 	</div>
		<div>
			<a href="addCar">Add Car</a>
		</div>
			
		<div>
			<a href="addCustomer">Add Customer</a>
		</div>
		<div>
			<a href="showCustomers">Show Customers</a>
		</div>
		
		<div>
			<a href="addRes">Add Reservation</a>
		</div>
		<div>
			<a href="showRes">Show Reservations</a>
		</div>
		
		<div>
			<a href="checkAvailability">Find Available Cars</a>
		</div>
			<div>
			<a href="logout">Logout</a>
		</div> -->
	</body>
</html>