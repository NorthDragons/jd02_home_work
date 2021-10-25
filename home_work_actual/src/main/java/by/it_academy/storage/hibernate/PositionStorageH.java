package by.it_academy.storage.hibernate;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Position;
import by.it_academy.storage.api.IPositionStorage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.List;

public class PositionStorageH implements IPositionStorage {
    private final static PositionStorageH instance = new PositionStorageH();
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public Long putPosition(Position position) {
        try (final Session session = sessionFactory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            session.save(position);
            transaction.commit();
            return position.getId();
        }

    }

    @Override
    public Long updatePosition(Position position) {
        try (Session session = sessionFactory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            session.update(position);
            transaction.commit();
            return position.getId();
        }
    }

    @Override
    public Position getPosition(Long id) {
        try (Session session = sessionFactory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            final Position position = session.get(Position.class, id);
            transaction.commit();
            return position;
        }
    }

    @Override
    public Collection<Position> getAllPosition(Long limit, Long offset) {
        try (Session session = sessionFactory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            final CriteriaQuery<Position> criteriaQuery = criteriaBuilder.createQuery(Position.class);
            final Root<Position> from = criteriaQuery.from(Position.class);
            final Query<Position> query = session.createQuery(criteriaQuery);
            query.setFirstResult(Math.toIntExact(offset));
            query.setMaxResults(Math.toIntExact(limit));
            transaction.commit();
            return query.list();
        }
    }

    @Override
    public String getPosName(Position position) {
        if (position.getName() == null) {
            try (Session session = sessionFactory.openSession()) {
                final Transaction transaction = session.beginTransaction();
                final String name = session.get(Position.class, position.getId()).getName();
                transaction.commit();
                return name;
            }
        } else {
            return position.getName();
        }
    }

    @Override
    public Long getMaxPage(Long limit) {
        try (Session session = sessionFactory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            final CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
            criteriaQuery.select(criteriaBuilder.count(criteriaQuery.from(Position.class)));
            float aFloat = ((float) session.createQuery(criteriaQuery).getSingleResult() / (float) limit);
            transaction.commit();
            return (long) Math.ceil(aFloat);
        }
    }

    public static PositionStorageH getInstance() {
        return instance;
    }
}
