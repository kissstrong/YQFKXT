package com.yqfk.mapper;


import com.yqfk.pojo.Address;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AddressMapper {

    List<Address> queryAll();
    Address getAddressByAid(int aId);
    int firstAdd(Address address);
    int addAddress(Address address);
    int updateAddress(Address address);
    int updatedef(Address address);
    int deleteAddress(int aId);
}
