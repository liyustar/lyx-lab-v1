package com.lyx.omslab;

import com.lyx.omslab.util.db.DbMetaUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class OmsLabApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(OmsLabApplication.class, args);
	}

	@Autowired
	DbMetaUtil dbMetaUtil;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("Application started !!!!");

//		dbMetaUtil.analyTableMetaData();
//		dbMetaUtil.analyColumnMetaData();
		dbMetaUtil.analyPrimaryKeyMetaData();

        log.info("-- DONE");

	}
}

