package codegym.service;

import codegym.model.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class NasaRepositoryImpl implements INasaRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Comment comment) {
        entityManager.persist(comment);
        comment.setLikes(comment.getLikes()+1);
        comment.setDate();
    }

    @Override
    public List<Comment> findAll() {
        return entityManager.createQuery("select c from Comment c").getResultList();
    }

    @Override
    public List<Comment> findAllToday(String date) {
        return entityManager.createQuery("select c from Comment c where c.date = ?1").setParameter(1,date).getResultList();
    }
}
