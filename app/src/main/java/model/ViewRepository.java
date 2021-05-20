package model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.eclipseprogrammer.takeawalk.R;
import com.eclipseprogrammer.takeawalk.ui.view.walk;

import java.util.ArrayList;
import java.util.List;

public class ViewRepository {

    private MutableLiveData<List<walk>>walkLiveData = new MutableLiveData<>();

    public ViewRepository() {

        List<walk> walks = new ArrayList<>();
        walks.add(new walk("True skov",R.drawable.image_trueskov));
        walks.add(new walk("Riis skov",R.drawable.image_riisskov));
        walks.add(new walk("Skovruten",R.drawable.image_skovruten));
        walks.add(new walk("Årslev engsø",R.drawable.image_arslev));
        walks.add(new walk("Brabrand sø",R.drawable.image_brabrand));
        walks.add(new walk("Egå engsø",R.drawable.image_ega));
        walks.add(new walk("Kort oversigt",R.drawable.image_kort));

        walkLiveData.setValue(walks);
    }
    public LiveData<List<walk>> getWalk() {
        return walkLiveData;
    }

}
