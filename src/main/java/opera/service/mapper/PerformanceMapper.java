package opera.service.mapper;

import opera.dto.request.PerformanceRequestDto;
import opera.dto.response.PerformanceResponseDto;
import opera.model.Performance;
import org.springframework.stereotype.Component;

@Component
public class PerformanceMapper implements RequestDtoMapper<PerformanceRequestDto, Performance>,
        ResponseDtoMapper<PerformanceResponseDto, Performance> {
    @Override
    public Performance mapToModel(PerformanceRequestDto dto) {
        Performance performance = new Performance();
        performance.setTitle(dto.getMovieTitle());
        performance.setDescription(dto.getMovieDescription());
        return performance;
    }

    @Override
    public PerformanceResponseDto mapToDto(Performance performance) {
        PerformanceResponseDto responseDto = new PerformanceResponseDto();
        responseDto.setMovieId(performance.getId());
        responseDto.setMovieTitle(performance.getTitle());
        responseDto.setMovieDescription(performance.getDescription());
        return responseDto;
    }
}
