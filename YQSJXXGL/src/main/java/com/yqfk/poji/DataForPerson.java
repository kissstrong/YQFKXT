package com.yqfk.poji;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author cyz
 * @date 2020-09-30 20:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataForPerson {
    private int id;
    private String username;
    private String idCard;
    private float heat;
    private String iscough;
    private String address;
    private Date date;
}
