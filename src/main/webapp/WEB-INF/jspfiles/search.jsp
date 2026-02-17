<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Car Search</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background: url('https://images.unsplash.com/photo-1565043666747-69f6646db940?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D') no-repeat center center fixed;
            background-size: cover;
            color: white;
            margin: 0;
            padding: 0;
            height: 100vh; /* full-height viewport */
        }
        .navbar {
            background-color: #007bff; /* Bootstrap primary blue */
        }
        .navbar .nav-link {
            color: white;
        }
        .navbar .nav-link:hover {
            color: #ccc;
        }
        .card-container {
            padding-top: 60px; /* Offset from fixed navbar */
            display: flex;
            justify-content: center;
            align-items: flex-start;
            height: calc(100vh - 60px); /* Full height minus navbar */
            padding-bottom: 20px; /* Padding at the bottom */
        }
        .info-card {
            background-color: rgba(255, 255, 255, 0.8); /* Slightly transparent card */
            border-radius: 20px;
            color: black;
            padding: 20px;
            margin-top: 60px; /* Offset to avoid overlap with navbar */
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            width: 100%; /* Maximum width */
            max-width: 750px; /* Broader card */
        }
        #available-label {
            margin-left: 5px;
        }
    </style>
</head>
<body>

<!-- Fixed Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="/">Car Resale Platform</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/">Home</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownCars" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Cars
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownCars">
                        <a class="dropdown-item" href="/viewcars">View Cars</a>
                        <a class="dropdown-item" href="/addcar">Add Car</a>
                        <a class="dropdown-item" href="/search">Search Cars</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownAppointments" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Appointments
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownAppointments">
                        <a class="dropdown-item" href="/viewappointments">View Appointments</a>
                        <a class="dropdown-item" href="/addappointment">Schedule Appointment</a>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="card-container">
    <div class="info-card">
        <h5 class="card-title text-center">Search Car</h5>
        <form action="/submitsearch" method="post">
            <div class="form-group">
                <label for="fuelType">Fuel Type:</label>
                <select class="form-control" id="fuelType" name="fuelType">
                    <option value="">Select Fuel Type</option>
                    <c:forEach items="${fuelTypes}" var="fuelType">
                        <option value="${fuelType}">${fuelType}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="capacity">Seating Capacity:</label>
                <select class="form-control" id="capacity" name="capacity">
                    <option value="">Select Seating Capacity</option>
                    <c:forEach items="${seatingCapacity}" var="seat">
                        <option value="${seat}">${seat}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="brand">Brand:</label>
                <select class="form-control" id="brand" name="brand">
                    <option value="">Select Brand</option>
                    <c:forEach var="brand" items="${brands}">
                        <option value="${brand}">${brand}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="budget">Budget: <span id="budgetValue">${minPrice}</span></label>
                <input type="range" class="form-control-range" id="budget" name="budget" min="${minPrice}" max="${maxPrice}" step="1000" oninput="updateBudgetValue(this.value)">
            </div>
            <button type="submit" class="btn btn-primary">Search</button>
        </form>
    </div>
</div>

<!-- Bootstrap and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
<script>
    function updateBudgetValue(value) {
        document.getElementById("budgetValue").textContent = value;
    }
</script>
</body>
</html>