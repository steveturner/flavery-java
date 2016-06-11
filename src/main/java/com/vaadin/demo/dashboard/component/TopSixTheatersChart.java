package com.vaadin.demo.dashboard.component;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.ChartType;
import com.vaadin.addon.charts.model.Credits;
import com.vaadin.addon.charts.model.DataSeries;
import com.vaadin.addon.charts.model.DataSeriesItem;
import com.vaadin.addon.charts.model.PlotOptionsPie;
import com.vaadin.demo.dashboard.DashboardUI;
import com.vaadin.demo.dashboard.data.dummy.DummyDataGenerator;
import com.vaadin.demo.dashboard.domain.Beer;
import com.vaadin.demo.dashboard.domain.RawBeer;

@SuppressWarnings("serial")
public class TopSixTheatersChart extends Chart {

    public TopSixTheatersChart() {
        super(ChartType.PIE);

        setCaption("Popular Beers");
        getConfiguration().setTitle("");
        getConfiguration().getChart().setType(ChartType.PIE);
        getConfiguration().getChart().setAnimation(false);
        setWidth("100%");
        setHeight("90%");

        DataSeries series = new DataSeries();

        List<RawBeer> movies = new ArrayList<RawBeer>(DashboardUI.getDataProvider()
                .getBeers());
        for (int i = 0; i < 6; i++) {
            RawBeer movie = movies.get(i);
            DataSeriesItem item = new DataSeriesItem(movie.beer_name,
                    movie.amount_used*100);
            series.add(item);
            item.setColor(DummyDataGenerator.chartColors[5 - i]);
        }
        getConfiguration().setSeries(series);

        PlotOptionsPie opts = new PlotOptionsPie();
        opts.setBorderWidth(0);
        opts.setShadow(false);
        opts.setAnimation(false);
        getConfiguration().setPlotOptions(opts);

        Credits c = new Credits("");
        getConfiguration().setCredits(c);
    }

}
