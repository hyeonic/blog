package me.hyeonic.subway.dao;

import java.util.List;
import me.hyeonic.subway.domain.Station;

public interface StationDao {

    Station save(Station station);

    List<Station> findAll();

    void deleteById(Long id);
}
