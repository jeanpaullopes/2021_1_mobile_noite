package br.edu.uniritter.mobile.nossaprimeiraappnoite.adapter;

import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.edu.uniritter.mobile.nossaprimeiraappnoite.R;
import br.edu.uniritter.mobile.nossaprimeiraappnoite.databinding.LayoutBinding;
import br.edu.uniritter.mobile.nossaprimeiraappnoite.databinding.LayoutUserBinding;
import br.edu.uniritter.mobile.nossaprimeiraappnoite.model.Todo;
import br.edu.uniritter.mobile.nossaprimeiraappnoite.model.User;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<User> users;

    public class UserViewHolder extends RecyclerView.ViewHolder {
        LayoutUserBinding bindind;

        public UserViewHolder(@NonNull LayoutUserBinding binding) {
            super(binding.getRoot());
            this.bindind = binding;
        }
    }

    public UserAdapter(List<User> listUser) {
        this.users = listUser;

    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutUserBinding lub;
        //vamos inflar um layout
        //1º passo um LayoutInflator
        LayoutInflater inflator =  LayoutInflater.from(parent.getContext());

        lub = LayoutUserBinding.inflate(inflator, parent, false);

        return new UserViewHolder(lub);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.bindind.setUser(users.get(position));

    }



    @Override
    public int getItemCount() {
        return this.users.size();
    }
}
