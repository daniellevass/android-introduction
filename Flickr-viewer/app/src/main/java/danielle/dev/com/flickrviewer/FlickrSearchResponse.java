package danielle.dev.com.flickrviewer;

import java.util.List;

/**
 * Created by daniellevass on 11/04/15.
 */
public class FlickrSearchResponse {

    private FlickrPhotos photos;


    public FlickrPhotos getPhotos() {
        return photos;
    }

    public class FlickrPhotos
    {

        private List<FlickrPhoto> photo;

        public List<FlickrPhoto> getPhoto() {
            return photo;
        }
    }


    public class FlickrPhoto
    {
        private String title;
        private String url_o;
        private String url_m;

        public String getTitle() {
            return title;
        }

        public String getUrl_o() {
            return url_o;
        }

        public String getUrl_c() {
            return url_m;
        }

        public String getImageURL(){

            if (url_m != null){
                return url_m;
            } else {
                if ( url_o != null){
                    return "";
                } else {
                    return "";
                }
            }

        }
    }

}
