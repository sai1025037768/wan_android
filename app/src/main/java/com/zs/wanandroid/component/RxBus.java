package com.zs.wanandroid.component;

import io.reactivex.Flowable;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.PublishProcessor;

/**
 * @author Administrator
 * @name wanandroid
 * @time 2018/10/9 18:23
 * @class describe
 */
public class RxBus {

    private final FlowableProcessor<Object> bus;

    public RxBus(){
        bus = PublishProcessor.create().toSerialized();
    }

    public static RxBus getDefault(){
        return RxBusHolder.INSTANCE;
    }

    private static class RxBusHolder{
        public static final RxBus INSTANCE = new RxBus();
    }

    /**
     * 添加一个新事件
     * @param o
     */
    public void post(Object o){
        bus.onNext(o);
    }

    /**
     * 根据传递的 eventType 类型返回特定的 eventType 被观察者
     * @param eventType
     * @param <T>
     * @return
     */
    public <T> Flowable<T> toFlowable(Class<T> eventType){
        return bus.ofType(eventType);
    }
}
