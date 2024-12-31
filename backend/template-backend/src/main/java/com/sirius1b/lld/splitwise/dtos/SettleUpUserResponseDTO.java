package com.sirius1b.lld.splitwise.dtos;


import com.sirius1b.lld.splitwise.models.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpUserResponseDTO {
    private ResponseStatus responseStatus;
    private List<Transaction> transactions;
}
