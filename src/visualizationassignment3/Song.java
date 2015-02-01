package visualizationassignment3;

/**
 * Model for a song in the million song database.
 *
 * @author maikel
 */
public class Song {

    private int analysis_sample_rate;
    private int artist_7digitalid;
    private double artist_familiarity;
    private double artist_hotttnesss;
    private String artist_id;
    private double artist_latitude;
    private String artist_location;
    private double artist_longitude;
    private String artist_mbid;
    private String[] artist_mbtags;
    private int[] artist_mbtags_count;
    private String artist_name;
    private int artist_playmeid;
    private String[] artist_terms;
    private float[] artist_terms_freq;
    private float[] artist_terms_weight;
    private String audio_md5;
    private float[] bars_confidence;
    private float[] bars_start;
    private float[] beats_confidence;
    private float[] beats_start;
    private double danceability;
    private double duration;
    private double end_of_fade_in;
    private double energy;
    private String filename;
    private int key;
    private double key_confidence;
    private double loudness;
    private int mode;
    private double mode_confidence;
    private long num_songs;
    private String release;
    private int release_7digitalid;
    private float[] sections_confidence;
    private float[] sections_start;
    private float[] segments_confidence;
    private float[] segments_loudness_max;
    private float[] segments_loudness_max_time;
    private float[] segments_loudness_start;
    private float[][] segments_pitches;
    private float[] segments_start;
    private float[][] segments_timbre;
    private String[] similar_artists;
    private double song_hotttnesss;
    private String song_id;
    private double start_of_fade_out;
    private float[] tatums_confidence;
    private float[] tatums_start;
    private double tempo;
    private int time_signature;
    private double time_signature_confidence;
    private String title;
    private int track_7digitalid;
    private String track_id;
    private int year;

    public int getAnalysis_sample_rate() {
        return analysis_sample_rate;
    }

    public int getArtist_7digitalid() {
        return artist_7digitalid;
    }

    public double getArtist_familiarity() {
        return artist_familiarity;
    }

    public double getArtist_hotttnesss() {
        return artist_hotttnesss;
    }

    public String getArtist_id() {
        return artist_id;
    }

    public double getArtist_latitude() {
        return artist_latitude;
    }

    public String getArtist_location() {
        return artist_location;
    }

    public double getArtist_longitude() {
        return artist_longitude;
    }

    public String getArtist_mbid() {
        return artist_mbid;
    }

    public String[] getArtist_mbtags() {
        return artist_mbtags;
    }

    public int[] getArtist_mbtags_count() {
        return artist_mbtags_count;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public int getArtist_playmeid() {
        return artist_playmeid;
    }

    public String[] getArtist_terms() {
        return artist_terms;
    }

    public float[] getArtist_terms_freq() {
        return artist_terms_freq;
    }

    public float[] getArtist_terms_weight() {
        return artist_terms_weight;
    }

    public String getAudio_md5() {
        return audio_md5;
    }

    public float[] getBars_confidence() {
        return bars_confidence;
    }

    public float[] getBars_start() {
        return bars_start;
    }

    public float[] getBeats_confidence() {
        return beats_confidence;
    }

    public float[] getBeats_start() {
        return beats_start;
    }

    public double getDanceability() {
        return danceability;
    }

    public double getDuration() {
        return duration;
    }

    public double getEnd_of_fade_in() {
        return end_of_fade_in;
    }

    public double getEnergy() {
        return energy;
    }

    public String getFilename() {
        return filename;
    }

    public int getKey() {
        return key;
    }

    public double getKey_confidence() {
        return key_confidence;
    }

    public double getLoudness() {
        return loudness;
    }

    public int getMode() {
        return mode;
    }

    public double getMode_confidence() {
        return mode_confidence;
    }

    public long getNum_songs() {
        return num_songs;
    }

    public String getRelease() {
        return release;
    }

    public int getRelease_7digitalid() {
        return release_7digitalid;
    }

    public float[] getSections_confidence() {
        return sections_confidence;
    }

    public float[] getSections_start() {
        return sections_start;
    }

    public float[] getSegments_confidence() {
        return segments_confidence;
    }

    public float[] getSegments_loudness_max() {
        return segments_loudness_max;
    }

    public float[] getSegments_loudness_max_time() {
        return segments_loudness_max_time;
    }

    public float[] getSegments_loudness_start() {
        return segments_loudness_start;
    }

    public float[][] getSegments_pitches() {
        return segments_pitches;
    }

    public float[] getSegments_start() {
        return segments_start;
    }

    public float[][] getSegments_timbre() {
        return segments_timbre;
    }

    public String[] getSimilar_artists() {
        return similar_artists;
    }

    public double getSong_hotttnesss() {
        return song_hotttnesss;
    }

    public String getSong_id() {
        return song_id;
    }

    public double getStart_of_fade_out() {
        return start_of_fade_out;
    }

    public float[] getTatums_confidence() {
        return tatums_confidence;
    }

    public float[] getTatums_start() {
        return tatums_start;
    }

    public double getTempo() {
        return tempo;
    }

    public int getTime_signature() {
        return time_signature;
    }

    public double getTime_signature_confidence() {
        return time_signature_confidence;
    }

    public String getTitle() {
        return title;
    }

    public int getTrack_7digitalid() {
        return track_7digitalid;
    }

    public String getTrack_id() {
        return track_id;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Song{" + "artist_name=" + artist_name + ", title=" + title + '}';
    }

    public Number getValue(String s) {
        switch(s) {
            case "duration":
                return duration;
            case "hotness":
                return this.song_hotttnesss;
            default:
                throw new IllegalArgumentException("Unknown field " + s);
        }
    }

}
