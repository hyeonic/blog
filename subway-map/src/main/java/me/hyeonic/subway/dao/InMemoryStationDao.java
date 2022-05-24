package me.hyeonic.subway.dao;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import me.hyeonic.subway.domain.Station;
import org.springframework.stereotype.Repository;
import org.springframework.util.ReflectionUtils;

@Repository
public class InMemoryStationDao implements StationDao {

    private static Long seq = 0L;
    private static Map<Long, Station> stations = new HashMap<>();

    public Station save(Station station) {
        Station persistStation = createNewObject(station);
        stations.put(station.getId(), persistStation);
        return persistStation;
    }

    public List<Station> findAll() {
        return new ArrayList<>(stations.values());
    }

    public void deleteById(Long id) {
        if (!stations.containsKey(id)) {
            throw new NoSuchElementException(id + "의 지하철역은 존재하지 않습니다.");
        }

        stations.remove(id);
    }

    private Station createNewObject(Station station) {
        Field field = ReflectionUtils.findField(Station.class, "id");
        field.setAccessible(true);
        ReflectionUtils.setField(field, station, ++seq);
        return station;
    }
}
