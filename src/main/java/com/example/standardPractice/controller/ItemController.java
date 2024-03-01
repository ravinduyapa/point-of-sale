package com.example.standardPractice.controller;

import com.example.standardPractice.dto.paginated.PaginatedItemResponseDTO;
import com.example.standardPractice.dto.request.ItemSaveRequestDTO;
import com.example.standardPractice.dto.response.ItemGetResponseDTO;
import com.example.standardPractice.service.ItemService;
import com.example.standardPractice.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PutMapping(value = "/update")
    public ResponseEntity<StandardResponse>UpdateItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO) {
        String message = itemService.updateItem(itemSaveRequestDTO);
        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
                new StandardResponse(101, "Success", message), HttpStatus.CREATED
        );
        return response;
    }
    @PostMapping(value = "/save")
    public ResponseEntity<StandardResponse> SaveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO) {
        String message = itemService.saveItem(itemSaveRequestDTO);
        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
                new StandardResponse(102, "Success", message), HttpStatus.CREATED
        );
        return response;
    }


    @GetMapping (value = "/get-by-name",
                params = "name")
    public ResponseEntity<StandardResponse> getItemByNameAndState(@RequestParam(value = "name")String itemName){
        List<ItemGetResponseDTO> itemGetResponseDTOList=itemService.getItemByNameAndState(itemName);
        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
                new StandardResponse(103, "Success", itemGetResponseDTOList), HttpStatus.ACCEPTED
        );
        return response;
    }
    @GetMapping (value = "/get-all-item",
                 params = {"activeState","page","size"})
    public ResponseEntity<StandardResponse> getAllItemByActiveState(
            @RequestParam(value = "activeState")boolean activeState,
            @RequestParam(value = "page")int page,
            @RequestParam(value = "size")int size){
        PaginatedItemResponseDTO paginatedItemResponseDTO=itemService.getItemsByActiveStateWithPaginated(activeState,page,size);
        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
                new StandardResponse(104, "Success", paginatedItemResponseDTO), HttpStatus.ACCEPTED
        );
        return response;
    }

    @DeleteMapping(value = "/delete-item-by-name",
            params = "id")
    public ResponseEntity<StandardResponse> deleteCustomerByNameByActiveState(@RequestParam(value = "id")int itemId) {
        String message = itemService.deleteCustomerByNameByActiveState(itemId);
        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
                new StandardResponse(105, "Delete Success", message), HttpStatus.OK
        );
        return response;

    }


}
