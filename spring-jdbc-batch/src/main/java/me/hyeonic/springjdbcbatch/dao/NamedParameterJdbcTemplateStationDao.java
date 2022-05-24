package me.hyeonic.springjdbcbatch.dao;

import java.util.List;
import me.hyeonic.springjdbcbatch.domain.Station;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

@Repository
public class NamedParameterJdbcTemplateStationDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public NamedParameterJdbcTemplateStationDao(JdbcTemplate jdbcTemplate) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
    }

    public void save(Station station) {
        String sql = "insert into STATION (name) values (:name)";
        SqlParameterSource params = new MapSqlParameterSource("name", station.getName());
        namedParameterJdbcTemplate.update(sql, params);
    }

    public void saveAll(List<Station> stations) {
        String sql = "insert into STATION (name) values (:name)";
//        SqlParameterSource[] batch = generateParameters(stations);
//        namedParameterJdbcTemplate.batchUpdate(sql, batch);
        namedParameterJdbcTemplate.batchUpdate(sql, SqlParameterSourceUtils.createBatch(stations));
    }

    private SqlParameterSource[] generateParameters(List<Station> stations) {
        return stations.stream()
                .map(this::generateParameter)
                .toArray(SqlParameterSource[]::new);
    }

    private SqlParameterSource generateParameter(Station station) {
        return new MapSqlParameterSource("name", station.getName());
    }
}
