<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car Resale Application</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background: url('https://images.unsplash.com/photo-1565043666747-69f6646db940?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D') no-repeat center center fixed;
            background-size: cover;
            color: white;
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
            padding-top: 100px; /* Offset from fixed navbar */
            display: flex;
            justify-content: center;
            align-items: center;
            height: calc(100% - 56px); /* Subtract navbar height */
        }
        .info-card {
            background-color: rgba(255, 255, 255, 0.8); /* Slightly transparent card */
            border-radius: 20px;
            color: black;
            padding: 40px;
            margin-top: -50px; /* To pull the card slightly up */
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            max-width: 500px;
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

<!-- Card Content -->
<div class="card-container">
    <div class="info-card">
        <h1 class="card-title">Welcome to the Car Resale Platform</h1>
        <p class="card-text">Find your perfect car or sell one with ease.</p>
    </div>
</div>

<!-- Bootstrap and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>

</body>
</html>