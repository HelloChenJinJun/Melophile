package com.vpaliy.domain.interactor;


import com.vpaliy.domain.executor.BaseSchedulerProvider;
import com.vpaliy.domain.model.Track;
import com.vpaliy.domain.repository.Repository;

import java.util.List;

import io.reactivex.Single;

public class GetTracks extends SingleUseCase<List<Track>,List<String>>{

    private Repository repository;

    public GetTracks(BaseSchedulerProvider schedulerProvider,
                     Repository repository){
        super(schedulerProvider);
        this.repository=repository;
    }

    @Override
    public Single<List<Track>> buildUseCase(List<String> tags) {
        return repository.getTracksBy(tags);
    }
}
