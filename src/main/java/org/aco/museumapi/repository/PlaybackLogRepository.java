package org.aco.museumapi.repository;

import org.aco.museumapi.model.PlaybackLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaybackLogRepository extends JpaRepository<PlaybackLog, String> {
}
