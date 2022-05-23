package me.hyeonic.subway.dto;

import me.hyeonic.subway.domain.Station;

public class StationRequest {

    private String name;

    private StationRequest() {
    }

    public StationRequest(Station station) {
        this.name = station.getName();
    }

    public String getName() {
        return name;
    }
}
