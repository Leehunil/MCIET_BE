package gdsc.MCIET.domain.cuisine.service;

import gdsc.MCIET.domain.cuisine.domain.Cuisine;
import gdsc.MCIET.domain.cuisine.domain.repository.CuisineRepository;
import gdsc.MCIET.domain.cuisine.exception.CuisineNotFound;
import gdsc.MCIET.domain.cuisine.presentation.dto.request.SaveCuisineDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CuisineService implements CuisineUtils{

    private final CuisineRepository cuisineRepository;

    //요리 저장
    public Long saveCuisine(SaveCuisineDto saveCuisineDto){
        return cuisineRepository.save(Cuisine.builder()
                .title(saveCuisineDto.getTitle())
                .ingredients(saveCuisineDto.getIngredients())
                .build()).getId();
    }


    @Override
    public Cuisine findCuisine(Long id) {
        return cuisineRepository.findById(id).orElseThrow(() -> CuisineNotFound.EXCEPTION);
    }
}
