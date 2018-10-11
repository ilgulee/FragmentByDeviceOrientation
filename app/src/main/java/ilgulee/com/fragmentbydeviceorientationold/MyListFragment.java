package ilgulee.com.fragmentbydeviceorientationold;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MyListFragment extends ListFragment {

    private OnListFragmentListener mListener;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String[] pieces=getActivity().getResources().getStringArray(R.array.pieces);
        ArrayAdapter<String> mChessPieces = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,pieces);
        setListAdapter(mChessPieces);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        mListener.onItemClicked(position);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentListener) {
            mListener = (OnListFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnListFragmentListener {
        void onItemClicked(int index);
    }
}
