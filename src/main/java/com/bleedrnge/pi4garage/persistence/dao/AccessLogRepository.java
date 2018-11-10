package com.bleedrnge.pi4garage.persistence.dao;

import com.bleedrnge.pi4garage.persistence.model.AccessLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.Collection;

public interface AccessLogRepository extends JpaRepository<AccessLog, Long> {
    Collection<AccessLog> findAllByTimeAfter(Instant time);
    Collection<AccessLog> findAllByTimeBefore(Instant time);
    Collection<AccessLog> findAllByTimeBetween(Instant start, Instant finish);
    Collection<AccessLog> findAllByStatusIs(Boolean status);
}