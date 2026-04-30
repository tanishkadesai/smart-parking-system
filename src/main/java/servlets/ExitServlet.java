package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;
import java.sql.*;
import dao.DBConnection;

@WebServlet("/exit")
public class ExitServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String vehicleNo = request.getParameter("vehicle_no");

        try {
            Connection con = DBConnection.getConnection();

            // 🔍 Find parked vehicle
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM parking_slots WHERE vehicle_no=? AND status='occupied'"
            );
            ps.setString(1, vehicleNo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Timestamp entryTime = rs.getTimestamp("entry_time");
                Timestamp exitTime = new Timestamp(System.currentTimeMillis());

                long diff = exitTime.getTime() - entryTime.getTime();
                long hours = (long) Math.ceil(diff / (1000.0 * 60 * 60));

                //  Billing logic
                int bill;
                if (hours <= 1) {
                    bill = 20;
                } else {
                    bill = 20 + (int)(hours - 1) * 10;
                }

                //  Free the slot
                PreparedStatement update = con.prepareStatement(
                        "UPDATE parking_slots SET status='available', vehicle_no=NULL, entry_time=NULL WHERE slot_id=?"
                );
                update.setInt(1, rs.getInt("slot_id"));
                update.executeUpdate();

                //  Send data to receipt.jsp
                request.setAttribute("vehicle", vehicleNo);
                request.setAttribute("entry", entryTime);
                request.setAttribute("exit", exitTime);
                request.setAttribute("hours", hours);
                request.setAttribute("bill", bill);

                request.getRequestDispatcher("receipt.jsp").forward(request, response);

            } else {
                //  Vehicle not found
                request.setAttribute("message", "❌ Vehicle not found");
                request.getRequestDispatcher("viewSlots.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();

            // ⚠ Error case
            request.setAttribute("message", "⚠ Error occurred");
            request.getRequestDispatcher("viewSlots.jsp").forward(request, response);
        }
    }
}