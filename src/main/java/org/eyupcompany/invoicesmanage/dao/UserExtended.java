package org.eyupcompany.invoicesmanage.dao;

import org.eyupcompany.invoicesmanage.dto.requests.UserRequest;
import org.eyupcompany.invoicesmanage.dto.responses.UserResponse;
import org.eyupcompany.invoicesmanage.models.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserExtended {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public UserEntity login(UserRequest userRequest) {
        // Esta consulta es vulnerable a inyección SQL
        String sql = "SELECT user_id, username, user_phone FROM users WHERE username='" + userRequest.getUsername() + "' AND password='" + userRequest.getPassword() + "'";

        try {
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
                UserEntity userEntity = new UserEntity();
                userEntity.setUser_id(rs.getLong("user_id"));
                userEntity.setUsername(rs.getString("username"));
                userEntity.setUser_phone(rs.getString("user_phone"));
                return userEntity;
            });
        } catch (EmptyResultDataAccessException exception) {
            return null; // Usuario no encontrado o credenciales inválidas
        }
    }


}
