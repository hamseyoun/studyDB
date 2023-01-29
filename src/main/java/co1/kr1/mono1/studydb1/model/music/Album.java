package co1.kr1.mono1.studydb1.model.music;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Album {

    private String albumId;

//    @JsonIgnore   //  --> JSON으로 변환 시 이 어노테이션이 붙은 것은 무시한다.
    private String mstId;

    private int albumSeq;

    private String albumTitle;

    private String openDate;

    private Artist artist;

    private List<Song> songs;
}
