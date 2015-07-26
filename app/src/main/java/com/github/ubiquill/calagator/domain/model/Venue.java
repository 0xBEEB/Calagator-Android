package com.github.ubiquill.calagator.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ubiquill on 7/20/15.
 */
public class Venue {

    @Expose
    private Integer id;
    @Expose
    private String title;
    @Expose
    private String description;
    @Expose
    private String address;
    @Expose
    private String url;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("street_address")
    @Expose
    private String streetAddress;
    @Expose
    private String locality;
    @Expose
    private String region;
    @SerializedName("postal_code")
    @Expose
    private String postalCode;
    @Expose
    private String country;
    @Expose
    private String latitude;
    @Expose
    private String longitude;
    @Expose
    private String email;
    @Expose
    private String telephone;
    @SerializedName("source_id")
    @Expose
    private Object sourceId;
    @SerializedName("duplicate_of_id")
    @Expose
    private Object duplicateOfId;
    @Expose
    private Boolean closed;
    @Expose
    private Boolean wifi;
    @SerializedName("access_notes")
    @Expose
    private String accessNotes;
    @SerializedName("events_count")
    @Expose
    private Integer eventsCount;

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
      return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
      this.id = id;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
      return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
      this.title = title;
    }

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
      return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
      this.description = description;
    }

    /**
     *
     * @return
     * The address
     */
    public String getAddress() {
      return address;
    }

    /**
     *
     * @param address
     * The address
     */
    public void setAddress(String address) {
      this.address = address;
    }

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
      return url;
    }

    /**
     *
     * @param url
     * The url
     */
    public void setUrl(String url) {
      this.url = url;
    }

    /**
     *
     * @return
     * The createdAt
     */
    public String getCreatedAt() {
      return createdAt;
    }

    /**
     *
     * @param createdAt
     * The created_at
     */
    public void setCreatedAt(String createdAt) {
      this.createdAt = createdAt;
    }

    /**
     *
     * @return
     * The updatedAt
     */
    public String getUpdatedAt() {
      return updatedAt;
    }

    /**
     *
     * @param updatedAt
     * The updated_at
     */
    public void setUpdatedAt(String updatedAt) {
      this.updatedAt = updatedAt;
    }

    /**
     *
     * @return
     * The streetAddress
     */
    public String getStreetAddress() {
      return streetAddress;
    }

    /**
     *
     * @param streetAddress
     * The street_address
     */
    public void setStreetAddress(String streetAddress) {
      this.streetAddress = streetAddress;
    }

    /**
     *
     * @return
     * The locality
     */
    public String getLocality() {
      return locality;
    }

    /**
     *
     * @param locality
     * The locality
     */
    public void setLocality(String locality) {
      this.locality = locality;
    }

    /**
     *
     * @return
     * The region
     */
    public String getRegion() {
      return region;
    }

    /**
     *
     * @param region
     * The region
     */
    public void setRegion(String region) {
      this.region = region;
    }

    /**
     *
     * @return
     * The postalCode
     */
    public String getPostalCode() {
      return postalCode;
    }

    /**
     *
     * @param postalCode
     * The postal_code
     */
    public void setPostalCode(String postalCode) {
      this.postalCode = postalCode;
    }

    /**
     *
     * @return
     * The country
     */
    public String getCountry() {
      return country;
    }

    /**
     *
     * @param country
     * The country
     */
    public void setCountry(String country) {
      this.country = country;
    }

    /**
     *
     * @return
     * The latitude
     */
    public String getLatitude() {
      return latitude;
    }

    /**
     *
     * @param latitude
     * The latitude
     */
    public void setLatitude(String latitude) {
      this.latitude = latitude;
    }

    /**
     *
     * @return
     * The longitude
     */
    public String getLongitude() {
      return longitude;
    }

    /**
     *
     * @param longitude
     * The longitude
     */
    public void setLongitude(String longitude) {
      this.longitude = longitude;
    }

    /**
     *
     * @return
     * The email
     */
    public String getEmail() {
      return email;
    }

    /**
     *
     * @param email
     * The email
     */
    public void setEmail(String email) {
      this.email = email;
    }

    /**
     *
     * @return
     * The telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     *
     * @param telephone
     * The telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     *
     * @return
     * The sourceId
     */
    public Object getSourceId() {
        return sourceId;
    }

    /**
     *
     * @param sourceId
     * The source_id
     */
    public void setSourceId(Object sourceId) {
        this.sourceId = sourceId;
    }

    /**
     *
     * @return
     * The duplicateOfId
     */
    public Object getDuplicateOfId() {
        return duplicateOfId;
    }

    /**
     *
     * @param duplicateOfId
     * The duplicate_of_id
     */
    public void setDuplicateOfId(Object duplicateOfId) {
        this.duplicateOfId = duplicateOfId;
    }

    /**
     *
     * @return
     * The closed
     */
    public Boolean getClosed() {
        return closed;
    }

    /**
     *
     * @param closed
     * The closed
     */
    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    /**
     *
     * @return
     * The wifi
     */
    public Boolean getWifi() {
        return wifi;
    }

    /**
     *
     * @param wifi
     * The wifi
     */
    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    /**
     *
     * @return
     * The accessNotes
     */
    public String getAccessNotes() {
        return accessNotes;
    }

    /**
     *
     * @param accessNotes
     * The access_notes
     */
    public void setAccessNotes(String accessNotes) {
        this.accessNotes = accessNotes;
    }

    /**
     *
     * @return
     * The eventsCount
     */
    public Integer getEventsCount() {
        return eventsCount;
    }

    /**
     *
     * @param eventsCount
     * The events_count
     */
    public void setEventsCount(Integer eventsCount) {
        this.eventsCount = eventsCount;
    }
}
