package com.yqfk.service.Impl;

import com.yqfk.mapper.AddressMapper;
import com.yqfk.pojo.Address;
import com.yqfk.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<Address> queryAll() {
        return addressMapper.queryAll();
    }

    @Override
    public int updateAddress(Address address) {
        return addressMapper.updateAddress(address);
    }

    @Override
    public int updatedef(Address address) {
        return addressMapper.updatedef(address);
    }

    @Override
    public int deleteAddress(int aId) {
        return addressMapper.deleteAddress(aId);
    }

    @Override
    public Address getAddressByAid(int aId) {
        return addressMapper.getAddressByAid(aId);
    }

    @Override
    public int firstAdd(Address address) {
        return addressMapper.firstAdd(address);
    }

    @Override
    public int addAddress(Address address) {
        return addressMapper.addAddress(address);
    }

}
