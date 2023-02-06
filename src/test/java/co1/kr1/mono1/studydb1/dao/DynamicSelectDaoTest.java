package co1.kr1.mono1.studydb1.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DynamicSelectDaoTest {

    @Autowired
    DynamicSelectDao dynamicSelectDao;

    @Test
    @DisplayName("")
    void subQueryInListTest() throws JsonProcessingException {
        List<String> classId = new ArrayList<String>(Arrays.asList("별림반", "달림반"));
        List<Map<String, Object>> rslt = dynamicSelectDao.subQueryInList(classId);
    }

    @Test
    @DisplayName("where if-test 동적 sql 생성")
    void findGradeWithClassLike1() throws JsonProcessingException {
        String name = "송해";
        dynamicSelectDao.findGradeWithClassLike1(name)
                .forEach((key, val) -> System.out.println(String.format("key: %s, val: %s", key, val)));

        name = null;
        dynamicSelectDao.findGradeWithClassLike1(name)
                .forEach((key, val) -> System.out.println(String.format("key: %s, val: %s", key, val)));
    }

    @Test
    @DisplayName("where if-test where 1=1 동적 sql 생성")
    void findGradeWithClassLike2() throws JsonProcessingException {

        Map<String, String> gradeAndNames = new HashMap<>();
        dynamicSelectDao.findGradeWithClassLike2(gradeAndNames)
                .forEach(gradeAndName -> gradeAndName.forEach((key, val) ->
                        System.out.println(String.format("key: %s, val: %s", key, val))));

        gradeAndNames.put("grade", "3");
        dynamicSelectDao.findGradeWithClassLike2(gradeAndNames)
                .forEach(user -> user.forEach((key, val) ->
                        System.out.println(String.format("key: %s, val: %s", key, val))));

        gradeAndNames.put("name", "이순신");
        dynamicSelectDao.findGradeWithClassLike2(gradeAndNames)
                .forEach(user -> user.forEach((key, val) ->
                        System.out.println(String.format("key: %s, val: %s", key, val))));
    }


    @Test
    @DisplayName("trim 테스트")
    void findExamTrim() throws JsonProcessingException {

        Map<String, String> parameter = new HashMap<>();
        parameter.put("grade", "3");
        dynamicSelectDao.findExamTrim(parameter)
                .forEach(user -> user.forEach((key, val) ->
                        System.out.println(String.format("key: %s, val: %s", key, val))));
    }

    @Test
    @DisplayName("where chooseCase 동적 sql 생성")
    void findChooseExam() throws JsonProcessingException {
        Map<String, String> parameter = new HashMap<>();
        findResultListMap(dynamicSelectDao, null);

        parameter.put("grade", "3");
        findResultListMap(dynamicSelectDao, parameter);

        parameter.put("name", "이정우");
        findResultListMap(dynamicSelectDao, parameter);
    }

    public static <K, V> void findResultListMap(DynamicSelectDao dynamicSelectDao, Map<K, V> parameter) {
        dynamicSelectDao.findChooseExam(parameter)
                .forEach(user -> user.forEach((key, val) ->
                        System.out.println(String.format("key: %s, val: %s", key, val))));
    }

}