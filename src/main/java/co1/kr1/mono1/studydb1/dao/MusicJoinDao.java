package co1.kr1.mono1.studydb1.dao;

import co1.kr1.mono1.studydb1.model.music.Album;
import co1.kr1.mono1.studydb1.model.music.Artist;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface MusicJoinDao {

    public List<Album> selectArtistByPrimaryKey1(String mst_id);

    public Artist selectArtistByPrimaryKey2(String mst_id);
}
