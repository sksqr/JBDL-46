package org.gfg;

public enum LectureStatus {
    UPCOMING("UPCOMING"), LIVE("LIVE"), ARCHIVED("ARCHIVED");
    private String value;

    private LectureStatus(String value) {
        this.value = value;
    }
}
