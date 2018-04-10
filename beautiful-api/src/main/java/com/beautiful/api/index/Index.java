package com.beautiful.api.index;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Description:
 * @Author: zhuyuping
 * @CreateDate: 2018/4/10 13:18
 **/
public class Index {

    private Map<Object, Integer> index;

    public Index() {
        this(Collections.<Object>emptyList());
    }

    public Index(final Collection<?> names) {
        this(names, names.size());
    }

    public Index(final Collection<?> names, final int size) {
        index = new LinkedHashMap<>(names.size());
        final Iterator<?> it = names.iterator();
        for (int i = 0; i < size; i++) {
            final Object name = it.hasNext() ? it.next() : i;
            add(name, i);
        }
    }

    public void add(final Object name, final Integer value) {
        if (index.put(name, value) != null) {
            throw new IllegalArgumentException("duplicate name '" + name + "' in index");
        }
    }

    public void extend(final Integer size) {
        for (int i = index.size(); i < size; i++) {
            add(i, i);
        }
    }

    public void set(final Object name, final Integer value) {
        index.put(name, value);
    }

    public Integer get(final Object name) {
        final Integer i = index.get(name);
        if (i == null) {
            throw new IllegalArgumentException("name '" + name + "' not in index");
        }
        return i;
    }

    public void rename(final Map<Object, Object> names) {
        final Map<Object, Integer> idx = new LinkedHashMap<>();
        for (final Map.Entry<Object, Integer> entry : index.entrySet()) {
            final Object col = entry.getKey();
            if (names.keySet().contains(col)) {
                idx.put(names.get(col), entry.getValue());
            } else {
                idx.put(col, entry.getValue());
            }
        }

        // clear and add all names back to preserve insertion order
        index.clear();
        index.putAll(idx);
    }

    public Set<Object> names() {
        return index.keySet();
    }

    public Integer[] indices(final Object[] names) {
        return indices(Arrays.asList(names));
    }

    public Integer[] indices(final List<Object> names) {
        final int size = names.size();
        final Integer[] indices = new Integer[size];
        for (int i = 0; i < size; i++) {
            indices[i] = get(names.get(i));
        }
        return indices;
    }
}
