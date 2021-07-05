package opera.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class PerformanceSessionRequestDto {
    @Positive
    private Long performanceId;
    @Positive
    private Long cinemaHallId;
    @NotNull
    private String showTime;

    public Long getPerformanceId() {
        return performanceId;
    }

    public Long getCinemaHallId() {
        return cinemaHallId;
    }

    public String getShowTime() {
        return showTime;
    }
}
