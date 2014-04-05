package com.breatheeasy;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class EditTasksActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		setContentView(R.layout.activity_edit_tasks);
		
		super.onCreate(savedInstanceState);
		DatabaseHandler db = new DatabaseHandler(this);
		List<Task> tasks = db.getAllTasks();

		
		
		String[] task_texts = new String[tasks.size()];
		
		int i = 0;
		for(Task t : tasks){
			task_texts[i] = t.getText();
			i++;
		}
		

		ListAdapter adapter = new ArrayAdapter<String>(
					this,
					android.R.layout.simple_list_item_1,
					task_texts
				);
		
		ListView tasksList = (ListView) findViewById(R.id.edit_tasks_list);
		tasksList.setAdapter(adapter);
	}
	

}
