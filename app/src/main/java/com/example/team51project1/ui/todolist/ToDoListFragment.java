package com.example.team51project1.ui.todolist;

import android.content.Context;
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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.team51project1.R;
import com.example.team51project1.databinding.FragmentTasksBinding;
import com.example.team51project1.ui.exams.ExamsFragment;
import com.example.team51project1.ui.home.HomeViewModel;
import com.example.team51project1.ui.todolist.ToDoListViewModel;

import java.util.ArrayList;

public class ToDoListFragment extends Fragment {

    private FragmentTasksBinding binding;
    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView listView;
    private Button addItemButton;
    //private EditText input;
    public EditText input;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ToDoListViewModel toDoListViewModel =
                new ViewModelProvider(this).get(ToDoListViewModel.class);

        binding = FragmentTasksBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textHome;
        //toDoListViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        return root;
    }

    //the "ADD TASK" button, this will be duplicated for "ADD EXAM"
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = view.findViewById(R.id.toDoListView);
        addItemButton = view.findViewById(R.id.button2);
        input = view.findViewById(R.id.editItem2);
        input.setEnabled(true);

        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //input = view.findViewById(R.id.editItem);
                additem();
            }
        });

        items = new ArrayList<>();
        itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, items);
        listView.setAdapter(itemsAdapter);
        setUpListViewListener();
    }

    private void setUpListViewListener() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Context context = getContext().getApplicationContext();
                Toast.makeText(context, "Item Removed", Toast.LENGTH_LONG).show();

                items.remove(position);
                itemsAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    private void additem() {
        //input = this.input;
        String itemText = input.getText().toString();

        if (!(itemText.equals(""))) {
            itemsAdapter.add(itemText);
            input.setText("");
        } else {
            Toast.makeText(getContext().getApplicationContext(), "Please enter text...", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
/*
package com.example.team51project1.ui.todolist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
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
import android.widget.Toast;

import com.example.team51project1.MainActivity;
import com.example.team51project1.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class ToDoListFragment<ItemEntry> extends AppCompatActivity {
    int selected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        selected = -1;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_tasks);
        Button back = findViewById(R.id.back_to_home);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ToDoListFragment.this, MainActivity.class));
            }
        });

        ListView toDoListView = (ListView) findViewById(R.id.todo_list);
        ArrayList<String> backingList = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, backingList);
        toDoListView.setAdapter(adapter);

        EditText item = findViewById(R.id.toDoItem);

        Button addItem = findViewById(R.id.todo_add);
        addItem.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String itemStr = item.getText().toString();

                backingList.add((itemStr));
                adapter.notifyDataSetChanged();

                item.setText("");
            }
        });

        Button edit = findViewById(R.id.todo_edit);
        toDoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selected = position;
                String now;
                now = backingList.get(position);

                item.setText(now);

                Toast.makeText(ToDoListFragment.this,"\"" + now + "\" has been selected to be edited or deleted.", Toast.LENGTH_SHORT).show();
            }
        });


        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selected != -1) {

                    backingList.set(selected, item.getText().toString());

                    adapter.notifyDataSetChanged();

                    item.setText("");
                    selected = -1;
                }
            }
        });

        Button del = findViewById(R.id.todo_delete);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selected != -1) {
                    backingList.remove(selected);
                    adapter.notifyDataSetChanged();
                    selected = -1;

                    item.setText("");
                }
            }
        });
    }
}
*/
