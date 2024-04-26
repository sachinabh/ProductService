package com.scaler.ProductService.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class FakeStoreProductDtoList {
    private List<FakeStoreProductDto> fakeStoreProductDtoList;

    public FakeStoreProductDtoList(){
        fakeStoreProductDtoList = new ArrayList<>();
    }

    public int size() {
        return fakeStoreProductDtoList.size();
    }

    public FakeStoreProductDto get(int i){
        return fakeStoreProductDtoList.get(i);
    }
}
