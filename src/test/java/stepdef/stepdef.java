package stepdef;

import org.openqa.selenium.WebElement;

import com.baseclass.Base;

import Locater.Locater;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepdef extends Base {
	@When("Enter the from location")
	public void enterTheFromLocation() throws InterruptedException {
		Locater.from().click();
		sendKeysWithClear(Locater.from(), "C H E N N A I");
		Thread.sleep(3000);
		click(Locater.fromclick());
		
	}

	@When("Enter the to location")
	public void enterTheToLocation() throws InterruptedException {
		Locater.to().click();
		sendKeysWithClear(Locater.to(), "DE L");
		Thread.sleep(3000);
		click(Locater.toclick());
		
	}
	@Then("validate the name")
	public void validateTheName() {
		WebElement vali = Locater.validate();
		System.out.println(vali.getText());
	}

}
