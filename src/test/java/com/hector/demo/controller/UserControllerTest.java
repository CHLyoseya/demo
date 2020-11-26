package com.hector.demo.controller;

import com.hector.demo.mapper.UserMapper;
import com.hector.demo.pojo.DistributionDTO;
import com.hector.demo.pojo.UserDO;
import com.hector.demo.pojo.DistributionDO;
import com.hector.demo.service.UserService;
import javafx.util.Pair;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author hector.lin
 * @date 2020/8/10 15:35
 */
@SpringBootTest
@AutoConfigureMockMvc
@EnableCaching
class UserControllerTest {
    @Autowired
    public UserController userController;
    @Autowired
    public MockMvc mockMvc;

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;
    @Test
    public void list(){

        System.out.println(userController.list());
    }


    @Test
    public void test1()  throws  Exception{
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/list")
                .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(MockMvcResultHandlers.print()).andReturn();
        String content=result.getResponse().getContentAsString();

    }

    @Test
    public void testSelectOne(){
        List<UserDO> user = userMapper.selectList(null);
        System.out.println(user);
    }

    @Test
    public void testList(){
        String names = "lisi,wangwu";
        String passwords = "123,567";
        String[] name = names.split(",");
        String[] password = passwords.split(",");
        UserDO userDO = new UserDO(name, password);
        userMapper.insertForName(userDO);
    }

    @Test
    public void tt(){
//        DistributionDTO distributionDTO = new DistributionDTO("threeItems", "MD5");
//        DistributionDTO distributionDTO1 = new DistributionDTO("threeItems", "SHA256");
//        List<Pair<String,Double>> list = userService.getList(distributionDTO);
//        List<Pair<String,Double>> list1 = userService.getList(distributionDTO);
//        List<Pair<String,Double>> list2 = userService.getList(distributionDTO1);
//        System.out.println(list);
//        System.out.println(list1);
//        System.out.println(list2);
        DistributionDTO distributionDTO2 = new DistributionDTO("threeItems", "MD5","WLY_MCKJ",80.0);
        DistributionDTO distributionDTO3 = new DistributionDTO("threeItems", "SHA256","WLY_XYD",70.0);
        DistributionDTO distributionDTO = new DistributionDTO("threeItems", "MD5");
        Map<String,Double> list = userService.getList(distributionDTO);
        Map<String,Double> list1 = userService.updateList(distributionDTO2);
        Map<String,Double> list2 = userService.getList(distributionDTO);
        System.out.println(list);
        System.out.println(list1);
        System.out.println(list2);



    }

}