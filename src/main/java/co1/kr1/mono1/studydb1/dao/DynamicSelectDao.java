package co1.kr1.mono1.studydb1.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DynamicSelectDao {

    public List<Map<String, Object>> subQueryInList(List<String> classId);

    public Map<String, Object> findGradeWithClassLike1(String name);

    public List<Map<String, Object>> findGradeWithClassLike2(Map<String, String> gradeAndName);

    public List<Map<String, Object>> findExamTrim(Map<String, String> nameAndGrade);

    public <K, V> List<Map<String, Object>> findChooseExam(Map<K, V> condition);    //위의 findExamTrim과 같은 의미의 generic메서드이다.
}
