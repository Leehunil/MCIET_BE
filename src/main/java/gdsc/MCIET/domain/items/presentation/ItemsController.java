package gdsc.MCIET.domain.items.presentation;

import gdsc.MCIET.domain.items.presentation.dto.request.SaveItemDto;
import gdsc.MCIET.domain.items.presentation.dto.response.RecommendItemDto;
import gdsc.MCIET.domain.items.presentation.dto.response.ShowItemDto;
import gdsc.MCIET.domain.items.service.ItemsService;
import gdsc.MCIET.global.successResponse.ResponseMessage;
import gdsc.MCIET.global.successResponse.StatusCode;
import gdsc.MCIET.global.successResponse.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemsController {

    private final ItemsService itemsService;

    @PostMapping("/add")
    public ResponseEntity addItems(@RequestBody SaveItemDto saveItemDto){
        Long itemId = itemsService.saveItem(saveItemDto);
        return SuccessResponse.successtoResponseEntity(StatusCode.OK, itemId, ResponseMessage.SAVE_ITEM);
    }

    @GetMapping("/{email}/list")
    public ResponseEntity showItems(@PathVariable String email){
        List<ShowItemDto> result = itemsService.showItems(email);
        return SuccessResponse.successtoResponseEntity(StatusCode.OK, result, ResponseMessage.SHOW_ITEM_LIST);
    }

    @GetMapping("/{email}/recommend-list")
    public ResponseEntity showRecommendItems(@PathVariable String email){
        List<RecommendItemDto> result = itemsService.sendItemName(email);
        return SuccessResponse.successtoResponseEntity(StatusCode.OK, result, ResponseMessage.SHOW_ITEM_LIST);
    }
}
