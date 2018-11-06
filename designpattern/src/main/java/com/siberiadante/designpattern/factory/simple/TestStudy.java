package com.siberiadante.designpattern.factory.simple;

/**
 * create date: 2018/11/6
 */
public class TestStudy {
    private void test() {
        StudyFactory studyFactory = new StudyFactory();
        //学习Java
        StudySchool studyTypeJava = studyFactory.getStudyType(StudyFactory.STUDY_JAVA);
        studyTypeJava.study();
        //学习PHP
        StudySchool studyTypePhp = studyFactory.getStudyType(StudyFactory.STUDY_PHP);
        studyTypePhp.study();
    }
}
