import java.util.Arrays;

public class Application {
	public int appNum = 0;
	public String name = "";
	public Reference[] references = new Reference[10];
	public String whyYouWantThisJob = "";
	public String whatMakesYouQualified = "";
	public String whenToStart = "";
	public int yearsOfPrevExp = 0;
	public int size = 0;
	
	public Application() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void addReference(Reference ref) {
		references[size] = ref;
		size++;
	}

	@Override
	public String toString() {
		return "Application [appNum=" + appNum + ", name=" + name + ", references=" + Arrays.toString(references)
				+ ", whyYouWantThisJob=" + whyYouWantThisJob + ", whatMakesYouQualified=" + whatMakesYouQualified
				+ ", whenToStart=" + whenToStart + ", yearsOfPrevExp=" + yearsOfPrevExp + "]";
	}
}
