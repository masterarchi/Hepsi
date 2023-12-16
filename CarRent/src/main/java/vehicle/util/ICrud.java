package product.util;

import java.util.List;
import java.util.Optional;

public interface ICrud <T,ID>{
    T save(T entity);
    Iterable<T> saveAll(Iterable<T> entities);
    T update(T entity);
    void deleteById(ID id);
    void delete(T entity);
    Optional<T> findById(ID id);
    boolean existsById(ID id);
    List<T> findAll();
    List<T> findByEntity(T entity);
    <E> List<T> findByColumnNameAndValue(String columnName,E value);




}
