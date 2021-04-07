package br.edu.uniritter.mobile.nossaprimeiraappnoite.adapter;

import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.edu.uniritter.mobile.nossaprimeiraappnoite.DetalheTodoActivity;
import br.edu.uniritter.mobile.nossaprimeiraappnoite.R;
import br.edu.uniritter.mobile.nossaprimeiraappnoite.model.Todo;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {
    private List<Parcelable> listaTodos;
    private int layout;

    public class TodoViewHolder extends RecyclerView.ViewHolder {
        public View viewTodo;
        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
            this.viewTodo = itemView;
        }
    }
    public TodoAdapter(List<Parcelable> todos, int layout) {
        this.listaTodos = todos;
        this.layout = layout;
        if (this.layout == 0) {
            this.layout =  R.layout.layout_user;
        }
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = null;
        if (listaTodos.get(0) instanceof Todo) {
            v = LayoutInflater.from(parent.getContext()).inflate(this.layout, parent, false);
        }
        return new TodoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        if (this.listaTodos.get(position) instanceof  Todo) {
            Todo obj = (Todo)this.listaTodos.get(position);
            TextView tv;
            //= holder.viewTodo.findViewById(R.id.tvId);
            //tv.setText(obj.getId()+"");
            //tv = holder.viewTodo.findViewById(R.id.tvIdUser);
            //tv.setText(obj.getUserId()+"");
            if (this.layout != R.layout.layout_user) {
                tv = holder.viewTodo.findViewById(R.id.tvTitle);
                tv.setText(obj.getTitle());
                CheckBox cb = holder.viewTodo.findViewById(R.id.cbCompleted);
                cb.setChecked(obj.isCompleted());
            }
            if (layout == R.layout.layout_user) {
                CardView bt = holder.viewTodo.findViewById(R.id.cardUser);
                bt.setTag(obj);
                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CardView btn = (CardView) v;
                        Todo todo = (Todo) btn.getTag();
                        Intent intent = new Intent(holder.viewTodo.getContext(), DetalheTodoActivity.class);

                        // adicional para incluir dados para a proxima activity
                        intent.putExtra("objTodo", obj);
                        // lança intent para o SO chamar a activity
                        holder.viewTodo.getContext().startActivity(intent);
                    }
                });
            }
        }


    }



    @Override
    public int getItemCount() {
        return this.listaTodos.size();
    }
}
