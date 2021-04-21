package br.edu.uniritter.mobile.nossaprimeiraappnoite.presenter;

import android.content.Context;
import android.os.Parcelable;

import java.util.List;

import br.edu.uniritter.mobile.nossaprimeiraappnoite.model.Address;
import br.edu.uniritter.mobile.nossaprimeiraappnoite.model.Todo;
import br.edu.uniritter.mobile.nossaprimeiraappnoite.model.User;

public interface SegundaActivityContrato {
    interface SegundaActivityView {
        public void bindLista(List<Parcelable> lista);
        public void bindListaAdd(List<Address> list);
        public void bindListaUser(List<User> lista);
        public void mostraToast(String msg);
        public void stopRefreshing();
        public Context getContexto();
    }

    interface SegundaActivityInterfacePresenter {
        public void start();
        public void encerrar();

    }
}
