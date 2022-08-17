package uz.pdp.service;

import org.springframework.stereotype.Service;
import uz.pdp.model.Todo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService implements Base<Todo> {

    @Override
    public boolean add(Todo todo) {
        int status=0;

        try {
            Connection connection = getConnection();
            String sql="insert into todo(todo,time,date,completed) values (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, todo.getTodo());
            preparedStatement.setString(2, todo.getTime());
            preparedStatement.setString(3, todo.getDate());
            preparedStatement.setBoolean(4, todo.isCompleted());
            status = preparedStatement.executeUpdate();

        } catch (SQLException  e) {
            e.printStackTrace();
        }
        return status>0;
    }

    @Override
    public List<Todo> getALL(int page, int size) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        int status=0;

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = getConnection();
            String sql="delete from todo where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            status = preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return status>0;
    }

    @Override
    public boolean update(Todo todo) {
        int status=0;

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("" +
                    "update todo set todo=?," +
                    "time=?," +
                    "date=?," +
                    "completed=? where id=?");
            preparedStatement.setString(1, todo.getTodo());
            preparedStatement.setString(2, todo.getTime());
            preparedStatement.setString(3,todo.getDate());
            preparedStatement.setBoolean(4, todo.isCompleted());
            preparedStatement.setLong(5, todo.getId());
            status = preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return status>0;
    }

    @Override
    public boolean completed(Long id) {
        int status=0;

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("" +
                    "update todo set completed=? where id=?");
            preparedStatement.setBoolean(1, true);
            preparedStatement.setLong(2, id);
            status = preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return status>0;
    }



    @Override
    public Todo get(Long id) {

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select * from todo where id=?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Todo todo= Todo.builder()
                        .id(resultSet.getLong("id"))
                        .todo(resultSet.getString("todo"))
                        .time(resultSet.getString("time"))
                        .date(resultSet.getString("date"))
                        .completed(resultSet.getBoolean("completed"))
                        .build();
                return todo;
            }


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Todo> getALLTodo() {

        List<Todo> todoList=new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select * from todo");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Todo todo= Todo.builder()
                        .id(resultSet.getLong("id"))
                        .todo(resultSet.getString("todo"))
                        .time(resultSet.getString("time"))
                        .date(resultSet.getString("date"))
                        .completed(resultSet.getBoolean("completed"))
                        .build();
                todoList.add(todo);
            }


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return todoList;
    }

}
