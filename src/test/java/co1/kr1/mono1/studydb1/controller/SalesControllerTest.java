package co1.kr1.mono1.studydb1.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class SalesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void saleListTest() throws Exception {
        this.mockMvc.perform(get("/saleList/10"))
                .andDo(print());
    }


    @Test
    public void salesMapTest() throws Exception {
        this.mockMvc.perform(get("/salemap/10"))
                .andExpect(jsonPath("$.AREACD").value("10"))
                .andExpect(jsonPath("$.REGIONAREA").value("GER"))
                .andExpect(jsonPath("$.SALECNT").value("9"))
                .andDo(print());
    }


    //숙제
    @Test
    public void SalesMapParamTest() throws Exception{
        this.mockMvc.perform(get("/saleMapList?prodId=10&prodNm=냉장고"))
                .andDo(print());
    }

    @Test
    public void SalesMapParamMultiTest() throws Exception{
        this.mockMvc.perform(get("/multiList?prodId=10&prodNm=냉장고"))
                .andDo(print());
    }
}