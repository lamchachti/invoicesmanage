package org.eyupcompany.invoicesmanage.dao;

import org.eyupcompany.invoicesmanage.models.InternalUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternalUser extends JpaRepository<InternalUserEntity,Long> {
}
