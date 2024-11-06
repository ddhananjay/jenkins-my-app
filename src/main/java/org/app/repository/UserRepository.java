package org.app.repository;

import org.app.entity.PortalUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

//TODO @Repository removed for Jenkins CICD example
public interface UserRepository extends JpaRepository<PortalUser, String> {
    Optional<PortalUser> findByUserName(String userName);
}
