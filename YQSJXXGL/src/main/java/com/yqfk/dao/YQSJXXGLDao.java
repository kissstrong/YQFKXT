package com.yqfk.dao;

import com.yqfk.pojo.DataForPerson;
import com.yqfk.vo.Tags;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author cyz
 * @date 2020-10-02 13:59
 */
@Mapper
public interface YQSJXXGLDao {
    void addData(DataForPerson dataForPerson);
    List<DataForPerson> queryAll();
    List<DataForPerson> queryByTags(Tags tags);
    void deleteById(int id);
}
