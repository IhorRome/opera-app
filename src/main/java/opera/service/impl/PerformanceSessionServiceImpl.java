package opera.service.impl;

import opera.dao.PerformanceSessionDao;
import opera.exception.DataProcessingException;
import opera.model.PerformanceSession;
import opera.service.PerformanceSessionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PerformanceSessionServiceImpl implements PerformanceSessionService {
    private final PerformanceSessionDao performanceSessionDao;

    public PerformanceSessionServiceImpl(PerformanceSessionDao performanceSessionDao) {
        this.performanceSessionDao = performanceSessionDao;
    }

    @Override
    public List<PerformanceSession> findAvailableSessions(Long movieId, LocalDate date) {
        return performanceSessionDao.findAvailableSessions(movieId, date);
    }

    @Override
    public PerformanceSession add(PerformanceSession session) {
        return performanceSessionDao.add(session);
    }

    @Override
    public PerformanceSession get(Long id) {
        return performanceSessionDao.get(id).orElseThrow(
                () -> new DataProcessingException("Session with id " + id + " not found"));
    }

    @Override
    public PerformanceSession update(PerformanceSession performanceSession) {
        return performanceSessionDao.update(performanceSession);
    }

    @Override
    public void delete(Long id) {
        performanceSessionDao.delete(id);
    }
}
