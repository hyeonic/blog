package me.hyeonic.tistory.domain.study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudyRepository {

    private static final StudyRepository studyRepository = new StudyRepository();
    private static final Map<Long, Study> studyMap = new HashMap<>();
    private static long count;

    private StudyRepository() { }

    public static StudyRepository getInstance() {
        return studyRepository;
    }

    public Long save(String name) {
        Study savedStudy = new Study(count, name);
        studyMap.put(count, savedStudy);
        count++;

        return savedStudy.getId();
    }

    public Study findById(Long id) {
        return studyMap.get(id);
    }

    public List<Study> findStudies() {
        return new ArrayList<>(studyMap.values());
    }
}