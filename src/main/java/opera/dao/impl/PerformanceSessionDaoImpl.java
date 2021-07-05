package opera.dao.impl;

import opera.dao.AbstractDao;
import opera.dao.PerformanceSessionDao;
import opera.exception.DataProcessingException;
import opera.model.PerformanceSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class PerformanceSessionDaoImpl extends AbstractDao<PerformanceSession> implements PerformanceSessionDao {
    public PerformanceSessionDaoImpl(SessionFactory factory) {
        super(factory, PerformanceSession.class);
    }

    @Override
    public List<PerformanceSession> findAvailableSessions(Long movieId, LocalDate date) {
        try (Session session = factory.openSession()) {
            Query<PerformanceSession> getAvailableSessions = session.createQuery(
                    "FROM MovieSession WHERE id = :id "
                            + "AND DATE_FORMAT(showTime, '%Y-%m-%d') = :date", PerformanceSession.class);
            getAvailableSessions.setParameter("id", movieId);
            getAvailableSessions.setParameter("date", date.toString());
            return getAvailableSessions.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Session for performance with id "
                    + movieId + " and show date " + date + " not found", e);
        }
    }
}
