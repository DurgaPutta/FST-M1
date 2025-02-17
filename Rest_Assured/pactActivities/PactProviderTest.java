package pactActivities;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

import au.com.dius.pact.core.model.annotations.PactFolder;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;

@Provider("UserProvider")
@PactFolder("target/pacts")   
public class PactProviderTest {		
		@BeforeEach
		public void setUp(PactVerificationContext context) {
		    // Set target for provider to send request to
			HttpTestTarget target = new HttpTestTarget("localhost",8585);
		    context.setTarget(target);
		}
		
		@TestTemplate
	    @ExtendWith(PactVerificationInvocationContextProvider.class)
	    public void pactTestTemplate(PactVerificationContext context) {
	   	   // Verify the interaction between Consumer and Provider
	   	   // using the contract generated in target/pacts
	   	   context.verifyInteraction();
	     }
		
		@State("POST Request")
		public void sampleState() {}

}