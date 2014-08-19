package com.xywy.drug.engine.medicine;

/**
 * Created by Administrator on 2014/8/16.
 */
public interface MedicineFetcherListener<T> {
    public void handleMedicineFetchResult(boolean result, T data);
}
