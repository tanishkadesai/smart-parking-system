<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>

<html>
<head>
  <title>Parking Receipt</title>

  ```
  <!-- Main CSS -->
  <link rel="stylesheet" href="style.css">

  <!-- Icons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
  ```

</head>
<body>

<!-- Navbar -->

<div class="navbar">
  <h2><i class="fas fa-receipt"></i> Parking Receipt</h2>
</div>

<!-- Receipt Box -->

<div class="container receipt-box">

  ```
  <h2>Parking Receipt</h2>

  <p><b>🚗 Vehicle No:</b> ${vehicle}</p>
  <p><b>⏱ Entry Time:</b> ${entry}</p>
  <p><b>🚪 Exit Time:</b> ${exit}</p>
  <p><b>🕒 Total Hours:</b> ${hours}</p>

  <h3 class="bill">💰 Bill: ₹${bill}</h3>

  <br>

  <button onclick="window.print()">🖨 Print</button>

  <br><br>

  <a href="index.jsp">
    <button>⬅ Back to Home</button>
  </a>
  ```

</div>

</body>
</html>
