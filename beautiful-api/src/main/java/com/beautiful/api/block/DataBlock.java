package com.beautiful.api.block;

import com.beautiful.api.writable.WritableValue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:抽象 可以 扩展
 * @Author: zhuyuping
 * @CreateDate: 2018/4/10 13:46
 **/
public class DataBlock<T extends WritableValue> implements Serializable {

    private List<List<T>> blocks;

    public DataBlock() {
        this(Collections.<List<T>>emptyList());

    }

    public DataBlock(Collection<? extends Collection<? extends T>> data) {
        blocks = new LinkedList<>();
        for (final Collection<? extends T> col : data) {
            add(new ArrayList<>(col));
        }
    }

    public List<List<T>> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<List<T>> blocks) {
        this.blocks = blocks;
    }

    public T get(final int col, final int row) {
        return blocks.get(col).get(row);
    }

    public void set(final T value, final int col, final int row) {
        blocks.get(col).set(row, value);
    }

    public void add(final List<T> col) {
        final int len = length();
        for (int r = col.size(); r < len; r++) {
            col.add(null);
        }
        blocks.add(col);
    }

    public int size() {
        return blocks.size();
    }

    public int length() {
        return blocks.isEmpty() ? 0 : blocks.get(0).size();
    }

}
