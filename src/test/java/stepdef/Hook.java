package stepdef;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.baseclass.Base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook extends Base {
	@Before
	public void before() {
		browserName("chrome");
		openUrl("https://www.cheapoair.com/flights/booknow/cheap-flight-tickets?fpaffiliate=coa-googledesktop-global-brand&fpsub=&utm_campaign=brand_exact_atlas_global&utm_term=cheapair&utm_term_id=kwd-102814351&utm_source={google}&utm_medium={cpc}&device=c&fpprice=&campaignID=21771907145&adgroupId=169167449758&gad_source=1&gad_campaignid=21771907145&gclid=EAIaIQobChMImNff-MOUkQMVdD2DAx2VaRR2EAAYASAAEgLddPD_BwE");
	}

	@After
	public void tearDown() {

		 driver.quit();
	}
}
