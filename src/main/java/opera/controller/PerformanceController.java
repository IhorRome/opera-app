package opera.controller;

import opera.dto.request.PerformanceRequestDto;
import opera.dto.response.PerformanceResponseDto;
import opera.model.Performance;
import opera.service.PerformanceService;
import opera.service.mapper.PerformanceMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/performances")
public class PerformanceController {
    private final PerformanceService performanceService;
    private final PerformanceMapper performanceMapper;

    public PerformanceController(PerformanceService performanceService, PerformanceMapper performanceMapper) {
        this.performanceService = performanceService;
        this.performanceMapper = performanceMapper;
    }

    @PostMapping
    public PerformanceResponseDto add(@RequestBody @Valid PerformanceRequestDto requestDto) {
        Performance performance = performanceService.add(performanceMapper.mapToModel(requestDto));
        return performanceMapper.mapToDto(performance);
    }

    @GetMapping
    public List<PerformanceResponseDto> getAll() {
        return performanceService.getAll()
                .stream()
                .map(performanceMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
