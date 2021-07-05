package com.example.restaurant.wishlist.repository;

import com.example.restaurant.db.MemoryDbRepositoryAbstract;
import com.example.restaurant.wishlist.entity.WishListEntity;
import org.springframework.stereotype.Repository;

// 데이터 저장소로 사용
@Repository
// 타입을 WishListEntity로 사용 하기 때문에 추상클래스 MemoryDbRepositoryAbstract의 모든 기능에 WishListEntity가 대체된다.
public class WishListRepository extends MemoryDbRepositoryAbstract<WishListEntity> {


}
