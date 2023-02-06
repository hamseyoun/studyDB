package co1.kr1.mono1.studydb1.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DynamicSelectDao {

    public List<Map<String, Object>> subQueryInList(List<String> classId);

    public Map<String, Object> findGradeWithClassLike1(String name);
}
