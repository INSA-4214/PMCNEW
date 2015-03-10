package com.pmc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created on 09/03/15.
 *
 * @author stephaneki
 */
@Entity(name="favorite")
@JsonIgnoreProperties({"user"})
public class Favorite {

    private static final float DEFAULT_INTENSITY = 1;
    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column
    private double latitude;

    @Column
    private double longitude;

    @Column
    private String address;

    @Transient
    private float intensity;

    @Transient
    private Density density;

    @ManyToOne()
    @JoinColumn(name="user_id")
    private User user;

    public Favorite(double latitude, double longitude, User user, String address) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.user = user;
        this.density=null;
        this.intensity=DEFAULT_INTENSITY;
        this.address=address;
    }

    public Favorite() {
    }

    public int getId() {
        return id;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public User getUser() {
        return user;
    }

    public Favorite setDensity(Density density) {
        this.density = density;
        return this;
    }

    public Favorite setIntensity(int intensity) {
        this.intensity = intensity;
        return this;
    }

    public float getIntensity() {
        return intensity;
    }

    public Density getDensity() {
        return density;
    }

    public String getAddress() {
        return address;
    }
}
