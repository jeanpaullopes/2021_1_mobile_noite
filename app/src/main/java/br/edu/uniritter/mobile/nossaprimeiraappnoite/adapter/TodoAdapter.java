package br.edu.uniritter.mobile.nossaprimeiraappnoite.adapter;

import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
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
import br.edu.uniritter.mobile.nossaprimeiraappnoite.databinding.LayoutBinding;
import br.edu.uniritter.mobile.nossaprimeiraappnoite.databinding.LayoutTodoBinding;
import br.edu.uniritter.mobile.nossaprimeiraappnoite.model.Todo;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {
    private List<Parcelable> listaTodos;
    private int layout;

    public class TodoViewHolder extends RecyclerView.ViewHolder {

        //troquei o viewTodo de View para LayoutBindind
        public LayoutBinding viewTodo;
        public LayoutTodoBinding viewTodo2;

        //troquei o itemView de View para LayoutBindind
        public TodoViewHolder(@NonNull LayoutBinding itemView) {
            //alterei aqui colocando o .getRoot()
            super(itemView.getRoot());
            this.viewTodo = itemView;
        }
        //Criei um segundo construtor itemView classe LayoutTodoBindind
        public TodoViewHolder(@NonNull LayoutTodoBinding itemView) {
            //alterei aqui colocando o .getRoot()
            super(itemView.getRoot());
            this.viewTodo2 = itemView;
        }
    }
    public TodoAdapter(List<Parcelable> todos, int layout) {
        this.listaTodos = todos;
        this.layout = layout;

        //troquei o layout para o layout_todo
        if (this.layout == 0) {
            this.layout =  R.layout.layout_todo;
        }
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //troquei o v para LayoutBinding e v1 para LayoutTodoBinding
        LayoutBinding v = null;
        LayoutTodoBinding v1 = null;
        if (listaTodos.get(0) instanceof Todo) {
            //mudei aqui
            // v = LayoutInflater.from(parent.getContext()).inflate(this.layout, parent, false);
            if (layout == R.layout.layout) {
                v = LayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                return new TodoViewHolder(v);
            } else {
                v1 = LayoutTodoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                return new TodoViewHolder(v1);
            }
        }
        //escape return
        return null;
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

            //torquei o layout para ser layour ou layout_todo
            if (this.layout != R.layout.layout_todo) {
                //aqui faz o binding do objeto Todo
                holder.viewTodo.setNossoTodo(obj);
            }

            //torquei o layout para ser layour ou layout_todo
            if (layout == R.layout.layout_todo) {
                Log.w("TodoAdapter",position+" obj:"+obj);
                if (obj != null) {
                    holder.viewTodo2.setTodo(obj);
                    //aqui vai fazer o bind do adapter para poder chamar o método onCLick
                    holder.viewTodo2.setAdapter(this);
                }
                // aqui não tem mais o .findViewById() então comentei tudo
                // todo foi para o layout_todo e para o método cardClick
                /*
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

                 */
            }
        }


    }
    // aqui vai atender o onclick definido no layout
    public void cardClick(View v) {
        Log.w("onclick","no card onclick");
        CardView btn = (CardView) v;
        Todo todo = (Todo) btn.getTag();
        Intent intent = new Intent(v.getContext(), DetalheTodoActivity.class);

        // adicional para incluir dados para a proxima activity
        intent.putExtra("objTodo", todo);
        // lança intent para o SO chamar a activity
        v.getContext().startActivity(intent);
    }



    @Override
    public int getItemCount() {
        return this.listaTodos.size();
    }
}
