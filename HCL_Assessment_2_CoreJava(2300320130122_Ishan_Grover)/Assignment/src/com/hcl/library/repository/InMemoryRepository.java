
package com.hcl.library.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class InMemoryRepository<T, ID>
        implements Repository<T, ID> {

    private final Map<ID, T> data = new HashMap<>();
    private final Function<T, ID> idExtractor;

    public InMemoryRepository(Function<T, ID> idExtractor) {
        this.idExtractor = idExtractor;
    }

    @Override
    public void save(T entity) {
        ID id = idExtractor.apply(entity);
        data.put(id, entity);
    }

    @Override
    public T findById(ID id) {
        return data.get(id);
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public void deleteById(ID id) {
        data.remove(id);
    }
}
