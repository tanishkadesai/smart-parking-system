package servlets;


import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;
import java.sql.*;
import dao.DBConnection;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Connection con = DBConnection.getConnection();

            // Total slots
            PreparedStatement totalPs = con.prepareStatement("SELECT COUNT(*) FROM parking_slots");
            ResultSet totalRs = totalPs.executeQuery();
            totalRs.next();
            int total = totalRs.getInt(1);

            // Available slots
            PreparedStatement availPs = con.prepareStatement(
                    "SELECT COUNT(*) FROM parking_slots WHERE status='available'"
            );
            ResultSet availRs = availPs.executeQuery();
            availRs.next();
            int available = availRs.getInt(1);

            // Occupied slots
            PreparedStatement occPs = con.prepareStatement(
                    "SELECT COUNT(*) FROM parking_slots WHERE status='occupied'"
            );
            ResultSet occRs = occPs.executeQuery();
            occRs.next();
            int occupied = occRs.getInt(1);

            // Display
            out.println("<div style='display:flex; gap:20px; justify-content:center; margin-top:50px; font-family:sans-serif;'>");

            out.println("<div style='padding:20px; background:#3498db; color:white; border-radius:10px;'>");
            out.println("<h3>Total Slots</h3>");
            out.println("<h2>" + total + "</h2>");
            out.println("</div>");

            out.println("<div style='padding:20px; background:#2ecc71; color:white; border-radius:10px;'>");
            out.println("<h3>Available</h3>");
            out.println("<h2>" + available + "</h2>");
            out.println("</div>");

            out.println("<div style='padding:20px; background:#e74c3c; color:white; border-radius:10px;'>");
            out.println("<h3>Occupied</h3>");
            out.println("<h2>" + occupied + "</h2>");
            out.println("</div>");

            out.println("</div>");

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h2>Error loading dashboard</h2>");
        }
    }
}