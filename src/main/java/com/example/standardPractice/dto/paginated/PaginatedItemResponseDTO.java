package com.example.standardPractice.dto.paginated;

import com.example.standardPractice.dto.response.ItemGetResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedItemResponseDTO {
    List<ItemGetResponseDTO> itemGetResponseDTOList;
    private long dataCount;
}
