package co1.kr1.mono1.studydb1.service;

import co1.kr1.mono1.studydb1.dao.AreaSalesDao;
import co1.kr1.mono1.studydb1.model.AreaSalesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SaleService {

    @Autowired
    AreaSalesDao areaSalesDao;

    public AreaSalesDto selectSales(String areaCd) {
        return areaSalesDao.findAreaSales(areaCd);
    }


    public Map<String, Object> selectSalesMap(String areaCd) {
        return areaSalesDao.findAreaSalesMap(areaCd);
    }


    public Map<String, Object> selectMapList(Map<String, Object> condMap) {
        return areaSalesDao.findMsaleByMultiParm(condMap);
    }


    public List<Map<String, Object>> selectMultiList(Map<String, Object> condMap) {
        return areaSalesDao.findMsaleByMultiReturn(condMap);
    }
}
