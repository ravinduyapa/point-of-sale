package com.example.standardPractice.service;

import com.example.standardPractice.dto.paginated.PaginatedItemResponseDTO;
import com.example.standardPractice.dto.request.ItemSaveRequestDTO;
import com.example.standardPractice.dto.response.ItemGetResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {

    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemGetResponseDTO> getItemByNameAndState(String itemName);



    String updateItem(ItemSaveRequestDTO itemSaveRequestDTO);

    String deleteCustomerByNameByActiveState(int itemId);

    PaginatedItemResponseDTO getItemsByActiveStateWithPaginated(boolean activeState, int page, int size);
}
