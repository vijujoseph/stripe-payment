package payment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.PaymentSource;
import com.stripe.model.PaymentSourceCollection;
import com.stripe.model.Token;

public class App {

	public static void main(String[] args) throws StripeException {

		//Stripe secret key
		//Stripe secret can be obtained as below:
		//go to https://dashboard.stripe.com/test/dashboard --> developers --> apikeys --> Secret Key

		 //1. Add Customer
		//Check if CustomerPaymentId existing for user:
		//if not existing, create customer
		Map<String, Object> customerParams = new HashMap<String, Object>();
		customerParams.put("email", "test@test.com");
		customerParams.put("description", "Stripe testing");
		//Customer customer = Customer.create(customerParams);

		//if customer existing
		Customer customer = Customer.retrieve("cus_J9eCJgE9");

		// 2. Add Card
		// Sample test cards are available at https://stripe.com/docs/testing
		/*Customer customer = retrieveCustomer("cus_JAcQIW");
		System.out.println("customer" + customer);

		Map<String, Object> cardParam = new HashMap<String, Object>();
		cardParam.put("name", "Abc Test");
		cardParam.put("number", "5555555555554444");
		cardParam.put("exp_month", "03");
		cardParam.put("exp_year", "2033");
		cardParam.put("cvc", "333");


		Map<String, Object> tokenParam = new HashMap<String, Object>();
		tokenParam.put("card", cardParam);

		Token token = Token.create(tokenParam);

		Map<String, Object> source = new HashMap<String, Object>();
		source.put("source", token.getId());

		Card card = (Card) customer.getSources().create(source);
		 System.out.println("card" + card);*/

		//3. list all cards
/*		Map<String, Object> params = new HashMap<String, Object>();
		params.put("object", "card");
		params.put("limit", 10);

		PaymentSourceCollection cards = customer.getSources().list(params);
		System.out.println("cards : " + cards);
		List<PaymentSource> paymentSources = cards.getData();
		
		//converting payment source from stripe to Java object using Gson
		Gson gson = new GsonBuilder().create();
		for(PaymentSource paymentSource: paymentSources) {
			CardDetail card = gson.fromJson(gson.toJson(paymentSource) , CardDetail.class);
			if(customer.getDefaultSource().equals(card.getId())) {
				card.setDefaultSource(true);
				System.out.println("Default source" + card.getId());
			}
		}
*/
		//3. Update a card
/*		Card card = (Card) customer.getSources().retrieve("card_1IXL");

		 We have the provision to update
		Map<String, Object> updateCardParam = new HashMap<String, Object>();
		updateCardParam.put("name", "Abc Test");
		updateCardParam.put("exp_month", "06");
		updateCardParam.put("exp_year", "25");
		updateCardParam.put("default_source", "25");

		 Card updatedCard = (Card) card.update(updateCardParam);
		 System.out.println("updatedCard" + updatedCard);*/

		 //4. Delete a card
/*		Card card = (Card) customer.getSources().retrieve("card_1IXW");
		Card deletedCard = (Card) card.delete();
		System.out.println("deletedCard" + deletedCard);*/

		//5. Update default source
/*		Map<String, Object> defaultSource = new HashMap<String, Object>();
		defaultSource.put("default_source", "card_1I");
		Customer updatedCustomer = customer.update(defaultSource);
		System.out.println("updatedCustomer" + updatedCustomer);*/
		
		//6 Charge
		
		 Map<String, Object> chargeParams = new HashMap<String, Object>();
		 chargeParams.put("amount", 330); chargeParams.put("currency", "eur"); 
		 
		 //charge customer using customer default source 
		 //chargeParams.put("customer", customer.getId());
		  
		 //charge card using card id 
		 chargeParams.put("source", "card_1IXX5aLr");
		 
		 chargeParams.put("description", "Testing charge using direct card id..!");
		  
		 //Charge charge = Charge.create(chargeParams); System.out.println("charge" +charge);
		 
	}

	public static Customer retrieveCustomer(String customerId) throws StripeException {
		Stripe.apiKey = "sk_test_51IWkVXLruJhI54uWz5KtW4s97I0gy1an984a9fj4gZPljZq3P049HTT";
		
		Map<String, Object> retrieveParams = new HashMap<String, Object>();
		List<String> expandList = new ArrayList<String>();
		expandList.add("sources");
		retrieveParams.put("expand", expandList);
		return Customer.retrieve(customerId, retrieveParams, null);
	}
}
