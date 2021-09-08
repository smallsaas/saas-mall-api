package com.jfeat.am.module.order.services.domain.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jfeat.am.module.config.MyMappingJackson2HttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URL;
import java.util.Map;

/**
 * 用于访问远端方法的工具类
 * 访问https的时候 忽略了证书的验证
 * */
@Configuration
public class HttpUtil {

	@Resource
	RestTemplate restTemplate;

	/**
	 * 获取基本header
	 *
	 * @return
	 */
	public  HttpHeaders getNormalHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/x-www-form-urlencoded");
		headers.add("Accept", "*/*");
		headers.add("connection", "Keep-Alive");
		return headers;
	}
	/**
	 * 主要方法
	 */
	public  JSONObject getResponse(String serverUrl, HttpMethod method, MultiValueMap<String,Object> map) {
/*		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		requestFactory.setOutputStreaming(false);
		requestFactory.setConnectTimeout(1000*60*2);
		RestTemplate rest = new RestTemplate(requestFactory);*/
		HttpHeaders normalHttpHeaders = getNormalHttpHeaders();
		HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity(map, normalHttpHeaders);
		restTemplate.getMessageConverters().add(new MyMappingJackson2HttpMessageConverter());
		String body = restTemplate.postForObject(serverUrl, httpEntity, String.class);
		/* String body = responseEntity.getBody();*/
		//依赖中没有引入 索性返回string 用的时候自行转换成json读取数据
		JSONObject result = JSON.parseObject(body);
		return result;
	}






}
