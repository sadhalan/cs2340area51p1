package com.example.team51project1.ui.todolist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.team51project1.Assignment;
import com.example.team51project1.Course;
import com.example.team51project1.R;
import com.example.team51project1.Task;
import com.example.team51project1.databinding.FragmentTasksBinding;
import com.example.team51project1.ui.todolist.TaskFragment;
import com.example.team51project1.ui.todolist.ToDoListViewModel;
import com.example.team51project1.ui.classes.ClassesFragment;

import java.util.ArrayList;

public class TaskFragment extends Fragment {

    int selected;
    private FragmentTasksBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ToDoListViewModel notificationsViewModel =
                new ViewModelProvider(this).get(ToDoListViewModel.class);

        binding = FragmentTasksBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.homeButtonTasks).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(TaskFragment.this)
                        .navigate(R.id.action_navigation_todo_to_navigation_home);
            }
        });

        selected = -1;

        ListView taskListView = (ListView) view.findViewById(R.id.taskList);
        ArrayList<Task> backingArray = new ArrayList<>();
        ArrayAdapter<Task> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, backingArray);
        taskListView.setAdapter(adapter);

        EditText enterTask = view.findViewById(R.id.task_title);
        EditText enterDueDate = view.findViewById(R.id.task_duedate);
        EditText enterCourse = view.findViewById(R.id.task_course);

        Button addTask = view.findViewById(R.id.addTask);


        addTask.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String taskStr = enterTask.getText().toString();
                String dueDateStr = enterDueDate.getText().toString();
                String courseStr = enterCourse.getText().toString();
                backingArray.add(new Task(taskStr, dueDateStr, courseStr));
                adapter.notifyDataSetChanged();

                enterTask.setText("");
                enterDueDate.setText("");
                enterCourse.setText("");
            }
        });

        Button edit = view.findViewById(R.id.editTask);
        taskListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selected = position;
                enterTask.setText(backingArray.get(position).getTaskName());
                enterDueDate.setText(backingArray.get(position).getTaskDueDate());
                enterCourse.setText(backingArray.get(position).getTaskCourse());

            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selected != -1) {
                    backingArray.get(selected).setTaskName(enterTask.getText().toString());
                    backingArray.get(selected).setTaskDueDate(enterDueDate.getText().toString());
                    backingArray.get(selected).setTaskCourse(enterCourse.getText().toString());
                    adapter.notifyDataSetChanged();

                    enterTask.setText("");
                    enterDueDate.setText("");
                    enterCourse.setText("");
                    selected = -1;
                }
            }
        });

        Button del = view.findViewById(R.id.deleteTask);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selected != -1) {
                    backingArray.remove(selected);
                    adapter.notifyDataSetChanged();
                    selected = -1;

                    enterTask.setText("");
                    enterDueDate.setText("");
                    enterCourse.setText("");
                }
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}