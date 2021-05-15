package ca.amir.dbtest;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

// http://localhost:8080/Spring_MVC_Hibernate_war/TestServlet
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Define a Connection Pool
    @Resource(name = "jdbc/passenger_tracker")
    private DataSource dataSource;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        // 1- Setup connection variables
        String user = "amir	";
        String pass = "Ab#77886951";

        String jdbcUrl = "jdbc:mysql://localhost:3306/passenger_tracker?useSSL=false&serverTimezone=UTC";
        String driver = "com.mysql.cj.jdbc.Driver";

        // 2- Get connection to database
        try {
            PrintWriter out = response.getWriter();
            out.println("Connecting to database: " + jdbcUrl);
            Class.forName(driver);
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
            out.println("SUCCESS!!!");
            myConn.close();
        } catch (Exception exc) {
            exc.printStackTrace();
            throw new ServletException(exc);
        }
    }
}