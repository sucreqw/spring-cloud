package com.youmi.zuuldemo.filter;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

/**
 * @author sucre chen 906509023@qq.com
 * @Title: FallBackFilter
 * @Package
 * @Description: 服务的熔断功能。
 * @date 2019-03-18 09:57
 */
@Component
public class FallBackFilter implements FallbackProvider {

    /**
     * 指定 可以熔断拦截 哪些服务
     * @return "*"; //指定    可熔断所有服务
     * "springcloud-ms-member";//指定 可熔断某个服务 服务名是配置文件中配置的各服务的serviceId
     */
    @Override
    public String getRoute() {
        return "*";
    }

    /**
     * 指定  熔断后返回的定制化内容
     * @param route
     * @param cause
     * @return
     */
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse2();
    }

}

/**
 * 需要返回的内容返回的定制化内容
 */
class ClientHttpResponse2 implements ClientHttpResponse {

        public HttpStatus getStatusCode() throws IOException {
            return HttpStatus.OK;
        }


        public int getRawStatusCode() throws IOException {
            return 200;
        }


        public String getStatusText() throws IOException {
            return "ok";
        }


        public void close() {

        }

        /**
         * 设置响应体
         * @return
         * @throws IOException
         */

        public InputStream getBody() throws IOException {
            //TODO 此处可以做日志记录
            String ret="服务凉凉了";
            return new ByteArrayInputStream(ret.getBytes());
        }

        /**
         * 设置响应头信息
         * @return
         */

        public HttpHeaders getHeaders() {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);//指定响应体 格式+编码方式
            headers.setLocation(URI.create("http://localhost:8888/demo/default"));
            return headers;
        }
    }
