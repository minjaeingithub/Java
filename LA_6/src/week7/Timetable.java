package week7;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;
import java.util.Collections;
import java.util.Iterator;

public class Timetable {
	public HashMap<String, String> subjectList = new HashMap<>();
	public HashMap<String, String> timeSubjectList = new HashMap<>();
	public ArrayList<String> classList = new ArrayList <>();
	
	//show all table in time order
	public void ShowTables (ArrayList<String> classList) {	
		Collections.sort(classList);
		
		//display
		Iterator<String> display =classList.iterator();
		
		while(display.hasNext()) {
			System.out.println(display.next());
		}
	}
	//class_name -> classID
	public String FindClassID(String class_name) {
		String matchedID = "";
		Set<Entry<String, String>> entrySet = subjectList.entrySet();
		for (Entry<String, String> entry : entrySet) {
		if (entry.getValue().equals(class_name)) {
			matchedID = entry.getKey(); 
			}
		}
		return matchedID;
	}
	
	//class_id -> className
	public String FindClassName(String class_id) {
		return subjectList.get(class_id);
	}
	//use split
	public void AddClass(String class_info) {
		classList.add(class_info);
		//segmentation for each class
		String[] forEachCls = class_info.split("\\n");
		for(int k=0; k < forEachCls.length; k++) {
			String[] forEachclassInfo = class_info.split(" ");
			String classID = forEachclassInfo[0];
			String className = forEachclassInfo[1];
			String classTime = forEachclassInfo[2];
			//input data into hash map object
			subjectList.put(classID, className);
			timeSubjectList.put(classID, classTime);
		}
	}
}