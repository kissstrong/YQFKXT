package com.yqfk.service;

import com.yqfk.dao.AdminDao;
import com.yqfk.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AdminService {

    @Autowired
    private AdminDao adminDao;

    public Admin getAdmin(Admin admin){
        return admin;
    }
}
