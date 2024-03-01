package com.example.standardPractice.service.impl;

import com.example.standardPractice.dto.paginated.PaginatedItemResponseDTO;
import com.example.standardPractice.dto.request.ItemSaveRequestDTO;
import com.example.standardPractice.dto.response.ItemGetResponseDTO;
import com.example.standardPractice.entity.Item;
import com.example.standardPractice.exception.DuplicateException;
import com.example.standardPractice.exception.NotFoundException;
import com.example.standardPractice.repo.ItemRepo;
import com.example.standardPractice.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {
        Item item = modelMapper.map(itemSaveRequestDTO, Item.class);
        if (!itemRepo.existsById(item.getItemID())) {
            itemRepo.save(item);
            return item.getItemID() + " save Successfully";
        } else {
            throw new DuplicateException("Already Save Item for This ID");
        }
    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndState(String itemName) {
        boolean b = true;
        List<Item> items = itemRepo.getAllByItemNameEqualsAndActiveStateEquals(itemName, b);
        if (items.size() > 0) {
            List<ItemGetResponseDTO> itemGetResponseDTOList = modelMapper.map(items, new TypeToken<List<ItemGetResponseDTO>>() {
            }.getType());
            return itemGetResponseDTOList;
        } else {
            throw new NotFoundException("No Items Found for This Name");
        }
    }


    @Override
    public String updateItem(ItemSaveRequestDTO itemSaveRequestDTO) {
        Item item = modelMapper.map(itemSaveRequestDTO, Item.class);
        if (!itemRepo.existsById(item.getItemID())) {
            itemRepo.save(item);
            return item.getItemID() + " Updated Successfully";
        } else {
            throw new NotFoundException("No Items Found for This ID");
        }
    }

    @Override
    public String deleteCustomerByNameByActiveState(int itemId) {

        if (itemRepo.existsById(itemId)) {
            itemRepo.deleteById(itemId);
            return itemId + " Delete Successfully";
        } else {
            throw new NotFoundException("No Items Found for This ID");
        }
    }

    @Override
    public PaginatedItemResponseDTO getItemsByActiveStateWithPaginated(boolean activeState, int page, int size) {
        Page<Item> items=itemRepo.getItemByActiveState(activeState, PageRequest.of(page,size));

        if(items.getSize()<1){
            throw new NotFoundException("No Data Found");
        }

        long totalCount=itemRepo.countAllByActiveStateEquals(activeState);
        List<ItemGetResponseDTO> itemGetResponseDTOList = items.getContent().stream()
                .map(item -> modelMapper.map(item, ItemGetResponseDTO.class))
                .collect(Collectors.toList());

        PaginatedItemResponseDTO paginatedItemResponseDTO = new PaginatedItemResponseDTO();
        paginatedItemResponseDTO.setItemGetResponseDTOList(itemGetResponseDTOList);
        paginatedItemResponseDTO.setDataCount(totalCount);

        return paginatedItemResponseDTO;
    }
}


