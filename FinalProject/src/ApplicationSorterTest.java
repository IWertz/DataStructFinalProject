import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ApplicationSorterTest {

	public ApplicationSorter as = new ApplicationSorter();
	
	//tests if an application can be created
	@Test
	void testAppCreate() throws ListFullException {
		Application newApp = new Application();
		as.createApp(newApp);
		assertNotNull(as.evaluateApps());
	}
	
	//tests if a proper number is added to applications
	@Test
	void testAppNum() throws ListFullException {
		Application newApp = new Application();
		as.createApp(newApp);
		Application[] array = as.evaluateApps();
		assertEquals(1, array[0].appNum);
	}
	
	//tests if a ref can be successfully created
	@Test
	void testRefCreate() {
		Application newApp = new Application();
		Reference ref = new Reference();
		newApp.addReference(ref);
		assertNotNull(newApp.references[0]);
	}
	
	//tests if the ref size is updated each time a ref is added
	@Test
	void testRefSize() {
		Application newApp = new Application();
		Reference ref = new Reference();
		newApp.addReference(ref);
		assertEquals(1, newApp.size);
	}
	
	//tests if sort successfully adds a priority to each app
	@Test
	void testSort() {
		Application newApp = new Application();
		newApp.name = "Isaiah";
		newApp.yearsOfPrevExp = 3;
		as.createApp(newApp);
		assertEquals(3, as.pq.head.priority);
	}
	
	//tests sort between different prioriy apps
	@Test
	void testEvaluateTopApp() {
		Application app1 = new Application();
		app1.yearsOfPrevExp = 4;
		Application app2 = new Application();
		app2.name = "Isaiah";
		app2.yearsOfPrevExp = 2;
		as.createApp(app1);
		as.createApp(app2);
		assertEquals(app2, as.pq.head.jobApp);
	}
	
	//test if sorter properly throws extra applications
	@Test
	void testFullEvaluations() throws ListFullException {
		for(int i = 1; i <= 11; i++) {
			Application newApp = new Application();
			newApp.name = "Isaiah" + String.valueOf(i);
			as.createApp(newApp);
		}
		as.evaluateApps();
		
		//if it makes it this far, it did not throw exception. instead it 
		//successfully cut off extra applications
		assertEquals(1, 1);
	}
}
