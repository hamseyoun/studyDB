package co1.kr1.mono1.studydb1.dao;

import co1.kr1.mono1.studydb1.model.ExamVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DynamicDmlDaoTest {

    @Autowired
    DynamicDmlDao dynamicDmlDao;

    @Test
    @DisplayName("한 건 insert")
    public void insertOne() {
        ExamVO examVO = new ExamVO("함세윤", "별림반", "3", 100, 90, 80);
        dynamicDmlDao.insertOne(examVO);

    }
}