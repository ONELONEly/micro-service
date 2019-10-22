package com.yhm.microserviceclient.base.controller.command;

import com.netflix.hystrix.HystrixObservableCommand;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Subscriber;

public class UserObservableCommand extends HystrixObservableCommand<String> {

    private RestTemplate template;
    private int id;

    protected UserObservableCommand(Setter setter, RestTemplate template, int id) {
        super(setter);
        this.template = template;
        this.id = id;
    }

    @Override
    protected Observable<String> construct() {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    if (subscriber.isUnsubscribed()) {
                        String s = template.getForObject("http://microServiceClient/{1}", String.class, id);
                        subscriber.onNext(s);
                        subscriber.onCompleted();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
