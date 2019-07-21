package jkh.eventlistener;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public interface ValueEventListenerAdapter extends ValueEventListener {
	
	@Override
	default void onCancelled(DatabaseError error) {
	
	}
}
