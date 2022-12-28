package com.example.testprovider.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.net.URI;

/**
 * @author wenkr
 * @version V1.0
 * @Package com.example.testprovider.bean
 * @date 2022/12/28 14:18
 * @Copyright ©
 */
public class CustomErrorHandler implements ResponseErrorHandler {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 表示 response 是否存在任何错误。实现类通常会检查 response 的 HttpStatus。
     *
     * @param response
     * @return
     * @throws IOException
     */
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        int rawStatusCode = response.getRawStatusCode();
        HttpStatus statusCode = HttpStatus.resolve(rawStatusCode);
        return (statusCode != null ? statusCode.isError() : hasError(rawStatusCode));
    }

    protected boolean hasError(int unknownStatusCode) {
        HttpStatus.Series series = HttpStatus.Series.resolve(unknownStatusCode);
        return (series == HttpStatus.Series.CLIENT_ERROR || series == HttpStatus.Series.SERVER_ERROR);
    }

    /**
     * 处理 response 中的错误, 当 hasError 返回 true 时才调用此方法。
     * 当返回异常信息时自己想要做的一些操作处理
     *
     * @param response
     * @throws IOException
     */
    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
    }

    /**
     * 覆盖了上面的方法
     * 处理 response 中的错误, 当 hasError 返回 true 时才调用此方法。
     * 当返回异常信息时自己想要做的一些操作处理
     *
     * @param url
     * @param method
     * @param response
     * @throws IOException
     */
    @Override
    public void handleError(URI url, HttpMethod method, ClientHttpResponse response) throws IOException {
        logger.error("=======================ERROR============================");
        logger.error("HOST:{},URI：{}", url.getHost(), url.getPath());
        logger.error("Method Type：{}", method.name());
        logger.error("Exception：{}", response.getStatusCode());
        logger.error("========================================================");
    }
}
