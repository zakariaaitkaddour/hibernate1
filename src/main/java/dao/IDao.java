package dao;

import java.util.List;

public interface IDao<T> {
    boolean create(T t);
    boolean update(T t);
    boolean delete(T t);
    List<T> findAll();
    T findById(int id);
}
