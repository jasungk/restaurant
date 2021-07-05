package com.example.restaurant.db;

import java.util.List;
import java.util.Optional;

public interface MemoryDbRepositoryIfs<T> {

    // 아이디 찾는 기능
    Optional<T> findById(int index);
    // 저장하는 기능
    T save(T entity);
    // 아이디 삭제 기능
    void deleteById(int index);
    // 전체 리턴 기능
    List<T> listAll();
}
