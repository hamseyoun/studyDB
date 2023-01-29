package co1.kr1.mono1.studydb1.model.music;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Song {

    private String albumId;

    private String songName;

    private Float playTime;
}
