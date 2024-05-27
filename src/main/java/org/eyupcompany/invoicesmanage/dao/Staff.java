package org.eyupcompany.invoicesmanage.dao;

import org.eyupcompany.invoicesmanage.models.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Staff extends JpaRepository<StaffEntity,Long> {
}
