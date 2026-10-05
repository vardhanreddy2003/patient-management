package com.pm.billingservice.grpc;


import billing.BillingServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@GrpcService
public class BillingGrpcService extends BillingServiceGrpc.BillingServiceImplBase {

    private static  final Logger log= LoggerFactory.getLogger(
            BillingGrpcService.class);

    public BillingGrpcService() {
        log.info(">>> BillingGrpcService CREATED <<<");
    }
    @Override
    public void createBillingAccount(billing.BillingRequest billingRequest, StreamObserver<billing.BillingResponse> responseObserver)
    {
        System.out.println("hey came here");
        log.info("create billing account request received{}",billingRequest.toString());

        billing.BillingResponse response= billing.BillingResponse.newBuilder().setAccountId("12345").setStatus("Active").build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
