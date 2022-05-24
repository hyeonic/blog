package me.hyeonic.subway.service;

import static java.util.stream.Collectors.toList;

import java.util.List;
import me.hyeonic.subway.dao.StationDao;
import me.hyeonic.subway.domain.Station;
import me.hyeonic.subway.dto.StationRequest;
import me.hyeonic.subway.dto.StationResponse;
import org.springframework.stereotype.Service;

@Service
public class StationService {

    private final StationDao stationDao;

    public StationService(StationDao stationDao) {
        this.stationDao = stationDao;
    }

    public StationResponse save(StationRequest stationRequest) {
        Station newStation = stationDao.save(new Station(stationRequest.getName()));
        return new StationResponse(newStation);
    }

    public List<StationResponse> findAll() {
        List<Station> stations = stationDao.findAll();

        return stations.stream()
                .map(StationResponse::new)
                .collect(toList());
    }

    public void deleteById(Long id) {
        stationDao.deleteById(id);
    }
}
