package jdbc.repository;

import jdbc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    
    JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> findById(Long id){
        String sql = "select id, username, age from jdbc_user where id=?";
        List<User> list = jdbcTemplate.query(sql, new User(), new Object[]{id});
        return list;

    }

    public List<User> findAll(){
        String sql = "select id, username, age from jdbc_user limit 1000";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        return list;
    }

    public int insert(String username, Integer age){
        String sql = "insert into jdbc_user(username, age) values(?,?)";
        int update = jdbcTemplate.update(sql, username, age);
        return update;
    }

    public int update(Long id, String username, Integer age){
        String sql = "update jdbc_user set username = ?, age = ? where id = ?";
        int update = jdbcTemplate.update(sql, username, age, id);
        return update;
    }

    public int delete(Long id){
        String sql = "delete from jdbc_user where id = ?";
        int update = jdbcTemplate.update(sql, id);
        return update;
    }
}
