package uz.pdp.service;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import uz.pdp.model.Todo;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService implements Base<Todo> {

    private JdbcTemplate jdbcTemplate;

    public TodoService(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean add(Todo todo) {
        int status=0;

        String sql="insert into todo(todo,time,date,completed) values (?,?,?,?)";
        status=jdbcTemplate.update(sql,todo.getTodo(),todo.getTime(),todo.getDate(),todo.isCompleted());

        return status>0;
    }

    @Override
    public List<Todo> getALL(int page, int size) {
        return null;
    }

    @Override
    public boolean delete(Long id) {

        int status=0;
        String sql="delete from todo where id=?";
        status=jdbcTemplate.update(sql,id);

        return status>0;
    }

    @Override
    public boolean update(Todo todo) {

        int status=0;
        String sql="update todo set todo=?,time=?,date=?,completed=? where id=?";
        status=jdbcTemplate.update(sql,todo.getTodo(),todo.getTime(),todo.getDate(),todo.isCompleted(),todo.getId());
        return status>0;
    }

    @Override
    public boolean completed(Long id) {
        int status=0;

        String sql="update todo set completed=? where id=?";
        status=jdbcTemplate.update(sql,true,id);
        return status>0;
    }
    @Override
    public Todo get(Long id) {

        String sql = "SELECT * FROM todo WHERE id=" + id;
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Todo.class));
    }

    public List<Todo> getALLTodo() {
            String sql = "SELECT * FROM todo";
            return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Todo.class));
    }

}
