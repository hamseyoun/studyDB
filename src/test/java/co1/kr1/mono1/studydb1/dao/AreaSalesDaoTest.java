package co1.kr1.mono1.studydb1.dao;

import co1.kr1.mono1.studydb1.model.AreaSalesDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@MybatisTest    //mybatis-spring-boot-starter-test 를 dependency에 따로 추가해줘야한다.
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AreaSalesDaoTest {

    @Autowired
    private AreaSalesDao areaSalesDao;  //인터페이스이기 때문에 다이나믹프록시가 구현해준다.

    @Test
    @DisplayName("areaSaleMapper Test")
    public void areaSalesMapperTest() {
        AreaSalesDto areaSalesDto = areaSalesDao.findAreaSales("10");
        System.out.println(areaSalesDao);
    }


    @Test
    @DisplayName("Dto없이 Map으로 대체")
    public void findAreaSalesMapTest() {
        Map<String, Object> areaSaleMap = areaSalesDao.findAreaSalesMap("10");

        areaSaleMap.forEach((key, val) ->
                System.out.println(String.format("%s : %s", key, val)));
    }


    @Test
    @DisplayName("Single param, multi return test")
    public void findMsaleByMultiParmTest() {
        HashMap<String, Object> condMap = new HashMap<>();
        condMap.put("PRODID", "10");
        condMap.put("PRODNM", "냉장고");

        Map<String, Object> rsltMap = areaSalesDao.findMsaleByMultiParm(condMap);
        System.out.println("rsltMap = " + rsltMap);
    }


    @Test
    @DisplayName("multi param, multi return test")
    public void findMsaleByMultiReturnTest() {
        HashMap<String, Object> condMap = new HashMap<>();
        condMap.put("PRODID", "10");
//        condMap.put("PRODNM", "냉장고");

        List<Map<String, Object>> rsltList = areaSalesDao.findMsaleByMultiReturn(condMap);
        rsltList.stream().forEach(System.out::println);
    }
}