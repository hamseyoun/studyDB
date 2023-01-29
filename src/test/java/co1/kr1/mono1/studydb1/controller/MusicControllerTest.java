package co1.kr1.mono1.studydb1.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.function.IntUnaryOperator;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class MusicControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void selectAlbumListTest() throws Exception{
        this.mockMvc.perform(get("/albumList/BTS"))
                .andDo(print());
    }


    @Test
    public void selectArtistTest() throws Exception{
        this.mockMvc.perform(get("/artist/BTS"))
                .andDo(print());
    }
}