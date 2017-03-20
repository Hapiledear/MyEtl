package com.suixingpay;

import com.suixingpay.sourceCode.Enum.DbType;
import com.suixingpay.sourceCode.Utils.SpringContextUtil;
import com.suixingpay.sourceCode.events.TestEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@Configurable(autowire = Autowire.BY_NAME)
@ImportResource(value={"classpath:application-context.xml"})
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class MyEtlApplication {

	private  static Logger LOGGER = LoggerFactory.getLogger(MyEtlApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MyEtlApplication.class, args);
        LOGGER.info("---------spring boot执行完毕-----------");
        TestEvent event = new TestEvent(TestEvent.class, DbType.TEST);
        SpringContextUtil.getContext().publishEvent(event);

    }
}
