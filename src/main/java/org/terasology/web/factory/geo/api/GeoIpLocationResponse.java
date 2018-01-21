package org.terasology.web.factory.geo.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GeoIpLocationResponse {

    private String ipAddress;
    private String continentCode;
    private String countryCode;
    private String countryName;
    private String currencyCode;
    private String currencyName;
    private String phonePrefix;
    private List<String> languages;

    @JsonProperty("ipAddress")
    public String getIpAddress() {
        return ipAddress;
    }

    @JsonProperty("ipAddress")
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @JsonProperty("continentCode")
    public String getContinentCode() {
        return continentCode;
    }

    @JsonProperty("continentCode")
    public void setContinentCode(String continentCode) {
        this.continentCode = continentCode;
    }

    @JsonProperty("countryCode")
    public String getCountryCode() {
        return countryCode;
    }

    @JsonProperty("countryCode")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @JsonProperty("countryName")
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @JsonProperty("countryName")
    public String getCountryName() {
        return countryName;
    }

    @JsonProperty("currencyCode")
    public String getCurrencyCode() {
        return currencyCode;
    }

    @JsonProperty("currencyCode")
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @JsonProperty("currencyName")
    public String getCurrencyName() {
        return currencyName;
    }

    @JsonProperty("currencyName")
    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    @JsonProperty("phonePrefix")
    public String getPhonePrefix() {
        return phonePrefix;
    }

    @JsonProperty("phonePrefix")
    public void setPhonePrefix(String phonePrefix) {
        this.phonePrefix = phonePrefix;
    }

    @JsonProperty("languages")
    public List<String> getLanguages() {
        return languages;
    }

    @JsonProperty("languages")
    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }
}


//   "ipAddress": "23.255.240.0",
//    "continentCode": "NA",
//    "continentName": "North America",
//    "countryCode": "US",
//    "countryName": "United States",
//    "currencyCode": "USD",
//    "currencyName": "Dollar",
//    "phonePrefix": "1",
//    "languages": [
//        "en-US",
//        "es-US",
//        "haw",
//        "fr"
//    ],
//    "stateProv": "California",
//    "district": "Santa Clara County",
//    "city": "Mountain View",
//    "geonameId": 5375480,
//    "zipCode": "94043",
//    "latitude": 37.3861,
//    "longitude": -122.084,
//    "gmtOffset": -7,
//    "timeZone": "America\/Los_Angeles"