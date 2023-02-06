package co1.kr1.mono1.studydb1.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExamVO {
    private String name;
    private String className;
    private String grade;
    private int kor;
    private int eng;
    private int mat;
}