package com.suixingpay;

import com.suixingpay.example.Enum.CreateEnum;
import com.suixingpay.example.Enum.DbType;
import com.suixingpay.example.Utils.CreateUtils;
import com.suixingpay.example.Utils.Encryption.EncryptFactory;
import com.suixingpay.example.Utils.Encryption.EncryptorEnum;
import com.suixingpay.example.Utils.SpringContextUtil;
import com.suixingpay.example.events.TestEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

import java.text.ParseException;
import java.util.Date;

@SpringBootApplication
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




        Thread thread1 = new Thread(()->{
            String res1 = (String) CreateUtils.create(CreateEnum.TYPE_USR_ID,"123321");
            String res2 = (String) CreateUtils.create(CreateEnum.TYPE_USR_ID,"123321");
            String res3 = (String) CreateUtils.create(CreateEnum.TYPE_USR_ID,"123456789");
            LOGGER.info("thread1 1-2相同2-3不同{}-{}-{}",res1,res2,res3);
        });
        thread1.start();

        Thread thread2 = new Thread(()->{
            String res1 = (String) CreateUtils.create(CreateEnum.TYPE_USR_ID,"555555");
            String res2 = (String) CreateUtils.create(CreateEnum.TYPE_USR_ID,"123321");
            String res3 = (String) CreateUtils.create(CreateEnum.TYPE_USR_ID,"555554");
            LOGGER.info("thread2 1-2相同2-3不同{}-{}-{}",res1,res2,res3);
        });
        thread2.start();

    }
}
