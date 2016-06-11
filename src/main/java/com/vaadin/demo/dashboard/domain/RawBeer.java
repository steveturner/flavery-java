package com.vaadin.demo.dashboard.domain;

import java.util.Date;

public class RawBeer {
    public final String beer_name;
    public final String beer_id;
    public final float amount_remaining;
    public final float amount_used;
    public final int current_kegs;
    public final int total_kegs;
    public final Date created_at;
    public final Date updated_at;

    public RawBeer(String beer_name, String beer_id, float amount_remaining, float amount_used, int current_kegs,
            int total_kegs, Date created_at, Date updated_at) {
        this.beer_name = beer_name;
        this.beer_id = beer_id;
        this.amount_remaining = amount_remaining;
        this.amount_used = amount_used;
        this.current_kegs = current_kegs;
        this.total_kegs = total_kegs;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
