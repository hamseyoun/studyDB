package co1.kr1.mono1.studydb1.dao;

import co1.kr1.mono1.studydb1.model.AreaSalesDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AreaSalesDao {

    //메서드 시그니처: 접근제어자(public) + 리턴타입 + 메서드명 + 매개변수

    //1.
    public AreaSalesDto findAreaSales(String areaCd);


    //2.
    public Map<String, Object> findAreaSalesMap(String areaCd);


    //3.
    public Map<String, Object> findMsaleByMultiParm(Map<String, Object> condMap);


    //4.
    public List<Map<String, Object>> findMsaleByMultiReturn(Map<String, Object> condMap);
}
