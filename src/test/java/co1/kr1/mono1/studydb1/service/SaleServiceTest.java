package co1.kr1.mono1.studydb1.service;

import co1.kr1.mono1.studydb1.model.AreaSalesDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@Slf4j
class SaleServiceTest {

    @Autowired
    SaleService saleService;

    ObjectMapper mapper;
    //ObjectMapper는 JSON객체를 Java객체로, Java객체를 JSON객체로 변환시켜주는 역할을 하는 JACKSON라이브러리의 클래스이다

    @BeforeEach
    void setUp() {
        mapper = new ObjectMapper();
    }

    @Test
    @DisplayName("특정지역에서 판매한 제품 정보 1건_DTO로 매핑, input:String, output:DTO")
    public void selectTestOneStaticParam() throws JsonProcessingException {

        AreaSalesDto sale = saleService.selectSales("30");
        log.info("JSON 변환: {}", mapper.writeValueAsString(sale));
    }

    @Test
    @DisplayName("input: String, output: map")
    public void selectTestOneStaticParamMap() throws JsonProcessingException {
        Map<String, Object> sale = saleService.selectSalesMap("30");
        sale.forEach((key, val) -> log.info("****{}:{}****", key, val));
    }


    @Test
    @DisplayName("input: map, output: map")
    public void selectMapListTest() throws JsonProcessingException {
        Map<String, Object> condMap = new HashMap<>();
        condMap.put("PRODID", "10");
        condMap.put("PRODNM", "냉장고");
        Map<String, Object> sale = saleService.selectMapList(condMap);
        sale.forEach((key, val) -> log.info("****{}:{}****", key, val));
    }


    @Test
    @DisplayName("input:map, output: multi")
    public void selectMultiListTest() throws JsonProcessingException {
        HashMap<String, Object> condMap = new HashMap<>();
        condMap.put("PRODID", "10");
//        condMap.put("PRODNM", "냉장고");

        List<Map<String, Object>> rsltList = saleService.selectMultiList(condMap);
        rsltList.stream().forEach(System.out::println);
    }
}