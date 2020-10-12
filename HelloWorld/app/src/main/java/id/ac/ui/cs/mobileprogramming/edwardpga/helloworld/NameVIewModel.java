package id.ac.ui.cs.mobileprogramming.edwardpga.helloworld;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NameVIewModel extends ViewModel{
    private MutableLiveData<String> viewName = new MutableLiveData<>();
    private PraisesCursesModel praiseCurseName = new PraisesCursesModel("No Name");

    public void setName(String name) {
        praiseCurseName.setName(name);
        updatePhrase();
    }

    public void updatePhrase() {
        viewName.setValue(praiseCurseName.getName());
    }

    public LiveData<String> getPhrase() {
        return viewName;
    }
}
