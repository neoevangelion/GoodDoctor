package com.xywy.drug.engine.account;

/**
 * Created by Administrator on 2014/8/19.
 */
public interface SessionIdCache {
    public void save(String sessionId);

    public String restore();
}
