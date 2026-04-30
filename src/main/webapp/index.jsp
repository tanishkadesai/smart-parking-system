<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>

<html>
<head>
    <title>Smart Parking System</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>

<div class="navbar">
    <h2><i class="fas fa-car"></i> Smart Parking</h2>
</div>

<div class="dashboard">

    <div class="card blue">
        <i class="fas fa-car"></i>
        <h3>Total Slots</h3>
        <p>--</p>
    </div>

    <div class="card green">
        <i class="fas fa-check-circle"></i>
        <h3>Available</h3>
        <p>--</p>
    </div>

    <div class="card red">
        <i class="fas fa-times-circle"></i>
        <h3>Occupied</h3>
        <p>--</p>
    </div>

</div>
<div class="container">

    ```
    <h2>Manage Parking</h2>

    <form action="book" method="post">
        <input type="text" name="vehicle_no" placeholder="Vehicle Number" required>
        <input type="submit" value="Park Vehicle">
    </form>

    <form action="exit" method="post">
        <input type="text" name="vehicle_no" placeholder="Vehicle Number" required>
        <input type="submit" value="Exit Vehicle">
    </form>

    <form action="search" method="post">
        <input type="text" name="vehicle_no" placeholder="Vehicle Number" required>
        <input type="submit" value="Search Vehicle">
    </form>


    <a href="viewSlots.jsp"><button>View Slots</button></a>
    <a href="dashboard"><button>Dashboard</button></a>
    ```

</div>

</body>
</html>