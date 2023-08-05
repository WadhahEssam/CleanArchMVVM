package com.example.cleanarchmvvm;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class CreateNoteActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        NoteViewModel noteViewModel = new ViewModelProvider(this).get(NoteViewModel.class);

        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams linearLayoutLP = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        linearLayout.setLayoutParams(linearLayoutLP);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setPadding(20, 20, 20, 20);

        TextInputEditText titleInputText = new TextInputEditText(this);
        titleInputText.setHint("Enter the title");
        linearLayout.addView(titleInputText, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        TextInputEditText descriptionInputText = new TextInputEditText(this);
        descriptionInputText.setHint("Enter description");
        linearLayout.addView(descriptionInputText, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        TextInputEditText priorityInputText = new TextInputEditText(this);
        priorityInputText.setHint("Enter priority");
        priorityInputText.setText("1");
        priorityInputText.setInputType(InputType.TYPE_NUMBER_VARIATION_NORMAL);
        linearLayout.addView(priorityInputText, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        MaterialButton saveButton = new MaterialButton(this);
        saveButton.setText("Save");
        saveButton.setOnClickListener(view -> {
            Note newNote = new Note(String.valueOf(titleInputText.getText()), String.valueOf(descriptionInputText.getText()), Integer.parseInt(String.valueOf(priorityInputText.getText())));
            noteViewModel.insert(newNote);
            startActivity(new Intent(this, MainActivity.class));
        });
        linearLayout.addView(saveButton);

        setContentView(linearLayout);
    }
}
