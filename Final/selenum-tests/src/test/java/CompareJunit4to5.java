


public class CompareJunit4to5 {

	@BeforeEach
	void setup(TestInfo info) {
		
	}
	
	
	@ParameterizedTest
	@CsvSource({"chrome","firefox"})
	void testGoogle(String browser) {
		
	}
	
	
}
