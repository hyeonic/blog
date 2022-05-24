package me.hyeonic.subway.config;

import me.hyeonic.subway.dao.InMemoryStationDao;
import me.hyeonic.subway.dao.StationDao;
import me.hyeonic.subway.service.StationService;

public class AppConfig {

    public StationService stationService() {
        return new StationService(stationDao());
    }

    public StationDao stationDao() {
        return new InMemoryStationDao();
    }
}
