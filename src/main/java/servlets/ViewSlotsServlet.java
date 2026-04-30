package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;

@WebServlet("/viewSlots")
public class ViewSlotsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {



        request.getRequestDispatcher("/viewSlots.jsp").forward(request, response);
    }
}