package ru.ecom.ecommerce.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.ecom.ecommerce.model.BasketDetail;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class BasketDTO {

    private long id;
    private List<BasketDetail> basketDetailList;

}