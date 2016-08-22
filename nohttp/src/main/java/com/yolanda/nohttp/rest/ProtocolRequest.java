/*
 * Copyright © Yan Zhenjie. All Rights Reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yolanda.nohttp.rest;

import android.text.TextUtils;

import com.yolanda.nohttp.BasicRequest;
import com.yolanda.nohttp.RequestMethod;

/**
 * <p>For the Request to encapsulate some Http protocol related properties.</p>
 * Created by YOLANDA on 2016/8/20.
 */
public abstract class ProtocolRequest extends BasicRequest implements IProtocolRequest {

    /**
     * Cache key.
     */
    private String mCacheKey;
    /**
     * If just read from cache.
     */
    private CacheMode mCacheMode = CacheMode.DEFAULT;

    /**
     * Create a request, RequestMethod is {@link RequestMethod#GET}.
     *
     * @param url request address, like: http://www.google.com.
     */
    public ProtocolRequest(String url) {
        this(url, RequestMethod.GET);
    }

    /**
     * Create a request
     *
     * @param url           request address, like: http://www.google.com.
     * @param requestMethod request method, like {@link RequestMethod#GET}, {@link RequestMethod#POST}.
     */
    public ProtocolRequest(String url, RequestMethod requestMethod) {
        super(url, requestMethod);
    }

    @Override
    public void setCacheKey(String key) {
        this.mCacheKey = key;
    }

    @Override
    public String getCacheKey() {
        return TextUtils.isEmpty(mCacheKey) ? url() : mCacheKey;
    }

    @Override
    public void setCacheMode(CacheMode cacheMode) {
        this.mCacheMode = cacheMode;
    }

    @Override
    public CacheMode getCacheMode() {
        return mCacheMode;
    }

}
