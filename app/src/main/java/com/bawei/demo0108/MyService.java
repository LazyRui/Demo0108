package com.bawei.demo0108;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * ProjectName: Demo0108
 * PackageName: com.bawei.demo0108
 * ClassName:   MyService
 * Description: Java类的作用
 * Author: Lazy
 * CreateDate: 2020/1/8_8:52
 */
public interface MyService {

    @GET("small/order/verify/v1/findShoppingCart")
    Observable<Entity> getData(@Header("userId") String uid,@Header("sessionId") String sesid);
}
