package org.eyupcompany.invoicesmanage.dao;

import org.eyupcompany.invoicesmanage.dto.requests.UserRequest;
import org.eyupcompany.invoicesmanage.models.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User extends JpaRepository<UserEntity,Long> {
    boolean existsByUsername(String username);
    UserEntity findByUsername(String username);

}
