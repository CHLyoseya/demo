package com.hector.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hector.demo.pojo.DistributionDTO;
import com.hector.demo.pojo.UserDO;
import com.hector.demo.pojo.DistributionDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author hector.lin
 * @date 2020/8/13 17:15
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
    List<UserDO> testList();

    List<DistributionDO> testPro(@Param("dto") DistributionDTO dto);

    Integer updateList(@Param("dto") DistributionDTO dto);

    Integer insertForName(@Param("dto")UserDO userDO);
}
