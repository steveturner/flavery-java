package com.vaadin.demo.dashboard.component;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.ChartType;
import com.vaadin.addon.charts.model.Credits;
import com.vaadin.addon.charts.model.ListSeries;
import com.vaadin.addon.charts.model.PlotOptionsBar;
import com.vaadin.addon.charts.model.Series;
import com.vaadin.demo.dashboard.DashboardUI;
import com.vaadin.demo.dashboard.data.dummy.DummyDataGenerator;
import com.vaadin.demo.dashboard.domain.Beer;
import com.vaadin.demo.dashboard.domain.RawBeer;

@SuppressWarnings("serial")
public class TopGrossingMoviesChart extends Chart {

    public TopGrossingMoviesChart() {
        setCaption("Top Grossing Beers");
        getConfiguration().setTitle("");
        getConfiguration().getChart().setType(ChartType.BAR);
        getConfiguration().getChart().setAnimation(false);
        getConfiguration().getxAxis().getLabels().setEnabled(false);
        getConfiguration().getxAxis().setTickWidth(0);
        getConfiguration().getyAxis().setTitle("");
        setSizeFull();

        List<RawBeer> movies = new ArrayList<RawBeer>(DashboardUI.getDataProvider()
                .getBeers());

        List<Series> series = new ArrayList<Series>();
        for (int i = 0; i < 6; i++) {
            RawBeer movie = movies.get(i);
            PlotOptionsBar opts = new PlotOptionsBar();
            opts.setColor(DummyDataGenerator.chartColors[5 - i]);
            opts.setBorderWidth(0);
            opts.setShadow(false);
            opts.setPointPadding(0.4);
            opts.setAnimation(false);
            ListSeries item = new ListSeries(movie.beer_name, movie.amount_used * 1000);

            item.setPlotOptions(opts);
            series.add(item);

        }
        getConfiguration().setSeries(series);

        Credits c = new Credits("");
        getConfiguration().setCredits(c);

        PlotOptionsBar opts = new PlotOptionsBar();
        opts.setGroupPadding(0);
        getConfiguration().setPlotOptions(opts);

    }
}
