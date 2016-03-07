package teamwork;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TeamWork {

	public static void main(String[] args) throws FileNotFoundException, JSONException {

		@SuppressWarnings("resource")
		String jsonArrStr = new Scanner(new File("stud.txt")).useDelimiter("\\Z").next();

		JSONArray jsonArr = new JSONArray(jsonArrStr);
		JSONArray sortedJsonArray = new JSONArray();

		List<JSONObject> jsonValues = new ArrayList<JSONObject>();
		for (int i = 0; i < jsonArr.length(); i++) {
			jsonValues.add(jsonArr.getJSONObject(i));
		}
		Collections.sort(jsonValues, new Comparator<JSONObject>() {
			// You can change "Name" to different value 
			private static final String KEY_NAME = "Name";

			@Override
			public int compare(JSONObject a, JSONObject b) {
				String valA = new String();
				String valB = new String();

				try {
					valA = (String) a.get(KEY_NAME);
					valB = (String) b.get(KEY_NAME);
				} catch (JSONException e) {
				}

				return valA.compareTo(valB);
				// if you want to change the sort order, simply use the
				// following:
				// return -valA.compareTo(valB);
			}
		});

		for (int i = 0; i < jsonArr.length(); i++) {
			sortedJsonArray.put(jsonValues.get(i));
		}

		System.out.print(sortedJsonArray);
	}
}
