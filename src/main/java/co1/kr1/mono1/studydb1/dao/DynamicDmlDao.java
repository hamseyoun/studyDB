package co1.kr1.mono1.studydb1.dao;

import co1.kr1.mono1.studydb1.model.ExamVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DynamicDmlDao {

    public void insertOne(ExamVO examVO);
}
