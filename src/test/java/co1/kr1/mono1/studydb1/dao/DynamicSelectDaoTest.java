package co1.kr1.mono1.studydb1.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
}