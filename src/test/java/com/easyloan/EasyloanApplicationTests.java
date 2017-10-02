package com.easyloan;

import com.easyloan.bean.User;
import com.easyloan.bean.UserExample;
import com.easyloan.dao.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class EasyloanApplicationTests {


	@Autowired
	UserMapper userMapper;

	public static void main(String[] args) throws Exception {
//		List<String> warnings = new ArrayList<String>();
//		boolean overwrite = true;
//		File configFile = new File("mbg.xml");
//		ConfigurationParser cp = new ConfigurationParser(warnings);
//		Configuration config = cp.parseConfiguration(configFile);
//		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
//		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
//		myBatisGenerator.generate(null);

	}

	@Test
	public void test(){
		System.out.println(userMapper);
	}

}
