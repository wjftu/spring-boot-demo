package jdbc.entity;

import lombok.Data;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class User implements RowMapper<User> {
    Long id;
    String username;
    Integer age;

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user=new User();
        user.setId(rs.getLong("id"));
        user.setUsername(rs.getString("username"));
        user.setAge(rs.getInt("age"));
        return user;
    }
}
