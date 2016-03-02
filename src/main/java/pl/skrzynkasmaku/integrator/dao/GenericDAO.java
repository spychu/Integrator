package pl.skrzynkasmaku.integrator.dao;

import java.io.*;
import java.util.*;
import org.hibernate.Query;

/**
 *
 * @author Spychu
 * @param <T>
 * @param <ID>
 */
public interface GenericDAO<T, ID extends Serializable> {

    public List<T> findMany(Query query);

    public T findOne(Query query);

    public List<T> findAll(Class clazz);

    public T findByID(Class clazz, Integer id);
}
