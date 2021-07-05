package opera.service.impl;

import opera.dao.PerformanceDao;
import opera.exception.DataProcessingException;
import opera.model.Performance;
import opera.service.PerformanceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformanceServiceImpl implements PerformanceService {
    private final PerformanceDao performanceDao;

    public PerformanceServiceImpl(PerformanceDao performanceDao) {
        this.performanceDao = performanceDao;
    }

    @Override
    public Performance add(Performance performance) {
        return performanceDao.add(performance);
    }

    @Override
    public Performance get(Long id) {
        return performanceDao.get(id).orElseThrow(
                () -> new DataProcessingException("Can't get movie by id " + id));
    }

    @Override
    public List<Performance> getAll() {
        return performanceDao.getAll();
    }
}
