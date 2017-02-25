package com.github.ubiquill.calagator.domain.model;

import com.github.ubiquill.calagator.utils.DateHelper;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;

public class Event implements Comparable<Event> {

    @Expose
    private Integer id;
    @Expose
    private String title;
    @Expose
    private String description;
    @SerializedName("start_time")
    @Expose
    private String startTime;
    @Expose
    private String url;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("venue_id")
    @Expose
    private Integer venueId;
    @SerializedName("source_id")
    @Expose
    private Object sourceId;
    @SerializedName("duplicate_of_id")
    @Expose
    private Object duplicateOfId;
    @SerializedName("end_time")
    @Expose
    private String endTime;
    @Expose
    private Object version;
    @Expose
    private Object rrule;
    @SerializedName("venue_details")
    @Expose
    private String venueDetails;
    @Expose
    private Boolean locked;
    @Expose
    private Venue venue;

    /**
     * @return The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * @param startTime The start_time
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * @return The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt The created_at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return The updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt The updated_at
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * @return The venueId
     */
    public Integer getVenueId() {
        return venueId;
    }

    /**
     * @param venueId The venue_id
     */
    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    /**
     * @return The sourceId
     */
    public Object getSourceId() {
        return sourceId;
    }

    /**
     * @param sourceId The source_id
     */
    public void setSourceId(Object sourceId) {
        this.sourceId = sourceId;
    }

    /**
     * @return The duplicateOfId
     */
    public Object getDuplicateOfId() {
        return duplicateOfId;
    }

    /**
     * @param duplicateOfId The duplicate_of_id
     */
    public void setDuplicateOfId(Object duplicateOfId) {
        this.duplicateOfId = duplicateOfId;
    }

    /**
     * @return The endTime
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * @param endTime The end_time
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * @return The version
     */
    public Object getVersion() {
        return version;
    }

    /**
     * @param version The version
     */
    public void setVersion(Object version) {
        this.version = version;
    }

    /**
     * @return The rrule
     */
    public Object getRrule() {
        return rrule;
    }

    /**
     * @param rrule The rrule
     */
    public void setRrule(Object rrule) {
        this.rrule = rrule;
    }

    /**
     * @return The venueDetails
     */
    public String getVenueDetails() {
        return venueDetails;
    }

    /**
     * @param venueDetails The venue_details
     */
    public void setVenueDetails(String venueDetails) {
        this.venueDetails = venueDetails;
    }

    /**
     * @return The locked
     */
    public Boolean getLocked() {
        return locked;
    }

    /**
     * @param locked The locked
     */
    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    /**
     * @return The venue
     */
    public Venue getVenue() {
        return venue;
    }

    /**
     * @param venue The venue
     */
    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public DateTime getStartDate() {
        if (getStartTime() == null) {
            return null;
        }

        return DateHelper.fromISOTimeStamp(getStartTime());
    }

    public DateTime getEndDate() {
        if (getEndTime() == null) {
            return null;
        }

        return DateHelper.fromISOTimeStamp(getEndTime());
    }

    @Override
    public int compareTo(Event o) {
        return this.getStartDate().compareTo(o.getStartDate());
    }
}
