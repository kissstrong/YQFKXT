package com.yqfk.service.impl;

import com.yqfk.dao.YQSJXXGLDao;
import com.yqfk.poji.DataForPerson;
import com.yqfk.poji.Province;
import com.yqfk.service.YQSJXXGLService;
import com.yqfk.utils.GetAddr;
import com.yqfk.utils.MapProvince;
import com.yqfk.vo.Tags;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author cyz
 * @date 2020-09-29 15:30
 */
@Service
public class YQSJXXGLServiceImpl implements YQSJXXGLService {
    @Resource
    private YQSJXXGLDao yqsjxxglDao;

    public Map<String, Province> getJsonMsg() {
        try {
            Map<String, Province> province = MapProvince.getProvince();
            return province;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public Map<String, String> getLocalAddr(String ip) {
        try {
            return GetAddr.getLocalProvinceAndCity(ip);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public void uploadPersonData(DataForPerson dataForPerson) {
        yqsjxxglDao.addData(dataForPerson);
    }

    public List<DataForPerson> queryAll() {
        return yqsjxxglDao.queryAll();
    }

    public List<DataForPerson> queryByTags(Tags tags) {
        return yqsjxxglDao.queryByTags(tags);
    }

    public void deleteById(int id) {
        yqsjxxglDao.deleteById(id);
    }
}
