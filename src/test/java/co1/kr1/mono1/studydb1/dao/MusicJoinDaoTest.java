package co1.kr1.mono1.studydb1.dao;

import co1.kr1.mono1.studydb1.model.music.Album;
import co1.kr1.mono1.studydb1.model.music.Artist;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;


//replace 가 any이면 기본으로 내장된 DB사용 //none이면 내가 따로 설정한 DB 사용
@MybatisTest    //mybatis-spring-boot-starter-test 를 dependency에 따로 추가해줘야한다.
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MusicJoinDaoTest {

    @Autowired
    MusicJoinDao musicJoinDao;

    @Test
    @DisplayName("album -> artist 매핑(Association Mapping")
        //has one 매핑
    void selectArtistByPrimaryKey1Test() {
        List<Album> album = musicJoinDao.selectArtistByPrimaryKey1("BTS");
        album.forEach(System.out::println);
    }


    @Test
    @DisplayName("artist -> album 매핑(Collection Mapping)")
    void selectArtistByPrimaryKey2Test() {
        Artist artist = musicJoinDao.selectArtistByPrimaryKey2("BTS");
        System.out.println("artist = " + artist);
    }
}