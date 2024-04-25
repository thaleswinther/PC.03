package com.example.todov1app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.todov1app.databinding.ActivityAddTaskBinding;

public class AddTaskActivity extends AppCompatActivity {

    ActivityAddTaskBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddTaskBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.addNewButton.setOnClickListener(view -> {
            String name = binding.taskNameEditText.getText().toString();
            String desc = binding.taskDescEditText.getText().toString();
            int selectedPriorityId = binding.priorityRadioGroup.getCheckedRadioButtonId();
            String priority = getPriorityFromRadioButtonId(selectedPriorityId);
            Task task = new Task(name, desc, priority);
            Intent i = new Intent();
            i.putExtra("taskAdded", task);
            setResult(RESULT_OK, i);
            AddTaskActivity.this.finish();
        });
    }

    // Método para obter a prioridade a partir do ID do RadioButton selecionado
    private String getPriorityFromRadioButtonId(int radioButtonId) {
        switch (radioButtonId) {
            case R.id.highPriorityRadioButton:
                return "High";
            case R.id.mediumPriorityRadioButton:
                return "Medium";
            case R.id.lowPriorityRadioButton:
                return "Low";
            default:
                return "Low"; // Prioridade padrão, caso nenhum seja selecionado
        }
    }

}