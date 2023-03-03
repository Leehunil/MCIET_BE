package gdsc.MCIET.domain.cuisine.service;

import gdsc.MCIET.domain.cuisine.domain.repository.CuisineRepository;
import gdsc.MCIET.global.utils.UserUtilsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CuisineService {

    private final CuisineRepository cuisineRepository;
    private final UserUtilsImpl userUtils;

    //
}
