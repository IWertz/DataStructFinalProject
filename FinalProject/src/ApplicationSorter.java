
public class ApplicationSorter {
	//global variables to be used by methods
	private int iterator = 1;
	PriorityQueue pq = new PriorityQueue();
	LinkedArray la = new LinkedArray();
	
	public ApplicationSorter() {
		super();
	}
	
	//adds application with sorted priority to the priority queue
	public void addApp(Application app) {
		int priority = 0;
		priority = sort(app);
		pq.enqueue(app, priority);
	}
	
	//takes the top 10 apps in the priority queue to fill the linked array
	//throws away extra applications
	public Application[] evaluateApps() throws ListFullException {
		while (pq.size() != 0) {
			if (la.size() < la.array.length) {
				la.addLast(pq.dequeue());
			}
		}
		return la.array;
	}
	
	//returns a list of apps currently in the linked array
	public String printChosenApps() {
		return la.printArray();
	}
	
	//method to input an application into the sorter
	public void createApp(Application app) {
		app.appNum = iterator;
		iterator++;
		addApp(app);
	}
	
	//sort algorithm to determine priority
	public int sort(Application app) {
		int priority = 0;
		priority += app.size;
		priority += app.yearsOfPrevExp;
		if (app.whatMakesYouQualified.length() > 15) priority++;
		if (app.whenToStart.length() > 0) priority++;
		if (app.whyYouWantThisJob.length() > 15) priority++;
		if (priority > 10) priority = 10;
		if (app.name.equals("")) priority = 0;
		return priority;
	}
}
