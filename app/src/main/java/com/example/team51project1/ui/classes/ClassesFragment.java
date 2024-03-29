package com.example.team51project1.ui.classes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
//does this make a change?

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.team51project1.Course;
import com.example.team51project1.R;
import com.example.team51project1.databinding.FragmentClassesBinding;

import java.util.ArrayList;

public class ClassesFragment extends Fragment {

    private FragmentClassesBinding binding;
    int selected;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentClassesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.homeButtonC).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ClassesFragment.this)
                        .navigate(R.id.action_navigation_classes_to_navigation_home2);
            }
        });

        selected = -1;

        ListView courseListView = (ListView) view.findViewById(R.id.classList);
        ArrayList<Course> backingList = new ArrayList<>();
        ArrayAdapter<Course> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, backingList);
        courseListView.setAdapter(adapter);

        EditText enterClass = view.findViewById(R.id.course_title);
        EditText enterTime = view.findViewById(R.id.course_time);
        EditText enterInstructor = view.findViewById(R.id.course_instructor);
        EditText enterLocation = view.findViewById(R.id.course_location);
        EditText enterDaysOfWeek = view.findViewById(R.id.course_days);

        Button addClass = view.findViewById(R.id.addClass);


        addClass.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String classStr = enterClass.getText().toString();
                String timeStr = enterTime.getText().toString();
                String instructorStr = enterInstructor.getText().toString();
                String locationStr = enterLocation.getText().toString();
                String dayOfWeekStr = enterDaysOfWeek.getText().toString();
                backingList.add(new Course(classStr,  instructorStr, locationStr, dayOfWeekStr, timeStr));
                adapter.notifyDataSetChanged();

                enterClass.setText("");
                enterTime.setText("");
                enterInstructor.setText("");
                enterLocation.setText("");
                enterDaysOfWeek.setText("");
            }
        });

        Button edit = view.findViewById(R.id.editClass);
        courseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selected = position;
                Course now = backingList.get(position);

                enterClass.setText(now.getCourseName());
                enterTime.setText(now.getCourseTime());
                enterInstructor.setText(now.getCourseTeacher());
                enterLocation.setText(now.getCourseBuilding());
                enterDaysOfWeek.setText(now.getCourseDaysOfWeek());

                //Toast.makeText(Classes.this, now.getName() + " has been selected to be edited or deleted.", Toast.LENGTH_SHORT).show();
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selected != -1) {
                    Course now = backingList.get(selected);
                    now.setCourseName(enterClass.getText().toString());
                    now.setCourseTime(enterTime.getText().toString());
                    now.setCourseTeacher(enterInstructor.getText().toString());
                    now.setCourseBuilding(enterLocation.getText().toString());
                    now.setCourseDaysOfWeek(enterDaysOfWeek.getText().toString());
                    adapter.notifyDataSetChanged();

                    enterClass.setText("");
                    enterTime.setText("");
                    enterInstructor.setText("");
                    enterLocation.setText("");
                    enterDaysOfWeek.setText("");
                    selected = -1;
                }
            }
        });

        Button del = view.findViewById(R.id.deleteClass);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selected != -1) {
                    backingList.remove(selected);
                    adapter.notifyDataSetChanged();
                    selected = -1;

                    enterClass.setText("");
                    enterTime.setText("");
                    enterInstructor.setText("");
                    enterLocation.setText("");
                    enterDaysOfWeek.setText("");
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