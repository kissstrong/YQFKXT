package com.yqfk.service;


import com.yqfk.pojo.DataForPerson;
import com.yqfk.pojo.Province;
import com.yqfk.vo.Tags;

import java.util.List;
import java.util.Map;

/**
 * @author cyz
 * @date 2020-09-29 15:28
 */

public interface YQSJXXGLService {

    public Map<String, Province> getJsonMsg();

    public Map<String, String> getLocalAddr(String ip);

    public void uploadPersonData(DataForPerson dataForPerson);

    List<DataForPerson> queryAll();

    List<DataForPerson> queryByTags(Tags tags);

    void deleteById(int id);

}
