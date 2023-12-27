package training.spring.springtraining.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import training.spring.springtraining.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Repository
public class PersonJpaRepository {

    @Autowired
    private EntityManagerFactory entityManagerFactory;


    @Transactional
    public void insert(Person personParam) {
        EntityManager entityManagerLoc = null;
        try {
            entityManagerLoc = entityManagerFactory.createEntityManager();
            entityManagerLoc.joinTransaction();
            if (entityManagerLoc.isJoinedToTransaction()){
                entityManagerLoc.persist(personParam);
            }
        } catch (Exception eParam) {
            throw new RuntimeException(eParam);
        } finally {
            try {
                entityManagerLoc.close();
            } catch (Exception eParam) {
            }
        }
    }

    public void insert2(Person personParam) {
        EntityManager entityManagerLoc = null;
        try {
            entityManagerLoc = entityManagerFactory.createEntityManager();
            entityManagerLoc.getTransaction().begin();
            entityManagerLoc.persist(personParam);
            entityManagerLoc.getTransaction().commit();
        } catch (Exception eParam) {
            entityManagerLoc.getTransaction().rollback();
            throw new RuntimeException(eParam);
        } finally {
            try {
                entityManagerLoc.close();
            } catch (Exception eParam) {
            }
        }
    }

}
