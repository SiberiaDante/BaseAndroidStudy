package com.dante.designpattern.factory.simple;

/**
 * create date: 2018/11/6
 */
public class StudyFactory {
    public static final int STUDY_JAVA = 0x01;
    public static final int STUDY_PHP = 0x02;

    public StudySchool getStudyType(int type) {
        switch (type) {
            case STUDY_JAVA:
                return new StudyJava();
            case STUDY_PHP:
                return new StudyPhp();
            default:
                return null;
        }
    }
}
