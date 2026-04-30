package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;
import java.sql.*;
import dao.DBConnection;

@WebServlet("/book")
public class ParkingServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String vehicleNo = request.getParameter("vehicle_no");

        try {
            Connection con = DBConnection.getConnection();

            // 🔴 Check if already parked
            PreparedStatement check = con.prepareStatement(
                    "SELECT * FROM parking_slots WHERE vehicle_no=? AND status='occupied'"
            );
            check.setString(1, vehicleNo);

            ResultSet checkRs = check.executeQuery();

            if (checkRs.next()) {
                request.setAttribute("message", "⚠ Vehicle already parked!");
                request.getRequestDispatcher("/viewSlots.jsp").forward(request, response);
                return;
            }

            // 🟢 Find available slot
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM parking_slots WHERE status='available' LIMIT 1"
            );

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int slotId = rs.getInt("slot_id");

                PreparedStatement update = con.prepareStatement(
                        "UPDATE parking_slots SET status='occupied', vehicle_no=?, entry_time=NOW() WHERE slot_id=?"
                );
                update.setString(1, vehicleNo);
                update.setInt(2, slotId);
                update.executeUpdate();

                request.setAttribute("message", "✅ Slot Assigned: " + slotId);
                request.getRequestDispatcher("/viewSlots.jsp").forward(request, response);

            } else {
                request.setAttribute("message", "❌ No slots available");
                request.getRequestDispatcher("/viewSlots.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();

            request.setAttribute("message", "⚠ Error occurred");
            request.getRequestDispatcher("/viewSlots.jsp").forward(request, response);
        }
    }
}
