package co1.kr1.mono1.studydb1.service;

import co1.kr1.mono1.studydb1.dao.MusicJoinDao;
import co1.kr1.mono1.studydb1.model.music.Album;
import co1.kr1.mono1.studydb1.model.music.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.metal.MetalSeparatorUI;
import java.util.List;

@Service
public class MusicJoinService {

    @Autowired
    MusicJoinDao musicJoinDao;

    public List<Album> searchArtistList(String mst_id) {
        return musicJoinDao.selectArtistByPrimaryKey1(mst_id);
    }

    public Artist searchArtist(String mst_id) {
        return musicJoinDao.selectArtistByPrimaryKey2(mst_id);
    }

}
