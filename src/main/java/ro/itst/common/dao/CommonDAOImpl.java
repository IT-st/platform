package ro.itst.common.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

public abstract class CommonDAOImpl<T extends Serializable, PK extends Serializable> implements CommonDAO<T, PK> {

    @PersistenceContext
    protected EntityManager em;

    protected abstract  Class<T> getEntityClass();

    public CommonDAOImpl() {
       // em.setFlushMode(FlushModeType.COMMIT);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @SuppressWarnings("unchecked")
    protected T findById(String columnName, PK identifier) throws PersistenceException {
        final Query query = em.createQuery("SELECT o FROM " + getEntityClass().getSimpleName()
                + " o WHERE o." + columnName + "=:identifier");
        query.setParameter("identifier", identifier);

        final List<T> results = query.getResultList();

        if (! results.isEmpty()) {
            return results.iterator().next();
        }

        return null;

    }


    @Override
    @SuppressWarnings("unchecked")
    public T saveOrUpdate(T entity) throws PersistenceException {
        try {
            return em.merge(entity);
        } catch (Exception e) {
            throw new PersistenceException("Failed saveOrUpdate for entity class " + getEntityClass(), e);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> findAll() throws PersistenceException {
        try {
            final Query query = em.createQuery("SELECT o FROM " + getEntityClass().getSimpleName());
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenceException("Failed findAll for entity class " + getEntityClass(), e);
        }
    }

    
    @Override
    public final void delete(final T entity) throws PersistenceException {
       try {
           em.remove(entity);
       } catch (Exception e) {
           throw new PersistenceException("Failed delete for entity class " + getEntityClass(), e);
       }
    }

    @Override
    public void close() {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
}
