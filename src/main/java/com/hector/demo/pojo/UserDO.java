package com.hector.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Table;

/**
 * @author hector.lin
 * @date 2020/8/10 15:12
 */

@Data
@TableName("test")
public class UserDO {
    public Integer id;
    public String names;
    public String passwords;
    public String[] name;
    public String[] password;

    public UserDO (String[] name,String[] password){
        this.name = name;
        this.password = password;
    }
    public UserDO(){}
}
