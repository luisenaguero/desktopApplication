/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA.utilities;

import JPA.entities.Entidad;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author luisenaguero
 * @param <T>
 */
public class JPAManager<T extends Entidad> {

    private final Class<T> entityClass;
    private static final String persistenceUnit = "desktopApplicationPU";
    //   @PersistenceContext(unitName = "UrbeIntPU")
    // public static EntityManagerFactory entityManagerFactory;

    public JPAManager(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    private static EntityManager getEntityManager() {

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit);
            return emf.createEntityManager();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    // INSERTA, ACTUALIZA O ELIMINA UNA ENTIDAD
    private boolean entityCUD(T entity, Actions action) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();

            switch (action) {

                case INSERT:
                    entityManager.persist(entity);
                    break;
                case UPDATE:
                    entityManager.merge(entity);
                    break;
                case DELETE:
                    entityManager.remove(entityManager.getReference(entityClass, entity.getId()));
                    break;
            }
            entityTransaction.commit();
            return true;
        } catch (javax.persistence.PersistenceException e) {
            return false;
        } finally {
            entityManager.close();
        }
    }

    public boolean persistEntity(T entity) {
        return entityCUD(entity, Actions.INSERT);
    }

    public boolean updateEntity(T entity) {

        return entityCUD(entity, Actions.UPDATE);
    }

    // BUSCO EN BDD SI EXISTE EL CÓDIGO DE LA ENTIDAD
    public boolean codeExists(String namedquery, Map<String, Object> parameters) {

        Long result = (Long) buildQuery(namedquery, parameters).getSingleResult();

        return (result == 1);

    }

    public boolean deleteEntity(T entity) {
        return entityCUD(entity, Actions.DELETE);
    }

    // BUSCA UNA ENTIDAD <T>
    public T findEntity(Object id) {

        return getEntityManager().find(entityClass, id);

    }

    // EJECUTA UN NAMED QUERY QUE RETORNA UN SOLO OBJETO <T>
    public T singleResultNQ(String query, Map<String, Object> parameters) {

        try {

            return (T) (buildQuery(query, parameters)).getResultList().get(0);

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    // EJECUTA UN NAMED QUERY QUE RETORNA UNA LISTA <T>
    public List<T> listResultNQ(String query, Map<String, Object> parameters) {

        try {

            return (buildQuery(query, parameters)).getResultList();

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    // BUSCA UNA ENTIDAD DIFERENTE A <T>
    public Object findEntity(Class clase, Object id) {

        //   getEntityManager().clear();
        return getEntityManager().find(clase, id);

    }

    // EJECUTA UN NAMED QUERY QUE RETORNA UNA LISTA <OBJECT>
    public List<Object> objectListResultNQ(String query, Map<String, Object> parameters) {

        try {

            return (buildQuery(query, parameters)).getResultList();

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    // EJECUTA UN NAMED QUERY PARA ACTUALIZAR
    public boolean updateNQ(String query, Map<String, Object> parameters) {

        try {

            buildQuery(query, parameters).executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

        return true;
    }

    //PREPARA EL QUERY
    private Query buildQuery(String query, Map<String, Object> parameters) {

        Query q = getEntityManager().createNamedQuery(query);

        if (parameters != null
                && !parameters.isEmpty()) {
            for (String parameter : parameters.keySet()) {
                q.setParameter(parameter, parameters.get(parameter));
            }
        }

        return q;
    }

    public enum Actions {

        // INSERTA UN NUEVO REGISTRO
        INSERT,
        // ACTUALIZA UN REGISTRO
        UPDATE,
        // ELIMINA UN REGISTRO
        DELETE,
        // ESPERA UNA LISTA 
        LIST,
        // ESPERA UN OBJETO
        OBJECT
    }
}
