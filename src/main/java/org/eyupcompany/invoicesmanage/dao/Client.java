package org.eyupcompany.invoicesmanage.dao;

import org.eyupcompany.invoicesmanage.models.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Client extends JpaRepository<ClientEntity, Long> {

}
