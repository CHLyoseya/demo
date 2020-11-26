package com.hector.demo.service.impl;

import com.hector.demo.mapper.UserMapper;
import com.hector.demo.pojo.DistributionDTO;
import com.hector.demo.pojo.UserDO;
import com.hector.demo.pojo.DistributionDO;
import com.hector.demo.service.UserService;
import javafx.util.Pair;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hector.lin
 * @date 2020/8/10 15:13
 */
@Service
@CacheConfig(cacheNames = "caffeineCacheManager")
public class UserServiceImpl implements UserService {

    @Resource
    public UserMapper userMapper;

    @Override
    public List<UserDO> list() {
        return userMapper.selectList(null);
    }

    @Override
    @Cacheable(key = "#dto.type+#dto.encryptType")
    public Map<String, Double> getList(DistributionDTO dto) {
        List<DistributionDO> distributionDOS = userMapper.testPro(dto);
        HashMap<String, Double> map = new HashMap<>();
        for (DistributionDO distributionDO : distributionDOS) {
            map.put(distributionDO.getProvider(), distributionDO.getProportion());
        }
        return map;
    }

    @Override
    @CachePut(key = "#dto.type+#dto.encryptType")
    public Map<String, Double> updateList(DistributionDTO dto) {
        userMapper.updateList(dto);
        List<DistributionDO> distributionDOS = userMapper.testPro(dto);
        HashMap<String, Double> map = new HashMap<>();
        for (DistributionDO distributionDO : distributionDOS) {
            map.put(distributionDO.getProvider(), distributionDO.getProportion());
        }
        return map;
    }

    @Override
    public List<DistributionDO> getAll(DistributionDTO dto) {
        return null;
    }

    public void tttt(UserDO userDO){
        userMapper.insertForName(userDO);
    }
}
