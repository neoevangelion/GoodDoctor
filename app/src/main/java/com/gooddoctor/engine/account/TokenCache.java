package com.gooddoctor.engine.account;

/**
 * Created by Administrator on 2014/8/16.
 */
public interface TokenCache {
    public void save(Token token);

    public Token restore();
}
