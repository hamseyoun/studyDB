package co1.kr1.mono1.studydb1.controller;

import co1.kr1.mono1.studydb1.model.AreaSalesDto;
import co1.kr1.mono1.studydb1.service.SaleService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Log4j2
public class SalesController {

    @Autowired
    SaleService saleService;

    @GetMapping("/saleList/{areacd}")
    public AreaSalesDto saleList(@PathVariable String areacd) {
        //uri에서 {areacd}를 가져와서 String areacd에 대입해라, 라고 하는것이 @PathVariable 이다.
        AreaSalesDto dto = saleService.selectSales(areacd);
        log.info(areacd);
        return dto;
    }


    @GetMapping("/salemap/{areacd}")
    public Map<String, Object> salesMap(@PathVariable String areacd) {
        Map<String, Object> map = saleService.selectSalesMap(areacd);
        log.info(areacd);
        return map;
    }


    //숙제
    @GetMapping("/saleMapList")
    public Map<String, Object> saleMapList(@RequestParam(required = false) String prodId,
                                           @RequestParam(required = false) String prodNm) {
        //@RequestParam은 @PathVariable과는 다르게 uri가 아니라 파라미터에서 값을 가져온다.
        Map<String, Object> condMap = new HashMap<>();
        condMap.put("PRODID", prodId);
        condMap.put("PRODNM", prodNm);

        Map<String, Object> rsltMap = saleService.selectMapList(condMap);

        log.info(rsltMap);
        return rsltMap;
    }


    @GetMapping("/multiList")
    public List<Map<String, Object>> multilist(@RequestParam Map<String, Object> rpMap) {
        Map<String, Object> condMap = new HashMap<>();
        condMap.put("PRODID", rpMap.get("prodId"));
        condMap.put("PRODNM", rpMap.get("prodNm"));

        List<Map<String, Object>> rsltList = saleService.selectMultiList(condMap);

        log.info(rsltList);
        return rsltList;
    }

}
