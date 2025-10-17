package com.example.listycity;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable {
    private String city;
    private String province;

    /**
     * Creation of the city object given a city and province
     * @param city
     * @param province
     */
    public City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * Get City name from the city object
     * @return city name
     */
    public String getCity() {
        return city;
    }

    /**
     * Set City to the City string given by the parameter
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Get Province name from the city object
     * @return province name
     */
    public String getProvince() {
        return province;
    }

    /**
     * Set Province to the Province string given by the parameter
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    /** This method compares cities based on city name field
     * @return -1 if the caller is greater than the city name field
     * */
    public int compareTo(Object o) {
        City city = (City) o;
        return this.city.compareTo(city.getCity());
    }

}
