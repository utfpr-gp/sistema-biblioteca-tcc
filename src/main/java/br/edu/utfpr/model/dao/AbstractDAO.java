package br.edu.utfpr.model.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.edu.utfpr.util.JPAUtil;
import java.io.Serializable;
import javax.persistence.TypedQuery;

@SuppressWarnings("unchecked")
public class AbstractDAO<PK, T> implements Serializable {

    protected EntityManager entityManager;
    private Class<T> entityClass;

    public AbstractDAO() {
        this.entityManager = JPAUtil.getEntityManager();
    }

    /**
     * Retorna uma entidade pelo seu ID
     *
     * @param pk id da entidade
     * @return
     */
    public T getById(PK pk) {
        this.entityManager = JPAUtil.getEntityManager();
        return (T) entityManager.find(getTypeClass(), pk);
    }

    /**
     * Retorna a entidade pelo atributo único, ou seja, assumirá que há apenas
     * uma entidade com este atributo, retornando apenas um elemento.
     *
     * @param propertyName nome do atributo
     * @param propertyValue valor do atributo
     * @return
     */
    public T getByProperty(String propertyName, String propertyValue) {
        this.entityManager = JPAUtil.getEntityManager();

        String queryString = "SELECT o FROM " + getTypeClass().getName() + " o where o." + propertyName + " = :param";

        Query query = entityManager.createQuery(queryString);
        query.setParameter("param", propertyValue);

        List<T> queryResult = query.getResultList();

        T returnObject = null;

        if (!queryResult.isEmpty()) {
            returnObject = queryResult.get(0);
        }

        return returnObject;
    }

    public void save(T entity) {
        this.entityManager = JPAUtil.getEntityManager();
        entityManager.persist(entity);
    }

    public void update(T entity) {
        this.entityManager = JPAUtil.getEntityManager();
        entityManager.merge(entity);
    }

    public void delete(T entity) {
        this.entityManager = JPAUtil.getEntityManager();
        try {
            //verifica se a entidade está gerenciada, se não estiver, recupera ela do BD
            entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<T> findAll() {
        this.entityManager = JPAUtil.getEntityManager();
        return entityManager.createQuery(("FROM " + getTypeClass().getName()))
                .getResultList();
    }

    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().
                getGenericSuperclass()).getActualTypeArguments()[1];
        return clazz;
    }

    public TypedQuery<T> createNamedQuery(String query) {
        return JPAUtil.getEntityManager().createNamedQuery(query, entityClass);
    }

    public Query createNativeQuery(String query) {
        return JPAUtil.getEntityManager().createNativeQuery(query, entityClass);
    }

    public T findById(int id) {
        return JPAUtil.getEntityManager().find(entityClass, id);
    }

    public T findReferenceOnly(int id) {
        return JPAUtil.getEntityManager().getReference(entityClass, id);
    }
}
