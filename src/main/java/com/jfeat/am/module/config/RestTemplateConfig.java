package com.jfeat.am.module.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.Assert;
import org.springframework.web.client.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URI;

@Configuration
public class RestTemplateConfig {

    @Resource(name = "simpleClientHttpRequestFactory")
    ClientHttpRequestFactory factory;
    //配置RestTemplate

    @Bean
    public RestTemplate restTemplate(){

        return new RestTemplate(factory){



            //重写执行方法，取消httpCode的判断
            @Override
            protected <T> T doExecute(URI url, HttpMethod method, RequestCallback requestCallback,
                                      ResponseExtractor<T> responseExtractor) throws RestClientException {

                Assert.notNull(url, "'url' must not be null");
                Assert.notNull(method, "'method' must not be null");
                ClientHttpResponse response = null;
                try {
                    ClientHttpRequest request = createRequest(url, method);
                    if (requestCallback != null) {
                        requestCallback.doWithRequest(request);
                    }
                    response = request.execute();
                    //取消验证
                    //handleResponse(url, method, response);
                    if (responseExtractor != null) {
                        return responseExtractor.extractData(response);
                    }
                    else {
                        return null;
                    }
                }
                catch (IOException ex) {
                    String resource = url.toString();
                    String query = url.getRawQuery();
                    resource = (query != null ? resource.substring(0, resource.indexOf(query) - 1) : resource);
                    throw new ResourceAccessException("I/O error on " + method.name() +
                            " request for \"" + resource + "\": " + ex.getMessage(), ex);
                }
                finally {
                    if (response != null) {
                        response.close();
                    }
                }
            }
        };
    }


    @Bean("simpleClientHttpRequestFactory")
    public ClientHttpRequestFactory simpleClientHttpRequestFactory(){

        //创建一个简单工厂
        SimpleClientHttpRequestFactory factory=new SimpleClientHttpRequestFactory();

        //链接超时设置
        factory.setConnectTimeout(15000);

        //读取超时设置
        factory.setReadTimeout(5000);

        return factory;

    }



}
