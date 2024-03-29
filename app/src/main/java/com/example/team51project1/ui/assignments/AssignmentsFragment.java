package com.example.team51project1.ui.assignments;

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
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.team51project1.Assignment;
import com.example.team51project1.Course;
import com.example.team51project1.R;
import com.example.team51project1.databinding.FragmentAssignmentsBinding;
import com.example.team51project1.ui.classes.ClassesFragment;

import java.util.ArrayList;

//does this make a change?
public class AssignmentsFragment extends Fragment {

    int selected;
    private FragmentAssignmentsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AssignmentsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(AssignmentsViewModel.class);

        binding = FragmentAssignmentsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textNotifications;
        //notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.homeButtonAssignments).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(AssignmentsFragment.this)
                        .navigate(R.id.action_navigation_assignments_to_navigation_home3);
            }
        });

        selected = -1;

        ListView courseListView = (ListView) view.findViewById(R.id.assignmentList);
        ArrayList<Assignment> backingList = new ArrayList<>();
        ArrayAdapter<Assignment> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, backingList);
        courseListView.setAdapter(adapter);

        EditText enterAssignment = view.findViewById(R.id.assignment_title);
        EditText enterDueDate = view.findViewById(R.id.assignment_duedate);
        EditText enterCourse = view.findViewById(R.id.assignment_course);

        Button addAssignment = view.findViewById(R.id.addAssignment);


        addAssignment.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String assignmentStr = enterAssignment.getText().toString();
                String dueDateStr = enterDueDate.getText().toString();
                String courseStr = enterCourse.getText().toString();
                backingList.add(new Assignment(assignmentStr, dueDateStr, courseStr));
                adapter.notifyDataSetChanged();

                enterAssignment.setText("");
                enterDueDate.setText("");
                enterCourse.setText("");
            }
        });

        Button edit = view.findViewById(R.id.editAssignment);
        courseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selected = position;
                Assignment now = backingList.get(position);

                enterAssignment.setText(now.getAssignmentName());
                enterDueDate.setText(now.getAssignmentDueDate());
                enterCourse.setText(now.getAssignmentCourse());

                //Toast.makeText(Classes.this, now.getName() + " has been selected to be edited or deleted.", Toast.LENGTH_SHORT).show();
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selected != -1) {
                    Assignment now = backingList.get(selected);
                    now.setAssignmentName(enterAssignment.getText().toString());
                    now.setAssignmentDueDate(enterDueDate.getText().toString());
                    now.setAssociatedCourse(enterCourse.getText().toString());
                    adapter.notifyDataSetChanged();

                    enterAssignment.setText("");
                    enterDueDate.setText("");
                    enterCourse.setText("");
                    selected = -1;
                }
            }
        });

        Button del = view.findViewById(R.id.deleteAssignment);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selected != -1) {
                    backingList.remove(selected);
                    adapter.notifyDataSetChanged();
                    selected = -1;

                    enterAssignment.setText("");
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