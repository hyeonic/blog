package me.hyeonic.subway.service;

import static java.util.stream.Collectors.toList;

import java.util.List;
import me.hyeonic.subway.dao.StationDao;
import me.hyeonic.subway.domain.Station;
import me.hyeonic.subway.dto.StationRequest;
import me.hyeonic.subway.dto.StationResponse;

public class StationService {

    public static StationResponse save(StationRequest stationRequest) {
        Station newStation = StationDao.save(new Station(stationRequest.getName()));
        return new StationResponse(newStation);
    }

    public static List<StationResponse> findAll() {
        List<Station> stations = StationDao.findAll();

        return stations.stream()
                .map(StationResponse::new)
                .collect(toList());
    }

    public static void deleteById(Long id) {
        StationDao.deleteById(id);
    }
}
