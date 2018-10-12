package com.zs.wanandroid.utils;

import com.zs.wanandroid.core.bean.BaseResponse;
import com.zs.wanandroid.core.http.exception.OtherException;

import org.reactivestreams.Publisher;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Administrator
 * @name wanandroid
 * @time 2018/10/8 14:13
 * @class describe
 */
public class RxUtils {

    /**
     * 统一线程调度
     * @return
     */
    public static <T> FlowableTransformer<T, T> rxFlSchedulerHelper(){
        return new FlowableTransformer<T, T>() {
            @Override
            public Publisher<T> apply(Flowable<T> flowable) {
                return flowable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };

    }

    /**
     * 统一线程调度
     * @return
     */
    public static <T> ObservableTransformer<T, T> rxSchedulerHelper(){
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };

    }

    /**
     * 统一处理返回结果
     *
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<BaseResponse<T>, T> handleResult() {

        return new ObservableTransformer<BaseResponse<T>, T>() {

            @Override
            public ObservableSource<T> apply(Observable<BaseResponse<T>> baseResponseObservable) {

                return baseResponseObservable.flatMap(new Function<BaseResponse<T>, Observable<T>>() {
                    @Override
                    public Observable<T> apply(BaseResponse<T> baseResponse) throws Exception {
                        if (baseResponse.getErrorCode() == BaseResponse.SUCCESS
                                && baseResponse.getData() != null
                                && CommonUtils.isNetworkConnected()) {
                            return createResultData(baseResponse.getData());
                        } else {
                            return Observable.error(new OtherException());
                        }


                    }
                });

            }


        };

    }


    /**
     * 得到返回具体数据的Observable
     * @param t
     * @return
     */
    private static <T> Observable<T> createResultData(T t) {
        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> emitter) throws Exception {
                try {
                    emitter.onNext(t);
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }

            }
        });
    }
}
