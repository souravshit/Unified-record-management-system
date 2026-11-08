package in.strikes.repository;


import in.strikes.model.Student;

import java.sql.*;

public class StudentsRepository {
    String url = "jdbc:mysql://localhost:3306/students_db ";
    String username = "root";
    String password = "root";

    public void createUser(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            String sql = "INSERT INTO Students(name, email, age)" +
                    "VALUES('Rahul', 'rahul@gmail.com', 29)";

            int result = statement.executeUpdate(sql);

            if(result == 1){
                System.out.println("Creation operation successfull");
            }else{
                System.out.println("Creation operation failed");
            }

            connection.close();
        }
        catch(SQLException e){
            System.out.println("Database connection failed");
            e.printStackTrace();

        }

    }

    public void updateUser(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            String sql = "UPDATE Students set age = 20 WHERE id = 1";

            int result = statement.executeUpdate(sql);

            if(result == 1){
                System.out.println("Update operation successfull");
            }else{
                System.out.println("Updation failed");
            }

            connection.close();
        }
        catch(SQLException e){
            System.out.println("Database connection failed");
            e.printStackTrace();

        }

    }

    public void deleteUser(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            String sql = "DELETE FROM Students WHERE id =1";

            int result = statement.executeUpdate(sql);

            if(result == 1){
                System.out.println("Deletion successfull");
            }else{
                System.out.println("Deletion failed");
            }

            connection.close();
        }
        catch(SQLException e){
            System.out.println("Database connection failed");
            e.printStackTrace();

        }
    }

    public void getUserById(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String sql = "SELECT id, name, email, age FROM Students WHERE id = 3";

           ResultSet resultSet =  statement.executeQuery(sql);

           resultSet.next();
           Student student = mapRow(resultSet);
            System.out.println(student);

            connection.close();

        }
        catch(SQLException e){
            System.out.println("Database connection failed");
            e.printStackTrace();

        }
    }

    public void completeCRUD(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String sql = "";



            connection.close();

        }
        catch(SQLException e){
            System.out.println("Database connection failed");
            e.printStackTrace();

        }
    }






    private Student mapRow(ResultSet resultSet) throws SQLException {
        Student student = new Student();

        student.setId(resultSet.getLong("id"));
        student.setName(resultSet.getString("name"));
        student.setEmail(resultSet.getString("email"));
        student.setAge(resultSet.getInt("age"));
        return student;
    }


}
