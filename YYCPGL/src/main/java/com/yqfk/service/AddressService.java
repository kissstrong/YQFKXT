package com.yqfk.service;

import com.yqfk.pojo.Address;

import java.util.List;

public interface AddressService {
    List<Address> queryAll();
    Address getAddressByAid(int aId);
    int firstAdd(Address address);
    int addAddress(Address address);
    int updateAddress(Address address);
    int updatedef(Address address);
    int deleteAddress(int aId);
}
