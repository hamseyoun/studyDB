package co1.kr1.mono1.studydb1.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AreaSalesDto {

    private String areaCd;
    private String regionArea;
    private String prodId;
    private int saleCnt;
}
