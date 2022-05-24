package me.hyeonic.springjdbcbatch.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import me.hyeonic.springjdbcbatch.domain.Station;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcTemplateStationDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateStationDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Station station) {
        String sql = "insert into STATION(name) values(?)";
        jdbcTemplate.update(sql, station.getName());
    }

    public void saveAll(List<Station> stations) {
        String sql = "insert into STATION(name) values(?)";

        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Station station = stations.get(i);
                ps.setString(1, station.getName());
            }

            @Override
            public int getBatchSize() {
                return stations.size();
            }
        });
    }
}
