package com.example.cleanarchmvvm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {

    private List<Note> notes = new ArrayList<>(); // it is important to set it to empty or you check for null later, this is easier.

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // parent view is the recycler view (ViewGroup)
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        return new NoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Note note = notes.get(position);
        if (note != null) {
            holder.textViewTitle.setText(note.getTitle());
            holder.textViewDescription.setText(note.getDescription());
            holder.textViewPriority.setText(note.getPriority() + "");
        }
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    // to get the list of notes
    public void setNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged(); // we will change this later, for a better and more performant way to notify about deletion and insertion
    }

    // this will hold the views inside the the recycler view items
    class NoteHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView textViewDescription;
        private TextView textViewPriority;


        public NoteHolder(@NonNull View itemView) {
            super(itemView); // the card it self
            textViewTitle = itemView.findViewById(R.id.text_view_title);
            textViewDescription = itemView.findViewById(R.id.text_view_description);
            textViewPriority = itemView.findViewById(R.id.text_view_priority);
        }
    }
}
