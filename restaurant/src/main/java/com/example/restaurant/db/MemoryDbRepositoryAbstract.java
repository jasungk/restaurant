package com.example.restaurant.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

abstract public class MemoryDbRepositoryAbstract<T extends MemoryDbEntity> implements MemoryDbRepositoryIfs<T>{
    // 데이터 저장
    // 리스에다가 쭉 데이터는 용도
    private final List<T> db = new ArrayList<>();
    // PK, AI
    private int index = 0;

    @Override
    public Optional<T> findById(int index) {
        return db.stream().filter(it -> it.getIndex() == index).findFirst();
    }

    @Override
    public T save(T entity) {

        var optionalEntity = db.stream().filter(it -> it.getIndex() == entity.getIndex()).findFirst();


        if(optionalEntity.isEmpty()){
            // db 에 데이터가 없는 경우
            index++;
            entity.setIndex(index);
            db.add(entity);
            return entity;

        } else {
            // db 에 이미 데이터가 있는 경우
            var preIndex = optionalEntity.get().getIndex();
            entity.setIndex(preIndex);

            deleteById(preIndex);
            db.add(entity);
            return entity;
        }
    }

    @Override
    public void deleteById(int index) {
        var optionalEntity = db.stream().filter(it -> it.getIndex() == index).findFirst();
        // db 에 이미 있는 경우
        if(optionalEntity.isPresent()) {
            // 해당 오브젝트와 동일한 오브젝트를 지운다.
            db.remove(optionalEntity.get());
        }
    }

    @Override
    public List<T> listAll() {
        // db의 모든 내용을 리턴
        return db;
    }
}
