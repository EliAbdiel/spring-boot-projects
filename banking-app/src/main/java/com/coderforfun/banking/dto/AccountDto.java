package com.coderforfun.banking.dto;

public record AccountDto(Long id,
                         String accountHolderName,
                         double balance) {
}
