package cnaps;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alyenc.cnaps.service.PersistentData;
import com.alyenc.cnaps.service.RequestData;

@RunWith(SpringJUnit4ClassRunner.class) // 整合 
@ContextConfiguration(locations="classpath*:spring.xml") // 加载配置
public class Test {
	
	@Autowired
	private RequestData requestData;
	
	public RequestData getRequestData() {
		return requestData;
	}


	public void setRequestData(RequestData requestData) {
		this.requestData = requestData;
	}


	@org.junit.Test
	public void test() {
		try {
			requestData.doRequest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

