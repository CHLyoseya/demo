package com.hector.demo.service;

import com.hector.demo.pojo.DistributionDTO;
import com.hector.demo.pojo.UserDO;
import com.hector.demo.pojo.DistributionDO;
import javafx.util.Pair;

import java.util.List;
import java.util.Map;

/**
 * @author hector.lin
 * @date 2020/8/10 15:12
 */
public interface UserService {
    List<UserDO> list();

    Map<String,Double> getList(DistributionDTO dto);

    Map<String,Double> updateList(DistributionDTO dto);

    List<DistributionDO> getAll(DistributionDTO dto);
}
