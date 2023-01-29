package co1.kr1.mono1.studydb1.controller;

import co1.kr1.mono1.studydb1.model.music.Album;
import co1.kr1.mono1.studydb1.model.music.Artist;
import co1.kr1.mono1.studydb1.service.MusicJoinService;
import lombok.Getter;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
public class MusicController {

    @Autowired
    private MusicJoinService musicJoinService;

    @GetMapping("/albumList/{artistId}")
    public List<Album> albumList(@PathVariable String artistId) {
        List<Album> albums = musicJoinService.searchArtistList(artistId);
        log.info(albums);
        return albums;
    }


    @GetMapping("/artist/{artistId}")
    public Artist artist(@PathVariable String artistId) {
        Artist artists = musicJoinService.searchArtist(artistId);
        log.info(artists);
        return artists;
    }
}
