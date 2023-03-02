package gdsc.MCIET.domain.items.service;

import gdsc.MCIET.domain.items.domain.Items;
import gdsc.MCIET.domain.items.domain.repository.ItemsRepository;
import gdsc.MCIET.domain.items.presentation.dto.request.SaveItemDto;
import gdsc.MCIET.domain.items.presentation.dto.response.RecommendItemDto;
import gdsc.MCIET.domain.items.presentation.dto.response.ShowItemDto;
import gdsc.MCIET.domain.user.domain.User;
import gdsc.MCIET.global.utils.UserUtilsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemsService {

    private final ItemsRepository itemsRepository;
    private final UserUtilsImpl userUtils;

    //아이템 저장하기
    public Long saveItem(SaveItemDto saveItemDto){
        User user = userUtils.findUser(saveItemDto.getEmail());
        return itemsRepository.save(Items.builder()
                .user(user)
                .name(saveItemDto.getName())
                .expirationDate(saveItemDto.getExpirationDate())
                .itemCategory(saveItemDto.getItemCategory())
                .build()
        ).getId();
    }

    //아이템 보여주기
    public List<ShowItemDto> showItems(String email){
        User user = userUtils.findUser(email);
        List<Items> itemsList = itemsRepository.findByUser(user);
        return itemsList.stream()
                .map(items -> new ShowItemDto(items))
                .collect(Collectors.toList());
    }

    //요리 추천 페이지 이름 보내주기
    public List<RecommendItemDto> sendItemName(String email){
        User user = userUtils.findUser(email);
        List<Items> itemsList = itemsRepository.findByUser(user);
        return itemsList.stream()
                .map(items -> new RecommendItemDto(items))
                .collect(Collectors.toList());
    }
}
