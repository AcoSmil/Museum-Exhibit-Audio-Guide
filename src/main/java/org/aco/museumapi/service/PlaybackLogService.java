package org.aco.museumapi.service;

import org.aco.museumapi.model.PlaybackLog;
import org.aco.museumapi.repository.PlaybackLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaybackLogService {

    private final PlaybackLogRepository playbackLogRepository;

    public PlaybackLogService(PlaybackLogRepository playbackLogRepository) {
        this.playbackLogRepository = playbackLogRepository;
    }

    public List<PlaybackLog> getAllLogs() {
        return playbackLogRepository.findAll();
    }

    public Optional<PlaybackLog> getLogById(String logId) {
        return playbackLogRepository.findById(logId);
    }

    public PlaybackLog saveLog(PlaybackLog log) {
        return playbackLogRepository.save(log);
    }

    public void deleteLog(String logId) {
        playbackLogRepository.deleteById(logId);
    }
}
