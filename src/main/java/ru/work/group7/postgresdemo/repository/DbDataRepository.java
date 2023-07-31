package ru.work.group7.postgresdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.work.group7.postgresdemo.domain.DbData;

import java.util.UUID;

/**
 * @author rnikonov
 */
@Repository
public interface DbDataRepository extends JpaRepository<DbData, UUID> {
}
