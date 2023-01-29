package co1.kr1.mono1.studydb1.model.music;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Artist {

    private String mstId;

    private String mstName;

    private String debutDate;

//    @JsonIgnore
    private List<Album> album;
}
