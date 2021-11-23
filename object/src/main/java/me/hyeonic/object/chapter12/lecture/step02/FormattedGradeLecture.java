package me.hyeonic.object.chapter12.lecture.step02;

import java.util.List;

public class FormattedGradeLecture extends GradeLecture {
    public FormattedGradeLecture(String title, int pass, List<Grade> grades, List<Integer> scores) {
        super(title, pass, grades, scores);
    }

    public String formatAverage() {
        return String.format("Avg: %1.1f", super.average());
    }
}
