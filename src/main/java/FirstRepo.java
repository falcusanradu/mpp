//import model.Student;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class FirstRepo {
//
//    private static final String URL = "jdbc:mysql://localhost:3306/mpp_db";
//    private static final String USERNAME = "Admin";
//    private static final String PASSWORD = "1234";
//
//    public void getAllUsers() {
//        try {
//            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//
//            Statement stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM student");
//            List<Student> students = new ArrayList<Student>();
//            while (rs.next()) {
//                Student student = new Student();
//                student.id = rs.getInt(1);
//                student.firstName = rs.getString(2);
//                student.lastName = rs.getString(3);
//                students.add(student);
//            }
//            students.forEach(student -> {
//                System.out.println(student.id + student.firstName + student.lastName);
//            });
//            connection.close();
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
