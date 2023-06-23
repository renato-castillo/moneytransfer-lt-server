package com.lt.moneytransfer.util;

import java.util.List;
import java.util.Optional;

public interface ICRUD<T,V> {

    T save(T t);

    void delete(V id);

    Optional<T> findById(V id);

    List<T> saveAll(List<T> t);

    List<T> findAll();


}
