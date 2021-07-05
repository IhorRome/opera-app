package opera.service.mapper;

import opera.dto.request.PerformanceSessionRequestDto;
import opera.dto.response.PerformanceSessionResponseDto;
import opera.model.PerformanceSession;
import opera.service.StageService;
import opera.service.PerformanceService;
import opera.util.DateTimePatternUtil;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class PerformanceSessionMapper implements RequestDtoMapper<PerformanceSessionRequestDto, PerformanceSession>,
        ResponseDtoMapper<PerformanceSessionResponseDto, PerformanceSession> {
    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern(DateTimePatternUtil.DATE_TIME_PATTERN);
    private final StageService stageService;
    private final PerformanceService performanceService;

    public PerformanceSessionMapper(StageService stageService, PerformanceService performanceService) {
        this.stageService = stageService;
        this.performanceService = performanceService;
    }

    @Override
    public PerformanceSession mapToModel(PerformanceSessionRequestDto dto) {
        PerformanceSession performanceSession = new PerformanceSession();
        performanceSession.setMovie(performanceService.get(dto.getMovieId()));
        performanceSession.setCinemaHall(stageService.get(dto.getCinemaHallId()));
        performanceSession.setShowTime(LocalDateTime.parse(dto.getShowTime(), formatter));
        return performanceSession;
    }

    @Override
    public PerformanceSessionResponseDto mapToDto(PerformanceSession performanceSession) {
        PerformanceSessionResponseDto responseDto = new PerformanceSessionResponseDto();
        responseDto.setMovieSessionId(performanceSession.getId());
        responseDto.setCinemaHallId(performanceSession.getCinemaHall().getId());
        responseDto.setMovieId(performanceSession.getMovie().getId());
        responseDto.setMovieTitle(performanceSession.getMovie().getTitle());
        responseDto.setShowTime(performanceSession.getShowTime().format(formatter));
        return responseDto;
    }
}
