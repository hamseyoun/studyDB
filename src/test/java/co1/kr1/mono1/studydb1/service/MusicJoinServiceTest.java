package co1.kr1.mono1.studydb1.service;

import co1.kr1.mono1.studydb1.model.music.Album;
import co1.kr1.mono1.studydb1.model.music.Artist;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class MusicJoinServiceTest {

    @Autowired
    MusicJoinService musicJoinService;

    ObjectMapper mapper;

    @BeforeEach
    void setup() {
        mapper = new ObjectMapper();
    }


    @Test
    @DisplayName("")
    public void albumList() throws JsonProcessingException {
        List<Album> albumList = musicJoinService.searchArtistList("BTS");
        log.info("JSON 변환: {}", mapper.writeValueAsString(albumList));
    }


    @Test
    @DisplayName("")
    public void searchArtist() throws JsonProcessingException {
        Artist artist = musicJoinService.searchArtist("BTS");
        log.info("JSON 변환: {}", mapper.writeValueAsString(artist));
    }
}