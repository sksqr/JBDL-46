package org.example.service;

import org.example.dto.TransactionInitPayload;
import org.example.dto.TransactionRequest;
import org.example.dto.TxnStatusDto;
import org.example.dto.UserCreatedPayload;
import org.example.entity.Transaction;
import org.example.entity.TransactionStatus;
import org.example.repo.TransactionRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Service
public class TransactionService {


    private static Logger LOGGER = LoggerFactory.getLogger(TransactionService.class);

    private static String TXN_INIT_TOPIC = "TXN_INIT";

    @Autowired
    private TransactionRepo transactionRepo;

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;


    public TxnStatusDto getStatus(String txnId){
        Transaction transaction = transactionRepo.findByTxnId(txnId);
        TxnStatusDto txnStatusDto = new TxnStatusDto(transaction.getStatus().name(), transaction.getReason());
        return  txnStatusDto;
    }

    public String doTransaction(TransactionRequest request){
        Transaction transaction = Transaction.builder()
                .fromUserId(request.getFromUserId())
                .toUserId(request.getToUserId())
                .amount(request.getAmount())
                .remark(request.getRemark())
                .status(TransactionStatus.PENDING)
                .txnId(UUID.randomUUID().toString())
                .build();
        transactionRepo.save(transaction);
        TransactionInitPayload transactionInitPayload = new TransactionInitPayload(transaction.getId(),transaction.getFromUserId(), transaction.getToUserId(), transaction.getAmount(), MDC.get("requestId"));
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(TXN_INIT_TOPIC,String.valueOf(transaction.getFromUserId()),transactionInitPayload);
        try {
            LOGGER.info("Pushed data to kafka, response : {} ",future.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        return transaction.getTxnId();
    }
}
