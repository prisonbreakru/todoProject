package uz.pdp.service;

import org.springframework.stereotype.Service;
import uz.pdp.model.Todo;

import java.util.List;

@Service
public interface Base<T> extends DatabaseInit{
    boolean add(T t);
    List<T> getALL(int page, int size);
    boolean delete(Long id);
    boolean update(T t);
    boolean completed(Long id);
    T get(Long id);

    List<T> getALLTodo();
}
