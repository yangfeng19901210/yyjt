package com.yy.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/*********************************************************
 **
 ** <br><br>
 ** @ClassName: ServiceCallConfig
 ** @author: yangfeng
 ** @date: 2025/5/30 11:08
 ** @version: 1.0.0
 *********************************************************/
@Configuration
public class ServiceCallConfig {
    @Bean
    @LoadBalanced // 启用服务名解析,不过不添加该注解就会报如下异常
    /**
     * java.net.UnknownHostException: user-service
     * 	at java.base/sun.nio.ch.NioSocketImpl.connect(NioSocketImpl.java:572) ~[na:na]
     * 	at java.base/java.net.Socket.connect(Socket.java:633) ~[na:na]
     * 	at java.base/java.net.Socket.connect(Socket.java:583) ~[na:na]
     * 	at java.base/sun.net.NetworkClient.doConnect(NetworkClient.java:183) ~[na:na]
     * 	at java.base/sun.net.www.http.HttpClient.openServer(HttpClient.java:534) ~[na:na]
     * 	at java.base/sun.net.www.http.HttpClient.openServer(HttpClient.java:639) ~[na:na]
     * 	at java.base/sun.net.www.http.HttpClient.<init>(HttpClient.java:282) ~[na:na]
     * 	at java.base/sun.net.www.http.HttpClient.New(HttpClient.java:387) ~[na:na]
     * 	at java.base/sun.net.www.http.HttpClient.New(HttpClient.java:409) ~[na:na]
     * 	at java.base/sun.net.www.protocol.http.HttpURLConnection.getNewHttpClient(HttpURLConnection.java:1309) ~[na:na]
     * 	at java.base/sun.net.www.protocol.http.HttpURLConnection.plainConnect0(HttpURLConnection.java:1242) ~[na:na]
     * 	at java.base/sun.net.www.protocol.http.HttpURLConnection.plainConnect(HttpURLConnection.java:1128) ~[na:na]
     * 	at java.base/sun.net.www.protocol.http.HttpURLConnection.connect(HttpURLConnection.java:1057) ~[na:na]
     * 	at org.springframework.http.client.SimpleBufferingClientHttpRequest.executeInternal(SimpleBufferingClientHttpRequest.java:76) ~[spring-web-5.3.24.jar:5.3.24]
     * 	at org.springframework.http.client.AbstractBufferingClientHttpRequest.executeInternal(AbstractBufferingClientHttpRequest.java:48) ~[spring-web-5.3.24.jar:5.3.24]
     * 	at org.springframework.http.client.AbstractClientHttpRequest.execute(AbstractClientHttpRequest.java:66) ~[spring-web-5.3.24.jar:5.3.24]
     * 	at org.springframework.http.client.InterceptingClientHttpRequest$InterceptingRequestExecution.execute(InterceptingClientHttpRequest.java:109) ~[spring-web-5.3.24.jar:5.3.24]
     * 	at org.springframework.cloud.sleuth.instrument.web.mvc.TracingClientHttpRequestInterceptor.intercept(TracingClientHttpRequestInterceptor.java:69) ~[spring-cloud-sleuth-instrumentation-3.1.5.jar:3.1.5]
     * 	at org.springframework.cloud.sleuth.instrument.web.client.LazyTraceClientHttpRequestInterceptor.intercept(LazyTraceClientHttpRequestInterceptor.java:51) ~[spring-cloud-sleuth-instrumentation-3.1.5.jar:3.1.5]
     * 	at org.springframework.http.client.InterceptingClientHttpRequest$InterceptingRequestExecution.execute(InterceptingClientHttpRequest.java:93) ~[spring-web-5.3.24.jar:5.3.24]
     * 	at org.springframework.http.client.InterceptingClientHttpRequest.executeInternal(InterceptingClientHttpRequest.java:77) ~[spring-web-5.3.24.jar:5.3.24]
     * 	at org.springframework.http.client.AbstractBufferingClientHttpRequest.executeInternal(AbstractBufferingClientHttpRequest.java:48) ~[spring-web-5.3.24.jar:5.3.24]
     * 	at org.springframework.http.client.AbstractClientHttpRequest.execute(AbstractClientHttpRequest.java:66) ~[spring-web-5.3.24.jar:5.3.24]
     * 	at org.springframework.web.client.RestTemplate.doExecute(RestTemplate.java:782) ~[spring-web-5.3.24.jar:5.3.24]
     * 	at org.springframework.web.client.RestTemplate.execute(RestTemplate.java:717) ~[spring-web-5.3.24.jar:5.3.24]
     * 	at org.springframework.web.client.RestTemplate.getForObject(RestTemplate.java:340) ~[spring-web-5.3.24.jar:5.3.24]
     * 	at com.yy.order.controller.ServiceAController.callServiceB(ServiceAController.java:16) ~[classes/:na]
     * 	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
     * 	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77) ~[na:na]
     * 	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
     * 	at java.base/java.lang.reflect.Method.invoke(Method.java:568) ~[na:na]
     * 	at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:205) ~[spring-web-5.3.24.jar:5.3.24]
     * 	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:150) ~[spring-web-5.3.24.jar:5.3.24]
     * 	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:117) ~[spring-webmvc-5.3.24.jar:5.3.24]
     * 	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:895) ~[spring-webmvc-5.3.24.jar:5.3.24]
     * 	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:808) ~[spring-webmvc-5.3.24.jar:5.3.24]
     * 	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87) ~[spring-webmvc-5.3.24.jar:5.3.24]
     * 	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1071) ~[spring-webmvc-5.3.24.jar:5.3.24]
     * 	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:964) ~[spring-webmvc-5.3.24.jar:5.3.24]
     * 	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006) ~[spring-webmvc-5.3.24.jar:5.3.24]
     * 	at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898) ~[spring-webmvc-5.3.24.jar:5.3.24]
     * 	at javax.servlet.http.HttpServlet.service(HttpServlet.java:670) ~[tomcat-embed-core-9.0.69.jar:4.0.FR]
     * 	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883) ~[spring-webmvc-5.3.24.jar:5.3.24]
     * 	at javax.servlet.http.HttpServlet.service(HttpServlet.java:779) ~[tomcat-embed-core-9.0.69.jar:4.0.FR]
     * 	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:227) ~[tomcat-embed-core-9.0.69.jar:9.0.69]
     * 	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.69.jar:9.0.69]
     * 	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53) ~[tomcat-embed-websocket-9.0.69.jar:9.0.69]
     * 	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) ~[tomcat-embed-core-9.0.69.jar:9.0.69]
     * 	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.69.jar:9.0.69]
     * 	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100) ~[spring-web-5.3.24.jar:5.3.24]
     * 	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117) ~[spring-web-5.3.24.jar:5.3.24]
     * 	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) ~[tomcat-embed-core-9.0.69.jar:9.0.69]
     * 	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.69.jar:9.0.69]
     * 	at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93) ~[spring-web-5.3.24.jar:5.3.24]
     * 	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117) ~[spring-web-5.3.24.jar:5.3.24]
     * 	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) ~[tomcat-embed-core-9.0.69.jar:9.0.69]
     * 	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.69.jar:9.0.69]
     * 	at org.springframework.cloud.sleuth.instrument.web.servlet.TracingFilter.doFilter(TracingFilter.java:68) ~[spring-cloud-sleuth-instrumentation-3.1.5.jar:3.1.5]
     * 	at org.springframework.cloud.sleuth.autoconfig.instrument.web.TraceWebServletConfiguration$LazyTracingFilter.doFilter(TraceWebServletConfiguration.java:131) ~[spring-cloud-sleuth-autoconfigure-3.1.5.jar:3.1.5]
     * 	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) ~[tomcat-embed-core-9.0.69.jar:9.0.69]
     * 	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.69.jar:9.0.69]
     * 	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201) ~[spring-web-5.3.24.jar:5.3.24]
     * 	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117) ~[spring-web-5.3.24.jar:5.3.24]
     * 	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) ~[tomcat-embed-core-9.0.69.jar:9.0.69]
     * 	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.69.jar:9.0.69]
     * 	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:177) ~[tomcat-embed-core-9.0.69.jar:9.0.69]
     * 	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:97) ~[tomcat-embed-core-9.0.69.jar:9.0.69]
     * 	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:541) ~[tomcat-embed-core-9.0.69.jar:9.0.69]
     * 	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:135) ~[tomcat-embed-core-9.0.69.jar:9.0.69]
     * 	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92) ~[tomcat-embed-core-9.0.69.jar:9.0.69]
     * 	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:78) ~[tomcat-embed-core-9.0.69.jar:9.0.69]
     * 	at org.springframework.cloud.sleuth.instrument.web.tomcat.TraceValve.invoke(TraceValve.java:103) ~[spring-cloud-sleuth-instrumentation-3.1.5.jar:3.1.5]
     * 	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:360) ~[tomcat-embed-core-9.0.69.jar:9.0.69]
     * 	at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:399) ~[tomcat-embed-core-9.0.69.jar:9.0.69]
     * 	at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65) ~[tomcat-embed-core-9.0.69.jar:9.0.69]
     * 	at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:891) ~[tomcat-embed-core-9.0.69.jar:9.0.69]
     * 	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1784) ~[tomcat-embed-core-9.0.69.jar:9.0.69]
     * 	at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49) ~[tomcat-embed-core-9.0.69.jar:9.0.69]
     * 	at org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1191) ~[tomcat-embed-core-9.0.69.jar:9.0.69]
     * 	at org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659) ~[tomcat-embed-core-9.0.69.jar:9.0.69]
     * 	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61) ~[tomcat-embed-core-9.0.69.jar:9.0.69]
     * 	at java.base/java.lang.Thread.run(Thread.java:842) ~[na:na]
     */
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
