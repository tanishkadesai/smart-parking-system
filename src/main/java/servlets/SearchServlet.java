package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;
import java.sql.*;
import dao.DBConnection;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String vehicleNo = request.getParameter("vehicle_no");

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM parking_slots WHERE vehicle_no=?"
            );
            ps.setString(1, vehicleNo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                // ✅ SEND ALL DETAILS
                request.setAttribute("found", true);
                request.setAttribute("vehicle", vehicleNo);   // ⭐ ADD THIS
                request.setAttribute("slot", rs.getString("slot_id"));
                request.setAttribute("status", rs.getString("status"));
                request.setAttribute("entry", rs.getTimestamp("entry_time"));

            } else {

                // ❌ NOT FOUND
                request.setAttribute("found", false);  // ⭐ ADD THIS
                request.setAttribute("message", "❌ Vehicle not found");
            }

            // ✅ ALWAYS GO TO SAME PAGE
            request.getRequestDispatcher("/viewSlots.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();

            request.setAttribute("found", false);
            request.setAttribute("message", "⚠ Error occurred");
            request.getRequestDispatcher("/viewSlots.jsp").forward(request, response);
        }
    }
}