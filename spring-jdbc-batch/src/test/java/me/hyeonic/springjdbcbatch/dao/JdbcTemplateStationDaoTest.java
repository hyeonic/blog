package me.hyeonic.springjdbcbatch.dao;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.IntStream;
import me.hyeonic.springjdbcbatch.domain.Station;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

@JdbcTest
class JdbcTemplateStationDaoTest {

    private final JdbcTemplateStationDao jdbcTemplateStationDao;

    @Autowired
    public JdbcTemplateStationDaoTest(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplateStationDao = new JdbcTemplateStationDao(jdbcTemplate);
    }

    @DisplayName("batch 사용하지 않고 저장한다.")
    @Test
    void batch_사용하지_않고_저장한다() {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            String name = String.valueOf(i);
            jdbcTemplateStationDao.save(new Station(name));
        }

        long end = System.currentTimeMillis();
        System.out.println("수행시간: " + (end - start) + " ms");
    }

    @DisplayName("batch 사용하고 저장한다.")
    @Test
    void batch_사용하여_저장한다() {
        long start = System.currentTimeMillis();

        List<Station> stations = IntStream.range(0, 10000)
                .mapToObj(String::valueOf)
                .map(Station::new)
                .collect(toList());

        jdbcTemplateStationDao.saveAll(stations);

        long end = System.currentTimeMillis();
        System.out.println("수행시간: " + (end - start) + " ms");
    }
}
