package exception;

public class Helper {
	
	public void fix( int issueNumber, String[] args){
		Helper h1; // helper class containing error fixes
		switch(issueNumber){
			case 1: h1 = new Helper1to100(); // 
					h1.method1(); break;
			case 2: method2(); break;
			case 3: method3(); break;
			case 4: method4(); break;
			// These are all instance methods -- don’t static it
			// Instance methods allow for ~serialization~
			}
	}
	// Write class called Helper - empty class
	// Write > 1 child classes - Helper1to100

	printMyProblem(){
		// Write a logFile to write each exception in a text file
	// FileWriter, Buffered Writer
		Format.printf - to format a string like printf function
	}

}
