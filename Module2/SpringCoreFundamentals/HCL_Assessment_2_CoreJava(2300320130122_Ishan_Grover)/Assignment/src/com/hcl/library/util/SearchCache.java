
package com.hcl.library.util;

import com.hcl.library.model.LibraryItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SearchCache {

    private static final int MAX_CACHE_SIZE = 5;

    private final Map<Integer, LibraryItem> cache =
            new LinkedHashMap<>();

    public void add(LibraryItem item) {
        cache.remove(item.getId());
        cache.put(item.getId(), item);

        if (cache.size() > MAX_CACHE_SIZE) {
            Iterator<Integer> iterator =
                    cache.keySet().iterator();

            iterator.next();
            iterator.remove();
        }
    }

    public List<LibraryItem> getRecentItems() {
        return new ArrayList<>(cache.values());
    }

    public void clear() {
        cache.clear();
    }
}
