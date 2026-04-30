<%@ page import="java.sql.*" %>
<%@ page import="dao.DBConnection" %>

<!DOCTYPE html>
<html>
<head>
    <title>Parking Slots</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>

<div class="navbar">
    <h2>Parking Slots</h2>
</div>

<--  MESSAGE BOX (correct place) -->
<%
    String msg = (String) request.getAttribute("message");
    if(msg != null){
%>
<div style="text-align:center; margin:20px;">
    <div style="display:inline-block; padding:10px 20px; border-radius:10px; background:rgba(0,0,0,0.7); color:white;">
        <%= msg %>
    </div>
</div>
<%
    }
%>

<div class="slot-container">

    <%
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM parking_slots");

            while(rs.next()) {
                String status = rs.getString("status");
                String vehicle = rs.getString("vehicle_no");
                String slot = rs.getString("slot_id");

                String color = status.equals("occupied") ? "occupied" : "available";
    %>

    <div class="slot <%=color%>">
        <i class="fas fa-car"></i>
        <h3><%=slot%></h3>
        <p><%= (vehicle == null ? "Empty" : vehicle) %></p>
    </div>

    <%
            }
        } catch(Exception e) {
            out.println("<h3 style='color:red;text-align:center;'>Error loading slots</h3>");
        }
    %>

</div>

</body>
</html>
