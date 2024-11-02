package model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatsResponse {
    private Long countMutantDna;
    private Long countHumanDna;
    private Double ratio;
}
