package com.islam.singlelivedata;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

/**
 * {@link LiveData} which publicly exposes {@link #setValue(T)} and {@link #postValue(T)} method.
 *
 * @param <T> The type of data hold by this instance
 */
@SuppressWarnings("WeakerAccess")
public class SingleLiveData<T> extends LiveData<T> {

    private boolean isActive = true;

    /**
     * Creates a SingleLiveData initialized with the given {@code value}.
     *
     * @param value initial value
     */
    public SingleLiveData(T value) {
        super(value);
    }

    /**
     * Creates a SingleLiveData with no value assigned to it.
     */
    public SingleLiveData() {
        super();
    }

    @Override
    public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<? super T> observer) {
        super.observe(owner, t -> {
            if (isActive) {
                isActive = false;
                observer.onChanged(t);
            }
        });
    }

    @Override
    public void postValue(T value) {
        isActive = true;
        super.postValue(value);
    }

    @Override
    public void setValue(T value) {
        isActive = true;
        super.setValue(value);
    }
}