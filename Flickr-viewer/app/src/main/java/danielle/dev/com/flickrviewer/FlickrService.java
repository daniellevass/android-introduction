package danielle.dev.com.flickrviewer;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by daniellevass on 11/04/15.
 */
public interface FlickrService {


    @GET("/services/rest/?api_key=68a955001427be845d9f461418692a04&format=" +
            "json&safe_search=1" +
            "&content_type=1&method=flickr.photos.search&nojsoncallback=1&extras=url_m,url_o")
    void getSearchPhoto(@Query("tags") String safeTag, Callback<FlickrSearchResponse> cb);

}
