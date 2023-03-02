package gdsc.MCIET.domain.items.presentation;

import gdsc.MCIET.domain.items.presentation.dto.request.SaveItemDto;
import gdsc.MCIET.domain.items.service.ItemsService;
import gdsc.MCIET.global.successResponse.ResponseMessage;
import gdsc.MCIET.global.successResponse.StatusCode;
import gdsc.MCIET.global.successResponse.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
