import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main extends HttpServlet {

    static String url = "jdbc:mysql://localhost:3306/test?useTimezone=true&serverTimezone=UTC";
    static String user = "root";
    static String password = "test";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        do_things(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        do_things(request, response);
    }

    private void do_things(HttpServletRequest request, HttpServletResponse response) throws IOException {
        saveToDatabase(request,response);
        addCookies(request,response);
        response.sendRedirect("end.jsp");
    }

    public void saveToDatabase(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("Name");
        String surname = request.getParameter("Surname");
        String patronymic = request.getParameter("Patronymic");
        String insertTableSQL= "INSERT INTO test.table " + "(Name, Surname, Patronymic) " + "VALUES " + "('" + name +"','" + surname + "','" + patronymic + "')";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            statement.executeUpdate(insertTableSQL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private void addCookies(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("Name");
        String surname = request.getParameter("Surname");
        String patronymic = request.getParameter("Patronymic");
        Cookie c_name = new Cookie("Name", name);
        Cookie c_surname = new Cookie("Surname", surname);
        Cookie c_patronymic = new Cookie("Patronymic", patronymic);
        c_name.setMaxAge(60 * 60 * 24);
        c_surname.setMaxAge(60 * 60 * 24);
        c_patronymic.setMaxAge(60 * 60 * 24);
        response.addCookie(c_name);
        response.addCookie(c_surname);
        response.addCookie(c_patronymic);
    }

}
