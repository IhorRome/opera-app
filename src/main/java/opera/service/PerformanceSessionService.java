package opera.service;

import opera.model.PerformanceSession;

import java.time.LocalDate;
import java.util.List;

public interface PerformanceSessionService {
    List<PerformanceSession> findAvailableSessions(Long movieId, LocalDate date);

    PerformanceSession add(PerformanceSession session);

    PerformanceSession get(Long id);

    PerformanceSession update(PerformanceSession performanceSession);

    void delete(Long id);
}
