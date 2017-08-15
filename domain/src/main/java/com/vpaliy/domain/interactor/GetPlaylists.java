package com.vpaliy.domain.interactor;

import com.vpaliy.domain.executor.BaseSchedulerProvider;
import com.vpaliy.domain.model.Playlist;
import com.vpaliy.domain.repository.Repository;
import java.util.List;
import io.reactivex.Single;

public class GetPlaylists extends SingleUseCase<List<Playlist>,List<String>>{

    private Repository repository;

    public GetPlaylists(BaseSchedulerProvider schedulerProvider,
                        Repository repository){
        super(schedulerProvider);
        this.repository=repository;
    }

    @Override
    public Single<List<Playlist>> buildUseCase(List<String> tags) {
        return repository.getPlaylistsBy(tags);
    }
}
