package com.example.restaurant.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
// 모든 데이타는 MemoryDbEntity를 상속받는다.
public class MemoryDbEntity {

    protected int index;
}
